/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;


/**
 *
 * @author Sourav
 */

public class Species  {
    private String speciesid;
    private String scientificname;
    private String localname;
    private String familyname;
    private String locationid;
    private String commonhabitat;

  
    private String indicator;
    
    public Species() {
    }

    
      public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getSpeciesid() {
        return speciesid;
    }

    public void setSpeciesid(String speciesid) {
        this.speciesid = speciesid;
    }

    public String getScientificname() {
        return scientificname;
    }

    public void setScientificname(String scientificname) {
        this.scientificname = scientificname;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getCommonhabitat() {
        return commonhabitat;
    }

    public void setCommonhabitat(String commonhabitat) {
        this.commonhabitat = commonhabitat;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    

  
 
    
}
