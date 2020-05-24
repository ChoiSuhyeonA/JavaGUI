import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ToppingPanel extends JPanel {

	String toppingName[] = { "피망", "치즈", "페페로니", "베이컨" };
	public JCheckBox toppingCB[] = new JCheckBox[toppingName.length];

	public ToppingPanel() {
		this.setLayout(new GridLayout(0, 1));
//		ButtonGroup bg = new ButtonGroup(); //버튼그룹생성
		for (int i = 0; i < toppingName.length; i++) {
			toppingCB[i] = new JCheckBox(toppingName[i]);
			this.add(toppingCB[i]);
//			bg.add(toppingCB[i]); //checkBox를 그룹으로 관리하여 한개씩 체크하게 가능하게함
		}

		this.setBorder(BorderFactory.createTitledBorder("추가토핑"));
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
