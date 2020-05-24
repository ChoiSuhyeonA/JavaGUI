import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;



public class FriendsDB extends JFrame implements ActionListener, MouseListener{
	private Connection con =null;
	private JTable table;
	private Vector title;
	private DefaultTableModel model;
	private Vector data;
	private Statement stmt;
	private JPanel lowpanel;
	private JButton btn3;
	private JButton btn5;
	private JButton btn4;
	private JButton btn2;
	private JLabel lblnum;
	private JLabel lblname;
	private JLabel lbladdr;
	
	private JTextField numt;
	private JTextField namet;
	private JTextField addrt;
	private Statement insertStmt;
	
	private Statement deleteStmt;
	ResultSet rs;
	Vector<String> in;
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblpnum;
	private JTextField idt;
	private JTextField pwt;
	private JTextField pnumt;
	
	public FriendsDB() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(2000,1000);
		this.setTitle("FriendsDB");
		
		con = (Connection) makeConnection();
		
		data = new Vector<>();
		
		title = new Vector<>();
		title.add("ID");
		title.add("PW");
		title.add("�̸�");
		title.add("H.P");
		
		lowpanel = new JPanel();
		 
		 //btn1 = new JButton();
		 
//		 nameField = new JTextField(5);
//		 subj1 = new JTextField(3);
//		 subj2 = new JTextField(3);
//		 subj3 = new JTextField(3);
//		 
//		 lowpanel.add(nameField);
//		 lowpanel.add(subj1);
//		 lowpanel.add(subj2);
//		 lowpanel.add(subj3);
		 
		 btn2 = new JButton("�߰�");
		 btn3 = new JButton("����");
		 btn4 = new JButton("����");
		 btn5 = new JButton("�ʱ�ȭ");
		 
		 
		 lblid = new JLabel();
		 lblpw = new JLabel();
		 lblname = new JLabel();
		 lblpnum = new JLabel();
		 
		 
		 idt = new JTextField(10);
		 pwt = new JTextField(8);
		 namet = new JTextField(10);
		 pnumt = new JTextField(15);
		 
		 
		 lowpanel.add(lblid);
		 lowpanel.add(idt);
		 lowpanel.add(lblpw);
		 lowpanel.add(pwt);
		 lowpanel.add(lblname);
		 lowpanel.add(namet);
		 lowpanel.add(lblpnum);
		 lowpanel.add(pnumt);
		 lowpanel.add(btn2);
		 lowpanel.add(btn3);
		 lowpanel.add(btn4);
		 lowpanel.add(btn5);
		 
		 btn2.addActionListener(this);
		 btn3.addActionListener(this);
		 btn4.addActionListener(this);
		 btn5.addActionListener(this);
		// lowpanel.add(btn1);
		 this.add(lowpanel, BorderLayout.SOUTH);
		 
		Vector result = selectAll();
		
		String header[] = {"�л��̸�","����","����","����"};
		String contents[][] = {
				{"ȫ�浿","90","80","70"},{"��ö��","90","80","70"},{"�̼���","90","80","70"}
		};
		model = new DefaultTableModel(header,0);
		model.addRow(contents[0]);
		model.addRow(contents[1]);
		model.addRow(contents[2]);

//		model.removeRow(0);
//		model.removeRow(0);
		
		System.out.println(model.getValueAt(1, 1));
		String data[] = {"���ϳ�","100","100","100"};
		model.addRow(data);
		model.setDataVector(result, title);
		
		
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table); // title�� ���� ��� �Ϸ��� ��� �ȴ�.
		this.add(sp, BorderLayout.CENTER); // table�� ��ġ ������ �� �־�� ���δ�.
		
		
		 sp.addMouseListener(this);
		
		//table.addMouseListener(this);
		this.pack();
		this.setVisible(true);
	}
	private Vector selectAll() {
		// TODO Auto-generated method stub
		data.clear();
		try {
			stmt = con.createStatement();
			 rs = stmt.executeQuery("select * from member;");
			while(rs.next()) {
				
				 in = new Vector<String>();
				
				in.add(rs.getString("num"));
				in.add(rs.getString("name"));
				in.add(rs.getString("address"));
				
				data.add(in);
				
				//btn1.setText(num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	private  Connection makeConnection() {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/member";
        String id = "root";
        String password = "dhr159753";
        Connection con = null;
        try {
               Class.forName("com.mysql.jdbc.Driver");
               System.out.println("����̹� ���� ����");
               con = (Connection) DriverManager.getConnection(url, id, password);
               System.out.println("�����ͺ��̽� ���� ����");
        } catch (ClassNotFoundException e) {
               System.out.println("����̹��� ã�� �� �����ϴ�.");
               e.printStackTrace();
        } catch (SQLException e) {
               System.out.println("���ῡ �����Ͽ����ϴ�.");
               e.printStackTrace();
        }
		return con;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new FriendsDB();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == btn2) {
			
			
			try {
				 insertStmt = (Statement) con.createStatement();
				 String insertQry = "insert into members (ID,PW,name,pnum)"+ "values('"+idt.getText()+"','"+
							pwt.getText()+"','"+namet.getText()+"','"+pnumt.getText()+"');" ;
				 int result = insertStmt.executeUpdate(insertQry);
					if(result == 1) {
						System.out.println("Insert success");
					}
					else {
						System.out.println("Insert fail");
			}
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Vector result = selectAll();
			model.setDataVector(result,title);
			
		}
		if(arg0.getSource() == btn2) {
			
			try{

//				
			}catch(Exception e){

				e.printStackTrace();

			}



	
		}
		
		
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
//		Vector<String> in = (Vector<String>) data.get(index);
//		numt.setText(in.get(0));
//		namet.setText(in.get(1));
//		addrt.setText(in.get(2));
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
