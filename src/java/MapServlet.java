/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tartan
 */
public class MapServlet extends HttpServlet {

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
            throws ServletException, IOException, JSONException {
//        LocationUtil locationUtil = new LocationUtil();
//       
//        response.setContentType("text/html;charset=UTF-8");
//        ArrayList<Location> arrayList = new ArrayList<Location>();
//        //arrayList.add(new Location("17.74033553", "83.25067267"));
//        //arrayList.add(new Location("10", "20"));
//        
//        arrayList =   locationUtil.getLocationList("Dhankuta", null);
//        
//        
////        Iterator arrayListIterator = arrayList.iterator();
////        
////         while(arrayListIterator.hasNext()) {
////         Object element = arrayListIterator.next();
////         System.out.print(element + " ");
////      }
//        
//        JSONArray jsonArray = new JSONArray(arrayList);
//        try {
//            JSONObject json = new JSONObject();
//            json.put("jsonArray", jsonArray);
//            PrintWriter pw = response.getWriter(); 
//            pw.print(json.toString());
//            pw.close();
//        } finally {
//        }
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
        try {
           // processRequest(request, response);
            
                  LocationUtil locationUtil = new LocationUtil();
       
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Location> arrayList = new ArrayList<Location>();
        //arrayList.add(new Location("17.74033553", "83.25067267"));
        //arrayList.add(new Location("10", "20"));
        
       arrayList =   locationUtil.getLocationList("Dhankuta", null);
      //  System.out.println("%$#$#$#$#$#$# dyanamic species: "+ request.getParameter("species"));
        
        //arrayList =   locationUtil.getLocationList(null, request.getParameter("species"));
       
        
        Iterator arrayListIterator = arrayList.iterator();
        
         while(arrayListIterator.hasNext()) {
         Object element = arrayListIterator.next();
         System.out.print("%%%%%% "+element + " ");
      }
        
        JSONArray jsonArray = new JSONArray(arrayList);
        try {
            JSONObject json = new JSONObject();
            json.put("jsonArray", jsonArray);
            PrintWriter pw = response.getWriter(); 
            pw.print(json.toString());
            pw.close();
        } finally {
        }
            
            
            
            
            
        } catch (JSONException ex) {
            Logger.getLogger(MapServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(MapServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
