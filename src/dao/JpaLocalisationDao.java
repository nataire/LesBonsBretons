package dao;

import metier.LocalisationEntity;
import org.hibernate.query.Query;

import java.util.Collection;


public class JpaLocalisationDao extends JpaDao<LocalisationEntity> implements LocalisationDao {


    @Override
    public LocalisationEntity find(Integer codePostal) {
        Query query = session.createQuery("SELECT t FROM LocalisationEntity t WHERE code_postal = " + codePostal);
        return (LocalisationEntity) query.getSingleResult();
    }


    public Collection<LocalisationEntity> findVilles(Integer codePostal) {
        Query query = session.createQuery("SELECT t FROM LocalisationEntity t WHERE code_postal = " + codePostal);
        return (Collection<LocalisationEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        if (session.createQuery("DELETE FROM LocalisationEntity").executeUpdate() > 0) {
            return true;
        }
        return false;
    }


    public Collection<LocalisationEntity> find() {
        Query query = session.createQuery("SELECT t FROM LocalisationEntity t");
        return (Collection<LocalisationEntity>) query.getResultList();
    }

    public Collection<LocalisationEntity> findAll() {
        Query query = session.createQuery("SELECT t FROM LocalisationEntity t");
        return (Collection<LocalisationEntity>) query.getResultList();
    }
}
