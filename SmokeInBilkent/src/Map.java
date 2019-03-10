import java.awt.Graphics;
import java.util.ArrayList;

public class Map {

	
	ArrayList<Wall> walls;
	ArrayList<NoSmokingArea> areas;
	SecurityContainer securities;
	
	public Map( ) {
		securities = new SecurityContainer();
		walls = new ArrayList<Wall>();
		areas = new ArrayList<NoSmokingArea>();
		walls.add( new Wall(0,0,1350,1 ));
		walls.add( new Wall(0,0,1,700 ));
		walls.add( new Wall(1350,1,1350,700 ));
		walls.add( new Wall(1,700,1350,700 ));
		areas.add( new NoSmokingArea( 112,127,647 ,580 ) ); 
		
		String s1 = new String("C://Users//ardof//Desktop//SmokeInBilkent//src//sec/path1.txt");
		String s2 = new String("C://Users//ardof//Desktop//SmokeInBilkent//src//sec/path2.txt");
		securities.add( new Security(s1, 200 ,200  ) );
		securities.add( new Security(s2, 600 ,400  ) );
	}
	
	
	public void draw(Graphics g)
	{
		for( Security security : securities.secList ) {
			//g.fillOval( security.currentX - 25 , security.currentY - 25 , 50 , 50 );
			security.draw(g);
			g.drawPolygon( security.viewX, security.viewY, 3 );
			//g.drawRect( security.currentX - 25 , security.currentY - 25 , 50, 50);
			//security.anyIntersection( std.xLocation - 25 , std.yLocation - 25 , 25 );

		}
		
		for( Wall wall : walls) {
			g.drawRect( wall.x1 , wall.y1 , wall.rectWidth , wall.rectHeight  );
		}
		for( NoSmokingArea area : areas) {
			g.drawRect( area.x1 , area.y1 , area.rectWidth , area.rectHeight  );
		}
		
		
	}
	
	public boolean isReachable( int x0, int y0, int radius) {
		
		for( Wall wall : walls) {
			if( wall.doesIntersect( x0, y0, radius) ) {
				return false;
			}
			
		}
		return true;
	}
	
	

}
