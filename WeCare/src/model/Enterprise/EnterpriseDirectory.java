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
    
    
    
}
