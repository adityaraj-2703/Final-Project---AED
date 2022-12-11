/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Enterprise;

import java.util.List;
import model.Organisation.Organisation;
import model.Organisation.OrganisationDirectory;
import model.Person;
import model.city.Address;
import model.city.City;

/**
 *
 * @author adityaraj
 */
public class Enterprise {
    private EnterpriseType enterpriseType;

    
    
    public enum EnterpriseType{
        FoodService("FoodService"),
        ClothesService("ClothesService"),
        VolunteerService("VolunteerService"), 
        HousingService("HousingService");  
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
            return value;
        }
    }
    private String EnterpriseId;
    
    private Person person;
    private City city;
    private OrganisationDirectory organisationDirectory;

    public String getEnterpriseId() {
        return EnterpriseId;
    }

    public void setEnterpriseId(String EnterpriseId) {
        this.EnterpriseId = EnterpriseId;
    }

    
    
    public OrganisationDirectory getOrganisationDirectory() {
        return organisationDirectory;
    }

    public void setOrganisationDirectory(OrganisationDirectory organisationDirectory) {
        this.organisationDirectory = organisationDirectory;
    }
    
    

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public Enterprise(EnterpriseType type, String name){
        
        this.enterpriseType=type;
        organisationDirectory=new OrganisationDirectory();
    }
    
    public void addOrganisation(Organisation o) {
        organisationDirectory.addOrganisation(o);
    }
    
    
    
    
}
