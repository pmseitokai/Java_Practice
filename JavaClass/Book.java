/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ~Mono~
 */
public class Book {
    private String bookId;
    private String bookName;
    private String isbn;
    private String writerName;
    private String pubName;
    private String picURL;
    private float cost;
    private String categories;
    private int quantity;
    
    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String Categories) {
        this.categories = Categories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    /*public static Book findById(String bId){
        Book b = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + "FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + "JOIN Writers w ON b.writer_id = w.writer_id"
                + "JOIN Publishers p ON b.pub_id = p.pub_id"
                + "WHERE b.book_id = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, bId);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                b = new Book();
                getRow(b,rs);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return b;
    }
    
    public static Book findByWriter(String wName){
        Book b = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE w.writer_name like ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%"+wName+"%");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                b = new Book();
                getRow(b,rs);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return b;
    }*/
    
    public static List<Book> findByWriter(String name) {
        Book b = null;
        List<Book> books = null;
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE w.writer_name like ?";
        Connection conn = BuildConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%"+name+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
                if (books == null) {
                    books = new ArrayList<>();
                }
                    books.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return books;
    }
    
    public static List<Book> findByName(String bName){
        Book b = null;
        Connection conn = BuildConnection.getConnection();
        List<Book> books = null;
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE book_name like ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%"+bName+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
                if (books == null) {
                    books = new ArrayList<>();
                }
                    books.add(b);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return books;
    }   
    public static List<Book> findByISBN(String isbn){
        Book b = null;
        Connection conn = BuildConnection.getConnection();
        List<Book> books = null;
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE b.isbn = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, isbn);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
                if (books == null) {
                    books = new ArrayList<>();
                }
                    books.add(b);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return books;
    }
    
    public static Book findById(String id){
        Book b = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE b.book_id = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return b;
    }
    
    public static List<Book> findByCat(String cat){
        Book b = null;
        String catId = getCatId(cat);
        Connection conn = BuildConnection.getConnection();
        List<Book> books = null;
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE b.cate_id = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, catId);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
                if (books == null) {
                    books = new ArrayList<>();
                }
                    books.add(b);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return books;
    } 
    
        public static List<Book> findByPublisher(String pub){
        Book b = null;
        String pubId = getPubId(pub);
        Connection conn = BuildConnection.getConnection();
        List<Book> books = null;
        String sqlCmd = "SELECT b.book_id , b.book_name , c.cate_name , b.isbn , w.writer_name , p.pub_name , b.b_picture , b.price"
                + " FROM Book b JOIN Categories c ON b.cate_id = c.cate_id"
                + " JOIN Writers w ON b.writer_id = w.writer_id"
                + " JOIN Publishers p ON b.pub_id = p.pub_id"
                + " WHERE b.pub_id = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, pubId);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                b = new Book();
                getRow(b, rs);
                if (books == null) {
                    books = new ArrayList<>();
                }
                    books.add(b);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return books;
    } 
    
    public boolean addBook(String bId,int quantity){
        Connection conn = BuildConnection.getConnection();
        String sqlCmd1 = "SELECT * FROM Book WHERE book_id like ?";
        boolean r = true;
        try {        
            PreparedStatement pstm1 = conn.prepareStatement(sqlCmd1);
            pstm1.setString(1, "%"+bId+"%");           
            ResultSet rs = pstm1.executeQuery();
            if(!(rs.next())){
                System.out.println("Here");
                System.out.println(bookId);
                System.out.println(bookName);
                System.out.println(getCatId(categories));
                System.out.println(isbn);
                System.out.println(Writer.searchWriter(writerName));
                System.out.println(getPubId(pubName));
                System.out.println(picURL);
                System.out.println(cost);
                String sqlCmd2 = "INSERT INTO Book VALUES(? , ? , ? , ? , ? , ? , ? , ? , 1)";
                PreparedStatement pstm2 = conn.prepareStatement(sqlCmd2);
                pstm2.setString(1,bookId);
                pstm2.setString(2,bookName);
                pstm2.setString(3,getCatId(categories));
                pstm2.setString(4,isbn);
                pstm2.setInt(5,Writer.searchWriter(writerName));
                pstm2.setString(6,getPubId(pubName));
                pstm2.setString(7,picURL);
                pstm2.setFloat(8,cost);
                pstm2.executeUpdate();
                r = true; 
            }
            else{
                /*b = new Book();
                getRow(b, rs);
                String sqlCmd2 = "UPDATE BOOK SET quantity = ? WHERE book_id = ?";
                PreparedStatement pstm2 = conn.prepareCall(sqlCmd2);
                pstm2.setInt(1,this.quantity + quantity);
                pstm2.setString(2,bId);
                pstm2.executeUpdate();
                return true;*/                
                r = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public static String getPubId(String publisher){
        String pubId = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT * FROM Publishers WHERE pub_name like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%"+publisher+"%"); 
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                pubId = rs.getString("pub_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return pubId;
    }
    
    public String getWriterId(String writer){
        String writeId = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT * FROM Writers WHERE writer_name like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%" + writer + "%"); 
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                writeId = rs.getString("writer_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return writeId;
    }
    
    public static String getCatId(String cat){
        String catId = null;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT * FROM Categories WHERE cate_name like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, "%" + cat + "%"); 
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                catId = rs.getString("cate_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return catId;
    }    
    
    private static void getRow(Book b, ResultSet rs) throws SQLException {
        b.setBookId(rs.getString("b.book_id"));
        b.setBookName(rs.getString("b.book_name"));
        b.setCategories(rs.getString("c.cate_name"));
        b.setIsbn(rs.getString("b.isbn"));
        b.setWriterName(rs.getString("w.writer_name"));
        b.setPubName(rs.getString("p.pub_name"));
        b.setPicURL(rs.getString("b.b_picture"));
        b.setCost(rs.getFloat("b.price"));
    }
    
}
