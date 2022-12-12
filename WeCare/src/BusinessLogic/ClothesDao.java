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
import model.ClothesDetails;
import model.FoodDetails;
import model.Organisation.Organisation;

/**
 *
 * @author anupamaditya
 */
public class ClothesDao {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


/**
 *

 */
    Connection conn;
    public ClothesDao() {
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

    public int addclothes(ClothesDetails c, Organisation o) {
        try{
          String sql  = "insert into clothes values(?,?,?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,c.getClothesID());
          stmt.setString(2,c.getClothesCategory());
          stmt.setInt(3,c.getClothesQuantity());
          stmt.setString(4,c.getOrg().getOrganisationId());
          stmt.setString(5,c.getClothesStatus());
          stmt.setString(6, c.getClothesName());
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
            
            String sql  = "select count(*) from clothes";
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

    public ArrayList<ClothesDetails> getClothesDetails() {
        ArrayList<ClothesDetails> clothes = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from clothes";
              Statement st = conn.createStatement();
              rs = st.executeQuery(sql);
              while(rs.next()){
                  ClothesDetails c =  new ClothesDetails();
                  c.setClothesID(rs.getString(1));
                  c.setClothesCategory(rs.getString(2));
                  c.setClothesQuantity(rs.getInt(3));
                  c.setOrg(getOrganisation(rs.getString(4)));
                  c.setClothesStatus(rs.getString(5));
                   c.setClothesName(rs.getString(6));
                  clothes.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return clothes;
    }

    public int approveClothes(ClothesDetails c) {
        int result=0;
        try{
          String sql  = "update clothes set clothesStatus = ? where clothesId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,"APPROVED");
          stmt.setString(2,c.getClothesID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List<ClothesDetails> getApprovedClothesDetails() {
        ArrayList<ClothesDetails> clothes = new ArrayList<>();
        
        ResultSet rs = null;
        int count = 0;
        try{
            
            String sql  = "select * from clothes where clothesStatus = ? and clothesQuantity > 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"APPROVED");
              rs = st.executeQuery();
              while(rs.next()){
                  ClothesDetails c =  new ClothesDetails();
                  c.setClothesID(rs.getString(1));
                  c.setClothesCategory(rs.getString(2));
                  c.setClothesQuantity(rs.getInt(3));
                  //c.setCommunityList(getCommunities(c.getId()));
                   c.setOrg(getOrganisation(rs.getString(4)));                  
                  c.setClothesStatus(rs.getString(5));
                  c.setClothesName(rs.getString(6));
                  clothes.add(c);
              }
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return clothes;
    }

    public int updateClothes(ClothesDetails c) {
        int result=0;
        try{
          String sql  = "update clothes set clothesQuantity = ? where clothesId = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setInt(1,c.getClothesQuantity()-1);
          stmt.setString(2,c.getClothesID());
          
          result = stmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    
}


