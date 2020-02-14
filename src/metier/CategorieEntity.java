package metier;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "categorie")

public class CategorieEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idCategorie",nullable = false,insertable = false,updatable = false)
    private int idCategorie;

    @Column(name = "nomCategorie")
    private String nomCategorie;

    @Column(name = "idSurCategorieCtg")
    private int idSurCategorie;

    public CategorieEntity() {
    }

    //region getter / etc
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getIdSurCategorie() {
        return idSurCategorie;
    }

    public void setIdSurCategorie(int idSurCategorie) {
        this.idSurCategorie = idSurCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return idCategorie == that.idCategorie &&
                idSurCategorie == that.idSurCategorie &&
                Objects.equals(nomCategorie, that.nomCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, nomCategorie, idSurCategorie);
    }

    @Override
    public String toString() {
        return "CategorieEntity{" +
                "idCategorie=" + idCategorie +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", idSurCategorie=" + idSurCategorie +
                '}';
    }
    //endregion
}
