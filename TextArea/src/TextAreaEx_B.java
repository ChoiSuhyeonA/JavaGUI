import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TextAreaEx_B extends JFrame implements ActionListener, ListSelectionListener, ChangeListener {

	public JPanel pan = new JPanel();
	public JTextField tf = new JTextField(20);
	public JButton bt = new JButton("추가");
	public JTextArea ta = new JTextArea("Brother", 7, 20);
	String fruits[] = { "사과", "배", "체리", "사과", "배", "체리", "사과", "배", "체리", "사과", "배", "체리" };
	public JList fl = new JList(fruits);
	public Vector comboBoxItems = new Vector();
	public DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(comboBoxItems);
	public JComboBox cb = new JComboBox(comboBoxModel);
    
	public DefaultListModel listModel = new DefaultListModel();
	public JList fl2 = new JList(listModel);
	public JSlider sl = new JSlider(JSlider.HORIZONTAL,100,50);
	
	public TextAreaEx_B() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("Text Area Example");

		// JScrollPane sp =new JScrollPane(ta);
		
		pan.add(tf);
		pan.add(bt);
		pan.add(new JScrollPane(ta));
		pan.add(new JScrollPane(fl));
		this.add(pan);

		bt.addActionListener(this);
		tf.addActionListener(this);
		fl.addListSelectionListener(this);

		pan.add(new JScrollPane(cb));  //스크롤 생성
		cb.addActionListener(this);
		
		pan.add(new JScrollPane(fl2));
		
		comboBoxModel.addElement("키움히어로즈");
		listModel.addElement("샴미슈퍼스타즈");
		
		pan.add(sl);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		
		sl.setMajorTickSpacing(20);
		sl.setMinorTickSpacing(2);
		
		sl.addChangeListener(this);
		
		ta.append("\n" + "Hello");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextAreaEx_B();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt || e.getSource() == tf ) {
			ta.append("\n" + tf.getText());
			comboBoxModel.addElement(tf.getText());
			listModel.addElement(tf.getText());
			tf.setText("");
		}
		if (e.getSource() == cb) {
			JComboBox selCombo = (JComboBox) e.getSource();
			ta.append("\n"+selCombo.getSelectedItem());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == fl) {
			JList selList = (JList) e.getSource();
			if (selList.getValueIsAdjusting() == true)//두개선택되지 않게
				{
				ta.append("\n" + selList.getSelectedValue());
				// ta.append("\n" +fruits[selList.getSelectedIndex()]);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==sl) {
			ta.append("\n슬라이더:"+sl.getValue());
		}
		
	}

}
