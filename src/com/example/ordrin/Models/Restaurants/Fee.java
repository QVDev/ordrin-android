
package com.example.ordrin.Models.Restaurants;

public class Fee{
   	private Number delivery;
   	private String fee;
   	private String msg;
   	private String rid;
   	private String tax;

 	public Number getDelivery(){
		return this.delivery;
	}
	public void setDelivery(Number delivery){
		this.delivery = delivery;
	}
 	public String getFee(){
		return this.fee;
	}
	public void setFee(String fee){
		this.fee = fee;
	}
 	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
 	public String getRid(){
		return this.rid;
	}
	public void setRid(String rid){
		this.rid = rid;
	}
 	public String getTax(){
		return this.tax;
	}
	public void setTax(String tax){
		this.tax = tax;
	}
}
