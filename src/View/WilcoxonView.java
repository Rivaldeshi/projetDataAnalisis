package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ElementWilcoxon;
import Models.Wilcoxon;
import SwingComponent.Button;
import SwingComponent.Label;
import SwingComponent.Panel;
import SwingComponent.Text;
import Utils.Constans;

@SuppressWarnings("serial")
public class WilcoxonView extends Panel {

	//l'element de wicoxone
	public Wilcoxon wil;
	
	//Deisinateur de table 
	public DrawTableWilcoxon draw;
	
	// la veu de wilcoxone
	WilcoxonView() {
		
		super("Test de probabilliter de wilcolxon");

		this.setBackground(Color.white);
		
		//Panel des taille de nombre
		Panel pNombreElem = new Panel();
		
		Label lnb1 = new Label("Nombre element de 1");
		Label lnb2 = new Label("Nombre element de 2");
		Label erreur = new Label("");
		erreur.setForeground(Color.red);
		
        // les bouton
		Button valider = new Button("Valider");
		Button Calculer = new Button("Calculer");

		Text nb1 = new Text(0);
		Text nb2 = new Text(0);
       // ajout des elements
		pNombreElem.add(lnb1);
		pNombreElem.add(nb1);
		pNombreElem.add(lnb2);
		pNombreElem.add(nb2);
		pNombreElem.add(valider);
		pNombreElem.add(Calculer);
		pNombreElem.add(erreur);
		pNombreElem.setBackground(Color.white);
		pNombreElem.setLayout(new FlowLayout());
		pNombreElem.setPreferredSize(new Dimension(Constans.framewidh, 50));

		
		// notre grant conteneur
		Panel p = new Panel();
		p.setBackground(Color.white);

		//Conteneur des tableau 
		Panel p1 = new Panel();
		
		p1.add(pNombreElem);
		p1.setBackground(Color.white);

		// le tableau a entrer les elements
		Panel pEntrer = new Panel();
		pEntrer.setPreferredSize(new Dimension(Constans.framewidh, 100));
		p1.add(pEntrer);
		
		// le tableau avec les rnag calculer
		Panel pSortir = new Panel();
		pSortir.setPreferredSize(new Dimension(Constans.framewidh, 150));

		//ajout au panel des tableau
		p1.add(pSortir);
		p1.setPreferredSize(new Dimension(Constans.framewidh, 230));

		//Panel des Resultat
		Panel pResulta = new Panel();

		pResulta.setPreferredSize(new Dimension(Constans.framewidh - 100, 250));
		p.add(p1);
		p.add(pResulta);
		
        // les action de calculer et Valider
		Calculer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				double[] els1 = new double[draw.a];
				double[] els2 = new double[draw.b];
				try {

					for (int i = 0; i < draw.a; i++) {
						els1[i] = Float.parseFloat(draw.tab[0][i].getText());
					}

					for (int i = 0; i < draw.b; i++) {
						els2[i] = Float.parseFloat(draw.tab[1][i].getText());
					}
					wil = new Wilcoxon(els1, els2);

					pSortir.removeAll();
					pSortir.add(DrawTableWilcoxon.Draw(ElementWilcoxon.Elements));
					pSortir.repaint();
					pSortir.revalidate();
					pResulta.removeAll();
					pResulta.add(resulta());
					pResulta.repaint();
					pResulta.revalidate();

					erreur.setText("");
				} catch (Exception e1) {
					erreur.setText("Erreur de saisie");
				}

			}

		});

		valider.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(nb1.getText());
					int b = Integer.parseInt(nb2.getText());
					draw = new DrawTableWilcoxon(a, b);
					pEntrer.removeAll();
					pEntrer.add(draw);
					pEntrer.repaint();
					pEntrer.revalidate();

					erreur.setText("");
				} catch (Exception e1) {
					erreur.setText("Erreur de saisie");
				}

			}

		});

		this.add(p);
	}

	public Panel Sorti() {
		Panel pSortir = new Panel();
		pSortir.setPreferredSize(new Dimension(Constans.framewidh, 150));
		pSortir.setBackground(Color.white);
		pSortir.add(DrawTableWilcoxon.Draw(ElementWilcoxon.Elements));
		return pSortir;
	}

	public Panel Entrer(DrawTableWilcoxon DrawTable) {

		Panel pEntrer = new Panel();
		pEntrer.setPreferredSize(new Dimension(Constans.framewidh, 100));

		pEntrer.add(DrawTable);
		return pEntrer;
	}

	public Panel resulta() {

		Panel pResulta = new Panel("Recapitulatif");
		pResulta.setPreferredSize(new Dimension(Constans.framewidh - 100, 250));
		pResulta.setBackground(Color.white);

		Panel hypothese = new Panel("Hypothese", 0.0);
		Panel loie = new Panel("Loie", 0.0);
		Panel valeur = new Panel("Valeur de test", 0.0);
		Panel Pointcritique = new Panel("Point critique", 0.0);
		Panel decision = new Panel("Decision", 0.0);

		hypothese.add(new Label("H0: U1 = U2"));
		hypothese.add(new Label("H1: U1 <> U2"));

		loie.add(new Label(
				"<html>comme on compare les moyene et le test non parramerique on utlise le test du rang de  WILCOXON MAN-WITHNEY</html>"));

		valeur.add(new Label("Rang A = " + wil.getRangA()));
		valeur.add(new Label("Rang B = " + wil.getRangB()));
		valeur.add(new Label("Moyenne A = " + wil.getMoyenneA()));
		valeur.add(new Label("Moyenne B = " + wil.getMoyenneB()));
		valeur.add(new Label("Uobs =  " + wil.getUobs()));

		if (wil.isBon()) {
			decision.add(new Label("<html>Hypothese H0 accepter : a " + wil.Seuil * 100
					+ "% de seuil de siginification les moyennes sont egaux</html>"));
		} else {
			decision.add(new Label("<html>Hypothese H0 rejeter : au risque de se tromper de  " + wil.Seuil * 100
					+ "%  les moyennes ne sont pas sont egaux </html>"));
		}

		Pointcritique.add(new Label("Ucritique = " + wil.getUCritique()));
		Pointcritique.add(new Label("IRH0 = [0 ," + wil.getUCritique() + "]"));
		Panel res = new Panel();
		res.setLayout(new FlowLayout());
		res.add(hypothese);
		res.add(loie);
		res.add(valeur);
		res.add(Pointcritique);
		res.add(decision);

		pResulta.add(res);

		return pResulta;
	}

}
