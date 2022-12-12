/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Organisation.Organisation;

/**
 *
 * @author adityaraj
 */
public class Housing {
    private String housingId;
    private String BookingDate;
    private Organisation o;
    private int beds;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getHousingId() {
        return housingId;
    }

    public void setHousingId(String housingId) {
        this.housingId = housingId;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    public Organisation getO() {
        return o;
    }

    public void setO(Organisation o) {
        this.o = o;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
    
    
    
}
