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
import model.Food;
import model.FoodDetails;
import model.Organisation.Organisation;
import model.Person;
import model.city.City;

/**
 *
 * @author adityaraj
 */
public class FoodDao {
    Connection conn;
    public FoodDao() {
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

    public int addFood(FoodDetails f, Organisation o) {
        try{
          String sql  = "insert into Food values(?,?,?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,f.getFoodID());
          stmt.setString(2,f.getFoodName());
          stmt.setString(3,f.getFoodType());
          stmt.setInt(4,f.getFoodQuantity());
          stmt.setString(5,f.getOrg().getOrganisationId());
          stmt.setString(6, f.getFoodStatus());
          
          
          
          int i = stmt.executeUpdate();
          return i;        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int getCount() {
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from food";
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
    
    public Organisation getOrganisation(String s1) {
        int v=0;
        Organisation o=null;
        ResultSet rs = null;
        try{
          String sql  = "select * from organisation where OrganisationId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,s1);
          
          rs = stmt.executeQuery();
          if(rs.next()){
              o = new Organisation();
              o.setOrganisationId(rs.getString(1));
              o.setOrganisationType(rs.getString(2));
              o.setOrganisationName(rs.getString(3));
              
              
              
          }
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }

    public ArrayList<FoodDetails> getFoodDetails() {
        ArrayList<FoodDetails> foods = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from food where foodQuantity > 0";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  FoodDetails c =  new FoodDetails();
                  c.setFoodID(rs.getString(1));
                  c.setFoodName(rs.getString(2));
                  c.setFoodType(rs.getString(3));
                  //c.setCommunityList(getCommunities(c.getId()));
                  c.setFoodQuantity(rs.getInt(4));
                  c.setOrg(getOrganisation(rs.getString(5)));
                  c.setFoodStatus(rs.getString(6));
                  foods.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return foods;
    }

    public int approveFood(FoodDetails f) {
        int result=0;
        try{
          String sql  = "update food set foodStatus = ? where foodId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,"APPROVED");
          stmt.setString(2,f.getFoodID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<FoodDetails> getApprovedFoodDetails() {
        ArrayList<FoodDetails> foods = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from food where foodStatus = ? and foodQuantity > 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"APPROVED");
              rs = st.executeQuery();
              while(rs.next()){
                  FoodDetails c =  new FoodDetails();
                  c.setFoodID(rs.getString(1));
                  c.setFoodName(rs.getString(2));
                  c.setFoodType(rs.getString(3));
                  //c.setCommunityList(getCommunities(c.getId()));
                  c.setFoodQuantity(rs.getInt(4));
                  c.setOrg(getOrganisation(rs.getString(5)));
                  c.setFoodStatus(rs.getString(6));
                  foods.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return foods;
    }

    public int updateFood(FoodDetails f) {
        int result=0;
        try{
          String sql  = "update food set foodQuantity = ? where foodId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1,f.getFoodQuantity()-1);
          stmt.setString(2,f.getFoodID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    
}
