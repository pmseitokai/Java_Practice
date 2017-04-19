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
public class Login extends HttpServlet {

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

        HttpSession s = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer c = Customer.findById(username);
        String msg = "";
        if (c == null) {
            msg = "Invalid ID";
            s.setAttribute("msg", msg);
            //getServletContext().getRequestDispatcher(response.encodeURL("/Page/index.jsp")).forward(request, response);
            response.sendRedirect("Page/login.jsp");
        } else {
            String realPassword = c.getPass();
            if (password.equals(realPassword)) {
                s.setAttribute("username", username);
                s.setMaxInactiveInterval(60*60*24*7);
                //getServletContext().getRequestDispatcher(response.encodeURL("/Page/index.jsp")).forward(request, response);
                
                s.setAttribute("pre",c.getPrefix());
                s.setAttribute("name",c.getName());
                s.setAttribute("surname",c.getSurname());
                s.setAttribute("address",c.getAddress());
                s.setAttribute("province",c.getProvince());
                s.setAttribute("zip",c.getZip());
                s.setAttribute("tel",c.getMobile());
                s.setAttribute("email",c.getEmail());  
                
                if(username.equalsIgnoreCase("admin")){
                    response.sendRedirect("Page/AdminIndex.jsp");
                }else{
                    response.sendRedirect("Page/index.jsp");
                }
            } else {
                msg = "Invalid Password";
                s.setAttribute("msg", msg);
                //getServletContext().getRequestDispatcher(response.encodeURL("/Page/index.jsp")).forward(request, response);
                response.sendRedirect("Page/login.jsp");
            }
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
