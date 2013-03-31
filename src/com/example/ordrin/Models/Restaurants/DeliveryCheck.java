
package com.example.ordrin.Models.Restaurants;

public class DeliveryCheck{
   	private Number del;
   	private Number delivery;
   	private String mino;
   	private String msg;
   	private String rid;

 	public Number getDel(){
		return this.del;
	}
	public void setDel(Number del){
		this.del = del;
	}
 	public Number getDelivery(){
		return this.delivery;
	}
	public void setDelivery(Number delivery){
		this.delivery = delivery;
	}
 	public String getMino(){
		return this.mino;
	}
	public void setMino(String mino){
		this.mino = mino;
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
}
