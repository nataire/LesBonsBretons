package metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "caracteristique")
public class CaracteristiqueEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idCaracteristique",nullable = false,insertable = false,updatable = false)
    private int idCaracteristique;

    @Basic
    @Column(name = "nomCaracteristique")
    private String nomCaracteristique;

    @Basic
    @Column(name = "idTypeCaracteristiqueCrct")
    private int idTypeCaracteristiqueCrct;

    @Basic
    @Column(name = "minValue")
    private float minValue;

    @Basic
    @Column(name = "maxValue")
    private float maxValue;

    @Basic
    @Column(name = "texte")
    private String texte;

    @Basic
    @Column(name = "nombre")
    private float nombre;

    @Basic
    @Column(name = "checkbox")
    private boolean checkbox;

    @Basic
    @Column(name = "listeDeroulante")
    private int listeDeroulante;

    public CaracteristiqueEntity() {
    }

    //region getter / etc

    public int getIdCaracteristique() {
        return idCaracteristique;
    }

    public void setIdCaracteristique(int idCaracteristique) {
        this.idCaracteristique = idCaracteristique;
    }

    public String getNomCaracteristique() {
        return nomCaracteristique;
    }

    public void setNomCaracteristique(String nomCaracteristique) {
        this.nomCaracteristique = nomCaracteristique;
    }

    public int getIdTypeCaracteristiqueCrct() {
        return idTypeCaracteristiqueCrct;
    }

    public void setIdTypeCaracteristiqueCrct(int idTypeCaracteristiqueCrct) {
        this.idTypeCaracteristiqueCrct = idTypeCaracteristiqueCrct;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public float getNombre() {
        return nombre;
    }

    public void setNombre(float nombre) {
        this.nombre = nombre;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public int getListeDeroulante() {
        return listeDeroulante;
    }

    public void setListeDeroulante(int listeDeroulante) {
        this.listeDeroulante = listeDeroulante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaracteristiqueEntity that = (CaracteristiqueEntity) o;
        return idCaracteristique == that.idCaracteristique &&
                idTypeCaracteristiqueCrct == that.idTypeCaracteristiqueCrct &&
                Float.compare(that.minValue, minValue) == 0 &&
                Float.compare(that.maxValue, maxValue) == 0 &&
                Float.compare(that.nombre, nombre) == 0 &&
                checkbox == that.checkbox &&
                listeDeroulante == that.listeDeroulante &&
                Objects.equals(nomCaracteristique, that.nomCaracteristique) &&
                Objects.equals(texte, that.texte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCaracteristique, nomCaracteristique, idTypeCaracteristiqueCrct, minValue, maxValue, texte, nombre, checkbox, listeDeroulante);
    }

    @Override
    public String toString() {
        return "CaracteristiqueEntity{" +
                "idCaracteristique=" + idCaracteristique +
                ", nomCaracteristique='" + nomCaracteristique + '\'' +
                ", idTypeCaracteristiqueCrct=" + idTypeCaracteristiqueCrct +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", texte='" + texte + '\'' +
                ", nombre=" + nombre +
                ", checkbox=" + checkbox +
                ", listeDeroulante=" + listeDeroulante +
                '}';
    }

    //endregion
}
