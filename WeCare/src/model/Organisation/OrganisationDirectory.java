/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Organisation;

import java.util.ArrayList;

/**
 *
 * @author adityaraj
 */
public class OrganisationDirectory {
    private ArrayList<Organisation> organisationList;
    
    public OrganisationDirectory() {
        organisationList = new ArrayList();
    }

    public ArrayList<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(ArrayList<Organisation> organisationList) {
        this.organisationList = organisationList;
    }
    
    
    
}
