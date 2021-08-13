package moduls.entitys;
// Generated 13.08.2021 16:05:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Aggregator generated by hbm2java
 */
@Entity
@Table(name="aggregator"
    ,catalog="taxicomp"
)
public class Aggregator  implements java.io.Serializable {


     private int idAggregator;
     private String name;
     private String mainUrl;
     private Set<Searchforaggregator> searchforaggregators = new HashSet<Searchforaggregator>(0);

    public Aggregator() {
    }

	
    public Aggregator(int idAggregator) {
        this.idAggregator = idAggregator;
    }
    public Aggregator(String name, String mainUrl, Set<Searchforaggregator> searchforaggregators) {
       this.name = name;
       this.mainUrl = mainUrl;
       this.searchforaggregators = searchforaggregators;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @Column(name="idAggregator", unique=true, nullable=false)
    public int getIdAggregator() {
        return this.idAggregator;
    }
    
    public void setIdAggregator(int idAggregator) {
        this.idAggregator = idAggregator;
    }

    
    @Column(name="Name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="MainURL", length=45)
    public String getMainUrl() {
        return this.mainUrl;
    }
    
    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="aggregator")
    public Set<Searchforaggregator> getSearchforaggregators() {
        return this.searchforaggregators;
    }
    
    public void setSearchforaggregators(Set<Searchforaggregator> searchforaggregators) {
        this.searchforaggregators = searchforaggregators;
    }




}


