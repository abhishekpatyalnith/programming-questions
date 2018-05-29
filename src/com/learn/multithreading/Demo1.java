package com.learn.multithreading;

class Runner1 extends Thread{

	@Override
	public void run() {
		for(int i =0;i<10;i++){
			System.out.println("hello "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class Demo1 {

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		Runner1 runner2 = new Runner1();
		runner1.start();
		runner2.start();
	}
}
