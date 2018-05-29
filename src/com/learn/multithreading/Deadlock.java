package com.learn.multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	
	public void firstThread() throws InterruptedException{
		
		Random random = new Random();
		for(int i = 0;i<10000;i++){
			lock1.lock();
			lock2.lock();
			try{
				Account.transfer(acc1, acc2, random.nextInt(100));
			}	finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
		
	}

	public void secondThread() throws InterruptedException{
		
		Random random = new Random();
		for(int i = 0;i<10000;i++){
			lock1.lock();
			lock2.lock();
			try{
			Account.transfer(acc2, acc1, random.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished(){
		
		System.out.println("Account1 balance "+acc1.getBalance());
		System.out.println("account2 balance "+ acc2.getBalance());
		System.out.println("total balance "+(acc1.getBalance()+acc2.getBalance()));
	}
	
	public static void main(String[] args) {
		Deadlock p = new Deadlock();
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
