package metier;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Annonce")
public class AnnonceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idAnnonce",nullable = false,insertable = false,updatable = false)
    private int idAnnonce;

    @Basic
    @Column(name = "titreAnnonce")

    private String titreAnnonce;

    @Basic

    @Column(name = "descriptionAnnonce")
    private String descriptionAnnonce;

    @Basic
    @Column(name = "isOffreAnnonce")
    private boolean isOffreAnnonce;

    @OneToMany(mappedBy = "AnnonceCategorie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idCategorie")
    private List<CategorieEntity> categorie;

    @OneToMany(mappedBy = "AnnonceUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "idUtilisateur")
    private List<UtilisateurEntity> user;

    @Basic
    @Column(name = "idAnnonceLocalisation")
    private int idAnnonceLocalisation;

    @Basic
    @Column(name = "dateAnnonce")
    private Timestamp dateAnnonce;

    public AnnonceEntity() {

    }

    public AnnonceEntity(String titreAnnonce, String descriptionAnnonce, boolean isOffreAnnonce, int idCategorieAnnonce, int idUtilisateurAnnonce, int idAnnonceLocalisation) {
        this.titreAnnonce = titreAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
        this.isOffreAnnonce = isOffreAnnonce;

        this.idAnnonceLocalisation = idAnnonceLocalisation;
    }

    //region Getter / Setter / toString / Hashcode

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    public void setTitreAnnonce(String titreAnnonce) {
        this.titreAnnonce = titreAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public boolean isOffreAnnonce() {
        return isOffreAnnonce;
    }

    public void setOffreAnnonce(boolean offreAnnonce) {
        isOffreAnnonce = offreAnnonce;
    }

    public List<CategorieEntity> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<CategorieEntity> categorie) {
        this.categorie = categorie;
    }


    public int getIdAnnonceLocalisation() {
        return idAnnonceLocalisation;
    }

    public void setIdAnnonceLocalisation(int idAnnonceLocalisation) {
        this.idAnnonceLocalisation = idAnnonceLocalisation;
    }

    public Timestamp getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Timestamp dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnonceEntity that = (AnnonceEntity) o;
        return idAnnonce == that.idAnnonce &&
                isOffreAnnonce == that.isOffreAnnonce &&
                idAnnonceLocalisation == that.idAnnonceLocalisation &&
                Objects.equals(titreAnnonce, that.titreAnnonce) &&
                Objects.equals(descriptionAnnonce, that.descriptionAnnonce) &&
                Objects.equals(categorie, that.categorie) &&
                Objects.equals(dateAnnonce, that.dateAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, titreAnnonce, descriptionAnnonce, isOffreAnnonce, categorie, idAnnonceLocalisation, dateAnnonce);
    }

    @Override
    public String toString() {
        return "AnnonceEntity{" +
                "idAnnonce=" + idAnnonce +
                ", titreAnnonce='" + titreAnnonce + '\'' +
                ", descriptionAnnonce='" + descriptionAnnonce + '\'' +
                ", isOffreAnnonce=" + isOffreAnnonce +
                ", categorie=" + categorie +

                ", idAnnonceLocalisation=" + idAnnonceLocalisation +
                ", dateAnnonce=" + dateAnnonce +
                '}';
    }

    //endregion

}
