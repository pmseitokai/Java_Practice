/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import JavaClass.Book;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ~Mono~
 */
public class AddBook extends HttpServlet {

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
        
        String price = request.getParameter("price");
        float cost = parseFloat(request.getParameter("price"));
        
        Book b = new Book();
        b.setBookId(request.getParameter("bookId"));
        b.setBookName(request.getParameter("bookName"));
        b.setCost(cost);
        b.setIsbn(request.getParameter("isbn"));
        b.setPicURL(request.getParameter("picURL"));
        b.setPubName(request.getParameter("publisher"));
        b.setWriterName(request.getParameter("writerName"));
        b.setCategories(request.getParameter("categories"));
        String quan = request.getParameter("quantity");
        int quantity = Integer.parseInt(quan);
        
        boolean res = b.addBook(request.getParameter("bookId"),quantity);
        
        HttpSession s = request.getSession();
        String msg = null;
        if(res)
            msg = "Your book has added.";
        else
            msg = "ERROR!!";
        
        s.setAttribute("msg", msg);
        response.sendRedirect("Page/AdminAddBook.jsp");
            
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
