/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enterprise;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<Enterprise> addEnterprise(/*Enterprise.EnterpriseType entType*/){
       
        Enterprise e1 = new FoodService(Enterprise.EnterpriseType.FoodService);
        Enterprise e2 = new ClothesService(Enterprise.EnterpriseType.ClothesService);
        Enterprise e3 = new VolunteerService(Enterprise.EnterpriseType.VolunteerService);
        Enterprise e4 = new HousingService(Enterprise.EnterpriseType.HousingService);
        enterpriseDirectory.add(e1);
        enterpriseDirectory.add(e2);
        enterpriseDirectory.add(e3);
        enterpriseDirectory.add(e4);
        
        /*
        Enterprise e;
        if(entType == Enterprise.EnterpriseType.ClothesService){
            e = new ClothesService(Enterprise.EnterpriseType.ClothesService);
            enterpriseDirectory.add(e);
        }
        else if(entType == Enterprise.EnterpriseType.FoodService){
            e = new FoodService(Enterprise.EnterpriseType.FoodService);
            enterpriseDirectory.add(e);
        }
        
        else if(entType == Enterprise.EnterpriseType.VolunteerService){
            e = new VolunteerService(Enterprise.EnterpriseType.VolunteerService);
            enterpriseDirectory.add(e);
        }
        else{
            e= new HousingService(Enterprise.EnterpriseType.HousingService);
            enterpriseDirectory.add(e);
        }
        return e;
        */
        return enterpriseDirectory;
        
        
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
