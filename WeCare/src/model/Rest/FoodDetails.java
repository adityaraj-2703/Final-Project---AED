/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Rest;

import model.Person;

/**
 *
 * @author anupamaditya
 */
public class FoodDetails {
    private String foodName;
    private String foodType;
    private String foodQuantity;
    RestDetails  restName;
    RestDetails  restAddress;
    Person  restManager;

    public Person getRestManager() {
        return restManager;
    }

    public void setRestManager(Person restManager) {
        this.restManager = restManager;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public RestDetails getRestName() {
        return restName;
    }

    public void setRestName(RestDetails restName) {
        this.restName = restName;
    }

    public RestDetails getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(RestDetails restAddress) {
        this.restAddress = restAddress;
    }
    
}
