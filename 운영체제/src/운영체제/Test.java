package �ü��;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		BankAccount b = new BankAccount(1); // ������ �����Ǿ� �ܾ����� 1���� �������
		
		Parent p = new Parent(b);
		Child c1 = new Child(b);
		Child c2 = new Child(b);
		Child c3 = new Child(b);
		Child c4 = new Child(b);
		
		p.start();  // ������ ����
		c1.start(); // ������ ����
		c2.start(); // ������ ����
		c3.start(); // ������ ����
		c4.start(); // ������ ����
		
		p.join();   // ������ ���Ḧ ��ٸ�
		c1.join();  // ������ ���Ḧ ��ٸ�
		c2.join();  // ������ ���Ḧ ��ٸ�
		c3.join();  // ������ ���Ḧ ��ٸ�
		c4.join();  // ������ ���Ḧ ��ٸ�
		/* ��� �����尡 ���� �� ���������� ����Ǿ� �ִ� �ܾ��� ����Ѵ� */
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

			b.deposit(1000); // 1000�� �Ա�
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

			b.withdraw(250);   // 250�� ���
		}
	}
}
