/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaClass;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ~Mono~
 */
public class Cart implements Serializable{
    private List<Book> books = new ArrayList<Book>();
    private static int count = 0;
    
    public List<Book> getListBook(){
        return books;
    }
    
    public void setListBook(List<Book> books){
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cart.count = count;
    } 
    
    public static void addOrder(List<Book> b , Date d,String cId){
        Connection conn = BuildConnection.getConnection();
        PreparedStatement pstm = null;
        String sqlCmd = null;
        
        try{
            for(Book b1 : b){

                sqlCmd = "INSERT INTO project_comicbookstore.Order VALUES(NULL,?,?,'w',?,?)";
                pstm = conn.prepareStatement(sqlCmd);
                pstm.setDate(1, d);
                pstm.setString(2,cId);
                pstm.setString(3, b1.getBookId());
                pstm.setInt(4,b1.getQuantity());
                pstm.executeUpdate();
                
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public static List<Book> addBook(List<Book> b, String book_id, int quantity) {
        int check = 0;
        for (Book b1 : b) {
            if (b1.getBookId().equalsIgnoreCase(book_id)) {
                b1.setQuantity(b1.getQuantity()+quantity);
                check = 1;
                break;
            }

        }
        if (check == 0) {
            Book b2 = Book.findById(book_id);
            b2.setQuantity(quantity);
            b.add(b2);
        }
        count++;
        return b;
    }

    public static List<Book> removeProduct(List<Book> b, String book_id) {
        int index = 0;
        for (Book b1 : b) {
            if (b1.getBookId().equalsIgnoreCase(book_id)) {
                break;
            }else{
                index++;
            }
        }
        b.remove(index);
        count--;
        return b;
    }    
    
    public static List<Book> replaceProduct(List<Book> b, String book_id, int quan) {
        int index = 0;
        for (Book b1 : b) {
            if (b1.getBookId().equalsIgnoreCase(book_id)) {
                b1.setQuantity(quan);
                break;
            }else{
                index++;
            }
        }
        return b;
    }  
    
}
