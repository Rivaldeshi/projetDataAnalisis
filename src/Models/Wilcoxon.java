package Models;

import Utils.TableWilcoxon;

public class Wilcoxon {

	private double RangA;
	private double RangB;

	private double MoyenneA;
	private double MoyenneB;
	private double Uobs;

	private double TailleA;
	private double TailleB;
	private double UCritique;
	private  boolean bon;

	public double Seuil = 0.05;

	public Wilcoxon(double[] el1, double[] el2) {

		TailleA = el1.length;
		TailleB = el2.length;
		RangA = RangA(el1, el2);
		RangB = RangB(el1, el2);
		MoyenneA = RangA - el1.length * (el1.length + 1) / 2;
		MoyenneB = RangB - el2.length * (el2.length + 1) / 2;
		Uobs = Math.min(MoyenneA, MoyenneB);
		UCritique = TableWilcoxon.Table[el1.length-3][0][el2.length-3];
        setBon(UCritique < Uobs);
	}

	
	public Wilcoxon(double[] el1, double[] el2, double seuil) {
		this(el1, el2);
		this.Seuil=seuil;
	}
	
	public String toString() {
		return "\n RangA : "+this.RangA+ " \nRangB : "+this.RangB +"\n MoyenneA : " + this.MoyenneA + "\n MoyenneB : " + this.MoyenneB + "\n Ubos : " + this.Uobs+"\n Seuil : "+this.Seuil +"\n INRH0 :[0, "+this.UCritique+"]";
	}

	public double RangA(double[] el1, double[] el2) {
		ElementWilcoxon.Elements.clear();
		ElementWilcoxon.Rangprdef(el1, el2);
		double sum = 0;
		for (ElementWilcoxon el : ElementWilcoxon.Elements) {
			if (el.getGroupe() == 1) {
				sum += el.getRangdef();
			}
		}
		return sum;
	}

	public double RangB(double[] el1, double[] el2) {
		ElementWilcoxon.Elements.clear();
		ElementWilcoxon.Rangprdef(el1, el2);
		double sum = 0;
		for (ElementWilcoxon el : ElementWilcoxon.Elements) {
			if (el.getGroupe() == 2) {
				sum += el.getRangdef();
			}
		}
		return sum;
	}

	public double getRangA() {
		return RangA;
	}

	public void setRangA(double rangA) {
		RangA = rangA;
	}

	public double getRangB() {
		return RangB;
	}

	public void setRangB(double rangB) {
		RangB = rangB;
	}

	public double getMoyenneA() {
		return MoyenneA;
	}

	public void setMoyenneA(double moyenneA) {
		MoyenneA = moyenneA;
	}

	public double getMoyenneB() {
		return MoyenneB;
	}

	public void setMoyenneB(double moyenneB) {
		MoyenneB = moyenneB;
	}

	public double getUobs() {
		return Uobs;
	}

	public void setUobs(double uobs) {
		Uobs = uobs;
	}

	public double getTailleA() {
		return TailleA;
	}

	public void setTailleA(double tailleA) {
		TailleA = tailleA;
	}

	public double getTailleB() {
		return TailleB;
	}

	public void setTailleB(double tailleB) {
		TailleB = tailleB;
	}


	public double getUCritique() {
		return UCritique;
	}


	public void setUCritique(double uCritique) {
		UCritique = uCritique;
	}


	public boolean isBon() {
		return bon;
	}


	public void setBon(boolean bon) {
		this.bon = bon;
	}

}
