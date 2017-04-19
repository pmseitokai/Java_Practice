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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ~Mono~
 */
public class Customer {
    private String id;
    private String pass;
    private String email;
    private String prefix;
    private String name;
    private String surname;
    private String identity_number;
    private Date birthday;
    private String address;
    private String zip;
    private String province;
    private String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String Province) {
        this.province = Province;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /*String id , String pass , String prefix , String name , String surname , String address
        , String province , String mobile , String email , String zip , String identity_number*/
    public void register(){
        int save = 0;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "INSERT INTO Customer values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1 , this.id);
            pstm.setString(2, this.pass);
            pstm.setString(3, this.prefix);
            pstm.setString(4,this.name);
            pstm.setString(5, this.surname);
            pstm.setString(6, this.address);
            pstm.setString(7, this.province);
            pstm.setString(8, this.mobile);
            pstm.setString(9, this.email);
            pstm.setString(10, this.zip);
            pstm.setString(11, this.identity_number);
            
            save = pstm.executeUpdate();
            conn.close();       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    public void editProfile(String id){
        int save = 0;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "UPDATE Customer SET fname=? , lname=? , address=? , city=? , tel=? , email=? , zipcode=? WHERE cid = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            
            pstm.setString(1,this.name);
            pstm.setString(2, this.surname);
            pstm.setString(3, this.address);
            pstm.setString(4, this.province);
            pstm.setString(5, this.mobile);
            pstm.setString(6, this.email);
            pstm.setString(7, this.zip);
            pstm.setString(8 , id);
            
            save = pstm.executeUpdate();
            conn.close();       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    public void editPassword(String new_pass){
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "UPDATE Customer SET password=? where cid=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1,new_pass);
            pstm.setString(2, this.id);            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Customer findById(String id) {
        Customer c = null;
        String sqlCmd = "SELECT * FROM Customer Where cid = ?";
        Connection conn = BuildConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                c = new Customer();
                getRow(c, rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return c;
    }
    
    private static void getRow(Customer c, ResultSet rs) throws SQLException {
        c.setId(rs.getString("cid"));
        c.setPass(rs.getString("password"));
        c.setPrefix(rs.getString("pre"));
        c.setName(rs.getString("fname"));
        c.setSurname(rs.getString("lname"));
        c.setAddress(rs.getString("address"));
        c.setProvince(rs.getString("city"));
        c.setMobile(rs.getString("tel"));
        c.setEmail(rs.getString("email"));
        c.setZip(rs.getString("zipcode"));
        c.setIdentity_number(rs.getString("identity_number"));
    }

}
