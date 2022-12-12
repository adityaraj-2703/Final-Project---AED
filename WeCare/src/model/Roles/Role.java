/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Roles;

import javax.swing.JPanel;
import model.Data;
import model.Enterprise.Enterprise;
import model.Organisation.Organisation;
import model.Person;
import model.city.City;

/**
 *
 * @author adityaraj
 */
public abstract class Role {
    public enum RoleType {
        RESTAURANT_MANAGER("RESTAURANT_MANAGER"),
        COLLEGE_MANAGER("COLLEGE_MANAGER"),
        FOOD_SERVICE_ADMIN("FOOD_SERVICE_ADMIN"),
        CLOTHES_SERVICE_ADMIN("CLOTHES_SERVICE_ADMIN"),
        SYSTEM_ADMIN("SYSTEM_ADMIN"),
        HOUSING_SERVICE_ADMIN("HOUSING_SERVICE_ADMIN"),
        VOLUNTEER_SERVICE_ADMIN("VOLUNTEER_SERVICE_ADMIN"),
        DISTRIBUTION_MANAGER("DISTRIBUTION_MANAGER"),
        OUTLET_MANAGER("OUTLET_MANAGER"),
        RESIDENT_MANAGER("RESIDENT_MANAGER"),
        NGO_MANAGER("NGO_MANAGER"),
        USER("USER");
                
        private String value;
        
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
        
    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            Data data,
            Person person  
            );

    
    
}
