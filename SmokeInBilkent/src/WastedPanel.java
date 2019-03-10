import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import SuccessPage.StartListener;


public class WastedPanel extends JPanel {


	BufferedImage img;



	
	WastedPanel(){
		StartListener listener = new StartListener();
		JButton playAgain = new JButton("GO back to the main menu");
		playAgain.addActionListener( listener );
		add( playAgain );

		try {
			img = ImageIO.read( new File( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/wasted.png" ) );
			System.out.println("fgbnms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		g.drawImage( img , 0, 0, null );



	} 

	

	public class StartListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("listening");
			Main.gameStatus = 0;
			Main.changeGame();
			
		}
		
		
	}


}
