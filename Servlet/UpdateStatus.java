/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import JavaClass.BuildConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ~Mono~
 */
public class UpdateStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession s = request.getSession();
        String status = request.getParameter("status");
        String date = s.getAttribute("date").toString();
        String order_id = request.getParameter("order_id");
        int year = Integer.parseInt(date.substring(0, 4))-1900;
        int month = Integer.parseInt(date.substring(5, 7))-1;
        int day = Integer.parseInt(date.substring(8,10));
        Date d = new Date(new java.util.Date(year,month,day).getTime());        
        String cid = s.getAttribute("cid").toString();
        
        ResultSet rs = null;
        try{
        Connection conn = BuildConnection.getConnection();
         
        Statement stm = conn.createStatement();
        String sqlCmd1 = "UPDATE project_comicbookstore.Order SET"
                + " project_comicbookstore.Order.status = '"+status+"'"
                + "WHERE project_comicbookstore.Order.order_id = '"+order_id+"'";
        
        stm.executeUpdate(sqlCmd1);
        
        String sqlCmd2 = "SELECT * FROM project_comicbookstore.Order "
                + "WHERE project_comicbookstore.Order.date ='"+d+"'"
                + "AND project_comicbookstore.Order.cid = '"+cid+"'";
        rs = stm.executeQuery(sqlCmd2);
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        s.setAttribute("resultSet", rs);
        response.sendRedirect("Page/adminSearchResult.jsp");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

}
