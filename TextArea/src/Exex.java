import java.util.Scanner;

public class Exex {
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 System.out.println("배열의 크기를 입력하세요:");
	 int a = scan.nextInt();
	 int[] myArray = new int[a];
	 
	 for(int i=0; i<a; i++) {
		 myArray[i]=i+1;
		 System.out.println("myArray["+i+"]="+myArray[i]);
	 }
	 
}
}
