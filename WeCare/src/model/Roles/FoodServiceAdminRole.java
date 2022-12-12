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
import UI.FoodService.FoodServiceAdminPanel;

/**
 *
 * @author adityaraj
 */
public class FoodServiceAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Data data, Person person) {
       return new FoodServiceAdminPanel(data, person);
    }

    
    
    
}

