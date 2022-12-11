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
public class FoodDetails {
    String FoodID;
    String FoodName;
    String FoodType;
    int  FoodQuantity;
    Organisation org;
    String foodStatus;

    public String getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
    }
    
    

    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    
    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public String getFoodType() {
        return FoodType;
    }

    public void setFoodType(String FoodType) {
        this.FoodType = FoodType;
    }

    public int getFoodQuantity() {
        return FoodQuantity;
    }

    public void setFoodQuantity(int FoodQuantity) {
        this.FoodQuantity = FoodQuantity;
    }

    @Override
    public String toString() {
        return this.FoodName;
    }
    
    
    
    
    
    
    
    
}
