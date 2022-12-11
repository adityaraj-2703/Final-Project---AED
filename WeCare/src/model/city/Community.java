/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.city;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adityaraj
 */
public class Community {
    private String communityId;
    private String CommunityName;
    private City city;
    private List<Address> houseList;
    
    public Community(){
       houseList = new ArrayList<>();
       addCommunities();
       
    }

    public String getCommunityId() {
        return communityId;
    }
    
    
    public String getCommunityName() {
        return CommunityName;
    }

    public City getCity() {
        return city;
    }

    public List<Address> getHouseList() {
        return houseList;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
    

    public void setCommunityName(String CommunityName) {
        this.CommunityName = CommunityName;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setHouseList(List<Address> houseList) {
        this.houseList = houseList;
    }
    
    @Override
    public String toString() {
        return this.CommunityName;
    }

    public Address addHouse() {
        
        Address h = new Address();
        houseList.add(h);
        return h;
    }

    public Address getHouse(String text) {
        Address h = new Address();
        for(Address house : houseList){
            if(house.getAddressId().equals(text)){
                h = house;
                break;
            }
        }
        return h;
    }

    private void addCommunities() {
        
    }

    
    
    
    
    
    
}
