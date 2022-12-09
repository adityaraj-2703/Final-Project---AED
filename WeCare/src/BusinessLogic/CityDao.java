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
            
            String sql  = "select count(*) from city";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  City c =  new City();
                  c.setId(rs.getString(1));
                  c.setName(rs.getString(2));
                  c.setCommunityList(getCommunities(c.getId()));
                  c.setState(rs.getString(3));
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return cities;
    }

    private List<Community> getCommunities(String id) {
        List<Community> communities = new ArrayList<>();
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select count(*) from community where cityId = ?";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  Community c =  new Community();
                  c.setCommunityId(rs.getString(1));
                  c.set(rs.getString(2));
                  c.setCommunityList(getCommunities(c.getId()));
                  c.setState(rs.getString(3));
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return cities;
        
    }
}
