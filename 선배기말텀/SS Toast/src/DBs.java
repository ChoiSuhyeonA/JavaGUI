
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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



public class DBs extends JFrame {

	//경고가 발생하지 않도록 처리
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Vector data = null;
	@SuppressWarnings("rawtypes")
	private Vector title = null;
	private JTable table = null;
	private DefaultTableModel model = null;
	private JButton btnAdd = null;
	private JButton btnDel = null;
	private JButton btnUpdate= null;
	private String Url 	= "jdbc:mysql://localhost/member"; 
	private String user = "root"; 
	private String password = "dhr159753"; // 패스워드는 제 패스워드 나중에 onlyroot로 변경 필요
	private Connection conn = null;
	private Statement stmt	= null;
	private PreparedStatement pstmtAdd   = null;
	private PreparedStatement pstmtDel   = null;
	private PreparedStatement pstmtUpdate = null;
	private JTextField tfid = null;
	private JTextField tfpw = null;
	private JTextField tfname = null;
	private JTextField tfpnum = null;

	public DBs() {

		super("FriendsDB");
		preDbTreatment();

		data = new Vector<>();

		title = new Vector<>();

		title.add("ID");

		title.add("PW");

		title.add("이름");
		
		title.add("H.P");


		model = new DefaultTableModel();

		Vector result = selectAll();

		model.setDataVector(result, title);

		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);

		


		table.addMouseListener(new MouseAdapter() {

			



			

			@Override

			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Vector in = (Vector) data.get(index);

				


				String id = (String)in.get(0);

				String pw = (String)in.get(1);

				String name = (String)in.get(2);
				
				String pnum = (String)in.get(3);

			
				tfid.setText(id);

				tfpw.setText(pw);

				tfname.setText(name);
				
				tfpnum.setText(pnum);

				//tfid.setEditable(false); // id의 textfield값을 수정 불가능하게 설정해줍니다.
			

//				tfpw.setEditable(false);

//				tfname.setEditable(false);

				

			}

		});

		



		JPanel panel = new JPanel();

		



		tfid = new JTextField(8);

		tfpw = new JTextField(10);

		tfname = new JTextField(10);
		
		tfpnum = new JTextField(10);

		



	
		



		btnAdd = new JButton("추가");

		btnDel = new JButton("삭제");

		btnUpdate = new JButton("수정");

		

		





		btnAdd.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				String id = tfid.getText(); 
				String pw = tfpw.getText();
				String name = tfname.getText(); 
				String pnum = tfpnum.getText();
				insert(id, pw, name, pnum);
				Vector result = selectAll();

				model.setDataVector(result, title);

			}

		});

		btnDel.addActionListener(new ActionListener() {

			

			@Override

			public void actionPerformed(ActionEvent e) {


				String id = tfid.getText();

				



				delete(id);

				



				Vector result = selectAll();

				



				model.setDataVector(result, title);

			}

		});

		


		btnUpdate.addActionListener(new ActionListener() {

			

			@Override

			public void actionPerformed(ActionEvent e) {



				String id = tfid.getText(); 
				String pw = tfpw.getText();
				String name = tfname.getText(); 
				String pnum = tfpnum.getText();
				


				update(pw, name, pnum, id);

				


				Vector result = selectAll();

				



				model.setDataVector(result, title);

			}

		});



		
		panel.add(tfid);

		

		panel.add(tfpw);

		

		panel.add(tfname);
		
		panel.add(tfpnum);

		



		panel.add(btnAdd);

		panel.add(btnDel);

		panel.add(btnUpdate);

		

		



		Container c = getContentPane();

		


		c.add(sp,BorderLayout.CENTER);

		c.add(panel, BorderLayout.SOUTH);

		


		addWindowListener(new WindowAdapter(){

			@Override

			public void windowClosing(WindowEvent w) {

				try{

					stmt.close(); 

					conn.close(); 

					

					setVisible(false); // 화면 닫기

					dispose(); // 자원 반납  // 모두 반납하려면 exit처리

					System.exit(0); // 종료 

				}catch(Exception e){

					

				}

			}

		});

			this.pack();

		

			this.setVisible(true);

	}

	

	

	private Vector selectAll() {

		data.clear();

		

		try{

			ResultSet rs = stmt.executeQuery("select * from members order by id");

			

			while(rs.next()){

				Vector in = new Vector<String>(); 

				

				

				String id = rs.getString("id");

				

				

				String pw = rs.getString("pw");

				

				

				String name = rs.getString("name");
				
				
				String pnum = rs.getString("pnum");

				


				in.add(id);

				in.add(pw);

				in.add(name);
				
				in.add(pnum);

				



				data.add(in);

			}

		}catch(Exception e){

			e.printStackTrace();

		}

		return data; 

	}



	
// 			insert를 받기위해 각 tf에 값을 넣어 추가한다.
	private void insert(String id, String pw, String name, String pnum){

		try{

//			PreparedStatement 를 사용하여 1값은 첫번째 ?에 대입해주고, 2값은 두번째 3값은 3번째에 대입

			pstmtAdd = conn.prepareStatement("insert into members values(?,?,?,?)");

			



			pstmtAdd.setString(1, id);

			pstmtAdd.setString(2, pw);

			pstmtAdd.setString(3, name);
			
			pstmtAdd.setString(4, pnum);

			



			pstmtAdd.executeUpdate();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	

//		클릭한 데이터값의 num을 데이터베이스의 num값과 비교해서 delete 해준다.	
	private void delete(String id){

		try{



			pstmtDel = conn.prepareStatement("delete from members where id = ?");

			

//			num 값을 비교하여 삭제

 			pstmtDel.setString(1, id);

 			



			pstmtDel.executeUpdate();

			

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	

	
// string 순서를 변환하면 값이 안나온다. 클릭한 데이터 값이 각 tf에 출력되고 출력된 값을 수정 한 후 수정 버튼을 누르면 값이 바뀌어 들어간다.
	private void update(String pw, String name, String pnum ,String id){

		try{



			pstmtUpdate = conn.prepareStatement("update members set pw = ? , name = ? , pnum = ? where id = ?");



			pstmtUpdate.setString(1, pw);

			pstmtUpdate.setString(2, name);



			pstmtUpdate.setString(3, pnum);
			
			pstmtUpdate.setString(4, id);



			pstmtUpdate.executeUpdate();

			

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	

	
//		데이터베이스와 연동하는 함수.
	private void preDbTreatment() {

		try{

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(Url,user,password);

			stmt = conn.createStatement();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	

	public static void main(String[] args) {

		 new DBs();


		

	}

}



