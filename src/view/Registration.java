package view;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends Base {
	private static String palavra = "";

	public static String getPalavra() {
		return Registration.palavra;
	}

	public static void setPalavra(String palavra) {
		Registration.palavra = palavra;
	}

	public Registration() {
		super("WELCOME!", 400, 400);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel section = (JPanel) this.getContentPane();
		section.setLayout(new FlowLayout());

		JButton btn1 = new JButton("Informar palavra");
		JButton btn2 = new JButton("Adivinhar");

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String valor = JOptionPane.showInputDialog("Informe a palavra");
				setPalavra(valor);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("new window!");
			}
		});

		section.add(btn1);
		section.add(btn2);

		this.setVisible(true);
	}

}
