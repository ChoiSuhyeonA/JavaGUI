import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyButtonListener implements ActionListener {

	public Pizza pi;

	public MyButtonListener(Pizza pizza) {
		this.pi = pizza;
	} // Pizza 클래스를 pi변수에 넣어준다 -> 이로인해 'pi.'으로 Pizza클래스에 멤버를 접근할 수 있다.

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((e.getSource() == pi.orderBT )|| (e.getSource()==pi.menuItem[0])) {
//			pi.selectPanel[0].msgLB  //(WelcomePanel로 강제형변환해줘야한다. 안하게 되면 msgLB을 인식못한다.)
			// 각각의 패널에 접근해서 선택된 금액을 가지고 와서 출력
			int totalSum = ((TypePanel) pi.selectPanel[1]).calcTypeSelect()+ 
					((SizePanel)pi.selectPanel[3]).calcSizeSelect()+
					((ToppingPanel)pi.selectPanel[2]).calcToppingSelect();
			
			
			((WelcomePanel) pi.selectPanel[0]).msgLB.setText("주문버튼클릭!" + totalSum);
			JOptionPane.showMessageDialog(null,"주문가격:"+totalSum+"원입니다");
		}
		if(e.getSource()==pi.cancelBT ||(e.getSource()==pi.menuItem[1])) {
		((WelcomePanel)pi.selectPanel[0]).msgLB.setText("주문이 취소됐습니다, 다시 선택하세요");
		((TypePanel)pi.selectPanel[1]).resetType();
		((ToppingPanel)pi.selectPanel[2]).resetTopping();
		((SizePanel)pi.selectPanel[3]).resetSize();
		JOptionPane.showMessageDialog(null,"주문이 취소됐습니다");
		}
	}
}
