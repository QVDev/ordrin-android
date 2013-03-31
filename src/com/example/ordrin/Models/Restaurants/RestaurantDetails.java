
package com.example.ordrin.Models.Restaurants;

import java.util.List;

public class RestaurantDetails{
   	private String addr;
   	private String addr2;
   	private String city;
   	private String cs_contact_phone;
   	private List cuisine;
   	private Meal_name meal_name;
   	private List menu;
   	private String name;
   	private String postal_code;
   	private Rds_info rds_info;
   	private String restaurant_id;
   	private String state;

 	public String getAddr(){
		return this.addr;
	}
	public void setAddr(String addr){
		this.addr = addr;
	}
 	public String getAddr2(){
		return this.addr2;
	}
	public void setAddr2(String addr2){
		this.addr2 = addr2;
	}
 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCs_contact_phone(){
		return this.cs_contact_phone;
	}
	public void setCs_contact_phone(String cs_contact_phone){
		this.cs_contact_phone = cs_contact_phone;
	}
 	public List getCuisine(){
		return this.cuisine;
	}
	public void setCuisine(List cuisine){
		this.cuisine = cuisine;
	}
 	public Meal_name getMeal_name(){
		return this.meal_name;
	}
	public void setMeal_name(Meal_name meal_name){
		this.meal_name = meal_name;
	}
 	public List getMenu(){
		return this.menu;
	}
	public void setMenu(List menu){
		this.menu = menu;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPostal_code(){
		return this.postal_code;
	}
	public void setPostal_code(String postal_code){
		this.postal_code = postal_code;
	}
 	public Rds_info getRds_info(){
		return this.rds_info;
	}
	public void setRds_info(Rds_info rds_info){
		this.rds_info = rds_info;
	}
 	public String getRestaurant_id(){
		return this.restaurant_id;
	}
	public void setRestaurant_id(String restaurant_id){
		this.restaurant_id = restaurant_id;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
}
