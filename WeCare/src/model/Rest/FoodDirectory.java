/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Rest;

import java.util.ArrayList;

/**
 *
 * @author anupamaditya
 */
public class FoodDirectory {
     private ArrayList<FoodDetails> FoodDirectory;
     
     
     public FoodDirectory(){                            //this method is created whenever you can call docdirectory
        this.FoodDirectory = new ArrayList<FoodDetails>();
    }


    public ArrayList<FoodDetails> getFoodDirectory() {
        return FoodDirectory;
    }

    public void setFoodDirectory(ArrayList<FoodDetails> FoodDirectory) {
        this.FoodDirectory = FoodDirectory;
    }
     
}
