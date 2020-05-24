import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.jdi.connect.spi.Connection;

public class MyBorder extends JFrame {
	public JButton btn_next = new JButton("Next");
	public JButton btn_previous = new JButton("Previous");
	public JTextField[] tf = new JTextField[4];

	public MyBorder() throws SQLException {
		JPanel pan1 = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel pan2 = new JPanel();

		String[] lb_name = { "Title", "Publisher", "Year", "Price" };
		JLabel[] lab = new JLabel[4];
		for (int i = 0; i < lb_name.length; i++) {
			lab[i] = new JLabel(lb_name[i]);
			tf[i] = new JTextField(40);

		}
		for (int i = 0; i < lb_name.length; i++) {
			pan1.add(lab[i]);
			pan1.add(tf[i]);
		}
		pan2.add(btn_next);
		pan2.add(btn_previous);

		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setTitle("MyBorder DataBase");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		Statement stmt;
		ResultSet rs = null;

		btn_next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost:3306/book_db?characterEncoding=UTF-8&serverTimezone=UTC";
				String ID = "root";
				String password = "suhyeon1250*";
				java.sql.Connection con = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("JDBC 연결 성공");
					try {
						con = DriverManager.getConnection(url, ID, password);
						System.out.println("DB 연결 성공");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("JDBS 연결 실패");
				}
			
				try {
					while (rs.next()) {
						tf[0].setText("book_ID:" + rs.getInt("book_id") + " ");
						tf[1].setText("book_ID:" + rs.getInt("book_id") + " ");
						tf[2].setText("title:" + rs.getString("title") + " ");
						tf[3].setText("Price:" + rs.getInt(5) + " ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 결과를 하나씩 출력한다.
				
			}

		});

	}

	public static void main(String[] args) throws SQLException {
		MyBorder mb = new MyBorder();
	}

}
