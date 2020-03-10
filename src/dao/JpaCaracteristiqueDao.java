package dao;

import metier.CaracteristiqueEntity;
import org.hibernate.query.Query;


public class JpaCaracteristiqueDao extends JpaDao<CaracteristiqueEntity> implements CaracteristiqueDao{

    @Override
    public CaracteristiqueEntity find(Integer id) {
        Query query = session.createQuery("SELECT t FROM CaracteristiqueEntity t WHERE id = " + id);
        return (CaracteristiqueEntity) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        if(session.createQuery("DELETE FROM CaracteristiqueEntity").executeUpdate() > 0){
            return true;
        }
        return false;
    }
}
