package view;

import javax.swing.*;

public abstract class Base extends JFrame {
	public Base() {
	};

	public Base(String title, int width, int heigth) {
		this.setTitle(title);
		this.setSize(width, heigth);
		this.setLocationRelativeTo(null);
	}

}