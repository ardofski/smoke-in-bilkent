
public class Wall {
	
	int x1,y1,x2,y2;
	int rectHeight, rectWidth;

	public Wall( int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		rectWidth = x2 - x1;
		rectHeight = y2 - y1;
		
	}
	
	
	public boolean doesIntersect( int x, int y, int radius) {
		int DeltaX = x - Math.max( x1 , Math.min( x , x1 + rectWidth ));
		int DeltaY = y - Math.max( y1, Math.min( y , y1 + rectHeight ));
		return (DeltaX * DeltaX + DeltaY * DeltaY) < ( radius*radius );
	}

}
