package metier;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typecaracteristique")
public class TypeCaracteristiqueEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idTypeCaracteristique",nullable = false,insertable = false,updatable = false)
    private int idTypeCaracteristique;

    @Column(name = "typeCaracteristique")
    private String typeCaracteristique;

    public TypeCaracteristiqueEntity() {
    }

    //region Getter / etc
    public int getIdTypeCaracteristique() {
        return idTypeCaracteristique;
    }

    public void setIdTypeCaracteristique(int idTypeCaracteristique) {
        this.idTypeCaracteristique = idTypeCaracteristique;
    }

    public String getTypeCaracteristique() {
        return typeCaracteristique;
    }

    public void setTypeCaracteristique(String typeCaracteristique) {
        this.typeCaracteristique = typeCaracteristique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeCaracteristiqueEntity that = (TypeCaracteristiqueEntity) o;
        return idTypeCaracteristique == that.idTypeCaracteristique &&
                Objects.equals(typeCaracteristique, that.typeCaracteristique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeCaracteristique, typeCaracteristique);
    }

    @Override
    public String toString() {
        return "TypeCaracteristiqueEntity{" +
                "idTypeCaracteristique=" + idTypeCaracteristique +
                ", typeCaracteristique='" + typeCaracteristique + '\'' +
                '}';
    }
    //endregion
}
