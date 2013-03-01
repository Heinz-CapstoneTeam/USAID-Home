/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sourav
 */
public class ObsDataDAO {

    public List<Species> getSpeciesData(int locationId) {
        
        List<Species> speciesList = new ArrayList<Species>();
      
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            Species species;
            Connection con = JDBCConnection.getInstance().getConnection();
            StringBuffer sql= new StringBuffer();
            sql.append(" Select a.scientificname, a.localname, a.familyname, a.commonhabitat, a.type ");
            sql.append(" from species a, observation b, location c ");
            sql.append(" where a.speciesid = b.speciesid ");
            sql.append(" and b.locationid = c.locationid ");
            sql.append(" and c.locationid = ?");
            pst = con.prepareCall(sql.toString());
            pst.setInt(1,locationId);
            rs = pst.executeQuery();
           

            while (rs.next()) {
                species = new Species();
                
               /* System.out.print("Species id :" + rs.getString(1));
                System.out.print("Scientific name: " + rs.getString(2));
                System.out.println("local name: " + rs.getString(3));
                System.out.print("family name:" + rs.getString(4));
                System.out.print("common habbitat" + rs.getString(5));
                System.out.println("location id " + rs.getString(6));*/
               
                species.setScientificname(rs.getString(1));
                species.setLocalname(rs.getString(2));
                species.setFamilyname(rs.getString(3));
                species.setCommonhabitat(rs.getString(4));
                species.setIndicator(rs.getString(5));
                speciesList.add(species);
            }
            
                      
        } catch (SQLException ex) {
            Logger.getLogger(ObsDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return speciesList;
    }
    
    public List<Location> getLocationDetails(int locationId) {
        
        List<Location> locationList = new ArrayList<Location>();
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            Location location;
            Connection con = JDBCConnection.getInstance().getConnection();
            String sql = "select * from usaid.location where locationid=? ";
            pst = con.prepareCall(sql);
            pst.setInt(1,locationId);
            rs = pst.executeQuery();
           

            while (rs.next()) {
                location = new Location();
                
         
                location.setAltitude(rs.getString(2));
             
                locationList.add(location);
            }
            
                      
        } catch (SQLException ex) {
            Logger.getLogger(ObsDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return locationList;
    }
    
    public List getDistrict() {
        
        List<Location> districtList = new ArrayList<Location>();
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            Location location;
            Connection con = JDBCConnection.getInstance().getConnection();
            String sql = "select locationid, district from usaid.location ";
            pst = con.prepareCall(sql);
         
            rs = pst.executeQuery();
           

            while (rs.next()) {
               location = new Location();
               location.setLocationid(rs.getString(1));
               location.setDistrict(rs.getString(2));
               
               districtList.add(location);
                
            }
            
                      
        } catch (SQLException ex) {
            Logger.getLogger(ObsDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return districtList;
    }
    
    public List<Observation> getObservationData(int locationId, String ind) {
        
        List<Observation> observationList = new ArrayList<Observation>();
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;
            Observation observation;
            Connection con = JDBCConnection.getInstance().getConnection();
            String sql = "select * from usaid.observation a, usaid.species b where a.speciesid = b.speciesid and b.type = ? and a.locationid = ? ";
            pst = con.prepareCall(sql);
            pst.setString(1, ind );
            pst.setInt(2,locationId);
            rs = pst.executeQuery();
           

            while (rs.next()) {
                observation = new Observation();
                observation.setPhotoid(rs.getString(2));
                observation.setLatitude(rs.getString(7));
                observation.setLongitude(rs.getString(7));
                observationList.add(observation);
            }
            
                      
        } catch (SQLException ex) {
            Logger.getLogger(ObsDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return observationList;
    }
    
    
     public String getDistrictName( int district_id) {
        
        String districtName = new String();
        try {
            
            
            PreparedStatement pst = null;
            ResultSet rs = null;
           
            Connection con = JDBCConnection.getInstance().getConnection();
            String sql = "select district from usaid.location where locationid=?";
            pst = con.prepareCall(sql);
            pst.setInt(1,district_id);
            rs = pst.executeQuery();
            
             while (rs.next()) {
                 districtName = rs.getString("district");
             }
            
             
                      
        } catch (SQLException ex) {
            Logger.getLogger(ObsDataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return districtName;
    }
    
    public static void main(String[] args){
    
        ObsDataDAO od = new ObsDataDAO();
     //   od.getSpeciesData(1);
       System.out.println(od.getDistrictName(1));
                
    
    }   
}
