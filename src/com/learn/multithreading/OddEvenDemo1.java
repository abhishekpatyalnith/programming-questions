package com.learn.multithreading;

public class OddEvenDemo1 {

	int number = 1;
	int maxNumber = 20;
	boolean odd = true;

	public void printEven() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (this) {
			while (number < maxNumber) {
				while (odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				odd = true;
				notify();
			}
		}
	}

	public void printOdd() {
		synchronized (this) {
			while (number < maxNumber) {
				while (!odd) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				odd = false;
				notify();
			}
		}
	}

	public static void main(String[] args) {

		OddEvenDemo1 oddEven = new OddEvenDemo1();
		oddEven.odd = true;

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				oddEven.printOdd();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				oddEven.printEven();

			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
