package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Utils.ValidationException;
import SwingComponent.Header;
import SwingComponent.Panel;
import SwingComponent.TitreButton;

@SuppressWarnings("serial")
public class TableView extends Panel {

	public static Panel menu = new Panel();

	public static TitreButton AFN = new TitreButton("AFN");
	public static TitreButton AFDI = new TitreButton("AFD");
	public static TitreButton MINISER = new TitreButton("MINISER");
	public static TitreButton AFDC = new TitreButton("AFD Complet");
	public static TitreButton AFDComple = new TitreButton("AFD Bar");

	Panel footer = new Panel();

	TableView() throws ValidationException {

		super();
		unsetfocus();
		AFN.focus();
		footer.add(new Panel("Automate Non deterministe"));
		List<TitreButton> heads = new ArrayList<TitreButton>();
		heads.add(AFN);
		heads.add(AFDI);
		heads.add(MINISER);
		heads.add(AFDC);
		heads.add(AFDComple);
		Header header = new Header(heads);
		this.add(header);
		this.add(footer);

		ActionListener acc = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unsetfocus();

				if (e.getSource() == AFN) {
					footer.removeAll();
					AFN.focus();
					footer.add(new Panel("Automate Non deterministe"));
					footer.revalidate();
				} else if (e.getSource() == AFDI) {
					footer.removeAll();
					AFDI.focus();
					footer.add(new Panel());
					footer.revalidate();
				} else if (e.getSource() == AFDC) {
					footer.removeAll();
					AFDC.focus();
					footer.add(new Panel("AFDC"));
					footer.revalidate();
				} else if (e.getSource() == MINISER) {
					footer.removeAll();
					footer.add(new Panel());
					MINISER.focus();
					footer.revalidate();
				}
			}

		};

		for (TitreButton btn : heads) {
			btn.addActionListener(acc);
		}

	}

	public static void unsetfocus() {
		AFN.setBackground(Color.white);
		AFDI.setBackground(Color.white);
		AFDC.setBackground(Color.white);
		MINISER.setBackground(Color.white);
		AFDComple.setBackground(Color.white);

		AFN.setForeground(Color.black);
		AFDI.setForeground(Color.black);
		AFDC.setForeground(Color.black);
		MINISER.setForeground(Color.black);
		AFDComple.setForeground(Color.black);
	}

}
