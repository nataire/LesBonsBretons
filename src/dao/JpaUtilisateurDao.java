package dao;

import metier.UtilisateurEntity;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaUtilisateurDao extends JpaDao<UtilisateurEntity> implements UtilisateurDao{

    //region Override
    @Override
    public Collection<UtilisateurEntity> FindAllUserAnnonce() {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t ");
        return (Collection<UtilisateurEntity>) query.getResultList();
    }

    @Override
    public UtilisateurEntity find(Integer idUser) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE id = " + idUser);
        return (UtilisateurEntity) query.getResultList();
    }

    @Override
    public UtilisateurEntity find(Class c, Integer id) {
        return null;
    }

    @Override
    public Collection<UtilisateurEntity> findAll() {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t");
        return (Collection<UtilisateurEntity>) query.getResultList();
    }

    public boolean deleteAll() {
        if(session.createQuery("DELETE FROM UtilisateurEntity").executeUpdate() > 0){
            return true;
        }
        return false;
    }

    //endregion


    public UtilisateurEntity connexionUser(String loginUser, String passwordUser) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE login = " + loginUser + " AND password = " + passwordUser);
        return (UtilisateurEntity) query.getResultList();
    }

    public UtilisateurEntity inscriptionUser(String loginUser, String passwordUser, String numTel, String rue, int numRue, int idLocalisation) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE login = " + loginUser
                + " AND password = " + passwordUser
                + " AND numTel = " + numTel
                + " AND rue = " + rue
                + " AND numRue = " + numRue
                + " AND idLocalisationUtilisateur = " + idLocalisation);
        return (UtilisateurEntity) query.getResultList();
    }

}