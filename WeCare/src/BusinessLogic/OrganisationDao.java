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
import model.Organisation.Organisation;
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
    
    public int insertDetails(String id,String organisationType, String organisationName, Address location, Person serviceManager, String organisationPhoneNo,String eId) throws SQLException{
        int result = 0;
        try{
            String sql  = "update users set Status = ? where user_Name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"APPROVED");
            stmt.setString(2,serviceManager.getUserName());
            result = stmt.executeUpdate();
            int i=0;
            if(result ==1 ){
                sql  = "insert into organisation values(?,?,?,?,?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, id);
                stmt.setString(2,organisationType);
                stmt.setString(3,organisationName);
                stmt.setString(4,location.getAddressId());
                stmt.setString(5,serviceManager.getUserName());
                stmt.setString(6,organisationPhoneNo);
                stmt.setString(7,eId);
                i = stmt.executeUpdate();
            }
            
            
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

    public int updateDetails(String organisationId, String organisationType, String organisationName, Address address, Person person, String phoneNo, String eId) {
         int result=0;
        try{
          String sql  = "update organisation set organisationType = ? , organisationName = ?, OrganisationAddress = ?, OrganisationManager = ?,OrganisationPhoneNo = ? where organisationId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,organisationType);
          stmt.setString(2,organisationName);
          stmt.setString(5, phoneNo);
          stmt.setString(3, address.getAddressId());
          stmt.setString(4, person.getUserName());
          stmt.setString(6, organisationId);
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int deleteDetails(Organisation o, String eId) {
        int result=0;
        try{
          String sql  = "delete from organisation where organisationId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,o.getOrganisationId());
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
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

    public Organisation getOrganisation(Person p1) {
        int v=0;
        Organisation o=null;
        ResultSet rs = null;
        try{
          String sql  = "select * from organisation where OrganisationManager = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,p1.getUserName());
          
          rs = stmt.executeQuery();
          if(rs.next()){
              o = new Organisation();
              o.setOrganisationId(rs.getString(1));
              o.setOrganisationType(rs.getString(2));
              o.setOrganisationName(rs.getString(3));
              o.setAddress(getAddress(rs.getString(4)));
              o.setPerson(getUser(rs.getString(5)));
              
              
          }
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }
    
    
    
}
