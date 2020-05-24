import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyItemListener implements ItemListener {

	public Pizza pi;

	public MyItemListener(Pizza pizza) {
		this.pi = pizza;
	}

	public int totalSum() {
		TypePanel tp = ((TypePanel) pi.selectPanel[1]);
		ToppingPanel op = ((ToppingPanel) pi.selectPanel[2]);
		SizePanel sp = ((SizePanel) pi.selectPanel[3]);

		return tp.calcTypeSelect() + op.calcToppingSelect() + sp.calcSizeSelect();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		TypePanel tp = ((TypePanel) pi.selectPanel[1]);
		SizePanel sp =((SizePanel) pi.selectPanel[3]);
		ToppingPanel op = ((ToppingPanel) pi.selectPanel[2]);
		for (int i = 0; i < tp.typeRB.length; i++) {
			if (e.getSource() == tp.typeRB[i]) {
				if (tp.typeRB[i].isSelected()) {
					pi.resultTA.append(tp.typeName[i] + this.totalSum() + "원이 선택되었습니다\n");

				} else {
					pi.resultTA.append(tp.typeName[i] + "이 해제되었습니다\n");

				}

			}
		}
		for (int i = 0; i < sp.sizeRB.length; i++) {
			if (e.getSource() == sp.sizeRB[i]) {
				if (sp.sizeRB[i].isSelected()) {
					pi.resultTA.append(sp.sizeName[i] + this.totalSum() + "원이 선택되었습니다\n");

				} else {
					pi.resultTA.append(sp.sizeName[i] + "이 해제되었습니다\n");

				}

			}
		}
		for (int i = 0; i < op.toppingCB.length; i++) {
			if (e.getSource() == op.toppingCB[i]) {
				if (op.toppingCB[i].isSelected()) {
					pi.resultTA.append(op.toppingName[i] + this.totalSum() + "원이 선택되었습니다\n");

				} else {
					pi.resultTA.append(op.toppingName[i] + "이 해제되었습니다\n");

				}

			}
		}

	}

}
