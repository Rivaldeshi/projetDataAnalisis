package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Models.ElementWilcoxon;
import SwingComponent.Panel;
import SwingComponent.Text;
import Utils.Constans;

@SuppressWarnings("serial")
public class DrawTableWilcoxon extends Panel {

	public static ArrayList<Text> mts = new ArrayList<>();
	Text[][] tab;
	public int a;
	public int b;

	DrawTableWilcoxon(int a, int b) {
		tab = new Text[2][Math.max(a, b)];
		this.a = a;
		this.b = b;
		this.setPreferredSize(new Dimension(Constans.framewidh - 100, 100));
		this.setLayout(new GridLayout(2, Math.max(a, b), 10, 10));
		Text l1 = new Text("G1");
		Text l2 = new Text("G1");

		l1.setFont(new Font("serif", Font.ITALIC, 20));
		l2.setFont(new Font("serif", Font.ITALIC, 20));
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l1.setEditable(false);
		l2.setEditable(false);

		this.add(l1);
		for (int j = 0; j < Math.max(a, b); j++) {
			Text cellule = new Text(0);
			this.add(cellule);
			if (j >= a) {
				cellule.setEditable(false);
				cellule.setBackground(Color.gray);
			}
			tab[0][j] = cellule;
		}
		this.add(l2);

		for (int j = 0; j < Math.max(a, b); j++) {
			Text cellule = new Text(0);
			this.add(cellule);
			if (j >= b) {
				cellule.setEditable(false);
				cellule.setBackground(Color.gray);
			}
			tab[1][j] = cellule;
		}

		this.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
	}

	public static Panel Draw(ArrayList<ElementWilcoxon> Elements) {
		Panel pan = new Panel();
		Object[][] data = Tableaux(Elements);

		String[] columnNames = new String[Elements.size() + 1];
		for (int i = 0; i < Elements.size() + 1; i++) {
			columnNames[i] = "";
		}

		JTable table = new JTable(data, columnNames);

		table.setTableHeader(null);

		table.setRowHeight(40);
		table.setSelectionBackground(Color.white);
		table.setSelectionForeground(Color.black);
		table.setEnabled(false);
		table.setFont(new Font("serif", Font.ITALIC, 20));

		table.setOpaque(false);
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBorder(null);
		sp.getViewport().setBackground(Color.white);
		pan.add(sp);
		pan.setBackground(Color.white);
		pan.setPreferredSize(new Dimension(Constans.framewidh, 130));

		return pan;
	}

	public static Object[][] Tableaux(ArrayList<ElementWilcoxon> Elements) {

		Object[][] data = new Object[3][Elements.size() + 1];

		data[0][0] = "Element";
		data[1][0] = "Rang Prov";
		data[2][0] = "Rang def";
		for (int i = 0; i < Elements.size(); i++) {
			data[0][i + 1] = Elements.get(i).getVal();
			data[1][i + 1] = Elements.get(i).getRangprov();
			data[2][i + 1] = Elements.get(i).getRangdef();
		}

		return data;
	}

}
