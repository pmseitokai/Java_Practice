/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaClass;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author INT303
 */
public class BuildConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            String connectionURL = "jdbc:mysql://jsp.itkmutt19.in.th/project_comicbookstore";
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            con = DriverManager.getConnection(connectionURL+"?useUnicode=true&characterEncoding=UTF-8", "comicbookstore", "J5aJHr");
        }catch(Exception ex){
            out.println("Unable to connect to database: "+ex);
        }
        return con ;
    }
    
    public static void main(String[] args) {
        BuildConnection.getConnection();
    }

}
