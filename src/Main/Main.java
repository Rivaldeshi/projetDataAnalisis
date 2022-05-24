package Main;
import Models.Wilcoxon;
import View.MainView;

public class Main {

	public static void main(String[] args) {
		
		// pour faire en console tu recuperer seulement les donner si comme sa 
		//puis tu construit un objet de type man wilcoxone avec; dans l'objet construit tu aura tout les donner de wilcoxonne
        // le code etait bien dure
		double[] els1 = {1.5,0.9,1.5,0.8,1.3,1.2,0.7,1.1};
		double[] els2 = {1.1,1.4,1.5,1.2,0.9,0.6,0.7,1};

		Wilcoxon wil = new Wilcoxon(els1, els2);
		
		System.out.println(wil);
		MainView fen= new MainView();
		fen.pack();
		fen.setVisible(true);
	
	}
}
