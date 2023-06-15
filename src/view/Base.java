package view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.*;

public abstract class Base extends JFrame {
	public Base() {};

	public Base(String title, int width, int heigth) {
		this.setTitle(title);
		this.setLocation(new Point(width, heigth));
		this.setSize(new Dimension(width, heigth));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	};

}