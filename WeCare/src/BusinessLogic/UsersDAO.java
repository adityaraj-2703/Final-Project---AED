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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Enterprise.Enterprise;
import model.Person;

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

    public int createAdmin(Enterprise e) {
        int result=0;
        try{
          String sql  = "update users set Status = ? where userName = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,"APPROVED");
          stmt.setString(2,e.getPerson().getUserName());
          result = stmt.executeUpdate();
          if(result==1){
            String sql1 = "insert into Enterprise values(?,?,?,?)";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, e.getEnterpriseId());
            stmt.setString(2, e.getEnterpriseType().getValue());
            stmt.setString(3, e.getCity().getId());
            stmt.setString(4,e.getPerson().getUserName());
            result = stmt.executeUpdate();
          }
          
          
          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public List<Person> getUsers() {
        List<Person> pList = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            Person p = new Person();
            String sql  = "select * from Users";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if (rs.next()){
                p.setUserID(rs.getInt(1));
                p.setfName(rs.getString(2));
                p.setEmailAddress(rs.getString(3));
                p.setUserName(rs.getString(4));
                p.setAddress(rs.getString(7));
                p.setPhoneNo(rs.getString(8));
                p.setAge(rs.getInt(9));
                p.setStatus(rs.getString(10));
                pList.add(p);
            }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return pList;
    }

    public Integer getAdminCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from enterprise";
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
    
}

