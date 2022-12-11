/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BusinessLogic.CityDao;
import BusinessLogic.OrganisationDao;

import BusinessLogic.UsersDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Enterprise.Enterprise;
import model.Enterprise.EnterpriseDirectory;
import model.Organisation.Organisation;
import model.city.Address;
import model.city.City;
import model.city.Community;

/**
 *
 * @author adityaraj
 */
public class Data {
    private List<City> cities;
    private EnterpriseDirectory enterpriseDirectory;
    private PersonDirectory personDirectory;
    
    CityDao cityDao;
    OrganisationDao organisationDao;
    UsersDAO usersDao;
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    
    
    
    public Data(){
        cityDao = new CityDao();
        organisationDao = new OrganisationDao();
        usersDao = new UsersDAO();
        cities = new ArrayList<>();
        personDirectory = new PersonDirectory();
        enterpriseDirectory = new EnterpriseDirectory();
        enterpriseDirectory.addEnterprise();
        
        
    }

    public List<City> getCities() {
        cities  = cityDao.getCities();
        for(City c : cities){
            c.setCommunityList(cityDao.getCommunities(c));
            for(Community comm : c.getCommunityList()){
                comm.setHouseList(cityDao.getAddresses(comm));
            }
        }
        return cities;
    }
    
    

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    public int createCity(String name,String state){
        //object definition
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
    
    public City getCity(String id){
        City getCity = new City();
        for(City c : cities){
            if(c.getId().equals(id)){
                getCity = c;
                return getCity;
            }
        }
        return getCity;
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    public List<Enterprise> getEnterpriseList(){
        return usersDao.getEnterprise();
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public int updateCity(String id,String name,String state) {
        City getCity = getCity(id);
        int v = cityDao.updateCity(getCity,name,state);
        if(v!=0){
           getCity.setName(name);
           getCity.setState(state);
        }
        return v;
        
     
        
        
        
    }
    public Community getCommunity(String id){
         Community getCommunity = new Community();
         for(City c : cities){
             for(Community comm : c.getCommunityList()){
                 if(comm.getCommunityId().equals(id)){
                     getCommunity = comm;
                     return getCommunity;
                 }
             }
         }
         return getCommunity;
     }   
    public int updateCommunity(String id,String name){
        int v = cityDao.updateCommunity(id,name);
        if(v!=0){
            Community getComm = getCommunity(id);
            getComm.setCommunityName(name);
        }
        return v;
    }

    public int addCommunity(String cityId, String communityName) {
        City c = getCity(cityId);
        Community comm = new Community();
        comm.setCommunityId(String.valueOf(cityDao.getComunityCount() + Integer.valueOf("200")));
        comm.setCommunityName(communityName);
        comm.setCity(c);
        int v = cityDao.createCommunity(comm);
        if(v!=0){
            c.getCommunityList().add(comm);
        }
        return v;
        
    }

    public int addOrganisation(String organisationType, String organisationName, Address location, Person p, String phoneNo,String enterpriseType) throws SQLException{
        Enterprise e = getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.valueOf(enterpriseType));
        String id = String.valueOf(organisationDao.getCount() + Integer.valueOf("1000"));
        int v = organisationDao.insertDetails(id,organisationType, organisationName, location,p, phoneNo);
        if(v!=0){
            Organisation o = new Organisation();
            o.setOrganisationId(id);
            o.setOrganisationName(organisationName);
            o.setAddress(location);
            o.setPerson(p);
            o.setPhoneNo(phoneNo);
            o.setOrganisationType(organisationType);
            e.addOrganisation(o);
        }
        return v;
        
    }

    public int addAddress(String communityId, String streetAddress, String pinCode) {
        Community c = getCommunity(communityId);
        Address address = new Address();
        address.setAddressId(String.valueOf(cityDao.getAddressCount() + Integer.valueOf("300")));
        address.setStreetAddress(streetAddress);
        address.setPinCode(pinCode);
        address.setCommunity(c);
        int v = cityDao.createAddress(address);
        if(v!=0){
            c.getHouseList().add(address);
        }
        return v;
    }

    public int createAdmins(String type, Person p, City c) {
        //Enterprise e = enterpriseDirectory.addEnterprise(Enterprise.EnterpriseType.valueOf(type));
        Enterprise e = enterpriseDirectory.getEnterprise(Enterprise.EnterpriseType.valueOf(type));
        e.setEnterpriseId(String.valueOf(usersDao.getAdminCount() + Integer.valueOf("10")));
        e.setCity(c);
        e.setPerson(p);
        
        int v = usersDao.createAdmin(e);
        if(v!=0){
           enterpriseDirectory.getEnterpriseDirectory().add(e);
        }
        
        return v;
        
    }

    public List<Person> getUsers() {
        personDirectory.setPersonDirectory(usersDao.getUsers());
        return personDirectory.getPersonDirectory();
    }

    public List<Person> getPendingAdmins() {
        return usersDao.getPendingAdmins();
    }

    public List<Person> getClothesManagers() {
        return usersDao.getClothesManagers();
    }

}
