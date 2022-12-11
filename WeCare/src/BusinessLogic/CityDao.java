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
import java.util.ArrayList;
import java.util.List;
import model.city.Address;
import model.city.City;
import model.city.Community;

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

    public int insertIntoCity(City c) {
        int result=0;
        try{
          String sql  = "insert into city values(?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,c.getId());
          stmt.setString(2,c.getName());
          stmt.setString(3, c.getState());
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from city";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  City c =  new City();
                  c.setId(rs.getString(1));
                  c.setName(rs.getString(2));
                  //c.setCommunityList(getCommunities(c.getId()));
                  c.setState(rs.getString(3));
                  cities.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return cities;
            
    }

    public List<Community> getCommunities(City c) {
        List<Community> communities = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from community where communityCityId = ?";
                
              PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1,c.getId());
              rs = st.executeQuery();
              while(rs.next()){
                  Community comm =  new Community();
                  comm.setCommunityId(rs.getString(1));
                  comm.setCommunityName(rs.getString(2));
                  comm.setCity(c);
                  communities.add(comm);
                  
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return communities;
        
    }
    
    public List<Address> getAddresses(Community c) {
        List<Address> addresses = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from address where addressCommunityId = ?";
                
              PreparedStatement st = conn.prepareStatement(sql);
              st.setString(1,c.getCommunityId());
              rs = st.executeQuery();
              while(rs.next()){
                  Address comm =  new Address();
                  comm.setAddressId(rs.getString(1));
                  comm.setStreetAddress(rs.getString(2));
                  comm.setPinCode(rs.getString(3));
                  comm.setCommunity(c);
                  addresses.add(comm);
                  
                  
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return addresses;
        
    }
    
    

    public int updateCity(City c,String name,String state) {
        int result=0;
        try{
          String sql  = "update city set cityName = ? , cityState = ? where cityId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,name);
          stmt.setString(2,state);
          stmt.setString(3, c.getId());
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int createCommunity(Community c) {
        int result=0;
        try{
          String sql  = "insert into community values(?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,c.getCommunityId());
          stmt.setString(2,c.getCommunityName());
          stmt.setString(3, c.getCity().getId());
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Integer getComunityCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from community";
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
    /*
    public List<Community> getCommunities() {
        List<Community> communities = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from community";
                
              Statement st = conn.createStatement();
              
              rs = st.executeQuery(sql);
              while(rs.next()){
                  Community c =  new Community();
                  c.setCommunityId(rs.getString(1));
                  c.setCommunityName(rs.getString(2));
                  communities.add(c);
                  
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return communities;
    }
    */

    public int updateCommunity(String id, String name) {
        int result=0;
        try{
          String sql  = "update community set communityName = ?  where communityId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,name);
          stmt.setString(2,id);
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int createAddress(Address address) {
        int result=0;
        try{
          String sql  = "insert into address values(?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,address.getAddressId());
          stmt.setString(2,address.getStreetAddress());
          stmt.setString(3, address.getPinCode());
          stmt.setString(4, address.getCommunity().getCommunityId());
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Integer getAddressCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from address";
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
