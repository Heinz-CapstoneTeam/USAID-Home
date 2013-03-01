/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;


/**
 *
 * @author Sourav
 */

public class Volunteer  {
    private BigDecimal volunteerid;
    private String volunteername;
    private String volunteeremail;
   

    public Volunteer() {
    }

   

    public BigDecimal getVolunteerid() {
        return volunteerid;
    }

    public void setVolunteerid(BigDecimal volunteerid) {
        this.volunteerid = volunteerid;
    }

    public String getVolunteername() {
        return volunteername;
    }

    public void setVolunteername(String volunteername) {
        this.volunteername = volunteername;
    }

    public String getVolunteeremail() {
        return volunteeremail;
    }

    public void setVolunteeremail(String volunteeremail) {
        this.volunteeremail = volunteeremail;
    }

   
    
}
