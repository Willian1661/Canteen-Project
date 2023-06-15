package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.text.DecimalFormat;
import dbUtils.SelectRow;

public class StudentScreen extends Base {
	SelectRow slr = new SelectRow();
	JButton orderButton, statusButton;
	JTextField orderNumber, quantity;
	JComboBox<String> selectBox;
	String[] options;
	CanteenScreen cs = new CanteenScreen();
	int delay = 2000; // tempo de espera antes da 1ª execução da tarefa.
	int interval = 1000; // intervalo no qual a tarefa será executada.
	int severalTime = 8000; // tempo total
	boolean orderFlow = false;

	public StudentScreen(String student) {
		// JFrame
		super("Area do aluno", 550, 520);

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
		studentNameLabel.setBounds(330, 10, 100, 15);
		panel.add(studentNameLabel);

		JLabel studentNameContent = new JLabel(student);
		studentNameContent.setBounds(380, 10, 200, 15);
		panel.add(studentNameContent);

		JLabel nomeLojaLabel = new JLabel("Cantina:");
		nomeLojaLabel.setBounds(10, 0, 120, 35);
		panel.add(nomeLojaLabel);

		JLabel nomeLojaConteudo = new JLabel(bdCanteenName);
		nomeLojaConteudo.setBounds(120, 0, 200, 35);
		panel.add(nomeLojaConteudo);

		// Label para o bloco da loja
		JLabel blocoLojaLabel = new JLabel("Bloco:");
		blocoLojaLabel.setBounds(10, 40, 100, 35);
		panel.add(blocoLojaLabel);

		JLabel blocoLojaConteudo = new JLabel(bdCanteenBlock);
		blocoLojaConteudo.setBounds(120, 40, 200, 35);
		panel.add(blocoLojaConteudo);

		// Label para o menu da loja
		JLabel menuLojaLabel = new JLabel("Menu:");
		menuLojaLabel.setBounds(10, 80, 100, 35);
		panel.add(menuLojaLabel);

		// TextArea para guardar menu
		JTextArea menuLojaConteudo = new JTextArea();
		menuLojaConteudo.setBounds(10, 120, 260, 320);
		menuLojaConteudo.setEditable(false);

		int lengthMenu = 10;
		String menu = "";
		for (int i = 1; i <= lengthMenu; i++) {

			String menuRow = slr.selectRow(new String[] { "*", "menu_canteens", "ID", String.valueOf(i) });
			int start_menu_ID = 0, end_menu_ID = 0, start_menu_statement = 0, end_menu_statement = 0,
					start_price_statement = 0;

			// Name of the order
			start_menu_ID = menuRow.indexOf("D:") + 3;
			end_menu_ID = menuRow.indexOf("| C");

			// Name of the order
			start_menu_statement = menuRow.indexOf("e:") + 3;
			end_menu_statement = menuRow.indexOf("ue:") + 3;

			// Price of the order
			start_price_statement = menuRow.indexOf("ue: ") + 3;

			// Menu Item ID
			String bdCanteenMenuId = menuRow.substring(start_menu_ID, end_menu_ID);

			// Menu Item
			String bdCanteenMenu = menuRow.substring(start_menu_statement, end_menu_statement);

			// formatter the price
			String price = menuRow.substring(start_price_statement, menuRow.length() - 3);
			double amount = Double.parseDouble(price);
			DecimalFormat formatter = new DecimalFormat("#,##");

			// TextArea para guardar menu
			menu += "\n " + bdCanteenMenuId + ". " + bdCanteenMenu + " R$" + formatter.format(amount) + "\n";
		}

		menuLojaConteudo.setText(menu);
		panel.add(menuLojaConteudo);

		orderButton = new JButton("Fazer pedido");
		orderButton.setBounds(330, 230, 160, 25);
		orderButton.setForeground(Color.WHITE);
		orderButton.setBackground(Color.BLACK);

		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField orderNumber = new JTextField(5);
				JTextField quantity = new JTextField(5);

				JPanel orderPanel = new JPanel();

				// field
				orderPanel.add(new JLabel("Número do pedido:"));
				orderPanel.add(orderNumber);

				orderPanel.add(Box.createHorizontalStrut(15)); // a spacer

				// field
				orderPanel.add(new JLabel("Quantidade:"));
				orderPanel.add(quantity);

				// select box
				orderPanel.add(new JLabel("Forma de pagamento:"));
				options = new String[] { "dinheiro", "cartão", "PIX" };
				selectBox = new JComboBox<>(options);
				orderPanel.add(selectBox);

				int result = JOptionPane.showConfirmDialog(null, orderPanel, "preencha referente ao pedido desejado",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {

					cs.set_order_list_content(new String[] { student, orderNumber.getText(), quantity.getText(),
							selectBox.getSelectedItem().toString() });

					// this is alternative just for illustration,
					// because we need to store these information in BD
					// but unfortunately we don't have the enough time...
					new CanteenScreen("test");
					orderFlow = true;
				}
			};
		});
		panel.add(orderButton);

		statusButton = new JButton("Ver Status");
		statusButton.setBounds(330, 280, 160, 25);
		statusButton.setForeground(Color.WHITE);
		statusButton.setBackground(Color.BLACK);

		statusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (orderFlow) {
					JPanel statusPanel = new JPanel();

					// field
					JLabel msnLabel = new JLabel("Tempo estimado:");
					statusPanel.add(msnLabel);

					statusPanel.add(Box.createHorizontalStrut(5)); // a spacer

					JLabel timeLabel = new JLabel(String.valueOf(severalTime / 1000) + " min");
					statusPanel.add(timeLabel);

					// timer usado para contagem de minutos
					Timer timer = new Timer();
					timer.scheduleAtFixedRate(new TimerTask() {
						public void run() {

							severalTime -= interval;

							if (severalTime == 0) {
								timer.cancel();

								JOptionPane.showMessageDialog(new JPanel(), "Seu pedido está Pronto");

							}

						}
					}, delay, interval);

					JOptionPane.showConfirmDialog(null, statusPanel, "Pedido em andamento",
							JOptionPane.OK_CANCEL_OPTION);
				} else {
					JOptionPane.showMessageDialog(new JPanel(), "Realize seu pedido primeiro.");
				}

			};
		});

		panel.add(statusButton);

		this.setVisible(true);
	}
}
