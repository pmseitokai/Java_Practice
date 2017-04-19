/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

/**
 *
 * @author ~Mono~
 */
public class Writer {
    //private static  DecimalFormat df = new DecimalFormat("0000");
    private static int writerId ;
    private String writerName;
    
    /*public static void increment(){
        writerId++;
    }*/

    public static int getWriterId() {
        return writerId;
    }
    
    /*public static String transform(int id){
        String form = df.format(id);
        return "w"+form;
    }*/

    public static void setWriterId(int writerId) {
        Writer.writerId = writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    
    public static int searchWriter(String name){
        int id = 0;
        Connection conn = BuildConnection.getConnection();
        String sqlCmd = "SELECT * FROM Writers WHERE writer_name like ?";
        try{    
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1,"%"+name+"%");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                id = rs.getInt("writer_id");
            }else{
                String sqlCmd2 = "INSERT INTO Writers(writer_name) VALUES(?)";
                PreparedStatement pstm2 = conn.prepareStatement(sqlCmd2);
                pstm2.setString(1,name);
                pstm2.executeUpdate();
                
                String sqlCmd3 = "SELECT * FROM Writers WHERE writer_name like ?";
                PreparedStatement pstm3 = conn.prepareStatement(sqlCmd3);
                pstm3.setString(1, "%"+name+"%");
                ResultSet rs2 = pstm3.executeQuery();
                if(rs.next())
                    id = rs2.getInt("writer_id");
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return id;
    }
    
    public static void main(String[] args) {
        System.out.println(Writer.searchWriter("164"));
        
    }
    
}
