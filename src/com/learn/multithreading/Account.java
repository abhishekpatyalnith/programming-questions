package com.learn.multithreading;

public class Account {

	private int balance = 1000;
	
	public void deposit(int amount){
		balance += amount;
	}
	
	public void withDraw(int amount){
		balance -= amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public static void transfer(Account account1, Account account2, int amount){
		account1.withDraw(amount);
		account2.deposit(amount);
	}
}
