/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Roles;

import UI.Outlet.OutletManagerPanel;
import javax.swing.JPanel;
import model.Data;
import model.Person;

/**
 *
 * @author adityaraj
 */
public class OutletsManagerRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Data data, Person person) {
       return new OutletManagerPanel(data, person);
    }
}
