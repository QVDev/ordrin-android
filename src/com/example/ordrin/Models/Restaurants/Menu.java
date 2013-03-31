
package com.example.ordrin.Models.Restaurants;

import java.util.List;

public class Menu{
   	private List children;
   	private String descrip;
   	private String free_child_select;
   	private String id;
   	private Number is_orderable;
   	private String item_select_weight;
   	private String max_child_select;
   	private String max_free_child_select;
   	private String min_child_select;
   	private String name;
   	private String price;

 	public List getChildren(){
		return this.children;
	}
	public void setChildren(List children){
		this.children = children;
	}
 	public String getDescrip(){
		return this.descrip;
	}
	public void setDescrip(String descrip){
		this.descrip = descrip;
	}
 	public String getFree_child_select(){
		return this.free_child_select;
	}
	public void setFree_child_select(String free_child_select){
		this.free_child_select = free_child_select;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Number getIs_orderable(){
		return this.is_orderable;
	}
	public void setIs_orderable(Number is_orderable){
		this.is_orderable = is_orderable;
	}
 	public String getItem_select_weight(){
		return this.item_select_weight;
	}
	public void setItem_select_weight(String item_select_weight){
		this.item_select_weight = item_select_weight;
	}
 	public String getMax_child_select(){
		return this.max_child_select;
	}
	public void setMax_child_select(String max_child_select){
		this.max_child_select = max_child_select;
	}
 	public String getMax_free_child_select(){
		return this.max_free_child_select;
	}
	public void setMax_free_child_select(String max_free_child_select){
		this.max_free_child_select = max_free_child_select;
	}
 	public String getMin_child_select(){
		return this.min_child_select;
	}
	public void setMin_child_select(String min_child_select){
		this.min_child_select = min_child_select;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPrice(){
		return this.price;
	}
	public void setPrice(String price){
		this.price = price;
	}
}
