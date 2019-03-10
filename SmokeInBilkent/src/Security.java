import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;

public class Security {

	ArrayList< Integer > xPath; 
	ArrayList< Integer > yPath;
	int currentX,currentY;
	int direction , lastDirection = 1;
	double slope, slope1, slope2,angle = 10;
	double xChange,yChange;
	int lengthOfView = 200;
	int speed = 1;
	String path;
	int[] viewX;
	int[] viewY;
	int viewWidth = 887;
	int viewHeight = 461;
	ArrayList<LoadImage> img;
	AffineTransform tx;
	AffineTransformOp op;
	LoadImage image1;
	double rotationRequired,locationX,locationY;
	int frameNumber = 0;
	int numOfShowForEachFrame = 10 / speed;
	int showNumber = 0;
	int radius = 25;

	public Security( ArrayList<Integer> xPath , ArrayList<Integer> yPath , int xinitial, int yinitial ) {
		this.xPath = xPath;
		this.yPath = yPath;
		currentX = xinitial ;
		currentY = yinitial ;

	}

	public Security( String path , int xinitial, int yinitial ) {
		Coordinates cc = new Coordinates( path );
		this.xPath = cc.xCoordinates;
		this.yPath = cc.yCoordinates;
		currentX = xinitial ;
		currentY = yinitial ;
		System.out.println(xPath);
		System.out.println(yPath);
		viewX = new int[3];
		viewY = new int[3];

		image1 = new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/char1f0S.png" );
		img = new ArrayList<LoadImage>();
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/sec1.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/sec2.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/sec3.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/sec4.png" ) );
		img.add( new LoadImage( "C://Users//ardof//Desktop//SmokeInBilkent//src//images/sec5.png" ) );
		locationX = img.get(0).img.getWidth() / 2;
		locationY = img.get(0).img.getHeight() / 2;

	}

	public void move() {

		

		xChange = (xPath.get(0) - currentX) ;
		yChange = (yPath.get(0) - currentY) ;
		
		if( xChange > 0 ) {
			direction = 2;
		}
		else if( xChange < 0 ) {
			direction = 4;
		}
		else if( yChange < 0 ) {
			direction = 1;
		}
		else if( yChange > 0 ) {
			direction = 3;
		}



		if( (xPath.get(0) - currentX) != 0) {
			slope = (yPath.get(0) - currentY) / (xPath.get(0) - currentX);

		}
		else {
			slope = 99999;
		}

		slope1 =  Math.tan( Math.atan( slope ) + Math.toRadians( angle ) ) ; 
		slope2 =  Math.tan( Math.atan( slope ) - Math.toRadians( angle ) ) ; 




		if( direction == 1 ) {
			currentY -= speed;
			viewX[0] = currentX - viewWidth;
			viewY[0] = currentY - viewHeight;
			viewX[1] = currentX + viewWidth;
			viewY[1] = currentY - viewHeight;

		}
		if( direction == 2 ) {
			currentX += speed;
			viewX[0] = currentX + viewHeight;
			viewY[0] = currentY - viewWidth;
			viewX[1] = currentX + viewHeight;
			viewY[1] = currentY + viewWidth;
		}
		if( direction == 3 ) {
			currentY += speed;
			viewX[0] = currentX + viewWidth;
			viewY[0] = currentY + viewHeight;
			viewX[1] = currentX - viewWidth;
			viewY[1] = currentY + viewHeight;
		}
		if( direction == 4 ) {
			currentX -= speed;
			viewX[0] = currentX - viewHeight;
			viewY[0] = currentY - viewWidth;
			viewX[1] = currentX - viewHeight;
			viewY[1] = currentY + viewWidth;
		}

		viewX[2] = currentX;
		viewY[2] = currentY;


		if( isCloserThan( xPath.get(0) , yPath.get(0) , 5 ) ) {
			xPath.add( xPath.get(0) );
			yPath.add( yPath.get(0) );
			xPath.remove(0);
			yPath.remove(0);
			
			
		}
	}


	public boolean isCloserThan( int x , int y , int dist) {
		int xDist = currentX - x;
		int yDist = currentY - y;
		if( ( ( xDist*xDist ) + ( yDist*yDist ) )  < (dist*dist) ) {
			return true;
		}
		return false;
	}

	//ANY INTERSECTÝON TEST


	public boolean anyIntersection( int x, int y, int radius) {

		Polygon viewArea = new Polygon( viewX, viewY, 3 );
		boolean res;
		res = viewArea.intersects( x, y , radius*2 , radius*2 );


		if(res) {
			System.out.println("Gorunuyor");
		}

		return res;
	}




	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;



		g.setColor(Color.RED);

		//g.drawLine( currentX, currentY , (int) (currentX + xChange ), (int) (currentY + yChange )  ); 

		g.setColor(Color.BLUE);


		//g.drawLine( currentX, currentY , (int) ( currentX +  ( -xChange*Math.cos( angle) + yChange*Math.sin( angle ) ) ) , (int) (currentY - xChange*Math.sin( angle ) - yChange*Math.cos( angle ) )  ); 
		//g.drawLine( currentX, currentY , (int) ( currentX +  ( -xChange*Math.cos( -angle) + yChange*Math.sin( -angle ) ) ) , (int) (currentY - xChange*Math.sin( -angle ) - yChange*Math.cos( -angle ) )  );



		//g.drawString("slope: " + Math.toDegrees( Math.atan(slope) ), currentX, currentY);
		//g.drawString("angle1: " + Math.toDegrees( Math.atan(slope1) ), currentX, currentY+50);
		//g.drawString("angle2: " + Math.toDegrees( Math.atan(slope2) ), currentX, currentY+100);




		System.out.println( "direction : " + direction + "and slope1 = " + slope1 );
		System.out.println( "direction : " + direction + "and slope2 = " + slope2 );

		g.setColor(Color.BLACK);
		rotationRequired = Math.toRadians ( (90) * ( direction - 2 ));

		//System.out.println( "rotation: " + rotationRequired );

		tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// Drawing the rotated image at the required drawing locations

		if( showNumber < numOfShowForEachFrame ) {
			//System.out.println( "resiiim buuu:" + img.get(0).img);
			System.out.println("frame number is : " + frameNumber );
			g2d.drawImage( op.filter(img.get( frameNumber ).img, null), (int)currentX - radius, (int)currentY - radius, null);
			//g2d.drawImage( img.get( 0 ).img, 50 , 50, null);
			showNumber++;
		}

		else {
			g2d.drawImage(op.filter(img.get( frameNumber ).img, null), (int)currentX - radius, (int)currentY - radius, null);
			showNumber = 0;
			frameNumber++;
			if( frameNumber == 5 )frameNumber = 0;
		}

		lastDirection = direction;


		//g.drawRect( (int)xLocation - radius , (int)yLocation - radius, radius*2 , radius*2 );


	}



}
