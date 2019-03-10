import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class SuccessPage extends JPanel {


	BufferedImage img;



	
	SuccessPage(){
		StartListener listener = new StartListener();
		JButton play = new JButton("PLAY AGAÝN");
		play.addActionListener( listener );
		setLayout(null);
		//play.setPreferredSize( new Dimension( 100,50) );
		play.setBounds( 640,220,150,30 );
		add( play );
		

		try {
			img = ImageIO.read( new File( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/MainPage.png" ) );
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
			Main.gameStatus = 1;
			Main.changeGame();
			
		}
		
		
	}

	



}
