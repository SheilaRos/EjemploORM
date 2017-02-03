package transporthib;

import java.util.List;
import org.hibernate.HibernateException;

public class TransportHib {
    public static void main(String[] args) {
        try{
            TransportORM gestor = new TransportORM();
            System.out.println("Iniciada sesión con Hibernate");
            System.out.println("Test: Insertando ciudad...");
            //City c = new City("08001", "Barcelona");
           // gestor.insertCity(c);
            System.out.println("Ciudad insertada.");
             System.out.println("Insertando paquete...");
            Truckdriver d = new Truckdriver("45875215E", "Leopoldo", "666999666", 1000.0);
            City a = new City ("08033", "Barcelona");
            Package p = new Package(a, d, "Amancio");
            gestor.insertPackage(p);
           System.out.println("Paquete insertado.");
           System.out.println("");
           System.out.println("Modificando sueldo del camionero Leopoldo....");
            Truckdriver td = new Truckdriver("45875215E", "Leopoldo", "666999666", 1800.0);
            gestor.updateSueldo(td);
           System.out.println("Sueldo modificado correctamente.");
           System.out.println("");
           System.out.println("Devolver la lista de camiones que conduce Leopoldo:");
            List<Truck> trucks = gestor.selectTruck(d);
            for(Truck t : trucks){
                System.out.println(t);
            }
           System.out.println("");
           System.out.println("Devolver los paquetes que se han enviado a Barcelona:");
            List<Package> packages = gestor.selectPackageBy(a);
            for(Package pg: packages){
                System.out.println(pg);
            }
           System.out.println("");
           System.out.println("Devolver un ranking de envios por ciudad:");
            List<RankingEnvios> cities = gestor.rankingCity();
            for(RankingEnvios re: cities){
                System.out.println(re);
            }
            gestor.close();
            System.out.println("Sesión cerrada.");
        }catch(HibernateException ex){
            System.out.println(ex);
        }
    } 
}
