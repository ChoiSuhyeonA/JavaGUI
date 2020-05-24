import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimpleCalcuator extends JFrame implements ActionListener, KeyListener {

	JPanel pan = new JPanel();
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JTextField tf3 = new JTextField(30);
	JButton convBtn = new JButton("변환");

	public SimpleCalcuator() {
		this.setTitle("이자계산기");
		this.setSize(500, 500);
    
		JLabel lab1 = new JLabel("원금을 입력하시오.");
		JLabel lab2 = new JLabel("이율을 입력하시오.");

		ImageIcon image = new ImageIcon("Image/apple.png");
		JLabel lab3 = new JLabel("사과",image,SwingConstants.CENTER);

		pan.add(lab1);
		pan.add(tf1);
		pan.add(lab2);
		pan.add(tf2);
		pan.add(convBtn);
		pan.add(tf3);

		pan.add(lab3);

		pan.addKeyListener(this);

		convBtn.addActionListener(this);

		this.add(pan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SimpleCalcuator sc = new SimpleCalcuator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == convBtn) {
			double result = Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText()) * 12;

			tf3.setText("이자는 연 " + result + "원입니다.");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 엔터를 눌렀을때
		if (e.getKeyChar() == '\n') {
			tf1.setText("" + (int) (Math.random() * 5));
			tf2.setText("" + (int) (Math.random() * 5));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
