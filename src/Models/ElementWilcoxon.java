package Models;

import java.util.ArrayList;
import java.util.Collections;

public class ElementWilcoxon implements Comparable<ElementWilcoxon> {

	private int groupe;
	private double val;
	private int rangprov;
	private double rangdef;

	public static ArrayList<ElementWilcoxon> Elements = new ArrayList<ElementWilcoxon>();

	public ElementWilcoxon(int groupe, double val) {

		this.groupe = groupe;
		this.val = val;
		Elements.add(this);
	}

	public static void Rangprov(double[] el1, double[] el2) {

		for (int i = 0; i < el1.length; i++) {
			new ElementWilcoxon(1, el1[i]);
		}
		for (int i = 0; i < el2.length; i++) {
			new ElementWilcoxon(2, el2[i]);
		}

		Collections.sort(Elements);

		for (int i = 0; i < Elements.size(); i++) {
			Elements.get(i).setRangprov(i + 1);
		}

	}

	
	public static void Rangprdef(double[] el1, double[] el2) {
		Rangprov(el1, el2);
		ArrayList<ElementWilcoxon> ells = new ArrayList<ElementWilcoxon>();
		double sumderangProv = 0;
		for (int i = 1; i < Elements.size()+1; i++) {
			ells.add(Elements.get(i-1));
			sumderangProv += Elements.get(i-1).rangprov;
			
			
			if (i!=Elements.size() && Elements.get(i-1).equals(Elements.get(i))) {
				continue;
			} else {
				setRandefT(Elements.get(i-1), sumderangProv / ells.size());
				ells.clear();
				sumderangProv=0;
				
			}
		}
	}
	
	
	public static void setRandefT(ElementWilcoxon elselectioner, double rangdef) {

		for (ElementWilcoxon el : ElementWilcoxon.Elements) {

			if (el.equals(elselectioner)) {
				el.setRangdef(rangdef);
			}
		}
	}

	public String toString() {
		return "groupe : " + this.groupe + " val : " + this.val + " rangpov " + this.rangprov + " randef "
				+ this.rangdef + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ElementWilcoxon)) {
			return false;
		}
		ElementWilcoxon etat = (ElementWilcoxon) o;

		return val == etat.val;
	}

	@Override
	public int compareTo(ElementWilcoxon el) {

		if (this.getVal() > el.getVal()) {
			return 1;
		} else if (this.getVal() < el.getVal()) {
			return -1;
		} else {
			return 0;
		}
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public double getRangdef() {
		return rangdef;
	}

	public void setRangdef(double rangdef) {
		this.rangdef = rangdef;
	}

	public int getRangprov() {
		return rangprov;
	}

	public void setRangprov(int rangprov) {
		this.rangprov = rangprov;
	}

}
