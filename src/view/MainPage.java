package view;

import java.sql.*;
import javax.swing.*;
import view.*;
import dbUtils.SelectRow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import security.SecureHash;

public class MainPage extends Base {
	SelectRow slr = new SelectRow();
	SecureHash sh = new SecureHash();
	private static JLabel password1, label;
	private static JTextField registration;
	private static JButton loginButton, registrationButton;
	private static JPasswordField Password;
	int start_statement = 0, end_statement = 0;

	public MainPage() {
		super("WELCOME!", 300, 150);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new FlowLayout());

		label = new JLabel("Registration");
		panel.add(label);

		registration = new JTextField(15);
		panel.add(registration);

		password1 = new JLabel("Password");
		panel.add(password1);

		Password = new JPasswordField(15);
		panel.add(Password);

		loginButton = new JButton("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Registration = registration.getText();
				String PasswordField = sh.secureHash(Password.getText());
				String userRow = "";
				int start_name_statement = 0, end_name_statement= 0;

				if (Registration.contains("@cantina")) {
					userRow = slr.selectRow(new String[] { "*", "canteens", "Registration", Registration });
					start_statement = userRow.indexOf("on:") + 4;
					end_statement = userRow.indexOf(" | P");
					start_name_statement = userRow.indexOf("e:") + 3;
					end_name_statement = userRow.indexOf(" | R");
				} else {
					userRow = slr.selectRow(new String[] { "*", "users", "Registration", Registration });
					start_statement = userRow.indexOf("on:") + 4;
					end_statement = userRow.indexOf(" | P");
					start_name_statement = userRow.indexOf("e:") + 3;
					end_name_statement = userRow.indexOf(" | C");
				}



				int pass_word_index = userRow.indexOf("d: ") + 3;

				String bdUserName = userRow.substring(start_name_statement, end_name_statement);
				
				String bdUserResgistration = userRow.substring(start_statement, end_statement);
				String bdUserContact = userRow.substring(start_statement, end_statement);
				String bdPassWord = userRow.substring(pass_word_index, userRow.length() - 3);

				if (Registration.equals(bdUserContact) || Registration.equals(bdUserResgistration) && PasswordField.equals(bdPassWord)) {
					
					JOptionPane.showMessageDialog(null, "Login Successful");
					
					if (Registration.contains("@cantina")) 
						new CanteenScreen(bdUserName);
					else 
						new StudentScreen(bdUserName+"  "+bdUserResgistration);
					
				} else {
					JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
				}
			};
		});

		registrationButton = new JButton("Cadastro");
		registrationButton.setForeground(Color.WHITE);
		registrationButton.setBackground(Color.BLACK);

		registrationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Registration();
			};
		});

		panel.add(loginButton);
		panel.add(registrationButton);
		this.setVisible(true);
	}

}
