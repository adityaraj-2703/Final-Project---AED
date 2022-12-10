/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.volunteer;

import java.util.List;
import model.Person;

/**
 *
 * @author akshitabarot
 */
public class Volunteer extends Person {
    private List<VolunteerOrg> volunteerOrgList;
    private String location;
    Person volunteerManager;

    public List<VolunteerOrg> getVolunteerOrgList() {
        return volunteerOrgList;
    }

    public void setVolunteerOrgList(List<VolunteerOrg> volunteerOrgList) {
        this.volunteerOrgList = volunteerOrgList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person getVolunteerManager() {
        return volunteerManager;
    }

    public void setVolunteerManager(Person volunteerManager) {
        this.volunteerManager = volunteerManager;
    }
    
}

