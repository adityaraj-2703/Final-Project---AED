/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Organisation.Organisation;

/**
 *
 * @author anupamaditya
 */
public class ClothesOrder {
      private String orderId;
    private String ClothesId;
    private Person person;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClothesId() {
        return ClothesId;
    }

    public void setClothesId(String clothesId) {
        this.ClothesId = clothesId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

   
}
