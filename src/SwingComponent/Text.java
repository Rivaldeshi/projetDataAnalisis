package SwingComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Text extends JTextField {


	public Text() {
		super();
		this.setForeground(Color.black);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setFont(new Font("serif", Font.ITALIC, 20));
		this.setBackground(Color.white);
	}

	public Text(int a) {
		this();
		this.setPreferredSize(new Dimension(60, 40));
	}
	
	public Text(String a) {
		this();
		this.setText(a);
	}

}
