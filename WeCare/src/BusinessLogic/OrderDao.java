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
import model.Person;

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
    
    
}
