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
public class ClothesDetails {
    String clothesID;
    String clothesCategory;
    int clothesQuantity;
    String serviceTYpe;
    String serviceName;
     Organisation org;
   String clothesStatus;
   String clothesName;

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }
   

    public String getClothesStatus() {
        return clothesStatus;
    }

    public void setClothesStatus(String clothesStatus) {
        this.clothesStatus = clothesStatus;
    }
           
    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    public String getClothesID() {
        return clothesID;
    }

    public void setClothesID(String clothesID) {
        this.clothesID = clothesID;
    }

    public String getClothesCategory() {
        return clothesCategory;
    }

    public void setClothesCategory(String clothesCategory) {
        this.clothesCategory = clothesCategory;
    }

    public int getClothesQuantity() {
        return clothesQuantity;
    }

    public void setClothesQuantity(int clothesQuantity) {
        this.clothesQuantity = clothesQuantity;
    }

    public String getServiceTYpe() {
        return serviceTYpe;
    }

    public void setServiceTYpe(String serviceTYpe) {
        this.serviceTYpe = serviceTYpe;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
     @Override
    public String toString() {
        return this.clothesName;
    }
    
}
