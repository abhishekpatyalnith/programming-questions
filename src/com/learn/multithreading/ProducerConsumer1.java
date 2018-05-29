package com.learn.multithreading;

import java.util.LinkedList;

public class ProducerConsumer1 {
	
	private  LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private  Object lock = new Object();
	
	public  void produce() throws InterruptedException{
		
		int value = 0;
		
		while(true){
			synchronized (lock) {
				while(list.size() == LIMIT){
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
		
	}
	
	public void consume() throws InterruptedException{
		
		while(true){
			synchronized (lock) {
				while(list.size() == 0){
					lock.wait();
				}
				System.out.print("list size is "+list.size());
				int value = list.removeFirst();
				System.out.println(" ; value is "+value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer1 p = new ProducerConsumer1();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					p.produce();
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
					p.consume();
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
	}

}
