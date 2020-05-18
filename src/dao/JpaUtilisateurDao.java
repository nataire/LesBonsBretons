package dao;

import metier.UtilisateurEntity;
import org.hibernate.Transaction;
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


    public UtilisateurEntity Connexion(String mEmail, String mPassword) {
        Query query = session.createQuery("SELECT t FROM UtilisateurEntity t WHERE login =  ?  AND password = ?");
        query.setParameter(1, mEmail); // replace first ? with value for first name
        query.setParameter(2, mPassword);
        return (UtilisateurEntity) query.getSingleResult();
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


    public void inscriptionUser(UtilisateurEntity utilisateur) {


        /*Query query = session.createQuery("INSERT INTO UtilisateurEntity ( login, password, numTel, rue, numRue, idLocalisationUtilisateur) " +
                "VALUES ( " + utilisateur.getLogin() + ","
                + utilisateur.getPassword() + ","
                + utilisateur.getNumTel() +","
                + utilisateur.getRue() +","
                + utilisateur.getNumRue() +","
                + utilisateur.getIdLocalisationUtilisateur() +");");
*/

        Transaction txn = session.beginTransaction();

        Query updateQuery
                = session.createNativeQuery("INSERT INTO Utilisateur ( login, password, numTel, rue, numRue, idLocalisationUtilisateur) VALUES (?,?,?,?,?,?)");
        updateQuery.setParameter(1, utilisateur.getLogin());
        updateQuery.setParameter(2, utilisateur.getPassword());
        updateQuery.setParameter(3, utilisateur.getNumTel());
        updateQuery.setParameter(4, utilisateur.getRue());
        updateQuery.setParameter(5, utilisateur.getNumRue());
        updateQuery.setParameter(6, utilisateur.getIdLocalisationUtilisateur());
        updateQuery.executeUpdate();


        txn.commit();

    }

}
