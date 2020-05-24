import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sun.jdi.connect.spi.Connection;

public class SQLConnection {
	Statement stmt;
	ResultSet rs;

	public SQLConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/book?characterEncoding=UTF-8&serverTimezone=UTC";
		String ID = "root";
		String password = "1137";
		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC ���� ����");
			try {
				con = DriverManager.getConnection(url, ID, password);
				System.out.println("DB ���� ����");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBS ���� ����");
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from books ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement ���� ����");
		}
		while (rs.next()) {
			System.out.println("book_ID:" + rs.getInt("book_id") + " ");
			System.out.println("title:" + rs.getString("title") + " ");
			System.out.println("Price:" + rs.getInt(5) + " ");
		}
		stmt = con.createStatement();
		int  result= stmt.executeUpdate("insert into books (title, publisher, year,price) values('aaa','bbb','ccc',10000); ");
		if(result==1) {
			System.out.println("DB insert ����");
		}
		else {
			System.out.println("DB insert ����");	
		}
		
	}

	public static void main(String[] args) throws SQLException {

		new SQLConnection();
	}

}