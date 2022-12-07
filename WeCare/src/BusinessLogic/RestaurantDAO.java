/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author anupamaditya
 */
public class RestaurantDAO {
    Connection conn;
    int id =0;
    public  RestaurantDAO(){
        
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewProject", "root", "Pass1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    public int getID(){
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewProject", "root", "Pass1234");
          String sql  = "select max(RestaurantID) from Users";
          Statement st = conn.createStatement();
          rs = st.executeQuery(sql);
          while(rs.next()){
              
              id = rs.getInt(1);
              id++;
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    
    
}
