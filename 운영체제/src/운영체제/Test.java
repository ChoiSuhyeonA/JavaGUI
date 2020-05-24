package 운영체제;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		BankAccount b = new BankAccount(1); // 통장이 개설되어 잔액으로 1원이 들어있음
		
		Parent p = new Parent(b);
		Child c1 = new Child(b);
		Child c2 = new Child(b);
		Child c3 = new Child(b);
		Child c4 = new Child(b);
		
		p.start();  // 쓰레드 시작
		c1.start(); // 쓰레드 시작
		c2.start(); // 쓰레드 시작
		c3.start(); // 쓰레드 시작
		c4.start(); // 쓰레드 시작
		
		p.join();   // 쓰레드 종료를 기다림
		c1.join();  // 쓰레드 종료를 기다림
		c2.join();  // 쓰레드 종료를 기다림
		c3.join();  // 쓰레드 종료를 기다림
		c4.join();  // 쓰레드 종료를 기다림
		/* 모든 쓰레드가 끝난 후 최종적으로 저장되어 있는 잔액을 출력한다 */
		System.out.println("\nbalance = " + b.getBalance()); 
	}
}

class BankAccount {
	int balance;
	
	BankAccount(int amount) {
		this.balance = amount;
	}
	
	void deposit(int amount) {
		int result;
		
		result = balance + amount;
		System.out.print("+ ");
		balance = result;
	}

	void withdraw(int amount) {
		int result;
		
		result = balance - amount;
		System.out.print("- ");
		balance = result;
	}

	int getBalance() {
		return balance;
	}
}

class Parent extends Thread {
	BankAccount b;
	
	Parent(BankAccount b) {
		this.b = b;
	}

	public void run() {
		for (int i=0; i<100; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) { }

			b.deposit(1000); // 1000원 입금
		}
	}
}

class Child extends Thread {
	BankAccount b;
	
	Child(BankAccount b) {
		this.b = b;
	}

	public void run() {
		
		for (int i=0; i<100; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) { }

			b.withdraw(250);   // 250원 출금
		}
	}
}
