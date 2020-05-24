
public class SmartPhone implements Phone {
 public static void main(String[] args) {
	Phone p =new SmartPhone();
	p.call();
}

@Override
public void call() {
	// TODO Auto-generated method stub
	System.out.println("i love you");
}
}
interface Phone{
	void call();
}