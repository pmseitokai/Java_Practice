/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import JavaClass.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ~Mono~
 */
public class EditPass extends HttpServlet {

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
        String old_pass = request.getParameter("old_pass");
        String new_pass1 = request.getParameter("new_pass1");
        String new_pass2 = request.getParameter("new_pass2");
        String msg;
        
        HttpSession s = request.getSession();
        
        Customer c = Customer.findById(s.getAttribute("username").toString());
        
        if(c.getPass().equalsIgnoreCase(old_pass)){
            if(new_pass1.equalsIgnoreCase(new_pass2)){
                c.editPassword(new_pass2);
                msg = "Your password has changed !!";
                s.setAttribute("msg", msg);
                response.sendRedirect("Page/customer_edit_password.jsp");
            }
            else{
                msg = "Please enter same both new password.";
                s.setAttribute("msg", msg);
                response.sendRedirect("Page/customer_edit_password.jsp");
            }
        }else{
            msg = "Check your old password.";
            s.setAttribute("msg", msg);
            response.sendRedirect("Page/customer_edit_password.jsp");
        }
        
        
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
