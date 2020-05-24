import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ToppingPanel extends JPanel {

	String toppingName[] = { "�Ǹ�", "ġ��", "����δ�", "������" };
	public JCheckBox toppingCB[] = new JCheckBox[toppingName.length];

	public ToppingPanel() {
		this.setLayout(new GridLayout(0, 1));
//		ButtonGroup bg = new ButtonGroup(); //��ư�׷����
		for (int i = 0; i < toppingName.length; i++) {
			toppingCB[i] = new JCheckBox(toppingName[i]);
			this.add(toppingCB[i]);
//			bg.add(toppingCB[i]); //checkBox�� �׷����� �����Ͽ� �Ѱ��� üũ�ϰ� �����ϰ���
		}

		this.setBorder(BorderFactory.createTitledBorder("�߰�����"));
	}

	public int calcToppingSelect() {
		int subTotal = 0;
		int costOfTopping[] = { 50, 100, 150, 200 };
		for (int i = 0; i < costOfTopping.length; i++) {
			if (toppingCB[i].isSelected())
				subTotal += costOfTopping[i];
		}
		return subTotal;

	}
    public void resetTopping() {
    	for(int i=0; i<toppingCB.length; i++) {
    		toppingCB[i].setSelected(false);
    	}
    }
    
    
}
