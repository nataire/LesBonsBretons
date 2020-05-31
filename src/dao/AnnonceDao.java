package dao;

import metier.AnnonceEntity;
import metier.SurCategorieEntity;
import metier.UtilisateurEntity;

import java.util.Collection;

public interface AnnonceDao extends Dao<AnnonceEntity> {
    public AnnonceEntity findFirstAvailable();

    public Collection<AnnonceEntity> findAnnonce(String nomAnnonce, SurCategorieEntity idCategorie);

    public Collection<AnnonceEntity> findAnnonceByIdUser(UtilisateurEntity user);
}
