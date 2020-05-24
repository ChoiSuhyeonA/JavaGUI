import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FriendsDBGUI extends JFrame {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Vector rowData = null;
	public JPanel basePanel[] = new JPanel[3];
	public FriendsDBGUI() {
		con = makeConnection();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("연락처 DB GUI");
		this.setSize(400, 500);
		
		//basePanel[0] = new JPanel(new GridLayout(0,2));
		basePanel[0] = (JPanel) new DisplayPanel();
		basePanel[1] = (JPanel) new ButtonPanel();
		basePanel[2] = new TablePanel();
		
		MyDBActionListener MDBAL = new MyDBActionListener(this);
		((ButtonPanel)basePanel[1]).btnPrevious.addActionListener(MDBAL);
		((ButtonPanel)basePanel[1]).btnNext.addActionListener(MDBAL);
		((ButtonPanel)basePanel[1]).btnInsert.addActionListener(MDBAL);
		((ButtonPanel)basePanel[1]).btnDelete.addActionListener(MDBAL);
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from contact");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		this.add(basePanel[0], BorderLayout.NORTH);
		this.add(basePanel[1], BorderLayout.SOUTH);
		this.add(basePanel[2], BorderLayout.CENTER);
		
		
		this.setVisible(true);
		this.pack();
	}
	
	public Connection makeConnection() {
		// TODO Auto-generated method stub
		// DB명 : friends
		// Table명 : contact
		// Field : (1) name varchar(10)
		// (2) phone varchar(15)
		// (3) age int
		// primary key(phone)
		
		
		Connection con = null;
		String url ="jdbc:mysql://localhost:3306/friends?characterEncoding=UTF-8&serverTimezone=UTC";
		String user ="root";
		String password ="suhyeon1250*";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC 적재 성공...");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC 적재 오류...");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결 실패...");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FriendsDBGUI();
		
	}

}
