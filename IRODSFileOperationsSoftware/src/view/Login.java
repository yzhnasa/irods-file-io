package view;

import javax.swing.JFrame;

import controller.LoginListener;

public class Login extends JFrame {
	public static int width = 350;
	public static int height = 300;

	public LoginPanel loginPanel;

	public Login() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocation(500, 200);
		this.setResizable(false);

		loginPanel = new LoginPanel();
		loginPanel.addButtonListener(new LoginListener(this, loginPanel));
		this.add(loginPanel);
		this.setTitle("Login");
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
}
