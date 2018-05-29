package com.learn.multithreading;

public class ReEntrantLock {
	
	private int count = 0;
	
	public void increment(){
		for(int i =0;i<1000;i++){
			count++;
		}
	}

	public void firstThread() throws InterruptedException{
		increment();
	}
	
	public void secondThread() throws InterruptedException{
		increment();
	}
	
	public void finished(){
		System.out.println("count is "+count);
	}
	
	public static void main(String[] args) {
		ReEntrantLock p = new ReEntrantLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					p.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					p.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		p.finished();
	}
}
