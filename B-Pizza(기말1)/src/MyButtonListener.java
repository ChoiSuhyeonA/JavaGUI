import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyButtonListener implements ActionListener {

	public Pizza pi;

	public MyButtonListener(Pizza pizza) {
		this.pi = pizza;
	} // Pizza Ŭ������ pi������ �־��ش� -> �̷����� 'pi.'���� PizzaŬ������ ����� ������ �� �ִ�.

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((e.getSource() == pi.orderBT )|| (e.getSource()==pi.menuItem[0])) {
//			pi.selectPanel[0].msgLB  //(WelcomePanel�� ��������ȯ������Ѵ�. ���ϰ� �Ǹ� msgLB�� �νĸ��Ѵ�.)
			// ������ �гο� �����ؼ� ���õ� �ݾ��� ������ �ͼ� ���
			int totalSum = ((TypePanel) pi.selectPanel[1]).calcTypeSelect()+ 
					((SizePanel)pi.selectPanel[3]).calcSizeSelect()+
					((ToppingPanel)pi.selectPanel[2]).calcToppingSelect();
			
			
			((WelcomePanel) pi.selectPanel[0]).msgLB.setText("�ֹ���ưŬ��!" + totalSum);
			JOptionPane.showMessageDialog(null,"�ֹ�����:"+totalSum+"���Դϴ�");
		}
		if(e.getSource()==pi.cancelBT ||(e.getSource()==pi.menuItem[1])) {
		((WelcomePanel)pi.selectPanel[0]).msgLB.setText("�ֹ��� ��ҵƽ��ϴ�, �ٽ� �����ϼ���");
		((TypePanel)pi.selectPanel[1]).resetType();
		((ToppingPanel)pi.selectPanel[2]).resetTopping();
		((SizePanel)pi.selectPanel[3]).resetSize();
		JOptionPane.showMessageDialog(null,"�ֹ��� ��ҵƽ��ϴ�");
		}
	}
}
