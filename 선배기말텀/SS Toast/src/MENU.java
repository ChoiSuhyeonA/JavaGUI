import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MENU extends JFrame implements ActionListener {

	BufferedImage I1 = null;
	BufferedImage I2 = null;
	BufferedImage I3 = null;
	BufferedImage I4 = null;
	BufferedImage I5 = null;
	BufferedImage I6 = null;
	BufferedImage I7 = null;

	public JTextArea ta = new JTextArea();
	public JTextField tf = new JTextField();

	public JLayeredPane LP;
	public JPanel TP;

	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();

	JButton b1_1 = new JButton();
	JButton b1_2 = new JButton();
	JButton b1_3 = new JButton();
	JButton b1_4 = new JButton();
	JButton b1_5 = new JButton();
	JButton b1_6 = new JButton();
	JButton b1_7 = new JButton();

	JButton b2_1 = new JButton();
	JButton b2_2 = new JButton();

	JButton b3_1 = new JButton();
	JButton b3_2 = new JButton();
	JButton b3_3 = new JButton();
	JButton b3_4 = new JButton();
	JButton b3_5 = new JButton();
	JButton b3_6 = new JButton();

	JButton b4_1 = new JButton();
	JButton b4_2 = new JButton();
	JButton b4_3 = new JButton();
	JButton b4_4 = new JButton();
	JButton b4_5 = new JButton();
	JButton b4_6 = new JButton();

	JButton b5_1 = new JButton();
	JButton b5_2 = new JButton();
	JButton b5_3 = new JButton();

	JButton b6_1 = new JButton();
	JButton b6_2 = new JButton();
	JButton b6_3 = new JButton();
	JButton b6_4 = new JButton();
	JButton b6_5 = new JButton();

	JButton cal = new JButton();

	MyPanel2 p1;
	MyPanel3 p2;
	MyPanel4 p3;
	MyPanel5 p4;
	MyPanel6 p5;
	MyPanel7 p6;

	JPanel test = new JPanel();

	int total = 0;
	private int mtotal =0;

	public MENU() {

		this.setTitle("MENU");
		this.setSize(1280, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);

		LP = new JLayeredPane();
		LP.setBounds(0, 0, 1280, 1000);
		LP.setLayout(null);

		ta.setBounds(53, 148, 300, 457);
		ta.setOpaque(false);
		ta.setBorder(null);
		LP.add(ta);

		tf.setBounds(40, 690, 329, 88);
		tf.setOpaque(false);
		tf.setBorder(null);
		tf.setEditable(false);
		LP.add(tf);

		cal.setBounds(50, 830, 313, 71);
		cal.setOpaque(false);

		test.setOpaque(false);

		MyPanel1 panel = new MyPanel1();
		panel.setBounds(0, 0, 1280, 1000);
		LP.add(panel);

		b1.setBounds(422, 40, 100, 60);
		b1.setOpaque(false);
		b2.setBounds(564, 40, 100, 60);
		b2.setOpaque(false);
		b3.setBounds(710, 40, 100, 60);
		b3.setOpaque(false);
		b4.setBounds(856, 40, 100, 60);
		b4.setOpaque(false);
		b5.setBounds(1004, 40, 100, 60);
		b5.setOpaque(false);
		b6.setBounds(1147, 40, 100, 60);
		b6.setOpaque(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

		b1_1.addActionListener(this);
		b1_2.addActionListener(this);
		b1_3.addActionListener(this);
		b1_4.addActionListener(this);
		b1_5.addActionListener(this);
		b1_6.addActionListener(this);
		b1_7.addActionListener(this);

		b2_1.addActionListener(this);
		b2_2.addActionListener(this);

		b3_1.addActionListener(this);
		b3_2.addActionListener(this);
		b3_3.addActionListener(this);
		b3_4.addActionListener(this);
		b3_5.addActionListener(this);
		b3_6.addActionListener(this);

		b4_1.addActionListener(this);
		b4_2.addActionListener(this);
		b4_3.addActionListener(this);
		b4_4.addActionListener(this);
		b4_5.addActionListener(this);
		b4_6.addActionListener(this);

		b5_1.addActionListener(this);
		b5_2.addActionListener(this);
		b5_3.addActionListener(this);

		b6_1.addActionListener(this);
		b6_2.addActionListener(this);
		b6_3.addActionListener(this);
		b6_4.addActionListener(this);
		b6_5.addActionListener(this);

		cal.addActionListener(this);

		LP.add(cal);
		LP.add(b1);
		LP.add(b2);
		LP.add(b3);
		LP.add(b4);
		LP.add(b5);
		LP.add(b6);

		LP.add(test);

		this.add(LP);

	}

	class MyPanel1 extends JPanel {
		public void paint(Graphics g1) {
			g1.drawImage(I1, 0, 0, null);
			try {
				I1 = ImageIO.read(new File("img/JUMUN2.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel2 extends JPanel {

		public void paint(Graphics g2) {
			g2.drawImage(I2, 0, 0, null);
			try {
				I2 = ImageIO.read(new File("img/TOPING1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel3 extends JPanel {
		public void paint(Graphics g3) {
			g3.drawImage(I3, 0, 0, null);
			try {
				I3 = ImageIO.read(new File("img/BANG1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel4 extends JPanel {
		public void paint(Graphics g4) {
			g4.drawImage(I4, 0, 0, null);
			try {
				I4 = ImageIO.read(new File("img/SOSE1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel5 extends JPanel {
		public void paint(Graphics g5) {
			g5.drawImage(I5, 0, 0, null);
			try {
				I5 = ImageIO.read(new File("img/CAFFE1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel6 extends JPanel {
		public void paint(Graphics g5) {
			g5.drawImage(I6, 0, 0, null);
			try {
				I6 = ImageIO.read(new File("img/DRINK1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	class MyPanel7 extends JPanel {
		public void paint(Graphics g6) {
			g6.drawImage(I7, 0, 0, null);
			try {
				I7 = ImageIO.read(new File("img/JUSES1.jpg"));
			} catch (IOException e) {
				System.out.println("출력 불가");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MENU();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {

			LP.remove(test);

			p1 = new MyPanel2();
			p1.setBounds(428, 135, 854, 839);
			p1.setLayout(null);

			b1_1.setBounds(118, 137, 157, 75);
			b1_1.setOpaque(false);
			b1_2.setBounds(367, 137, 157, 75);
			b1_2.setOpaque(false);
			b1_3.setBounds(605, 137, 157, 75);
			b1_3.setOpaque(false);
			b1_4.setBounds(118, 342, 157, 75);
			b1_4.setOpaque(false);
			b1_5.setBounds(367, 342, 157, 75);
			b1_5.setOpaque(false);
			b1_6.setBounds(605, 342, 157, 75);
			b1_6.setOpaque(false);
			b1_7.setBounds(118, 551, 157, 75);
			b1_7.setOpaque(false);

			p1.add(b1_1);
			p1.add(b1_2);
			p1.add(b1_3);
			p1.add(b1_4);
			p1.add(b1_5);
			p1.add(b1_6);
			p1.add(b1_7);

			LP.add(p1);

		}
		if (e.getSource() == b2) {

			LP.remove(p1);

			p2 = new MyPanel3();
			p2.setBounds(428, 135, 854, 839);
			p2.setLayout(null);

			b2_1.setBounds(118, 97, 157, 75);
			b2_1.setOpaque(false);
			b2_2.setBounds(544, 97, 157, 75);
			b2_2.setOpaque(false);

			p2.add(b2_1);
			p2.add(b2_2);

			LP.add(p2);
		}
		if (e.getSource() == b3) {

			LP.remove(p2);

			p3 = new MyPanel4();
			p3.setBounds(428, 135, 854, 839);
			p3.setLayout(null);

			b3_1.setBounds(143, 90, 157, 75);
			b3_1.setOpaque(false);
			b3_2.setBounds(361, 90, 157, 75);
			b3_2.setOpaque(false);
			b3_3.setBounds(587, 90, 157, 75);
			b3_3.setOpaque(false);
			b3_4.setBounds(143, 364, 157, 75);
			b3_4.setOpaque(false);
			b3_5.setBounds(361, 364, 157, 75);
			b3_5.setOpaque(false);
			b3_6.setBounds(587, 364, 157, 75);
			b3_6.setOpaque(false);

			p3.add(b3_1);
			p3.add(b3_2);
			p3.add(b3_3);
			p3.add(b3_4);
			p3.add(b3_5);
			p3.add(b3_6);

			LP.add(p3);
		}
		if (e.getSource() == b4) {

			LP.remove(p3);

			p4 = new MyPanel5();
			p4.setBounds(428, 135, 854, 839);
			p4.setLayout(null);

			b4_1.setBounds(143, 90, 157, 75);
			b4_1.setOpaque(false);
			b4_2.setBounds(361, 90, 157, 75);
			b4_2.setOpaque(false);
			b4_3.setBounds(587, 90, 157, 75);
			b4_3.setOpaque(false);
			b4_4.setBounds(143, 364, 157, 75);
			b4_4.setOpaque(false);
			b4_5.setBounds(361, 364, 157, 75);
			b4_5.setOpaque(false);
			b4_6.setBounds(587, 364, 157, 75);
			b4_6.setOpaque(false);

			p4.add(b4_1);
			p4.add(b4_2);
			p4.add(b4_3);
			p4.add(b4_4);
			p4.add(b4_5);
			p4.add(b4_6);

			LP.add(p4);

		}
		if (e.getSource() == b5) {

			LP.remove(p4);

			p5 = new MyPanel6();
			p5.setBounds(428, 135, 854, 839);
			p5.setLayout(null);

			b5_1.setBounds(143, 90, 157, 75);
			b5_1.setOpaque(false);
			b5_2.setBounds(361, 90, 157, 75);
			b5_2.setOpaque(false);
			b5_3.setBounds(587, 90, 157, 75);
			b5_3.setOpaque(false);

			p5.add(b5_1);
			p5.add(b5_2);
			p5.add(b5_3);

			LP.add(p5);

		}
		if (e.getSource() == b6) {

			LP.remove(p5);

			LP.remove(p1);
			LP.remove(p2);
			LP.remove(p3);
			LP.remove(p4);
			LP.remove(p5);

			p6 = new MyPanel7();
			p6.setBounds(428, 135, 854, 839);
			p6.setLayout(null);

			b6_1.setBounds(143, 90, 157, 75);
			b6_1.setOpaque(false);
			b6_2.setBounds(361, 90, 157, 75);
			b6_2.setOpaque(false);
			b6_3.setBounds(587, 90, 157, 75);
			b6_3.setOpaque(false);
			b6_4.setBounds(143, 364, 157, 75);
			b6_4.setOpaque(false);
			b6_5.setBounds(361, 364, 157, 75);
			b6_5.setOpaque(false);

			p6.add(b6_1);
			p6.add(b6_2);
			p6.add(b6_3);
			p6.add(b6_4);
			p6.add(b6_5);

			LP.add(p6);

		}
		if (e.getSource() == b1_1) {
			total += 500;
			ta.append("기본 500원" + "\n");
		}
		if (e.getSource() == b1_2) {
			total += 500;
			ta.append("햄 500원" + "\n");
		}
		if (e.getSource() == b1_3) {
			total += 500;
			ta.append("치즈 500원" + "\n");
		}
		if (e.getSource() == b1_4) {
			total += 700;
			ta.append("치킨 700원" + "\n");
		}
		if (e.getSource() == b1_5) {
			total += 700;
			ta.append("스테이크 700원" + "\n");
		}
		if (e.getSource() == b1_6) {
			total += 700;
			ta.append("해쉬브라운 700원" + "\n");
		}
		if (e.getSource() == b1_7) {
			total += 700;
			ta.append("베이컨 700원" + "\n");
		}
		if (e.getSource() == b2_1) {
			total += 1000;
			ta.append("식빵 1000원" + "\n");
		}
		if (e.getSource() == b2_2) {
			total += 1500;
			ta.append("베이글 1000원" + "\n");
		}
		if (e.getSource() == b3_1) {
			ta.append("과일소스 무료" + "\n");
		}
		if (e.getSource() == b3_2) {
			ta.append("케찹 무료" + "\n");
		}
		if (e.getSource() == b3_3) {
			total += 200;
			ta.append("마요네즈 200원" + "\n");
		}
		if (e.getSource() == b3_4) {
			total += 200;
			ta.append("스테이크 200원" + "\n");
		}
		if (e.getSource() == b3_5) {
			total += 200;
			ta.append("머스타드 200원" + "\n");
		}
		if (e.getSource() == b3_6) {
			total += 200;
			ta.append("칠리소스 200원" + "\n");
		}
		if (e.getSource() == b4_1) {
			total += 2000;
			ta.append("아메리카도 2000원" + "\n");
		}
		if (e.getSource() == b4_2) {
			total += 2500;
			ta.append("카페라떄 2500원" + "\n");
		}
		if (e.getSource() == b4_3) {
			total += 3500;
			ta.append("카페모카 3500원" + "\n");
		}
		if (e.getSource() == b4_4) {
			total += 3500;
			ta.append("카라멜 마끼야도 3500원" + "\n");
		}
		if (e.getSource() == b4_5) {
			total += 2300;
			ta.append("초코우유 2300원" + "\n");
		}
		if (e.getSource() == b4_6) {
			total += 3000;
			ta.append("카푸치노 3000원" + "\n");
		}
		if (e.getSource() == b5_1) {
			total += 2000;
			ta.append("복숭아 에이드 2000원" + "\n");
		}
		if (e.getSource() == b5_2) {
			total += 2000;
			ta.append("체리 에이드 2000원" + "\n");
		}
		if (e.getSource() == b5_3) {
			total += 2000;
			ta.append("레몬 에이드 2000원" + "\n");
		}
		if (e.getSource() == b6_1) {
			total += 2500;
			ta.append("딸기 주스 2500원" + "\n");
		}
		if (e.getSource() == b6_2) {
			total += 2500;
			ta.append("바나나 우유 2500원" + "\n");
		}
		if (e.getSource() == b6_3) {
			total += 2500;
			ta.append("파인애플 주스 2500원" + "\n");
		}
		if (e.getSource() == b6_4) {
			total += 2500;
			ta.append("키위 주스 2500원" + "\n");
		}
		if (e.getSource() == b6_5) {
			total += 2500;
			ta.append("토마토 주스 2500원" + "\n");
		}
		if (e.getSource() == cal) {
			tf.setText("총 결제금액 " + total + " 원입니다.");
			mtotal  += total;
			ta.setText(" ");
			total = 0;

		}
	
	}}
