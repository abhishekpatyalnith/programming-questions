package com.learn.builder;

public class Beverage {
	
	private int water;
	private int milk;
	private int sugar;
	private int powderQuantity;
	private String beverageName;
	
	@Override
	public String toString() {
		return "Beverage [water=" + water + ", milk=" + milk + ", sugar=" + sugar + ", powderQuantity=" + powderQuantity
				+ ", beverageName=" + beverageName + "]";
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public int getPowderQuantity() {
		return powderQuantity;
	}
	public void setPowderQuantity(int powderQuantity) {
		this.powderQuantity = powderQuantity;
	}
	public String getBeverageName() {
		return beverageName;
	}
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}
	
	

}
