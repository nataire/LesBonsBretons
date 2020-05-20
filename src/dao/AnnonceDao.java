package dao;

import metier.AnnonceEntity;
import metier.CategorieEntity;

import java.util.Collection;

public interface AnnonceDao extends Dao<AnnonceEntity> {
    public AnnonceEntity findFirstAvailable();

    public Collection<AnnonceEntity> findAnnonce(String nomAnnonce, CategorieEntity idCategorie);
}
