/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author adityaraj
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseDirectory;
    
    public EnterpriseDirectory(){
        enterpriseDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(ArrayList<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public void addEnterprise(){
        Enterprise e1 = new FoodService(Enterprise.EnterpriseType.FoodService, "FoodService");
        Enterprise e2 = new ClothesService(Enterprise.EnterpriseType.ClothesService, "ClothesService");
        Enterprise e3 = new VolunteerService(Enterprise.EnterpriseType.VolunteerService, "VolunteerService");
        Enterprise e4 = new HousingService(Enterprise.EnterpriseType.HousingService, "HousingService");
        enterpriseDirectory.add(e1);
        enterpriseDirectory.add(e2);
        enterpriseDirectory.add(e3);
        enterpriseDirectory.add(e4);
        
    }
    public Enterprise getEnterprise(Enterprise.EnterpriseType etype){
        Enterprise enterprise=null;
        for(Enterprise e : enterpriseDirectory)
            if(e.getEnterpriseType() == etype){
                enterprise = e;
            }
        return enterprise;
    }
    
    
}
