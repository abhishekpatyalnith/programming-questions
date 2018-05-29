package com.learn.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	
	public static void main(String[] args) {
		
		
		ExecutorService executors = Executors.newCachedThreadPool();
		
		for(int i = 0;i<20;i++){
			executors.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		executors.shutdown();
		try {
			executors.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
