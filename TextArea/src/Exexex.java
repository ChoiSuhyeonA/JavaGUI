import java.util.Scanner;

public class Exexex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
	
	 while(true) {
			String s = scan.nextLine();
			String ss = scan.nextLine();
			
		 if(s.equals("bye")) {
			 break;
		 }
		 if(s.contains("java")) {
			 System.out.println(s+"�� ����");
		 }
		 if(s.endsWith(ss)) {
		
			 System.out.println(s+"���� "+ss);
		 }
	 }

	}
	


}
