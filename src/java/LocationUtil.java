/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abhishek
 */
public class LocationUtil {
      public ArrayList<Location> getLocationList(String districtName, String speciesName){
        ArrayList<Location> arrayList = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        try{
            arrayList = new ArrayList<Location>();
            conn = getConnection();
            stmt = conn.createStatement() ;
            if(speciesName!=null){
                rset = stmt.executeQuery("select observation.latitude,observation.longitude from observation, species"
                                        + " where observation.speciesid = species.speciesid "
                                        + " and upper(species.scientificname)='"+speciesName.toUpperCase()+"'");
            }else{
                rset = stmt.executeQuery("select observation.latitude,observation.longitude from observation, location "
                                         + "where observation.locationid = location.locationid "
                                         + "and upper(location.district) ='"+districtName.toUpperCase()+"'");
            }
            while(rset.next()){
                arrayList.add(new Location(rset.getString("longitude"),rset.getString("latitude")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LocationUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arrayList;
       
    }
    
    public Connection getConnection() throws SQLException{
        Connection con = null;
        String url = "jdbc:oracle:thin:@128.2.144.109:1521:xe";
        //String db = "usaid";
        String driver = "oracle.jdbc.OracleDriver";
        String user = "usaid";
        String pass = "icimod";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection is closed...");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args){
        LocationUtil locationUtil = new LocationUtil();
        ArrayList<Location> arrayList = locationUtil.getLocationList("koshi", null);
    }

}
