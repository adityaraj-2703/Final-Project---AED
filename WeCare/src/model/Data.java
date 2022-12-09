/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BusinessLogic.CityDao;
import BusinessLogic.RestaurantDAO;
import BusinessLogic.UsersDAO;
import java.util.ArrayList;
import java.util.List;
import model.Enterprise.EnterpriseDirectory;
import model.city.City;

/**
 *
 * @author adityaraj
 */
public class Data {
    private List<City> cities;
    private EnterpriseDirectory enterpriseDirectory;
    private PersonDirectory personDirectory;
    
    CityDao cityDao;
    RestaurantDAO restaurantDao;
    UsersDAO usersDao;
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    
    
    
    public Data(){
        cityDao = new CityDao();
        restaurantDao = new RestaurantDAO();
        usersDao = new UsersDAO();
        cities = new ArrayList<>();
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    public int createCity(String name,String state){
        City c = new City();
        c.setId(String.valueOf(cityDao.getCount() + Integer.valueOf("100")));
        c.setName(name);
        c.setState(state);
        int v = cityDao.insertIntoCity(c);
        if(v!=0){
            cities.add(c);
        }
        return v;
    }
    
    
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    
    
}
