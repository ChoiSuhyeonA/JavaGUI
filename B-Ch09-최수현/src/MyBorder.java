
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBorder extends JFrame implements ActionListener, MouseListener {
	public JButton btn = new JButton("버튼");
	public JButton btn_clr = new JButton("clear");
	public JButton btn1 = new JButton("1");
	public JButton btn2 = new JButton("2");
	public JButton btn3 = new JButton("3");
	public JButton btn_plus = new JButton("+");
	public JTextField[] tf = new JTextField[4];

	public MyBorder() {
		

		JPanel pan1 = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel pan2 = new JPanel();

		String[] lb_name = { "이름", "학과", "학번", "과목" };
		JLabel[] lab = new JLabel[4];
//      JTextField[]tf=new JTextField[4];
		for (int i = 0; i < lb_name.length; i++) {
			lab[i] = new JLabel(lb_name[i]);
			tf[i] = new JTextField(40);

		}
		for (int i = 0; i < lb_name.length; i++) {
			pan1.add(lab[i]);
			pan1.add(tf[i]);
		}
		pan2.add(btn);
		pan2.add(btn_clr);
		pan2.add(btn1);
		pan2.add(btn2);
		pan2.add(btn3);
		pan2.add(btn_plus);

		btn.addActionListener(this);
		btn.addMouseListener(this);

		btn_clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < tf.length; i++) {
					tf[i].setText("");
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn_obj = (JButton) e.getSource();
				tf[1].setText(tf[1].getText() + btn_obj.getActionCommand());
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn_obj = (JButton) e.getSource();
				tf[1].setText(tf[1].getText() + btn_obj.getActionCommand());
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn_obj = (JButton) e.getSource();
				tf[1].setText(tf[1].getText() + btn_obj.getActionCommand());
			}
		});

		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sum = Integer.parseInt(tf[0].getText()) + Integer.parseInt(tf[1].getText());
				tf[3].setText("" + sum);
			}
		});

		this.add(pan1, BorderLayout.CENTER);
		this.add(pan2, BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setTitle("MyBorder Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn_obj = (JButton) e.getSource();
		if (btn_obj.getText() == "버튼")
			btn_obj.setText("클릭");
		else
			btn_obj.setText("버튼");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			if (btn.getText() == "버튼")
				btn.setText("클릭");
			else
				btn.setText("버튼");
		}
		if (e.getSource() == tf[0]) {
			tf[3].setText("" + tf[0].getText());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			btn.setBackground(Color.CYAN);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			btn.setBackground(Color.YELLOW);
		}

	}
}
