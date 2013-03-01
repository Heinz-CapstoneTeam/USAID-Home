/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


/**
 *
 * @author Sourav
 */

public class Observation{
    private String locationid;
    private String observationid;
    private String photoid;
    private Date dateofobservation;
    private String volunteerid;
    private String speciesid;
     private String longitude;
    private String latitude;

    public Observation() {
    }

   

   
    public String getObservationid() {
        return observationid;
    }

    public void setObservationid(String observationid) {
        this.observationid = observationid;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public Date getDateofobservation() {
        return dateofobservation;
    }

    public void setDateofobservation(Date dateofobservation) {
        this.dateofobservation = dateofobservation;
    }

    public String getVolunteerid() {
        return volunteerid;
    }

    public void setVolunteerid(String volunteerid) {
        this.volunteerid = volunteerid;
    }

    public String getSpeciesid() {
        return speciesid;
    }

    public void setSpeciesid(String speciesid) {
        this.speciesid = speciesid;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

   
}
