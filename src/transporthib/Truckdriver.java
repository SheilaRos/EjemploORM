package transporthib;
// Generated 31-ene-2017 17:48:25 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Truckdriver generated by hbm2java
 */
public class Truckdriver  implements java.io.Serializable {


     private String dni;
     private String name;
     private String phone;
     private double salary;
     private Set trucks = new HashSet(0);
     private Set packages = new HashSet(0);

    public Truckdriver() {
    }

	
    public Truckdriver(String dni, String name, String phone, double salary) {
        this.dni = dni;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
    public Truckdriver(String dni, String name, String phone, double salary, Set trucks, Set packages) {
       this.dni = dni;
       this.name = name;
       this.phone = phone;
       this.salary = salary;
       this.trucks = trucks;
       this.packages = packages;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Set getTrucks() {
        return this.trucks;
    }
    
    public void setTrucks(Set trucks) {
        this.trucks = trucks;
    }
    public Set getPackages() {
        return this.packages;
    }
    
    public void setPackages(Set packages) {
        this.packages = packages;
    }




}

