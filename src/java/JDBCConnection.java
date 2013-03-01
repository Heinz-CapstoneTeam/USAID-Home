/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sourav
 */
public class JDBCConnection {

    private static final String jdbcURL = "jdbc:oracle:thin:@128.2.144.109:1521:XE";
    Connection connection = null;
    private static final String userName="usaid";
    private static final String password="icimod";
    private static JDBCConnection connOject = new JDBCConnection();

    private JDBCConnection() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
          
    }    
    
    public static JDBCConnection getInstance(){
     
        return connOject;
    
    }

    public Connection getConnection() {
        
        

        if (connection != null) {
            System.out.println("Cant create a connection");
        } else {
            FileInputStream fis = null;
            try {
                Properties security = new Properties();
                
               // String dir = System.getProperty("user.dir")+"\\src\\capstone\\usaid\\";
               // System.out.println(dir);
              //  fis = new FileInputStream(dir+"\\"+"security.properties");
              //  security.load(fis);
               // System.out.println("userName:" +security.getProperty("userName"));
                connection = DriverManager.getConnection(jdbcURL, userName, password);
               


//            } catch (IOException ex) {
//                Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {

                System.out.println(e.getMessage());


            } finally {
//                try {
//                    //fis.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }

      return connection;
     
    }
}
