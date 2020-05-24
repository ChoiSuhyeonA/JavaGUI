import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {
	
	String header[] = { "이름", "전화번호", "나이" };
	public DefaultTableModel model = new DefaultTableModel(header, 0);
	public JTable table = new JTable(model);

	public TablePanel() {
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
	}
}
