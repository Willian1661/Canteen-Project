package view;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import dbUtils.SelectRow;

public class CanteenScreen extends Base {

	public CanteenScreen(String table) {
		super("Painel cantina", 400, 300);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(null);

		// Label para o pedido feito
		JLabel mensagemLabel = new JLabel("solicitação de pedido:");
		mensagemLabel.setBounds(10, 0, 200, 25);
		panel.add(mensagemLabel);
		
		JLabel pedidoLabel = new JLabel("Pedido:");
		pedidoLabel.setBounds(10, 20, 80, 25);
		panel.add(pedidoLabel);

		JLabel pedidoConteudo = new JLabel("misto quente");
		pedidoConteudo.setBounds(100, 20, 200, 25);
		panel.add(pedidoConteudo);

		// Label para o usuário que fez o pedido
		JLabel usuarioLabel = new JLabel("Usuário:");
		usuarioLabel.setBounds(10, 50, 80, 25);
		panel.add(usuarioLabel);

		JLabel usuarioConteudo = new JLabel("William");
		usuarioConteudo.setBounds(100, 50, 200, 25);
		panel.add(usuarioConteudo);

		// Label para o número do pedido
		JLabel numeroPedidoLabel = new JLabel("Número do Pedido:");
		numeroPedidoLabel.setBounds(10, 80, 150, 25);
		panel.add(numeroPedidoLabel);

		JLabel numeroPedidoConteudo = new JLabel("1");
		numeroPedidoConteudo.setBounds(160, 80, 80, 25);
		panel.add(numeroPedidoConteudo);
		
		JLabel pagamentoPedidoLabel = new JLabel("forma de pagamento:");
		pagamentoPedidoLabel.setBounds(10, 110, 200, 25);
		panel.add(pagamentoPedidoLabel);

		JLabel pagamentoPedidoConteudo = new JLabel("dinheiro");
		pagamentoPedidoConteudo.setBounds(180, 110, 80, 25);
		panel.add(pagamentoPedidoConteudo);

		this.setVisible(true);
	}

}