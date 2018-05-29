package com.learn.multithreading;

class Counter {

	long count = 0;

	public synchronized void add(long value) {
		this.count += value;
	}
}

class CounterThread extends Thread {

	protected Counter counter = null;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			counter.add(i);
		}
	}
}

public class SynchronizationDemo4 {

	public static void main(String[] args) {
		Counter counter = new Counter();
		Counter counter1 = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter1);

		System.out.println("starting thread A at "+System.currentTimeMillis());
		threadA.start();
		System.out.println("starting thread B at "+System.currentTimeMillis());
		threadB.start();
		System.out.println("finished at "+System.currentTimeMillis());
	}
}
