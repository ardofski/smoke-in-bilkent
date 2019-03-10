import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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


public class GamePanel extends JPanel {

	Student student;
	Map map;
	BufferedImage img;
	JLabel scoreLabel;
	int totalScore;
	int gameNumber = 0;
	boolean isWasted;
	Timer timer;
	Score score;

	GamePanel(){

		createGame();
		gameNumber++;
	}


	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		g.drawImage( img , 0, 0, null );
		map.draw(g);
		System.out.println("painting");
		student.draw( g );
		
		score.draw(g, totalScore );
		
		if( map.securities.canSee( student.xLocation , student.yLocation , student.radius ) && ( map.areas.get(0).contains(student.xLocation, student.yLocation ) )  ) {
			g.setColor( new Color(255,0,0,50 ) ) ;
			g.fillOval(  student.xLocation - 25 , student.yLocation - 25 , 50, 50 );
			g.setColor( Color.BLACK ) ;
		}
		
		



	} 

	public void createGame(){

		if( gameNumber > 0) {

			remove( scoreLabel );
			timer.stop();
		} 

		try {
			img = ImageIO.read( new File( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/background2.png" ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize( new Dimension( Main.JFRAME_WÝDTH , Main.JFRAME_HEIGHT) );
		student = new Student("Arda", 100,100);
		map = new Map();
		scoreLabel = new JLabel("Score : 0");
		score = new Score();
		totalScore = 0;
		System.out.println( isFocusable() );
		setFocusable(true);
		setRequestFocusEnabled(true);

		// some code here

		grabFocus();
		
		Controller ctrl = new Controller( student );
		TimeListener timeListener = new TimeListener();
		timer = new Timer( 10 , timeListener );
		timer.start();
		addKeyListener( ctrl );
		add( scoreLabel );
		isWasted = false;

	}




	class TimeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event)
		{

			repaint();

			if( !isWasted ) {
				
				if( ( student.xVelocity != 0 ) || ( student.yVelocity != 0 ) ) {
					student.isSmoking = false;
				}
				
				
				if( map.securities.canSee( student.xLocation , student.yLocation , student.radius )   &&  ( map.areas.get(0).contains(student.xLocation, student.yLocation ) ) && ( student.isSmoking ) ) {
					isWasted = true;
				}
				repaint();

				student.xLocation += student.xVelocity;
				student.yLocation += student.yVelocity;
				map.securities.secList.get(0).move();
				map.securities.secList.get(1).move();


				if( ! map.isReachable( student.xLocation , student.yLocation, student.radius )) {
					student.xLocation -= student.xVelocity;
					student.yLocation -= student.yVelocity;
				}

				

				if( ( map.areas.get(0).contains(student.xLocation, student.yLocation ) ) && ( student.isSmoking ) ) {
					totalScore += 1;
					scoreLabel.setText( "Score : " + totalScore );
				}
				
				if( totalScore >= 1000 ) {
					Main.gameStatus = 3;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Main.changeGame();
					((Timer)event.getSource()).stop();
				}
			}


			repaint();
			
			


			if( isWasted ) {
				Main.gameStatus = 2;
				System.out.println( " game status : "  + Main.gameStatus );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Main.changeGame();
				((Timer)event.getSource()).stop();
			}

			

		}

	}



}
