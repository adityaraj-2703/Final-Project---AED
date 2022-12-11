/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.city;

/**
 *
 * @author adityaraj
 */
public class Address {
    private String addressId;
    private String streetAddress;
    private Community community;
    private String pinCode;

    public String getAddressId() {
        return addressId;
    }
    
    
    
    public String getStreetAddress() {
        return streetAddress;
    }

    public Community getCommunity() {
        return community;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setAddressId(String houseId) {
        this.addressId = houseId;
    }

    

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    
    @Override
    public String toString() {
        return this.streetAddress;
    }
}
