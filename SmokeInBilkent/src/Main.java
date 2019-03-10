
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

//import Student.Controller;

public class Main {

	final static int JFRAME_WÝDTH = 1366;
	final static int JFRAME_HEIGHT = 750;
	static int gameStatus = 0;
	static GamePanel gamePanel;
	static WastedPanel wastedPanel;
	static MainPanel mainPanel;
	static JFrame gameFrame;
	static SuccessPage successPage;

	public static void main(String[] args) {

		//Create new frame
		gameFrame = new JFrame();
		
		wastedPanel = new WastedPanel();
		mainPanel = new MainPanel();
		gamePanel = new GamePanel();
		successPage = new SuccessPage();
		gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		gameFrame.pack();
		gameFrame.setVisible( true );
		
		gameFrame.add( mainPanel );
		
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//gameFrame.setUndecorated(true);
		//gameFrame.setSize( JFRAME_WÝDTH , JFRAME_HEIGHT); 

		//snew Controller( );

	}
	
	
	public static void changeGame() {
		
		gameFrame.getContentPane().removeAll();
		gameFrame.repaint();

		if( gameStatus == 0 ) {
			
			System.out.println("okay we are here:)");

			gameFrame.add( mainPanel );

		}
		if( gameStatus == 1 ) {
			
			System.out.println("okay we are here:)");

			gameFrame.add( gamePanel );
			gamePanel.createGame();

		}
		if( gameStatus == 2) {
			gameFrame.add( wastedPanel );
			System.out.println("ASDFGHNMÖMHGFDSAQWERTYUIKLÞ.ÇÖMNHGFDSZ ");
			
		}
		
		if( gameStatus == 3) {
			gameFrame.add( successPage );
			System.out.println("ASDFGHNMÖMHGFDSAQWERTYUIKLÞ.ÇÖMNHGFDSZ ");
			
		}
		gameFrame.setSize( JFRAME_WÝDTH , JFRAME_HEIGHT);
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		

	}
	
}
