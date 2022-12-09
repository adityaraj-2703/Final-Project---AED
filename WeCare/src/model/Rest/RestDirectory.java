/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Rest;

import java.util.ArrayList;
import model.Person;

/**
 *
 * @author anupamaditya
 */
public class RestDirectory {
     private ArrayList<RestDetails> RestaurantDirectory;
     
       public RestDirectory(){                            //this method is created whenever you can call docdirectory
        this.RestaurantDirectory = new ArrayList<RestDetails>();
    }

    public ArrayList<RestDetails> getRestaurantDirectory() {
        return RestaurantDirectory;
    }

    public void setRestaurantDirectory(ArrayList<RestDetails> RestaurantDirectory) {
        this.RestaurantDirectory = RestaurantDirectory;
    }
     public RestDetails addNewRestDetails(){
        RestDetails newdata = new RestDetails();    //it creates new data without any particular data in it 
        RestaurantDirectory.add(newdata);          //it adds empty new data to DocDirectory so that newdata is part of DocDirectory
        return newdata;                      //it returns the reference to newdata
    }
    
    public void deleteDoc(RestDetails rd){
        RestaurantDirectory.remove(rd);
    }
    
}
