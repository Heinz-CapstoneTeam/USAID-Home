/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deepakga
 */
@WebServlet(name = "RdfController", urlPatterns = {"/RdfController"})
public class RdfController extends HttpServlet {

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
    RdfModel gm = null;

//    @Override
//    public void init() {
//        gm = new RdfModel();
//    }

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


        String search = request.getParameter("search");
         System.out.println("&&&&&&&species"+search);
         
         
         search = search.replace(" ", "_");

        PrintWriter out = response.getWriter();

        request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");

        // see if search parameter is present
        if (search != null) {
            
         //@Override
          // public void init() {
        gm = new RdfModel();
         //}   
            
            
            // use model to do the search and choose the result view
            gm.doSearch(search);

            if (gm.getkingdom().contains("Plant")) {

                request.setAttribute("search", gm.getsearchstring());
                request.setAttribute("class", gm.getclass());
                request.setAttribute("kingdom", gm.getkingdom());
                request.setAttribute("familia", gm.getfamilia());
                request.setAttribute("order", gm.getorder());
                request.setAttribute("image", gm.getpicture());
                request.setAttribute("commnts", gm.getcomments());
                request.setAttribute("orderURL", gm.getorderURL());
                request.setAttribute("divisio", gm.getdivisio());
              //  request.setAttribute("classURL", gm.getclassURL());
              //  request.setAttribute("kingdomURL", gm.getkingdomURL());
                request.setAttribute("familiaURL", gm.getfamiliaURL());
                
                System.out.println("Calling Plantresult.jsp");

                RequestDispatcher view = request.getRequestDispatcher("Plantresult.jsp");
                view.forward(request, response);


            } else {

                request.setAttribute("search", gm.getsearchstring());
                request.setAttribute("class", gm.getclass());
                request.setAttribute("kingdom", gm.getkingdom());
                request.setAttribute("familia", gm.getfamilia());
                request.setAttribute("order", gm.getorder());
                request.setAttribute("image", gm.getpicture());
                request.setAttribute("commnts", gm.getcomments());
                request.setAttribute("phylum", gm.getphylum());
//                request.setAttribute("conservationStatus", gm.getconservationstatus());
                request.setAttribute("orderURL", gm.getorderURL());
            //    request.setAttribute("classURL", gm.getclassURL());
            //    request.setAttribute("kingdomURL", gm.getkingdomURL());
//                  request.setAttribute("familiaURL", gm.getfamiliaURL());
                
                System.out.println("Calling Animalresult.jsp");

                RequestDispatcher view = request.getRequestDispatcher("Animalresult.jsp");
                view.forward(request, response);


            }



        }
        
        else {
        
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        
        
        
        }
        
    }
}
