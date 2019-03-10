import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Student {

	int lastDirection = 1;
	int xLocation,yLocation,xVelocity,yVelocity;
	int speed = 3;
	int frameNumber = 0;
	int numOfShowForEachFrame = 15 / speed;
	int showNumber = 0;
	String name;
	boolean isSmoking = false;
	int radius = 25;
	double rotationRequired,locationX,locationY;
	LoadImage image1;
	

	ArrayList<LoadImage> img;
	AffineTransform tx;
	AffineTransformOp op;

	public Student( String name, int xLocation, int yLocation ) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.name = name;
		image1 = new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f0S.png" );
		img = new ArrayList<LoadImage>();
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f0.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f1.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f2.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f3.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f4.png" ) );
		locationX = img.get(0).img.getWidth() / 2;
		locationY = img.get(0).img.getHeight() / 2;

	}

	public void draw(Graphics g)
	{
		
		
		Graphics2D g2d = (Graphics2D)g;
		
		
		
		if( isSmoking ) {
			
			rotationRequired = Math.toRadians ( (45) * ( lastDirection - 3 ));
			//System.out.println( "rotation: " + rotationRequired );
			
			tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			op = new AffineTransformOp(tx,   AffineTransformOp.TYPE_BILINEAR);
			g2d.drawImage(op.filter(image1.img, null), (int)xLocation - radius, (int)yLocation - radius, null);
		}
		
		else {
			
			if( direction() == 0 ) {
				rotationRequired = Math.toRadians ( (45) * ( lastDirection - 3 ));
				//System.out.println( "rotation: " + rotationRequired );
				
				tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(img.get( 0 ).img, null), (int)xLocation - radius, (int)yLocation - radius, null);
				
				
				
			}
			else {
				
				rotationRequired = Math.toRadians ( (45) * ( direction() - 3 ));
				
				//System.out.println( "rotation: " + rotationRequired );
				
				tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

				// Drawing the rotated image at the required drawing locations
				
				if( showNumber < numOfShowForEachFrame ) {
					g2d.drawImage(op.filter(img.get( frameNumber + 1 ).img, null), (int)xLocation - radius, (int)yLocation - radius, null);
					showNumber++;
				}
				
				else {
					g2d.drawImage(op.filter(img.get( frameNumber + 1 ).img, null), (int)xLocation - radius, (int)yLocation - radius, null);
					showNumber = 0;
					frameNumber++;
					if( frameNumber == 4 )frameNumber = 0;
				}
				
				lastDirection = direction();
				
			}
			//g.drawRect( (int)xLocation - radius , (int)yLocation - radius, radius*2 , radius*2 );
			

		}


	}
	
	//SET AND RETURN DIRECTION 
	
	

	public int direction() {
		int direction = 0;
		if( (xVelocity == 0) && yVelocity < 0 ) {
			direction = 1;
		}
		else if( (xVelocity > 0) && ( yVelocity < 0 ) ) {
			direction = 2;
		}
		else if( (xVelocity > 0) && ( yVelocity == 0 ) ) {
			direction = 3;
		}
		else if( (xVelocity > 0) && ( yVelocity > 0 ) ) {
			direction = 4;
		}
		else if( (xVelocity == 0) && ( yVelocity > 0 ) ) {
			direction = 5;
		}

		else if( (xVelocity < 0) && ( yVelocity > 0 ) ) {
			direction = 6;
		}
		else if( (xVelocity < 0) && ( yVelocity == 0 ) ) {
			direction = 7;
		}
		else if( (xVelocity < 0) && ( yVelocity < 0 ) ) {
			direction = 8;
		}
		return direction;
	}



}
