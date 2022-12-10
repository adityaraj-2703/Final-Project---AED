/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Roles;

import javax.swing.JPanel;
import model.Data;
import model.Person;
import UI.ClothesService.ClothesServiceAdminPanel;

/**
 *
 * @author adityaraj
 */
public class ClothesServiceAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,Data data, Person person) {
        return new ClothesServiceAdminPanel(data,person);
    }
    
}
