package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton;
	
	public LoginPanel(){
		this.setSize(Login.width, Login.height);
		this.setLayout(new GridLayout(3, 2));
		
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		username = new JTextField();
		password = new JPasswordField(20);
		loginButton = new JButton("Login");
		
		this.add(usernameLabel);
		this.add(username);
		this.add(passwordLabel);
		this.add(password);
		this.add(loginButton);
		
		this.setVisible(true);
	}
	public void addButtonListener(ActionListener a){
		loginButton.addActionListener(a);
	}
	
	public String getUsername(){
		return username.getText();
	}
	
	public char[] getPassword(){
		return password.getPassword();
	}
	
	public void clearUsernameAndPassword(){
		this.username.setText("");
		this.password.setText("");
	}
}
