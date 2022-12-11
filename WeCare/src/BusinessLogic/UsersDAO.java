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
import model.Organisation.Organisation;
import model.Organisation.OrganisationDirectory;
import model.Person;
import model.Roles.Role;
import model.city.Address;
import model.city.City;
import model.city.Community;

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
          String sql  = "update users set Status = ? where user_Name = ?";
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

    public ArrayList<Person> getUsers() {
        ArrayList<Person> pList = new ArrayList<>();
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
    public List<Person> getPendingAdmins() {
        ArrayList<Person> pList = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from Users where Status = ? and Role in (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"PENDING");
            stmt.setString(2,"FOOD_SERVICE_ADMIN");
            stmt.setString(3,"CLOTHES_SERVICE_ADMIN");
            stmt.setString(4,"VOLUNTEER_SERVICE_ADMIN");
            stmt.setString(5,"HOUSING_SERVICE_ADMIN");
            
            rs = stmt.executeQuery(); 
            while (rs.next()){
                Person p = new Person();
                p.setUserID(rs.getInt(1));
                p.setfName(rs.getString(2));
                p.setEmailAddress(rs.getString(3));
                p.setUserName(rs.getString(4));
                p.setRole(Role.RoleType.valueOf(rs.getString(6)));
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

    public List<Enterprise> getEnterprise() {
        ArrayList<Enterprise> pList = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from Enterprise";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql); 
            while(rs.next()){
                
                String type = rs.getString(2);
                Enterprise e = new Enterprise(Enterprise.EnterpriseType.valueOf(type));
                e.setEnterpriseId(rs.getString(1));
                e.setCity(getCity(rs.getString(3)));
                e.setPerson(getUser(rs.getString(4)));
                pList.add(e);
            }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return pList;
    }
    
    

    private Person getUser(String string) {
        
        Person p = null;
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from users where user_Name = ?";
              PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1, string);
              rs = st.executeQuery();
              if(rs.next()){
                p =  new Person();
                p.setUserID(rs.getInt(1));
                p.setfName(rs.getString(2));
                p.setEmailAddress(rs.getString(3));
                p.setUserName(rs.getString(4));
                p.setAddress(rs.getString(7));
                p.setPhoneNo(rs.getString(8));
                p.setAge(rs.getInt(9));
                p.setStatus(rs.getString(10));
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return p;
    }

    private City getCity(String string) {
        City p = null;
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from city where cityId = ?";
              PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1, string);
              rs = st.executeQuery();
              if(rs.next()){
                p =  new City();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setState(rs.getString(3));
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return p;
    }

    public List<Person> getClothesManagers() {
        List<Person> pList = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql  = "select * from users where Role in (?,?,?,?) and Status = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "COLLEGE_MANAGER");
            stmt.setString(2, "OUTLETS_MANAGER");
            stmt.setString(3, "RESIDENTS_MANAGER");
            stmt.setString(4, "NGO_MANAGER");
            stmt.setString(5, "PENDING");
            rs = stmt.executeQuery();
            while(rs.next()){
                Person p =  new Person();
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
            return pList;
            
    
            
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        return pList;
    }
    
    public Address getAddress(String id) {
        Address add = new Address();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from address where addressId = ?";
                
              PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1,id);
              rs = st.executeQuery();
              while(rs.next()){
                  
                  add.setAddressId(rs.getString(1));
                  add.setStreetAddress(rs.getString(2));
                  add.setPinCode(rs.getString(3));
                  
                  
                  
                  
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return add;
        
    }

    public ArrayList<Organisation> getOrganisation(Enterprise e) {
        ArrayList<Organisation> pList = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql  = "select * from organisation where OrganisationEnterprise = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getEnterpriseId());
            
            rs = stmt.executeQuery();
            while(rs.next()){
                Organisation o = new Organisation();
                o.setOrganisationId(rs.getString(1));
                o.setOrganisationType(rs.getString(2));
                o.setOrganisationName(rs.getString(3));
                o.setAddress(getAddress(rs.getString(4)));
                o.setPerson(getUser((rs.getString(5))));
                o.setPhoneNo(rs.getString(6));
                
               
                pList.add(o);
            }
            return pList;
            
            
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        return pList;
    }
}

