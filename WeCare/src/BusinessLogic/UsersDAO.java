/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anupamaditya
 */
public class UsersDAO {
    Connection conn;
    public UsersDAO() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewProject", "root", "Pass1234");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }

    public Connection getConn() {
        return conn;
    }
    
    
    public int getID (){
        ResultSet rs = null;
        int id = 0;
        try{
            
            String sql  = "select max(userID) from Users";
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
    
    public int insertDetails(String name,String emailAddress, String userName,String password,
            String role,String address,String phoneNo,int age) throws SQLException{
        
        try{
          String sql  = "insert into Users values(?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1,getID());
          stmt.setString(2,name);
          stmt.setString(3,emailAddress);
          stmt.setString(4,userName);
          stmt.setString(5,password);
          stmt.setString(6,role);
          stmt.setString(7,address);        
          stmt.setString(8, phoneNo);
          stmt.setInt(9, age);
          if(role.equals("USER")){
              stmt.setString(10,"APPROVED");
          }
          else{
              stmt.setString(10,"PENDING");
          }
          int i = stmt.executeUpdate();
          return i;        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
}

