package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

public class CanteenScreen extends Base {
	public static String[] orderList = { "-", "-", "-", "-" };

	public CanteenScreen() {
		super("NULL", 0, 0);
		this.setVisible(false);
	};

	public void set_order_list_content(String[] str) {
		orderList = new String[] { str[0], str[1], str[2], str[3] };
	}

	public CanteenScreen(String table) {
		super("Area da cantina", 400, 300);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(null);

		// Label para o pedido feito
		JLabel mensagemLabel = new JLabel("solicitação de pedido:");
		mensagemLabel.setBounds(120, 0, 200, 25);
		panel.add(mensagemLabel);

		// Label para o usuário que fez o pedido
		JLabel usuarioLabel = new JLabel("Usuário:");
		usuarioLabel.setBounds(10, 30, 80, 25);
		panel.add(usuarioLabel);

		JLabel usuarioConteudo = new JLabel((orderList[0] == "-") ? "vazio" : orderList[0]);
		usuarioConteudo.setBounds(80, 30, 200, 25);
		panel.add(usuarioConteudo);

		// Label para o número do pedido
		JLabel numeroPedidoLabel = new JLabel("Número do Pedido:");
		numeroPedidoLabel.setBounds(10, 70, 150, 25);
		panel.add(numeroPedidoLabel);

		JLabel numeroPedidoConteudo = new JLabel((orderList[1] == "-") ? "vazio" : orderList[1]);
		numeroPedidoConteudo.setBounds(150, 70, 80, 25);
		panel.add(numeroPedidoConteudo);

		JLabel quantidadePedidoLabel = new JLabel("Quantidades:");
		quantidadePedidoLabel.setBounds(10, 110, 200, 25);
		panel.add(quantidadePedidoLabel);

		JLabel quantidadePedidoConteudo = new JLabel((orderList[2] == "-") ? "vazio" : orderList[2]);
		quantidadePedidoConteudo.setBounds(120, 110, 200, 25);
		panel.add(quantidadePedidoConteudo);

		JLabel pagamentoPedidoLabel = new JLabel("forma de pagamento:");
		pagamentoPedidoLabel.setBounds(10, 150, 200, 25);
		panel.add(pagamentoPedidoLabel);

		JLabel pagamentoPedidoConteudo = new JLabel((orderList[3] == "-") ? "vazio" : orderList[3]);
		pagamentoPedidoConteudo.setBounds(170, 150, 200, 25);
		panel.add(pagamentoPedidoConteudo);

		JButton lastOrder = new JButton("Ultimos pedidos");
		lastOrder.setBounds(10, 190, 160, 25);
		lastOrder.setForeground(Color.WHITE);
		lastOrder.setBackground(Color.BLACK);

		// frame for the order's list
		JFrame lastOrdersFrame = new JFrame();
		lastOrdersFrame.setTitle("Ùltimos Pedidos");
		lastOrdersFrame.setLocation(new Point(650, 300));
		lastOrdersFrame.setSize(new Dimension(1000, 200));
		lastOrdersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// action event for the order list's button
		lastOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// panel for the order list's content
				JPanel lastOrdersLabel = new JPanel();
				lastOrdersFrame.add(lastOrdersLabel);
				
				//it will check if has any order done
				if (orderList[0] == "-" || orderList[1] == "-" || orderList[2] == "-" || orderList[3] == "-") {
					JLabel orderVazioLabel = new JLabel("Não houve pedidos...");
					orderVazioLabel.setBounds(10, 300, 80, 25);
					lastOrdersFrame.setSize(new Dimension(400, 100));
					lastOrdersLabel.add(orderVazioLabel);
				} else {

					// field
					JLabel orderUsuarioLabel = new JLabel("Usuário:");
					orderUsuarioLabel.setBounds(10, 300, 80, 25);
					lastOrdersLabel.add(orderUsuarioLabel);

					JLabel orderUsuarioConteudo = new JLabel(orderList[0]);
					orderUsuarioConteudo.setBounds(80, 30, 200, 25);
					lastOrdersLabel.add(orderUsuarioConteudo);

					lastOrdersLabel.add(Box.createHorizontalStrut(15)); // a spacer

					// Label para o número do pedido
					JLabel orderNumeroPedidoLabel = new JLabel("Número do Pedido:");
					orderNumeroPedidoLabel.setBounds(10, 70, 150, 25);
					lastOrdersLabel.add(orderNumeroPedidoLabel);

					JLabel orderNumeroPedidoConteudo = new JLabel(orderList[1]);
					orderNumeroPedidoConteudo.setBounds(150, 70, 80, 25);
					lastOrdersLabel.add(orderNumeroPedidoConteudo);

					lastOrdersLabel.add(Box.createHorizontalStrut(15)); // a spacer

					JLabel orderQuantidadePedidoLabel = new JLabel("Quantidades:");
					orderQuantidadePedidoLabel.setBounds(10, 110, 200, 25);
					lastOrdersLabel.add(orderQuantidadePedidoLabel);

					JLabel orderQuantidadePedidoConteudo = new JLabel(orderList[2]);
					orderQuantidadePedidoConteudo.setBounds(120, 110, 200, 25);
					lastOrdersLabel.add(orderQuantidadePedidoConteudo);

					lastOrdersLabel.add(Box.createHorizontalStrut(15)); // a spacer

					JLabel orderPagamentoPedidoLabel = new JLabel("forma de pagamento:");
					orderPagamentoPedidoLabel.setBounds(10, 150, 200, 25);
					lastOrdersLabel.add(orderPagamentoPedidoLabel);

					JLabel orderPagamentoPedidoConteudo = new JLabel(orderList[3]);
					orderPagamentoPedidoConteudo.setBounds(170, 150, 200, 25);
					lastOrdersLabel.add(orderPagamentoPedidoConteudo);
				}
				lastOrdersFrame.setVisible(true);
			}
		});
		panel.add(lastOrder);

		this.setVisible(true);
	};

}