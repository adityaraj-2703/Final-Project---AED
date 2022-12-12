/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author anupamaditya
 */
public class ClothesOrderDirectory {
     private ArrayList<ClothesOrder> clothesOrderDirectory;
     
     public ClothesOrderDirectory() {
         clothesOrderDirectory = new ArrayList<>();
     }

    public ArrayList<ClothesOrder> getClothesOrderDirectory() {
        return clothesOrderDirectory;
    }

    public void setClothesOrderDirectory(ArrayList<ClothesOrder> clothesOrderDirectory) {
        this.clothesOrderDirectory = clothesOrderDirectory;
    }
     
}
