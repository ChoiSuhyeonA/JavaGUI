import java.util.Scanner;

public class Exex {
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 System.out.println("�迭�� ũ�⸦ �Է��ϼ���:");
	 int a = scan.nextInt();
	 int[] myArray = new int[a];
	 
	 for(int i=0; i<a; i++) {
		 myArray[i]=i+1;
		 System.out.println("myArray["+i+"]="+myArray[i]);
	 }
	 
}
}
