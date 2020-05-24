import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBox extends JFrame implements ItemListener {

	String fruits[] = { "사과", "배", "체리" };
	String imageName[] = { "image/apple.png", "image/pear.jpg", "image/cherry.png" };

	public JCheckBox cb[] = new JCheckBox[fruits.length];
	public JPanel pan = new JPanel();
	public ImageIcon image[] = new ImageIcon[fruits.length];

	public CheckBox() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int i = 0; i < fruits.length; i++) {
			image[i] = new ImageIcon(imageName[i]);
			cb[i] = new JCheckBox(fruits[i], image[i]);
			cb[i].setBorderPainted(true); //체크박스 경계선 
			cb[i].addItemListener(this);
			pan.add(cb[i]);
		}
        cb[0].setSelectedIcon(new ImageIcon("image/apple_selected.png"));
		this.add(pan);
		this.setTitle("체크박스프레임");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBox();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
