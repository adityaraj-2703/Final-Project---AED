/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author adityaraj
 */
public class CityDao {
    Connection conn;
    public CityDao() {
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
    public int getCount (){
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from city";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              if(rs.next()){
                  count = rs.getInt(1);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return count;
    }

    public int createCity(String cid, String name, String state) {
        int result=0;
        try{
          String sql  = "insert into city values(?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,cid);
          stmt.setString(2,name);
          stmt.setString(3, state);
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
