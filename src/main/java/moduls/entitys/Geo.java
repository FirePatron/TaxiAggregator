package moduls.entitys;
// Generated 13.08.2021 16:05:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Geo generated by hbm2java
 */
@Entity
@Table(name="geo"
    ,catalog="taxicomp"
)
public class Geo  implements java.io.Serializable {


     private int idGeo;
     private String county;
     private String city;
     private String street;
     private String home;
     private Set<Order> ordersForEndGeo = new HashSet<Order>(0);
     private Set<Order> ordersForStartGeo = new HashSet<Order>(0);

    public Geo() {
    }

	
    public Geo(int idGeo, String county, String city, String street, String home) {
        this.idGeo = idGeo;
        this.county = county;
        this.city = city;
        this.street = street;
        this.home = home;
    }
    public Geo(String[] str) {
       this.county = str[0];
       this.city = str[1];
       this.street = str[2];
       this.home = str[3];
    }
   
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @Column(name="idGeo", unique=true, nullable=false)
    public int getIdGeo() {
        return this.idGeo;
    }
    
    public void setIdGeo(int idGeo) {
        this.idGeo = idGeo;
    }

    
    @Column(name="County", nullable=false, length=45)
    public String getCounty() {
        return this.county;
    }
    
    public void setCounty(String county) {
        this.county = county;
    }

    
    @Column(name="City", nullable=false, length=45)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="Street", nullable=false, length=45)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="Home", nullable=false, length=45)
    public String getHome() {
        return this.home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="geoByEndGeo")
    public Set<Order> getOrdersForEndGeo() {
        return this.ordersForEndGeo;
    }
    
    public void setOrdersForEndGeo(Set<Order> ordersForEndGeo) {
        this.ordersForEndGeo = ordersForEndGeo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="geoByStartGeo")
    public Set<Order> getOrdersForStartGeo() {
        return this.ordersForStartGeo;
    }
    
    public void setOrdersForStartGeo(Set<Order> ordersForStartGeo) {
        this.ordersForStartGeo = ordersForStartGeo;
    }




}


