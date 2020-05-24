import javax.swing.JLabel;
import javax.swing.JPanel;


public class WelcomePanel extends JPanel {

	public JLabel msgLB = new JLabel();

	public WelcomePanel() {
		msgLB.setText("자바 피자에 오신 걸 환영합니다");
		this.add(msgLB);
	}
}
//selectPanle[0]에 5개패널중에 첫번째 생성