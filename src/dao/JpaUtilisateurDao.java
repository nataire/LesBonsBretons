package dao;

import metier.UtilisateurEntity;
import org.hibernate.query.Query;

import java.beans.Statement;
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

    public Boolean inscriptionUser(UtilisateurEntity utilisateur) {

        Query query = session.createQuery("INSERT INTO UtilisateurEntity ( login, password, numTel, rue, numRue, idLocalisationUtilisateur) " +
                "VALUES ( " + utilisateur.getLogin() + ","
                + utilisateur.getPassword() + ","
                + utilisateur.getNumTel() +","
                + utilisateur.getRue() +","
                + utilisateur.getNumRue() +","
                + utilisateur.getIdLocalisationUtilisateur() +");");

        return (Boolean) query.getSingleResult();
    }

}
