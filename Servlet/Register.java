/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import JavaClass.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ~Mono~
 */
public class Register extends HttpServlet {

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
        
        String id = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String prefix = request.getParameter("prefix");        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String identity = request.getParameter("identity");
        String address = request.getParameter("address");
        String zip = request.getParameter("zipcode");
        String province = request.getParameter("province");
        String mobile = request.getParameter("phone");
        
        /*HttpSession session = request.getSession();
        
        session.setAttribute("id", id);
        session.setAttribute("pass", pass);
        session.setAttribute("email", email);
        session.setAttribute("prefix", prefix);
        session.setAttribute("name", name);
        session.setAttribute("surname", surname);
        session.setAttribute("address", address);
        session.setAttribute("zip", zip);
        session.setAttribute("province", province);
        session.setAttribute("mobile",mobile);*/
        
        
        Customer c = new Customer();
        
        c.setId(id);
        c.setPass(pass);
        c.setEmail(email);
        c.setPrefix(prefix);
        c.setName(name);
        c.setSurname(surname);
        c.setIdentity_number(identity);
        c.setAddress(address);
        c.setZip(zip);
        c.setProvince(province);
        c.setMobile(mobile);

        c.register();
        response.sendRedirect("Page/regis_check.jsp");
        //getServletContext().getRequestDispatcher("/Page/regis_check.jsp").forward(request, response);
        
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
