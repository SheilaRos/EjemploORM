package transporthib;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransportORM {
    private Session session;
    private Transaction tx;
    public TransportORM() {
        //Establecemos la conexión
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insertCity(City c) throws HibernateException{
            tx = session.beginTransaction();
            session.save(c);
            tx.commit();
    }
    
    public void updateCity(City c){
        tx = session.beginTransaction();
        session.update(c);
        tx.commit();
    }
    
    public void insertPackage(Package p){
        tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }
    
    public void updateSueldo(Truckdriver t){
        tx = session.beginTransaction();
        session.update(t);
        tx.commit();
    }
    public List<Truck> selectTruck(Truckdriver d){
        Query q = session.createQuery("select t from Truck t where truckdriver = '"+d.getDni()+"'");
        return q.list();
    }
    public List<Package> selectPackageBy(City c){
        Query q = session.createQuery("select distinct p from Package p where city = '"+c.getPostalcode()+"'");
        return q.list();
    }
    
    
    public void removeCity (City c){
        tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
    }
    public List<City> selectAllCity(){
        Query q = session.createQuery("select c from City c");
        return q.list();
    }
    public List<RankingEnvios> rankingCity(){
        Query q = session.createQuery("select c.name, count(p.idpackage) from City c, Package p where c.postalcode=p.city group by c.name");
        List<Object[]> resultado = q.list();
        List<RankingEnvios> ranking = new ArrayList<>();
        for(int i = 0; i<resultado.size(); i++){
            RankingEnvios r = new RankingEnvios();
            r.setNameCity((String)resultado.get(i)[0]);
            r.setEnvios((long)resultado.get(i)[1]);
            ranking.add(r);
        }
        return ranking;
    }
    
    // select c.name, p.idpackage from City c, Package p where p.
    public void close(){
        session.close();
    }
    
}
