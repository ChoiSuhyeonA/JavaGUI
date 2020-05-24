import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMouseEvent extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
   public JButton btn = new JButton("Button");
   public JLabel label = new JLabel("Hello");
	
	public MyMouseEvent() {
		this.setTitle("Mouse Event Frame");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(btn);
		btn.setLocation(100,30);
		btn.setSize(80, 0);
		
		panel.add(label);
		label.setLocation(200, 30);
		label.setSize(80, 30);
		
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		this.add(panel);
		
		this.setVisible(true);
		
	}

	

	@Override

	
	public void mouseClicked(MouseEvent e) {
		label.setLocation(e.getX(), e.getY());
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	    label.setLocation(e.getX(),e.getY());
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
