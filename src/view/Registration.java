package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class Registration extends Base {

	public Registration() {
		super("cadastro de usuario",300,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new FlowLayout());

		JLabel nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 20, 80, 25);
		panel.add(nameLabel);

		JTextField nameText = new JTextField(20);
		nameText.setBounds(100, 20, 165, 25);
		panel.add(nameText);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(10, 50, 80, 25);
		panel.add(emailLabel);

		JTextField emailText = new JTextField(20);
		emailText.setBounds(100, 50, 165, 25);
		panel.add(emailText);

		JLabel passwordLabel = new JLabel("Senha:");
		passwordLabel.setBounds(10, 80, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 80, 165, 25);
		panel.add(passwordText);

		JButton registerButton = new JButton("Cadastrar");
		registerButton.setBounds(100, 120, 120, 25);
		panel.add(registerButton);

		this.setVisible(true);
	}
}