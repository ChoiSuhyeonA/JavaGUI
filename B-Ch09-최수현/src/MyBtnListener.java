import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
     JButton btn_obj = (JButton)e.getSource();
     btn_obj.setBackground(Color.CYAN);
     System.out.println("Button 2 Clicked!!");
     System.out.println(""+btn_obj.getActionCommand());
	}

}
