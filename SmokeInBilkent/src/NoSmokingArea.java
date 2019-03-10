
public class NoSmokingArea {

	int x1,y1,x2,y2;
	int rectHeight, rectWidth;

	public NoSmokingArea( int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		rectWidth = x2 - x1;
		rectHeight = y2 - y1;
		
	}
	
	public boolean contains( int x, int y ) {
		if( (x > x1) && (x < x2) && (y > y1) && (y < y2) ) {
			return true;
			
		}
		else return false;
	}

}
