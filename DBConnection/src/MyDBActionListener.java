import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class MyDBActionListener implements ActionListener {

	PreparedStatement pstmt = null;
	public FriendsDBGUI fdb;

	public MyDBActionListener(FriendsDBGUI friendsDBGUI) {
		// TODO Auto-generated constructor stub
		this.fdb = friendsDBGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == ((ButtonPanel) fdb.basePanel[1]).btnPrevious) {
			try {
				if (fdb.rs.previous()) {
					((DisplayPanel) fdb.basePanel[0]).dbTextField[0].setText("" + fdb.rs.getString("nname"));
					((DisplayPanel) fdb.basePanel[0]).dbTextField[1].setText("" + fdb.rs.getString("phone"));
					((DisplayPanel) fdb.basePanel[0]).dbTextField[2].setText("" + fdb.rs.getInt("age"));
					System.out.println(fdb.rs.getString("nname"));

				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == ((ButtonPanel) fdb.basePanel[1]).btnNext) {
			try {
				if (fdb.rs.next()) {
					
					String name = fdb.rs.getString("nname");
					String phone = fdb.rs.getString("phone");
					int age = fdb.rs.getInt("age");
							
					((DisplayPanel) fdb.basePanel[0]).dbTextField[0].setText(""+name);
					((DisplayPanel) fdb.basePanel[0]).dbTextField[1].setText(""+phone);
					((DisplayPanel) fdb.basePanel[0]).dbTextField[2].setText(""+age);
					
					fdb.rowData = new Vector();
					fdb.rowData.addElement(name);
					fdb.rowData.addElement(phone);
					fdb.rowData.addElement(Integer.toString(age));
			
					((TablePanel)fdb.basePanel[2]).model.addRow(fdb.rowData);
					
					((ButtonPanel)fdb.basePanel[1]).btnName[0].setText(name);
					
					System.out.println(fdb.rs.getString("nname"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == ((ButtonPanel) fdb.basePanel[1]).btnInsert) {
			String sql = "insert into contact (nname, phone, age) values(?,?,?)";
			try {
				pstmt = fdb.con.prepareStatement(sql);
				String x = ((DisplayPanel) fdb.basePanel[0]).dbTextField[0].getText();
				String y = ((DisplayPanel) fdb.basePanel[0]).dbTextField[1].getText();
				int z = Integer.parseInt(((DisplayPanel) fdb.basePanel[0]).dbTextField[2].getText());
				pstmt.setString(1, x);
				pstmt.setString(2, y);
				pstmt.setInt(3, z); // age : int
				pstmt.executeUpdate();
				
				System.out.println("Insert ¼º°ø");
				fdb.stmt = fdb.con.createStatement();
				fdb.rs = fdb.stmt.executeQuery("select * from contact");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("pstmt ERR!!");
				e1.printStackTrace();
			}
		}

	}

}
