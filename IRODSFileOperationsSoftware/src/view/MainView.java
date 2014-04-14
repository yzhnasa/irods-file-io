package view;

import javax.swing.JFrame;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.IRODSFileSystem;

public class MainView extends JFrame {
	public static int width = 700;
	public static int height = 500;
	
	private MainViewPanel mainViewPanel;
	private IRODSAccount iRODSAccount;
	private IRODSFileSystem iRODSFileSystem;
	
	public MainView(IRODSAccount iRODSAccount){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocation(500, 200);
		
		this.iRODSAccount = iRODSAccount;
		try {
			iRODSFileSystem = IRODSFileSystem.instance();
		} catch (JargonException e) {
			e.printStackTrace();
		}
	}
}
