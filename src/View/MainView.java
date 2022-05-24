package View;

import SwingComponent.Frame;

@SuppressWarnings("serial")
public class MainView extends Frame {

	public static Menu menu = new Menu("hello");

	public static WilcoxonView wil = new WilcoxonView();

	public MainView() {
		super(wil, menu);

	}
}
