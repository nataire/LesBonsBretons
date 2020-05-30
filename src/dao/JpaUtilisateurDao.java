package dao;

import metier.UtilisateurEntity;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaUtilisateurDao extends JpaDao<UtilisateurEntity> implements UtilisateurDao {

    //region Override
    @Override
    public Collection<UtilisateurEntity> FindAllUserAnnonce() {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t ");
        return (Collection<UtilisateurEntity>) query.getResultList();
    }


    @Override
    public UtilisateurEntity find(Integer idUser) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE id = " + idUser);
        return (UtilisateurEntity) query.getSingleResult();
    }


    public UtilisateurEntity connexionUser(String mEmail, String mPassword) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE t.login =  :mEmail  AND t.password = :mPassword");
        query.setParameter("mEmail", mEmail); // replace first ? with value for first name
        query.setParameter("mPassword", mPassword);
        return (UtilisateurEntity) query.getSingleResult();
    }

    @Override
    public boolean update(String password, String numTel, String rue, int numRue, String ville, int idUtilisateur) {
        Query query = session.createQuery("UPDATE UtilisateurEntity SET password = :password, numTel = :numTel, rue = :rue, numRue = :numRue, ville =: ville WHERE idUtilisateur = :idUtilisateur");
        query.setParameter("password", password);
        query.setParameter("numTel", numTel);
        query.setParameter("rue", rue);
        query.setParameter("numRue", numRue);
        query.setParameter("ville", ville);
        query.setParameter("idUtilisateur", idUtilisateur);
        return true;
    }

    @Override
    public Collection<UtilisateurEntity> findAll() {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t");
        return (Collection<UtilisateurEntity>) query.getResultList();
    }

    public boolean deleteAll() {
        if (session.createQuery("DELETE FROM UtilisateurEntity").executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    //endregion


}
