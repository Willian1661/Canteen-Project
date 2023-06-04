package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import dbUtils.SelectRow;

public class StudentScreen extends Base {
	SelectRow slr = new SelectRow();
	JButton addItem;

	public StudentScreen(String student) {
		super("Area do aluno", 400, 300);
// get the block and the of of canteen
		String canteenRow = slr.selectRow(new String[] { "*", "canteens", "ID", "1" });
		int start_name_statement = 0, end_name_statement = 0, start_block_statement = 0;

		start_name_statement = canteenRow.indexOf("e:") + 3;
		end_name_statement = canteenRow.indexOf(" | R");

		start_block_statement = canteenRow.indexOf("k: ") + 3;

		String bdCanteenName = canteenRow.substring(start_name_statement, end_name_statement);
		String bdCanteenBlock = canteenRow.substring(start_block_statement, canteenRow.length() - 3);
// get the block and the of of canteen

		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel studentNameLabel = new JLabel("Aluno:");
		studentNameLabel.setBounds(10, 0, 100, 15);
		panel.add(studentNameLabel);

		JLabel studentNameContent = new JLabel(student);
		studentNameContent.setBounds(120, 2, 200, 15);
		panel.add(studentNameContent);

		JLabel nomeLojaLabel = new JLabel("Cantina:");
		nomeLojaLabel.setBounds(10, 20, 120, 35);
		panel.add(nomeLojaLabel);

		JLabel nomeLojaConteudo = new JLabel(bdCanteenName);
		nomeLojaConteudo.setBounds(120, 20, 200, 35);
		panel.add(nomeLojaConteudo);

		// Label para o bloco da loja
		JLabel blocoLojaLabel = new JLabel("Bloco:");
		blocoLojaLabel.setBounds(10, 50, 100, 35);
		panel.add(blocoLojaLabel);

		JLabel blocoLojaConteudo = new JLabel(bdCanteenBlock);
		blocoLojaConteudo.setBounds(120, 50, 200, 35);
		panel.add(blocoLojaConteudo);
		
		// Label para o menu da loja
		JLabel menuLojaLabel = new JLabel("Menu:");
		menuLojaLabel.setBounds(10, 80, 100, 35);
		panel.add(menuLojaLabel);

		// area para pegar items do menu
		// TextArea para guardar menu
		JTextArea menuLojaConteudo = new JTextArea();
		menuLojaConteudo.setBounds(120, 80, 250, 160);
		menuLojaConteudo.setEditable(false);
		
		int lengthMenu = 10;
		String menu = "";
		for (int i = 1; i <= lengthMenu; i++) {

			String menuRow = slr.selectRow(new String[] { "*", "menu_canteens", "ID", String.valueOf(i) });
			int start_menu_statement = 0, end_menu_statement = 0, start_price_statement = 0;

			start_menu_statement = menuRow.indexOf("e:") + 3;
			end_menu_statement = menuRow.indexOf("ue:") + 3;
			start_price_statement = menuRow.indexOf("ue: ") + 3;

			String bdCanteenMenu = menuRow.substring(start_menu_statement, end_menu_statement);
			// formatter the price
			String number = menuRow.substring(start_price_statement, menuRow.length() - 3);
			double amount = Double.parseDouble(number);
			DecimalFormat formatter = new DecimalFormat("#,##");
			// formatter the price

			// area para pegar items do menu
			// TextArea para guardar menu
			menu += bdCanteenMenu + " R$" + formatter.format(amount)+"\n";
		}
		menuLojaConteudo.setText(menu);
		panel.add(menuLojaConteudo);
		this.setVisible(true);
		String order = JOptionPane.showInputDialog("informe seu pedido");
		System.out.println(order);
	}
}
