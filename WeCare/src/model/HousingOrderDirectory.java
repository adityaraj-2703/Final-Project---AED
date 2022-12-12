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
public class HousingOrderDirectory {
    private ArrayList<HousingOrder> housingOrderDirectory;
     
     public HousingOrderDirectory() {
         housingOrderDirectory = new ArrayList<>();
     }

    public ArrayList<HousingOrder> getHousingOrderDirectory() {
        return housingOrderDirectory;
    }

    public void setHousingOrderDirectory(ArrayList<HousingOrder> housingOrderDirectory) {
        this.housingOrderDirectory = housingOrderDirectory;
    }
    
}
