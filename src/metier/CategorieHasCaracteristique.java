package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CategorieHasCaracteristique")
public class CategorieHasCaracteristique {
    @Id
    @Column(name = "idCaracteristique", nullable = false, insertable = false, updatable = false)
    private int idCaracteristique;

    @Id
    @Column(name = "idCategorie", nullable = false, insertable = false, updatable = false)
    private int idCategorie;

    public CategorieHasCaracteristique() {
    }

    //region getter/setter
    public int getIdCaracteristique() {
        return idCaracteristique;
    }

    public void setIdCaracteristique(int idCaracteristique) {
        this.idCaracteristique = idCaracteristique;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieHasCaracteristique that = (CategorieHasCaracteristique) o;
        return idCaracteristique == that.idCaracteristique &&
                idCategorie == that.idCategorie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCaracteristique, idCategorie);
    }

    @Override
    public String toString() {
        return "CategorieHasCaracteristique{" +
                "idCaracteristique=" + idCaracteristique +
                ", idCategorie=" + idCategorie +
                '}';
    }
    //endregion
}
