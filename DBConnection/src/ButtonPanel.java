import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ButtonPanel extends JPanel {

	public JButton btnPrevious = new JButton("Previous");
	public JButton btnNext = new JButton("Next");
	public JButton btnInsert = new JButton("Insert");
	public JButton btnDelete = new JButton("Delete");
	public JButton btnName[] = new JButton[4];
	
	public ButtonPanel() {
		this.add(btnPrevious);
		this.add(btnNext);
//		this.add(btnInsert);
//		this.add(btnDelete);
		
		for(int i=0; i<btnName.length; i++) {
			btnName[i] = new JButton("   ");
			btnName[i].setSize(50, 50);
			this.add(btnName[i]);
		}

	}
}
