package dao;

import metier.AnnonceEntity;

public interface AnnonceDao extends Dao<AnnonceEntity> {
    public AnnonceEntity findFirstAvailable();
}
