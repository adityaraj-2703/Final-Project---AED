/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.city.Address;

/**
 *
 * @author anupamaditya
 */
public class HousingDetails {
    String housingID;
    String housingName;
    Address housingAddress;
    int availableBeds;
    String bookingDate;

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    

    public String getHousingID() {
        return housingID;
    }

    public void setHousingID(String housingID) {
        this.housingID = housingID;
    }

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public Address getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(Address housingAddress) {
        this.housingAddress = housingAddress;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }
    
    
    
}
