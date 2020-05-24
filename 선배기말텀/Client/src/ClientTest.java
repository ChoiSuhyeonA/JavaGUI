
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

         


public class ClientTest extends JFrame implements ActionListener {

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	private JTextArea textArea;
	private JTextField textField;
	BufferedImage I1 = null;
	public JLayeredPane LP;
	
	public ClientTest() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("손님 채팅");
		this.setSize(500, 500);
		
		
		LP = new JLayeredPane();
		LP.setBounds(0, 0, 500, 500);
		LP.setLayout(null);
		
		
		
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(40, 101, 420, 320);
		sp.setBorder(null);
		LP.add(sp);
		
		textField = new JTextField(30);
		textField.setBounds(41, 456, 406, 24);
		textField.setBorder(null);
		textField.setOpaque(false);
		LP.add(textField);
		textField.addActionListener(this);
		
		
		MyPanel1 panel = new MyPanel1();
		panel.setBounds(0, 0, 500, 500);
		LP.add(panel);

		this.add(LP);
		
		this.setVisible(true);
		try {
			socket = new Socket("localhost", 8888);
			System.out.println("연결됨");
			
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			
			String input;
			while(true) {
				input = in.readLine();
				if (input.equalsIgnoreCase("bye"))
					break;
				textArea.append("[Received] " + input + "\n");
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("localhost 연결 불가");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("포트 접속 불가");
		}
	}
	
	class MyPanel1 extends JPanel {
		public void paint(Graphics g1) {
			g1.drawImage(I1, 0, 0, null);
			try {
				I1 = ImageIO.read(new File("img/cost.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientTest();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			out.write(textField.getText()+"\n");
			out.flush();
			textArea.append("[Sent] " + textField.getText() + "\n");
			textField.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}