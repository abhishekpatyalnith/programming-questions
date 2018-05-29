package com.learn.builder;

public class CofeeBuilder extends BeverageBuilder {

	@Override
	void setBeverageType() {

		System.out.println("coffee");
		getBeverage().setBeverageName("coffee");
	}

	@Override
	void setWater() {
		System.out.println("step 1: boiling water");
		getBeverage().setWater(40);
	}

	@Override
	void setMilk() {
		System.out.println("step 2: adding milk");
		getBeverage().setMilk(40);

	}

	@Override
	void setSugar() {
		System.out.println("step 3: adding sugar");
		getBeverage().setSugar(10);
	}

	@Override
	void setPowderQuantity() {
		System.out.println("step 4: adding 9 grams of coffee powder");
		getBeverage().setPowderQuantity(9);
	}

	@Override
	Beverage createBeverage() {
		return new Beverage();
	}

}
