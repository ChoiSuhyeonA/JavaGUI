import java.sql.DriverManager;

public class DBConnection {
	public DBConnection() {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("JDBC ���缺��...");
		} 
	}
	public static void main(String[] args) {
		new DBConnection();
	}
}
