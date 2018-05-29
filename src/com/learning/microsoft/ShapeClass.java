package com.learning.microsoft;


class Circle{
	private float radius;
	public void Circle(float radius){
		this.radius =radius;
	}
	
	public int getArea(){
		return (int)Math.ceil(3.14159265*radius*radius);
	}
}

class Rectangle{
	private float height;
	private float width;
	
	public void Circle(float height, float width){
		this.height =height;
		this.width = width;
	}
	
	public int getArea(){
		return (int)Math.ceil(height*width);
	}
}

class Square{
	private float width;
	
	public void Circle(float width){
		this.width = width;
	}
	
	public int getArea(){
		return (int)Math.ceil(width*width);
	}
}
public class ShapeClass {

}
