import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;





public class MainFrame extends JFrame implements ActionListener{

	BufferedImage img = null;
	private JButton bt1;
	private JButton bt2;
	private JLayeredPane layeredPane;
	private JButton btn3;
	
	public MainFrame() {
		
		this.setTitle("SS Toast");
        this.setSize(1300, 1070);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //안에 들어갈 내용물들, 레이아웃, 패널설정, 컴포넌트들
        setLayout(null);
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1280, 1024);
        layeredPane.setLayout(null);
         
         
        
        this.add(layeredPane);
        
        try {
            img = ImageIO.read(new File("img/background.jpg"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
        
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1280, 1024);
         
        // 마지막 추가들.
        //반드시 layeredPane의 제일 마지막에 add해줘야함.
        layeredPane.add(panel);
       
        //생성자 바깥으로 다음과 같은 내부클래스를 하나 만들어준다.
       
               
               bt1 = new JButton();
               bt1.setBounds(443, 276, 350, 250);
               bt1.setBackground(null);
               bt1.setOpaque(false);
               bt1.setBorderPainted(false);
               
               layeredPane.add(bt1);
               
               bt2 = new JButton();
               bt2.setBounds(900,700,350,250);
              
               bt2.setBackground(null);
               bt2.setOpaque(false);
               bt2.setBorderPainted(false);
               layeredPane.add(bt2);
             
                              
               bt1.addActionListener(this);
               bt2.addActionListener(this);
               
               btn3 = new JButton();
               btn3.setBounds(35,847,350,250);
               btn3.setOpaque(false);
               layeredPane.add(btn3);
               btn3.addActionListener(this);
        
        this.setVisible(true);
	}
	 class MyPanel extends JPanel {
         public void paint(Graphics g) {
             g.drawImage(img, 0, 0, null);
         }
         }
	public static void main(String[] args) throws SQLException {
		new MainFrame();
		new ClientTest();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt1) {
			new AdminInterface().setVisible(true);
			
		}
		if(e.getSource() == bt2) {
			new AdminInterfacea().setVisible(true);
			
		}
		
		if(e.getSource() == btn3) {
			
		}
		
	}
	
	
		
}
	
	
	
	

	 class AdminInterface extends JFrame  implements ActionListener{
		
		public JLabel user_lb = new JLabel("USER ID:");
		public JTextField user_tf = new JTextField(15);
		public JLabel pw_lb = new JLabel("\nPASSWORD:");
		public JPasswordField pw_tf = new JPasswordField(15);
		public JButton back_btn = new JButton("뒤로 가기");
		public JButton sign_up_btn = new JButton("회원 가입");
		public JButton login_btn = new JButton("로그인");
		private JLayeredPane layeredPane;
		private BufferedImage img = null;
		private String ids;
		private String pws;
		private String ID;
		private String PW;
		private String name;
		private String pnum;

		
		public AdminInterface() {
			this.setTitle("로그인 메뉴");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(525, 550);
			this.setLayout(null);
			
			layeredPane = new JLayeredPane();
			layeredPane.setBounds(0,0,500,500);
			this.add(layeredPane);
	        
	        try {
	            img = ImageIO.read(new File("img/LOGINPAGE.jpg"));
	        } catch (IOException e) {
	            System.out.println("이미지 불러오기 실패");
	            System.exit(0);
	        }
	        
	        MyPanel2 p2 = new MyPanel2();
	        p2.setBounds(0,0,500,500);
	        layeredPane.add(p2);
	        
	        user_tf.setBounds(265,68,190,40);
	        pw_tf.setBounds(265,269,190,40);
	        back_btn.setBounds(380,469,120,26);
	        login_btn.setBounds(150,412,216,62);
	        sign_up_btn.setBounds(5,470,120,25);
			
			//this.add(user_lb);
			layeredPane.add(user_tf);
			//this.add(pw_lb);
			layeredPane.add(pw_tf);
			layeredPane.add(back_btn);
			layeredPane.add(login_btn);
			layeredPane.add(sign_up_btn);
			
			//user_tf.setOpaque(false);
			user_tf.setBackground(null);
			user_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			//pw_tf.setOpaque(false);
			pw_tf.setBackground(null);
			pw_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			back_btn.setOpaque(false);
			login_btn.setOpaque(false);
			sign_up_btn.setOpaque(false);
		
			back_btn.addActionListener(this);
			sign_up_btn.addActionListener(this);
			login_btn.addActionListener(this);
		
			this.setVisible(true);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// 창 하나만 닫기, exit()은 모든창 닫기
			String url = "jdbc:mysql://localhost/member";
	        String id = "root";
	        String password = "dhr159753";
	        Connection con ;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con = (Connection) DriverManager.getConnection(url,id,password);
				
				String sql = "Select * from members";
				
				Statement stmt = (Statement) con.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				if(e.getSource() == back_btn) {
					dispose();
				}
				if(e.getSource() == sign_up_btn) {
					try {
						new signupFrame().setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
				
				if(e.getSource() == login_btn) {
					
					while(rs.next()) {
					
						 ID = rs.getString("ID");
						 PW = rs.getString("PW");
						 name = rs.getString("name");
						 pnum = rs.getString("pnum");
						
						//System.out.format("%s, %s, %s, %s\n",ID, PW, name, pnum);
					
						// new getDB();
					
					
						 ids = new String(user_tf.getText()); // 아이디
						 pws = new String(pw_tf.getPassword());// 패스워드
//					 
					//System.out.println(ids);
					//System.out.println(pws);
						 
						 
					
						 if(ids.equals(rs.getString("ID")) && pws.equals(rs.getString("PW"))) {
							 
								 JOptionPane.showMessageDialog(null,user_tf.getText()+"님 환영합니다.", "Guest", JOptionPane.INFORMATION_MESSAGE);
					
					
						
								 new MENU().setVisible(true);
								
								 
								break;
							 }
							 
						 
					 
						 
					 else {
					
					//JOptionPane.showMessageDialog(null,"ID 혹은 비밀번호를 확인해 주세요!");
					
					//user_tf.setText(" ");
					//pw_tf.setText(" ");
					
					//tf값이 clear 되어 2번째 데이터 부터 비교를 해도 맞지 않음
					// ID 와 pw 값을 clear 시키게 
					 
					}
					 
					
					
				}
				
				// break 처리 안해주면 while문이 끝날때 까지 루프가 돌기 때문에 데이터의 갯수만큼 메시지 창이 뜬다. 따라서 break를 잘 해주어야 한다.
				
			}
				stmt.close();
					
				
			}catch(Exception e1){
				System.err.println("예외 처리됨.");
				System.err.println(e1.getMessage());
				
			}
			
			
			
			
		}
		class MyPanel2 extends JPanel {
	         

			public void paint(Graphics g) {
	             g.drawImage(img, 0, 0, null);
	         }
	         }
	 }
		
		
		class AdminInterfacea extends JFrame  implements ActionListener{
			
			public JLabel user_lb = new JLabel("USER ID:");
			public JTextField user_tf = new JTextField(15);
			public JLabel pw_lb = new JLabel("\nPASSWORD:");
			public JPasswordField pw_tf = new JPasswordField(15);
			public JButton back_btn = new JButton("뒤로 가기");
			public JButton login_btn = new JButton("로그인");
			private JLayeredPane layeredPane;
			private BufferedImage img = null;
			private String ids;
			private String pws;
			private String ID;
			private String PW;
			private String name;
			private String pnum;

			
			public AdminInterfacea() {
				this.setTitle("로그인 메뉴");
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setSize(525, 550);
				this.setLayout(null);
				
				layeredPane = new JLayeredPane();
				layeredPane.setBounds(0,0,500,500);
				this.add(layeredPane);
		        
		        try {
		            img = ImageIO.read(new File("img/LOGINADMIN.jpg"));
		        } catch (IOException e) {
		            System.out.println("이미지 불러오기 실패");
		            System.exit(0);
		        }
		        
		        MyPanel0 p0 = new MyPanel0();
		        p0.setBounds(0,0,500,500);
		        layeredPane.add(p0);
		        
		        user_tf.setBounds(265,68,190,40);
		        pw_tf.setBounds(265,269,190,40);
		        back_btn.setBounds(380,469,120,26);
		        login_btn.setBounds(150,412,216,62);
		        
				
				//this.add(user_lb);
				layeredPane.add(user_tf);
				//this.add(pw_lb);
				layeredPane.add(pw_tf);
				layeredPane.add(back_btn);
				layeredPane.add(login_btn);
				
				
				//user_tf.setOpaque(false);
				user_tf.setBackground(null);
				user_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				//pw_tf.setOpaque(false);
				pw_tf.setBackground(null);
				pw_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				back_btn.setOpaque(false);
				login_btn.setOpaque(false);
				
			
				back_btn.addActionListener(this);
				
				login_btn.addActionListener(this);
			
				this.setVisible(true);
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 창 하나만 닫기, exit()은 모든창 닫기
				
					
					if(e.getSource() == back_btn) {
						dispose();
					}
					
					
					
					
					
					
					if(e.getSource() == login_btn) {
						
						
						
							 
							
							//System.out.format("%s, %s, %s, %s\n",ID, PW, name, pnum);
						
							// new getDB();
						
						
							 ids = new String(user_tf.getText()); // 아이디
							 pws = new String(pw_tf.getPassword());// 패스워드
//						 
						//System.out.println(ids);
						//System.out.println(pws);
							 
							 
						
							 if(ids.equals("root") && pws.equals("onlyroot")) {
								 
								 
										
									// JOptionPane.showMessageDialog(null,user_tf.getText()+"님 환영합니다.", "Admin", JOptionPane.INFORMATION_MESSAGE);
								
									new DBs().setVisible(true);
									
								 
							 }
								 else  {
									 JOptionPane.showMessageDialog(null,"ID 혹은 비밀번호를 확인해 주세요!");
									 
								 }
								 
							 
							 
							 
						 
						 
						
						
					}
					
					// break 처리 안해주면 while문이 끝날때 까지 루프가 돌기 때문에 데이터의 갯수만큼 메시지 창이 뜬다. 따라서 break를 잘 해주어야 한다.
					
				
					
				
			
				
				
		}
		 
	 
			class MyPanel0 extends JPanel {
		         

				public void paint(Graphics g) {
		             g.drawImage(img, 0, 0, null);
		         }
		         }
		 
	 
	
	 }


	 class signupFrame extends JFrame implements ActionListener{
		// public JLabel[] dbLabel = new JLabel[4];
			//public JTextField[] dbtf = new JTextField[4];
			public JButton bbtn = new JButton();
			public JButton sbtn = new JButton();
			private JTextField signid;
			private JPasswordField signpw;
			private JTextField signname;
			private JTextField signpnum;
			private BufferedImage img;
		 public signupFrame() throws SQLException {
			 Connection con = makeConnection();
				Statement stmt = con.createStatement();
				ResultSet rs;
				rs=stmt.executeQuery("select * from members");
				// Query문 안에 "++" 양 ++ 사이에 값을 넣어줄 수 있다. 엄청난 사실!!!
			 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setTitle("회원가입");
				this.setSize(525,550);
				this.setLayout(null);
				
				JLayeredPane layeredPane = new JLayeredPane();
				layeredPane.setBounds(0,0,500,500);
				this.add(layeredPane);
		        
		        try {
		            img = ImageIO.read(new File("img/SIGNUPPAGE.jpg"));
		        } catch (IOException e) {
		            System.out.println("이미지 불러오기 실패");
		            System.exit(0);
		        }
		        
		        MyPanel3 p3 = new MyPanel3();
		        p3.setBounds(0,0,500,500);
		        layeredPane.add(p3);
				
				//String [] name = {"아이디","패스워드","이름","전화번호"};
				
					
		        
					
				//dbLabel[0] = new JLabel(name[0]);
				//this.add(dbLabel[0]);
				signid = new JTextField(10);
				signid.setBounds(194,39,190,40);
				signid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				signid.setBackground(null);
				layeredPane.add(signid);
				
				//dbLabel[1] = new JLabel(name[1]);
				//this.add(dbLabel[1]);
				signpw = new JPasswordField(10);
				signpw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				signpw.setBackground(null);
				signpw.setBounds(194,151,190,40);
				layeredPane.add(signpw);
				
				//dbLabel[2] = new JLabel(name[2]);
				//this.add(dbLabel[2]);
				signname = new JTextField(10);
				signname.setBounds(194,260,190,40);
				signname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				signname.setBackground(null);
				layeredPane.add(signname);
				
				//dbLabel[3] = new JLabel(name[3]);
				//this.add(dbLabel[3]);
				signpnum = new JTextField(10);
				signpnum.setBounds(194,369,190,40);
				signpnum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				signpnum.setBackground(null);
				layeredPane.add(signpnum);
				
				bbtn.setBounds(395,475,120,26);
				sbtn.setBounds(153,451,190,40);
				bbtn.setOpaque(false);
				sbtn.setOpaque(false);
				
				layeredPane.add(bbtn);
				layeredPane.add(sbtn);
				
				bbtn.addActionListener(this);
				sbtn.addActionListener(this);
		 }
		 class MyPanel3 extends JPanel {
	         

				public void paint(Graphics g) {
		             g.drawImage(img, 0, 0, null);
		         }
		 }
		 private Connection makeConnection() {
				// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost/member";
		        String id = "root";
		        String password = "dhr159753";
		        Connection con = null;
		        try {
		               Class.forName("com.mysql.jdbc.Driver");
		               System.out.println("드라이버 적재 성공");
		               con = DriverManager.getConnection(url, id, password);
		               System.out.println("데이터베이스 연결 성공");
		        } catch (ClassNotFoundException e) {
		               System.out.println("드라이버를 찾을 수 없습니다.");
		               e.printStackTrace();
		        } catch (SQLException e) {
		               System.out.println("연결에 실패하였습니다.");
		               e.printStackTrace();
		        }
				return con;
			}
		@Override
		public void actionPerformed(ActionEvent e) {
			ResultSet rs;
			Connection con = makeConnection();
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated method stub
			if(e.getSource() == bbtn) {
				dispose();
			}
			if(e.getSource() == sbtn) {
				try {
					

					int result=stmt.executeUpdate("insert into members (ID,PW,name,pnum)"+ "values('"+signid.getText()+"', '"+signpw.getText()+"','"
							+ signname.getText()+"',' "+signpnum.getText()+"');");
					
					
					if(result == 1) {
						System.out.println("회원가입이 완료되었습니다.");
					}
					else {
						System.out.println("Insert fail");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	 }

	 
	 
	

		






		

	 
		 
	