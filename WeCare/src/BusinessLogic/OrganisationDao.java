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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Person;
import model.city.Address;

/**
 *
 * @author anupamaditya
 */
public class OrganisationDao {
    Connection conn;
    //String restName, restAddress, restManager, restPhoneNo;

    public  OrganisationDao(){
        
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewProject", "root", "Pass1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    
    public Connection getCon(){
        return conn;
    }
    public int getID(){
        ResultSet rs = null;
        int id =0;
        try{
            
          String sql  = "select max(RestaurantID) from Restaurant";
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
    
    public int insertDetails(String id,String organisationType, String organisationName, Address location, Person serviceManager, String organisationPhoneNo) throws SQLException{
        try{
            String sql  = "insert into organisation values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2,organisationType);
            stmt.setString(3,organisationName);
            stmt.setString(4,location.getAddressId());
            stmt.setString(5,serviceManager.getUserName());
            stmt.setString(6,organisationPhoneNo);
            int i = stmt.executeUpdate();
          return i; 
            
        } catch (Exception e) {
             e.printStackTrace();
        }
         return 0;
    }

    public List<Person> getPendingManagers() {
        List<Person> pList = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql  = "select user_name from users where Role = ? and Status = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "RESTAURANT_MANAGER");
            stmt.setString(2, "Pending");
            rs = stmt.executeQuery();
            while(rs.next()){
                Person p = new Person();
                p.setUserName(rs.getString(1));
                pList.add(p);
            }
            return pList;
            
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        return pList;
    }

    public int getCount() {
        ResultSet rs = null;
        int id =0;
        try{
            
          String sql  = "select count(*) from Organisation";
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
