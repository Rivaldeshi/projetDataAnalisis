package SwingComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import Utils.Constans;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	public static JSplitPane splitPane;
	Titre titre;

	public Panel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(Constans.framewidh,
				Constans.framehight));
	}

	public Panel(String s) {
		this();
		titre = new Titre("<html>"+s+"</html>", 30);
		titre.setBackground(Color.BLUE);
		titre.setForeground(Color.WHITE);
		titre.setOpaque(true);
		this.add(titre);
		this.add(Box.createRigidArea(new Dimension(20, 20)));
	}

	public Panel(String s, int size) {
		this();
		titre = new Titre(s, size);
		titre.setOpaque(true);
		titre.setBackground(Color.BLACK);
		titre.setForeground(Color.white);
		this.add(titre);
		this.setBackground(Color.white);
	}

	public Panel(String s, boolean a) {
		this();
		titre = new Titre("<html>"+s+"</html>", 30);
		titre.setBackground(Color.ORANGE);
		titre.setOpaque(true);
		this.add(titre);
	}

	public Panel(JLabel l, JButton b) {
		super();
		this.setBackground(Color.black);
		this.setLayout(new FlowLayout(200));
		l.setForeground(Color.white);
		this.add(l);
		this.add(b);
	}
	
	public Panel(JScrollPane graph, Label l) {
		super();
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout(300));
		this.setFont(new Font("serif", Font.ITALIC, 30));
		l.setForeground(Color.BLUE);
		this.add(new Label("         "));
		this.add(graph);
		this.add(l);
	}

	public Panel(String s, String s1) {
		this();
		titre = new Titre(s, 30);
		titre.setBackground(Color.cyan);
		titre.setOpaque(true);
		this.add(titre);
	}
	
	public Panel(String s, double a) {
		this();
		titre = new Titre("<html>"+s+"</html>", 30);
		titre.setBackground(Color.cyan);
		titre.setForeground(Color.black);
		titre.setOpaque(true);
		this.add(titre);
		this.add(Box.createRigidArea(new Dimension(20, 20)));
		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(Constans.framewidh/6,Constans.framehight));

	}

	public Panel(JLabel l, Text t) {
		this.setBackground(Color.black);
		this.setLayout(new FlowLayout());
		l.setForeground(Color.white);
		this.add(l);
		this.add(t);
	}

	public Panel(JPanel panel1, JPanel panel2) {
		this();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel2);
		splitPane.setResizeWeight(1);
		splitPane.setRightComponent(panel1);
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.15);
		this.add(splitPane);
	}
}
