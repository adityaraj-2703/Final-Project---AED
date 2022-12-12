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
import model.FoodDetails;
import model.FoodOrder;
import model.HousingDetails;
import model.HousingOrder;
import model.Person;
import model.city.Address;

/**
 *
 * @author adityaraj
 */
public class OrderDao {
    Connection conn;
    public OrderDao() {
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

    public int addOrder(FoodOrder fo) {
        try{
          String sql  = "insert into FoodOrder values(?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,fo.getOrderId());
          stmt.setString(2,fo.getFoodId());
          stmt.setString(3,fo.getPerson().getUserName());
          int i = stmt.executeUpdate();
          return i;        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Integer getCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from foodOrder";
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

    public List<FoodOrder> getFoodOrders() {
        ArrayList<FoodOrder> foodOrders = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from foodOrder";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  FoodOrder fo =  new FoodOrder();
                  fo.setFoodId(rs.getString(1));
                  fo.setOrderId(rs.getString(2));
                  fo.setPerson(getUser(rs.getString(3)));
                  //c.setCommunityList(getCommunities(c.getId()));
                  
                  foodOrders.add(fo);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return foodOrders;
    }

    public Integer getHousingCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from housing";
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

    public int addHousing(HousingDetails ho) {
        try{
          String sql  = "insert into housing values(?,?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,ho.getHousingID());
          stmt.setString(2,ho.getBookingDate());
          stmt.setString(3,ho.getHousingAddress().getAddressId());
          stmt.setInt(4,ho.getAvailableBeds());
          stmt.setString(5,ho.getStatus());
          int i = stmt.executeUpdate();
          return i;        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
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

    public ArrayList<HousingDetails> getHousingDetails() {
        ArrayList<HousingDetails> housing = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from housing where availableBeds > 0";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  HousingDetails c =  new HousingDetails();
                  c.setHousingID(rs.getString(1));
                  c.setBookingDate(rs.getString(2));
                  c.setHousingAddress(getAddress(rs.getString(3)));
                  //c.setCommunityList(getCommunities(c.getId()));
                  c.setAvailableBeds(rs.getInt(4));
                  
                  c.setStatus(rs.getString(5));
                  housing.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return housing;
    }

    public int approveHouse(HousingDetails h) {
        int result=0;
        try{
          String sql  = "update housing set Status = ? where housingId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,"APPROVED");
          stmt.setString(2,h.getHousingID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int addHousingOrder(HousingOrder ho) {
        try{
          String sql  = "insert into housingorder values(?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,ho.getOrderId());
          stmt.setString(2,ho.getHousingId());
          stmt.setString(3,ho.getPerson().getUserName());
          
          int i = stmt.executeUpdate();
          return i;        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int updateHousing(HousingDetails f) {
        int result=0;
        try{
          String sql  = "update housing set availableBeds = ? where housingId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1,f.getAvailableBeds()-1);
          stmt.setString(2,f.getHousingID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<HousingOrder> getHousingOrders() {
        ArrayList<HousingOrder> housingOrders = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from housingOrder";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  HousingOrder ho =  new HousingOrder();
                  ho.setOrderId(rs.getString(1));
                  ho.setHousingId(rs.getString(2));
                  ho.setPerson(getUser(rs.getString(3)));
                  //c.setCommunityList(getCommunities(c.getId()));
                  housingOrders.add(ho);
                  
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return housingOrders;
    }

    public Integer getHousingOrderCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from housingOrder";
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

    public List<HousingDetails> getApprovedOrderDetails() {
        ArrayList<HousingDetails> housing = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from housing where Status = ? and availableBeds > 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"APPROVED");
              rs = st.executeQuery();
              while(rs.next()){
                  HousingDetails c =  new HousingDetails();
                  c.setHousingID(rs.getString(1));
                  c.setBookingDate(rs.getString(2));
                  c.setHousingAddress(getAddress(rs.getString(3)));
                  //c.setCommunityList(getCommunities(c.getId()));
                  c.setAvailableBeds(rs.getInt(4));
                  
                  c.setStatus(rs.getString(5));
                  housing.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return housing;
    }
    
    
}
