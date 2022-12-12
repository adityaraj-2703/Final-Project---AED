/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BusinessLogic.CityDao;
import BusinessLogic.FoodDao;
import BusinessLogic.OrderDao;
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
    private FoodDirectory foodDirectory;
    private FoodOrderDirectory foodOrderDirectory;
    private HousingDirectory housingDirectory;
    private HousingOrderDirectory housingOrderDirectory;

    public HousingOrderDirectory getHousingOrderDirectory() {
        return housingOrderDirectory;
    }

    public void setHousingOrderDirectory(HousingOrderDirectory housingOrderDirectory) {
        this.housingOrderDirectory = housingOrderDirectory;
    }
    
    
    

    public HousingDirectory getHousingDirectory() {
        return housingDirectory;
    }

    public void setHousingDirectory(HousingDirectory housingDirectory) {
        this.housingDirectory = housingDirectory;
    }
    
    

    public FoodOrderDirectory getFoodOrderDirectory() {
        return foodOrderDirectory;
    }

    public void setFoodOrderDirectory(FoodOrderDirectory foodOrderDirectory) {
        this.foodOrderDirectory = foodOrderDirectory;
    }
    
    
    //private OrderDirectory orderDirectory;

    public FoodDirectory getFoodDirectory() {
        return foodDirectory;
    }

    public void setFoodDirectory(FoodDirectory foodDirectory) {
        this.foodDirectory = foodDirectory;
    }
    
    
    CityDao cityDao;
    OrganisationDao organisationDao;
    UsersDAO usersDao;
    FoodDao foodDao;
    OrderDao orderDao;
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
        foodDirectory = new FoodDirectory();
        foodOrderDirectory = new FoodOrderDirectory();
        housingDirectory = new HousingDirectory();
        housingOrderDirectory = new HousingOrderDirectory();
        foodDao = new FoodDao();
        orderDao = new OrderDao();
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

    public int addOrganisation(String organisationType, String organisationName, Address location, Person p, String phoneNo,String enterpriseType,String eId) throws SQLException{
        Enterprise e = getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.valueOf(enterpriseType));
        String id = String.valueOf(organisationDao.getCount() + Integer.valueOf("1000"));
        int v = organisationDao.insertDetails(id,organisationType, organisationName, location,p, phoneNo,eId);
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

    public void getOrganisationList() {
        /*
        cities  = cityDao.getCities();
        for(City c : cities){
            c.setCommunityList(cityDao.getCommunities(c));
            for(Community comm : c.getCommunityList()){
                comm.setHouseList(cityDao.getAddresses(comm));
            }
        }
        return cities;
        */
        List<Enterprise> elist = usersDao.getEnterprise();
        enterpriseDirectory.setEnterpriseDirectory((ArrayList<Enterprise>) elist);
        for(Enterprise e : elist){
            e.getOrganisationDirectory().setOrganisationList( usersDao.getOrganisation(e));
            
        }
        
    }

    public int updateOrganisation(String organisationId, String organisationType, String organisationName, Address address, Person person, String phoneNo,String enterpriseType, String eId) {
        Enterprise e = getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.valueOf(enterpriseType));
        
        int v = organisationDao.updateDetails(organisationId,organisationType, organisationName, address,person, phoneNo,eId);
        if(v!=0){
            Organisation o = new Organisation();
            o.setOrganisationId(organisationId);
            o.setOrganisationName(organisationName);
            o.setAddress(address);
            o.setPerson(person);
            o.setPhoneNo(phoneNo);
            o.setOrganisationType(organisationType);
            e.addOrganisation(o);
        }
        return v;
    }

    public int deleteOrganisation(Organisation o,String enterpriseType, String eId) {
        Enterprise e = getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.valueOf(enterpriseType));
        
        int v = organisationDao.deleteDetails(o,eId);
        if(v!=0){
            
            e.getOrganisationDirectory().deleteOrganisation(o);
        }
        return v;
    }

    public Organisation getOrganisation(Person p1) {
        return organisationDao.getOrganisation(p1);
        
    }

    public int addFood(String name, String foodType, int quantity, Organisation o) {
        FoodDetails f = new FoodDetails();
        f.setFoodID(String.valueOf(foodDao.getCount() + Integer.valueOf("1000000")));
        f.setFoodName(name);
        f.setFoodQuantity(quantity);
        f.setFoodType(foodType);
        f.setOrg(o);
        f.setFoodStatus("PENDING");
        int v = foodDao.addFood(f,o);
        if(v!=0){
            foodDirectory.getFoodDirectory().add(f);
            
        }
        return v;
    }
    public void getFoodDetails(){
        foodDirectory.setFoodDirectory(foodDao.getFoodDetails());
    }

    public int approveFood(FoodDetails f) {
        
        int v = foodDao.approveFood(f);
        if(v!=0){
            f.setFoodStatus("APPROVED");
        }
        return v;
    }

    public List<FoodDetails> getApprovedFoodDetails() {
        return foodDao.getApprovedFoodDetails();
    }

    public int addOrder(FoodDetails f,Person p) {
        FoodOrder fo = new FoodOrder();
        fo.setOrderId(String.valueOf(orderDao.getCount() + Integer.valueOf("10000000")));
        fo.setFoodId(f.getFoodID());
        fo.setPerson(p);
        int c = 0;
        int v = orderDao.addOrder(fo);
        if(v!=0){
            
            c = foodDao.updateFood(f);
            if(c!=0){
                f.setFoodQuantity(f.getFoodQuantity()-1);
                foodOrderDirectory.getFoodOrderDirectory().add(fo);
            }
            
            
            
            
            
        }
        return c;
        
    }

    public List<FoodOrder> getFoodOrderDetails() {
        //foodOrderDirectory.setFoodOrderDirectory(foodDao.getFoodOrders());
        return orderDao.getFoodOrders();
    }

    public int addHousing(String date, int beds, Address add) {
        HousingDetails ho = new HousingDetails();
        ho.setHousingID(String.valueOf(orderDao.getHousingCount() + Integer.valueOf("100000000")));
        ho.setHousingAddress(add);
        ho.setBookingDate(date);
        ho.setAvailableBeds(beds);
        ho.setStatus("PENDING");
        
        int v = orderDao.addHousing(ho);
        if(v!=0){
            housingDirectory.getHousingDirectory().add(ho);
        }
        return v;
        
    }

    public void getHousingDetails() {
        housingDirectory.setHousingDirectory(orderDao.getHousingDetails());
    }

    public int approveHousing(HousingDetails h) {
        int v = orderDao.approveHouse(h);
        if(v!=0){
            h.setStatus("APPROVED");
        }
        return v;
    }
    
    public List<HousingDetails> getApprovedHousingDetails() {
        return orderDao.getApprovedOrderDetails();
    }

    public int addHousingOrder(HousingDetails f, Person p) {
        HousingOrder ho = new HousingOrder();
        ho.setOrderId(String.valueOf(orderDao.getHousingOrderCount() + Integer.valueOf("100000000")));
        ho.setHousingId(f.getHousingID());
        ho.setPerson(p);
        
        
        int c = 0;
        int v = orderDao.addHousingOrder(ho);
        if(v!=0){
            
            c = orderDao.updateHousing(f);
            if(c!=0){
                f.setAvailableBeds(f.getAvailableBeds()-1);
                //housingOrderDirectory.getHousingOrderDirectory().add(fo);
                housingOrderDirectory.getHousingOrderDirectory().add(ho);
            }
            
            
            
            
            
        }
        return c;
    }

    public List<HousingOrder> getHousingOrderDetails() {
        //Directory.setFoodDirectory(foodDao.getFoodDetails());
        return orderDao.getHousingOrders();
    }

    

}
