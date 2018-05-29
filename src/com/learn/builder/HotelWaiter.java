package com.learn.builder;

public class HotelWaiter {

	public static Beverage takeOrder(String beverageType){
		
		BeverageBuilder beverageBuilder = null;
		if(beverageType.equalsIgnoreCase("tea")){
			beverageBuilder = new TeaBuilder();
		}else if(beverageType.equalsIgnoreCase("coffee")){
			beverageBuilder = new CofeeBuilder();
		}else{
			System.out.println("invalid order");
			return null;
		}
		return beverageBuilder.buildBeverage();
		
	}
}
