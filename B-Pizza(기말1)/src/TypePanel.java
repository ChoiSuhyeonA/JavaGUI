import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TypePanel extends JPanel {

	String typeName[] = { "�޺�", "��������", "�Ұ��" };
	public JRadioButton typeRB[] = new JRadioButton[typeName.length];

	public TypePanel() {
		this.setLayout(new GridLayout(0, 1));
		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < typeName.length; i++) {
			typeRB[i] = new JRadioButton(typeName[i]);
			this.add(typeRB[i]);
			bg.add(typeRB[i]);
		}
		typeRB[0].setSelected(true);
		this.setBorder(BorderFactory.createTitledBorder("����")); // �гξȿ� �׵θ� ����
	}

	public int calcTypeSelect() { // ->�迭�� ����ؼ� �����ϰ�
//		if (typeRB[0].isSelected())
//			return 1000;
//		if (typeRB[1].isSelected())
//			return 2000;
//		if (typeRB[2].isSelected())
//			return 3000;
//		else
//			return 0;
		int costType[] = { 1000, 2000, 3000 };
		for (int i = 0; i < costType.length; i++) {
			if (typeRB[i].isSelected())
				return costType[i];
		}
		return 0;
	}

	public void resetType() {
		typeRB[0].setSelected(true);

	}
}
