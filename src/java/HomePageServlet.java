/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek
 */
public class HomePageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomePageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomePageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
     public List populatePlant(List plantList, int district_id){
        
//        Plant p1 = new Plant();
//        Plant p2 = new Plant();
//        Plant p3 = new Plant();
//        Plant p4 = new Plant();
//        Plant p5 = new Plant();
//        Plant p6 = new Plant();
//        p1.name = "Mangifera_indica";
//        p2.name = "Michelia Champaca (Chanp)";
//        p3.name = "Sapindus Mukorossi";
//        p4.name = "Alnus Nepalensis";
//        p5.name = "Oak Chestnut";
//        p6.name = "Acrous Clalmus (Bojh)";
//        
//        
//        plantList.add(p1);
//        plantList.add(p2);
//        plantList.add(p3);
//        plantList.add(p4);
//        plantList.add(p5);
//        plantList.add(p6);

        
        ObsDataDAO obsDataDAO = new ObsDataDAO();
        
        List<Species> speciesList = new ArrayList<Species>();
        speciesList =  obsDataDAO.getSpeciesData(district_id);
        
      
        Iterator<Species> iter = speciesList.iterator();
        
        while (iter.hasNext()){
            Species sp =  iter.next();
            
       
            if( sp.getIndicator().equals("P")){
                plantList.add(sp.getScientificname());
            }
         }
        
        
        
        
        return plantList;
       
        
        
    }
    
    
    public String getDistrictName(int district_id){
        String districtName = new String();
        
          ObsDataDAO obsDataDAO = new ObsDataDAO();
       districtName = obsDataDAO.getDistrictName(district_id);
          return districtName;
    }
    
    
    public String getPlantPicture(int district_id){
        String picUrl = new String();
        
          ObsDataDAO obsDataDAO = new ObsDataDAO();
           picUrl = obsDataDAO.getObservationData(district_id,"P").get(0).getPhotoid();
          return picUrl;
    }
    
        
    public String getAnimalPicture(int district_id){
        String picUrl = new String();
        
          ObsDataDAO obsDataDAO = new ObsDataDAO();
         picUrl= obsDataDAO.getObservationData(district_id,"A").get(0).getPhotoid();
         return picUrl;
    } 
    
     public List populateAnimal(List animalList,int district_id){
        
//        Animal a1 = new Animal();
//        Animal a2 = new Animal();
//        Animal a3 = new Animal();
//        Animal a4 = new Animal();
//        Animal a5 = new Animal();
//        Animal a6 = new Animal();
//        
//        a1.name = "Common Leopard (Chituwa)";
//        a2.name = "Deer (Mirga)";
//        a3.name = "Black Bear (Bhalu)";
//        a4.name = "Kalij Pheasant ";
//        a5.name = "Peafowl";
//        a6.name = "Dove";
//        
//        
//        animalList.add(a1);
//        animalList.add(a2);
//        animalList.add(a3);
//        animalList.add(a4);
//        animalList.add(a5);
//        animalList.add(a6);

        
         ObsDataDAO obsDataDAO = new ObsDataDAO();
        
        List<Species> speciesList = new ArrayList<Species>();
        speciesList =  obsDataDAO.getSpeciesData(district_id);
        
      
        Iterator<Species> iter = speciesList.iterator();
        
        while (iter.hasNext()){
            Species sp =  iter.next();
            
       
            if( sp.getIndicator().equals("A")){
                animalList.add(sp.getScientificname());
            }
         }
        
         
         
        return animalList;
       
        
        
    }
}
