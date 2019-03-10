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





public class Score {

	public Score() {
		// TODO Auto-generated constructor stub
	}
	public void draw( Graphics g , int score) {
		g.drawRect( 600, 5, 200, 20);
		g.setColor( Color.RED);
		g.fillRect( 601, 6, score/5 , 19);
	} 

}
