import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pizza extends JFrame {

	public JPanel basePanel[] = new JPanel[5];
	public JPanel selectPanel[] = new JPanel[5];
	public JButton orderBT = new JButton("林巩");
	public JButton cancelBT = new JButton("秒家");
	public JTextArea resultTA = new JTextArea(10, 20);
	public JTextField resultTF = new JTextField(20);
	public String[] menuList = { "林巩", "秒家" };
	public JMenuItem menuItem[] = new JMenuItem[menuList.length];
	public MyButtonListener mbl;

	public Pizza() 
   {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Pizza World");
      
      basePanel[0] = new JPanel(new BorderLayout());
      basePanel[1] = new JPanel(new BorderLayout());
      basePanel[2] = new JPanel(new GridLayout(0,1));
      
      selectPanel[0] = new WelcomePanel();
      selectPanel[1] = new TypePanel();
      selectPanel[2] = new ToppingPanel();
      selectPanel[3] = new SizePanel();
      
      selectPanel[4] = new JPanel();
      selectPanel[4].add(orderBT);
      selectPanel[4].add(cancelBT);
      
      basePanel[0].add(selectPanel[0], BorderLayout.NORTH);
      basePanel[0].add(selectPanel[1], BorderLayout.WEST);
      basePanel[0].add(selectPanel[2], BorderLayout.CENTER);
      basePanel[0].add(selectPanel[3], BorderLayout.EAST);
      basePanel[0].add(selectPanel[4], BorderLayout.SOUTH);
      
      basePanel[1].add(new JScrollPane(resultTA), BorderLayout.CENTER);
      basePanel[1].add(resultTF, BorderLayout.SOUTH);
      
      mbl = new MyButtonListener(this);
      orderBT.addActionListener(mbl);
      cancelBT.addActionListener(mbl);
      
      MyItemListener mil = new MyItemListener(this);
      
      for (int i=0; i < ((TypePanel)selectPanel[1]).typeRB.length; i++) 
         ((TypePanel)selectPanel[1]).typeRB[i].addItemListener(mil);
      
      for (int i=0; i < ((SizePanel)selectPanel[3]).sizeRB.length; i++) 
         ((SizePanel)selectPanel[3]).sizeRB[i].addItemListener(mil);
      
      for(int i=0;i<((ToppingPanel)selectPanel[2]).toppingCB.length;i++)
         ((ToppingPanel)selectPanel[2]).toppingCB[i].addItemListener(mil);
      
//      this.setLayout(new GridLayout(0,1));
//      this.add(basePanel[0]);
//      this.add(basePanel[1]);
      
      basePanel[2].add(basePanel[0]);
      basePanel[2].add(basePanel[1]);
      
      JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
      
      
      basePanel[3] = new JPanel(); //database 包府 菩澄
      basePanel[4] = new JPanel(); //network 包府  菩澄
      
      JButton btnDB = new JButton("DB_Button");
      basePanel[3].add(btnDB);
      
      tab.add("Pizza",basePanel[2]);
      tab.add("DataBase",basePanel[3]);
      tab.add("NetWork",basePanel[4]);
     
      
      
      this.add(tab);
      createMenu();
     
      this.setSize(400, 500);
      this.setVisible(true);
   }

	public void createMenu() {

		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("Pizza");
		mb.add(fileMenu);
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(menuList[i]);
			fileMenu.add(menuItem[i]);
			menuItem[i].addActionListener(mbl);
		}

		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pizza();
	}

}