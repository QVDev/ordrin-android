
package com.example.ordrin.Models.Restaurants;

import java.util.List;

public class DeliveryList{
   	private String ad;
   	private String city;
   	private String cs_phone;
   	private List cu;
   	private Number del;
   	private Number id;
   	private Number is_delivering;
   	private Number mino;
   	private String na;
   	private Rds_info rds_info;

 	public String getAd(){
		return this.ad;
	}
	public void setAd(String ad){
		this.ad = ad;
	}
 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCs_phone(){
		return this.cs_phone;
	}
	public void setCs_phone(String cs_phone){
		this.cs_phone = cs_phone;
	}
 	public List getCu(){
		return this.cu;
	}
	public void setCu(List cu){
		this.cu = cu;
	}
 	public Number getDel(){
		return this.del;
	}
	public void setDel(Number del){
		this.del = del;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public Number getIs_delivering(){
		return this.is_delivering;
	}
	public void setIs_delivering(Number is_delivering){
		this.is_delivering = is_delivering;
	}
 	public Number getMino(){
		return this.mino;
	}
	public void setMino(Number mino){
		this.mino = mino;
	}
 	public String getNa(){
		return this.na;
	}
	public void setNa(String na){
		this.na = na;
	}
 	public Rds_info getRds_info(){
		return this.rds_info;
	}
	public void setRds_info(Rds_info rds_info){
		this.rds_info = rds_info;
	}
}
