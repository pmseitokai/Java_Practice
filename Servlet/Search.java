/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import JavaClass.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ~Mono~
 */
public class Search extends HttpServlet {

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
        String searchMethod = request.getParameter("search");
        String msg = null;
        String searchName = request.getParameter("searchname");
        List<Book> b = null;
        boolean found;
        if(searchMethod.equalsIgnoreCase("Author")){
            b = Book.findByWriter(searchName);
            //b = b.findByWriter(searchName);
        }
        if(searchMethod.equalsIgnoreCase("Title")){
            b = Book.findByName(searchName);
            //b = b.findByName(searchName);
        }
        if(searchMethod.equalsIgnoreCase("ISBN")){
            b = Book.findByISBN(searchName);
            //b = b.findByISBN(searchName);
        }
        
        HttpSession session = request.getSession();
        System.out.println(b==null);
        if(b != null){
            found = true;
            /*String bId = b.getBookId();
            String bName = b.getBookName();
            String category = b.getCategories();
            String isbn = b.getIsbn();
            String writer = b.getWriterName();
            String publisher = b.getPubName();
            String pictureURL = b.getPicURL();
            String cost = String.valueOf(b.getCost());

            session.setAttribute("bookId", bId);
            session.setAttribute("bookName", bName);
            session.setAttribute("category", category);
            session.setAttribute("isbn", isbn);
            session.setAttribute("writer", writer);
            session.setAttribute("publisher", publisher);
            session.setAttribute("pURL", pictureURL);
            session.setAttribute("cost", cost);*/
            session.setAttribute("BookList", b);
        }else{
            found = false;
            msg = "Your search has not found.";
            session.setAttribute("msg", msg);
            b = null;
            session.setAttribute("BookList", b);
        }
        session.setAttribute("searchName", searchName);            
        session.setAttribute("found", found);        
        response.sendRedirect("Page/Result.jsp");        
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
