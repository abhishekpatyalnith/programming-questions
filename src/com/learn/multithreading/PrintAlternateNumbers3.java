package com.learn.multithreading;

public class PrintAlternateNumbers3 {

	public static void main(String[] args) {
		Helper helper1 = new Helper(1);
		Helper helper2 = new Helper(2);
		Helper helper3 = new Helper(0);

		Thread t1 = new Thread(helper1);
		Thread t2 = new Thread(helper2);
		Thread t3 = new Thread(helper3);

		t1.start();
		t2.start();
		t3.start();

	}

}

class Helper implements Runnable {

	int remainder;
	static int number = 1;
	int maxNumber = 20;
	static Object lock = new Object();

	public Helper(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {

		while (number < maxNumber) {
			synchronized (lock) {
				while (number % 3 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}
