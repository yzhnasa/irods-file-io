package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.AuthenticationException;
import org.irods.jargon.core.exception.CatalogSQLException;
import org.irods.jargon.core.exception.InvalidUserException;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.IRODSAccessObjectFactory;
import org.irods.jargon.core.pub.IRODSFileSystem;

import view.Login;
import view.LoginPanel;
import view.MainView;

public class LoginListener implements ActionListener {
	public static final String HOST = "data.iplantcollaborative.org";
	public static final String DEFAULT_STORAGE_RESOURCE = null;
	public static String HOME_DIR_PATH = "/iplant/home/";
	public static String ZONE = "iplant";
	public static int PORT = 1247;
	
	private Login login;
	private LoginPanel loginPanel;
	private String username;
	private String password;
	private IRODSFileSystem iRODSFileSystem;
	private IRODSAccessObjectFactory iRODSAccessObjectFactory;
	
	public LoginListener(Login login, LoginPanel loginPanel){
		this.login = login;
		this.loginPanel = loginPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		username = loginPanel.getUsername();
		password = String.valueOf(loginPanel.getPassword());
		
		IRODSAccount iRODSAccount = new IRODSAccount(HOST, PORT, username,
				password, HOME_DIR_PATH + username, ZONE, DEFAULT_STORAGE_RESOURCE);
		
		try {
			iRODSFileSystem = IRODSFileSystem.instance();
			iRODSAccessObjectFactory = iRODSFileSystem.getIRODSAccessObjectFactory();
			iRODSAccessObjectFactory.authenticateIRODSAccount(iRODSAccount);
			login.setVisible(false);
			MainView mainView = new MainView(iRODSAccount);
			mainView.setVisible(true);
		} catch (CatalogSQLException e){
			JOptionPane.showMessageDialog(null, "Please Input Your Username and Password!");
			loginPanel.clearUsernameAndPassword();
		} catch (InvalidUserException e) {
			JOptionPane.showMessageDialog(null, "Invalid Username!");
			loginPanel.clearUsernameAndPassword();
		} catch (AuthenticationException e) {
			JOptionPane.showMessageDialog(null, "Wrong Password!");
			loginPanel.clearUsernameAndPassword();
		} catch (JargonException e) {
			e.printStackTrace();
			loginPanel.clearUsernameAndPassword();
		}
	}
}
