package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import SwingComponent.Frame;
import SwingComponent.Panel;
import SwingComponent.TitreButton;
import Utils.ValidationException;

@SuppressWarnings("serial")
public class Menu extends Panel {

	public static TitreButton wilcoxon = new TitreButton("Test Wilcoxon");
	public static TitreButton Automates = new TitreButton("Fisher ");
	public static TitreButton TableDeTransistion = new TitreButton("1 WAY ANOVA");
	public static TitreButton Legende = new TitreButton("2 WAY ANOVA");
	public static TitreButton propos = new TitreButton("A propos");

	Menu(String m) {
		unsetfocus();
		wilcoxon.focus();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(50, 500));
		this.add(Box.createVerticalGlue());
		this.add(wilcoxon);
		this.add(Box.createVerticalGlue());
		this.add(Automates);
		this.add(Box.createVerticalGlue());
		this.add(TableDeTransistion);
		this.add(Box.createVerticalGlue());
		this.add(Legende);
		this.add(Box.createVerticalGlue());
		this.add(propos);
		this.add(Box.createVerticalGlue());
		
		wilcoxon.addActionListener(action);
		Automates.addActionListener(action);
		TableDeTransistion.addActionListener(action);
		Legende.addActionListener(action);
		propos.addActionListener(action);
	}

	public void bon() {
		Automates.setEnabled(true);
		TableDeTransistion.setEnabled(true);
	}

	public static void unsetfocus() {
		wilcoxon.setBackground(Color.white);
		Automates.setBackground(Color.white);
		TableDeTransistion.setBackground(Color.white);
		Legende.setBackground(Color.white);
		propos.setBackground(Color.white);
		
		wilcoxon.setForeground(Color.black);
		Automates.setForeground(Color.black);
		TableDeTransistion.setForeground(Color.black);
		Legende.setForeground(Color.black);
		propos.setForeground(Color.black);

	}

	public static ActionListener action = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			unsetfocus();
			if (e.getSource() == wilcoxon) {
				Frame.splitPane.setRightComponent(new WilcoxonView());
				wilcoxon.focus();
			} else

			if (e.getSource() == Automates) {

				Frame.splitPane.setRightComponent(new Panel("FISHER"));
				Automates.focus();
			} else

			if (e.getSource() == TableDeTransistion) {
				Frame.splitPane.setRightComponent(new Panel("ONE WAY ANOVA"));
				TableDeTransistion.focus();
			} else

			if (e.getSource() == Legende) {
				Legende.focus();
				Frame.splitPane.setRightComponent(new Panel("TOW WAY ANOVA"));
			}
			if (e.getSource() == propos) {
				propos.setBackground(Color.BLACK);
				propos.setForeground(Color.white);
				Frame.splitPane.setRightComponent(new Propos());
			}
		}

	};

}
