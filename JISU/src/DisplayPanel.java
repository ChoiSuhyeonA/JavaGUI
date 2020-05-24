import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayPanel extends JPanel {

	String field[] = {"이름","전화번호","나이"};
	public JLabel fieldLabel[] = new JLabel[field.length];
	public JTextField dbTextField[] = new JTextField[field.length];
	public DisplayPanel() {
		
		this.setLayout(new GridLayout(0,2));
		for(int i=0; i<field.length; i++) {
			fieldLabel[i] = new JLabel(field[i]);
			dbTextField[i] = new JTextField(15);
			this.add(fieldLabel[i]);
			this.add(dbTextField[i]);
			
			
		}
		
	}
}
