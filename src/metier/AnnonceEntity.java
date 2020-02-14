package metier;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "annonce")
public class AnnonceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idAnnonce",nullable = false,insertable = false,updatable = false)
    private int idAnnonce;

    @Basic
    @Column(name = "tireAnnonce")
    private String titreAnnonce;

    @Basic
    @Column(name = "descriptionAnnonce")
    private String descriptionAnnonce;

    @Basic
    @Column(name = "isOffreAnnonce")
    private boolean isOffreAnnonce;

    @Basic
    @Column(name = "idCategorieAnnonce")
    private int idCategorieAnnonce;

    @Basic
    @Column(name = "idUtilisateurAnnonce")
    private int idUtilisateurAnnonce;

    @Basic
    @Column(name = "idAnnonceLocalisation")
    private int idAnnonceLocalisation;

    public AnnonceEntity(){

    }

    public AnnonceEntity(String titreAnnonce, String descriptionAnnonce, boolean isOffreAnnonce, int idCategorieAnnonce, int idUtilisateurAnnonce, int idAnnonceLocalisation) {
        this.titreAnnonce = titreAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
        this.isOffreAnnonce = isOffreAnnonce;
        this.idCategorieAnnonce = idCategorieAnnonce;
        this.idUtilisateurAnnonce = idUtilisateurAnnonce;
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

    public int getIdCategorieAnnonce() {
        return idCategorieAnnonce;
    }

    public void setIdCategorieAnnonce(int idCategorieAnnonce) {
        this.idCategorieAnnonce = idCategorieAnnonce;
    }

    public int getIdUtilisateurAnnonce() {
        return idUtilisateurAnnonce;
    }

    public void setIdUtilisateurAnnonce(int idUtilisateurAnnonce) {
        this.idUtilisateurAnnonce = idUtilisateurAnnonce;
    }

    public int getIdAnnonceLocalisation() {
        return idAnnonceLocalisation;
    }

    public void setIdAnnonceLocalisation(int idAnnonceLocalisation) {
        this.idAnnonceLocalisation = idAnnonceLocalisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnonceEntity that = (AnnonceEntity) o;
        return idAnnonce == that.idAnnonce &&
                isOffreAnnonce == that.isOffreAnnonce &&
                idCategorieAnnonce == that.idCategorieAnnonce &&
                idUtilisateurAnnonce == that.idUtilisateurAnnonce &&
                idAnnonceLocalisation == that.idAnnonceLocalisation &&
                Objects.equals(titreAnnonce, that.titreAnnonce) &&
                Objects.equals(descriptionAnnonce, that.descriptionAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, titreAnnonce, descriptionAnnonce, isOffreAnnonce, idCategorieAnnonce, idUtilisateurAnnonce, idAnnonceLocalisation);
    }

    @Override
    public String toString() {
        return "AnnonceEntity{" +
                "idAnnonce=" + idAnnonce +
                ", titreAnnonce='" + titreAnnonce + '\'' +
                ", descriptionAnnonce='" + descriptionAnnonce + '\'' +
                ", isOffreAnnonce=" + isOffreAnnonce +
                ", idCategorieAnnonce=" + idCategorieAnnonce +
                ", idUtilisateurAnnonce=" + idUtilisateurAnnonce +
                ", idAnnonceLocalisation=" + idAnnonceLocalisation +
                '}';
    }
    //endregion
}
