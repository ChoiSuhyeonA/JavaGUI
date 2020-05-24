import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public JButton btn_insert = new JButton("Insert");
	
	public JButton btn_delete = new JButton("Delete");
	public JButton btn_next = new JButton("Next");
	public JButton btn_previous = new JButton("Previous");
	public JTextField[] tf = new JTextField[5];
	Statement stmt;
	ResultSet rs = null;
	PreparedStatement pstmt;

	public MyBorder() throws SQLException {
		JPanel pan1 = new JPanel(new GridLayout(5, 2, 5, 5));
		JPanel pan2 = new JPanel(new GridLayout(2, 2, 1, 1));

		String[] lb_name = {"book_id", "Title", "Publisher", "Year", "Price" };
		JLabel[] lab = new JLabel[5];
		for (int i = 0; i < lb_name.length; i++) {
			lab[i] = new JLabel(lb_name[i]);
			tf[i] = new JTextField(40);

		}
		for (int i = 0; i < lb_name.length; i++) {
			pan1.add(lab[i]);
			pan1.add(tf[i]);
		}
		pan2.add(btn_insert);
		pan2.add(btn_delete);
		pan2.add(btn_next);
		pan2.add(btn_previous);

		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		this.setSize(400, 400);
		this.setTitle("MyBorder DataBase");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

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
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from books ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Statement 생성 오류");
		}
		btn_insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result =0;
				 try {
			         result = stmt.executeUpdate("insert into books (book_id, title, publisher, year, price) value('"+tf[0].getText()+"','"+tf[1].getText()+"','"+tf[2].getText()+"','"+tf[3].getText()+"',"+tf[4].getText()+");");
			         if (result ==1) {
			            System.out.println("DB insert 성공");
			         }
			         else {
			            System.out.println("실페");
			         }
			         
			      } catch (SQLException e1) {
			         // TODO Auto-generated catch block
			         e1.printStackTrace();
			      }
				
				
			}
		
		});
		btn_delete.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result =0;
				 try {
			         result = stmt.executeUpdate("delete from books where book_id like "+tf[0].getText());
			         if (result ==1) {
			            System.out.println("DB delete 성공");
			         }
			         else {
			            System.out.println("실패");
			         }
			         
			      } catch (SQLException e1) {
			         // TODO Auto-generated catch block
			         e1.printStackTrace();
			      }
				
			}
			
		});
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (rs.next()) {
						try {
							tf[0].setText("book_id:" + rs.getInt("book_id") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							tf[1].setText("title:" + rs.getString("title") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							tf[2].setText("Publisher:" + rs.getString("publisher") + " ");
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							tf[3].setText("year:" + rs.getInt("year") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							tf[4].setText("Price:" + rs.getInt(5) + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 결과를 하나씩 출력한다.
			}
		});
		btn_previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (rs.previous()) {
						try {
							tf[0].setText("book_id:" + rs.getInt("book_id") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							tf[1].setText("title:" + rs.getString("title") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							tf[2].setText("Publisher:" + rs.getString("publisher") + " ");
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							tf[3].setText("year:" + rs.getInt("year") + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							tf[4].setText("Price:" + rs.getInt(5) + " ");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public static void main(String[] args) throws SQLException {
		MyBorder mb = new MyBorder();
	}

}
