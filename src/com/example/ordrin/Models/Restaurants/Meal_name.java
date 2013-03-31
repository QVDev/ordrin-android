
package com.example.ordrin.Models.Restaurants;

import com.google.gson.annotations.SerializedName;

public class Meal_name{

    @SerializedName("0")
   	private String a0;
    @SerializedName("3")
   	private String a3;
    @SerializedName("4")
   	private String a4;

 	public String get0(){
		return this.a0;
	}
	public void set0(String a0){
		this.a0 = a0;
	}
 	public String get3(){
		return this.a3;
	}
	public void set3(String a3){
		this.a3 = a3;
	}
 	public String get4(){
		return this.a4;
	}
	public void set4(String a4){
		this.a4 = a4;
	}
}
