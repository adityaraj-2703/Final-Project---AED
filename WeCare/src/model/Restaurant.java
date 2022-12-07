/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author akshitabarot
 */
public class Restaurant {
    private String restName; 
     private String restAddress;
     Person  restManager;

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(String restAddress) {
        this.restAddress = restAddress;
    }

    public Person getRestManager() {
        return restManager;
    }

    public void setRestManager(Person restManager) {
        this.restManager = restManager;
    }
     
    
}
