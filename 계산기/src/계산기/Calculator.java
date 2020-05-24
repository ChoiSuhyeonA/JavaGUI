package 계산기;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

public class Calculator extends JFrame {
	public JButton btn = new JButton("버튼");
	
	public JButton btn1 = new JButton("1");
	public JButton btn2 = new JButton("2");
	public JButton btn3 = new JButton("3");
	public JButton btn4 = new JButton("4");
	public JButton btn5 = new JButton("5");
	public JButton btn6= new JButton("6");
	public JButton btn7 = new JButton("7");
	public JButton btn8 = new JButton("8");
	public JButton btn9 = new JButton("9");

	
	public JButton btn_plus = new JButton("+");
	public JButton btn_minus = new JButton("-");
	public JButton btn_multi = new JButton("x");
	public JButton btn_div = new JButton("%");
	public JButton btn_clr = new JButton("clear");

	public JTextField[] tf = new JTextField[3];

	public Calculator() {
		this.setSize(400, 300);
		this.setTitle("Calculator");
	
		Container c = getContentPane();
		

		JPanel pan1 = new JPanel(new GridLayout(3, 5, 10, 10));
		JPanel pan2 = new JPanel(new GridLayout(1, 5, 10, 10));
		JPanel pan3 = new JPanel(new GridLayout(3, 3, 10, 10));
		
		c.add(pan1, BorderLayout.NORTH);
		c.add(pan2, BorderLayout.SOUTH);
		c.add(pan3, BorderLayout.CENTER);

		pan1.setBackground(Color.GREEN);
		pan2.setBackground(Color.CYAN);
		pan3.setBackground(Color.CYAN);
	
		
		String[] lb_name = { "숫자(1)", "숫자(2)", "결과" };
		JLabel[] lab = new JLabel[4];

		for (int i = 0; i < lb_name.length; i++) {
			lab[i] = new JLabel(lb_name[i]);
			tf[i] = new JTextField(100);
			pan1.add(lab[i]);
			pan1.add(tf[i]);

		}

		
		pan2.add(btn_clr);
		pan2.add(btn_plus);
		pan2.add(btn_minus);
		pan2.add(btn_multi);
		pan2.add(btn_div);
		
		pan3.add(btn1);
		pan3.add(btn2);
		pan3.add(btn3);
		pan3.add(btn4);
		pan3.add(btn5);
		pan3.add(btn6);
		pan3.add(btn7);
		pan3.add(btn8);
		pan3.add(btn9);

		
     
	      btn1.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn2.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn3.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn4.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn5.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn6.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn7.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn8.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      btn9.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    			// TODO Auto-generated method stub
	    	     JButton btn_obj = (JButton)e.getSource();
	    	     tf[0].setText(tf[0].getText()+btn_obj.getActionCommand());
	    		}
	      });
	      
		btn_clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < tf.length; i++) {
					tf[i].setText("");
				}
			}
		});

		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sum = Integer.parseInt(tf[0].getText()) + Integer.parseInt(tf[1].getText());
				tf[2].setText("" + sum);
			}
		});

		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sum = Integer.parseInt(tf[0].getText()) - Integer.parseInt(tf[1].getText());
				tf[2].setText("" + sum);
			}
		});

		btn_multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sum = Integer.parseInt(tf[0].getText()) * Integer.parseInt(tf[1].getText());
				tf[2].setText("" + sum);
			}
		});

		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int sum = Integer.parseInt(tf[0].getText()) / Integer.parseInt(tf[1].getText());
				tf[2].setText("" + sum);
			}
		});


		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


}
