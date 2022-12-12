/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author adityaraj
 */
public class FoodOrderDirectory {
    private ArrayList<FoodOrder> foodOrderDirectory;
     
     public FoodOrderDirectory() {
         foodOrderDirectory = new ArrayList<>();
     }

    public ArrayList<FoodOrder> getFoodOrderDirectory() {
        return foodOrderDirectory;
    }

    public void setFoodOrderDirectory(ArrayList<FoodOrder> foodOrderDirectory) {
        this.foodOrderDirectory = foodOrderDirectory;
    }
}
