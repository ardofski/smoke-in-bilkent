import java.util.ArrayList;

public class SecurityContainer {

	
	ArrayList<Security> secList;
	
	
	public SecurityContainer() {
		secList = new ArrayList<Security>();
	}
	
	public void add( Security sec ) {
		secList.add( sec );
	}
	
	public Security remove( int index ) {
		Security sec = secList.get(index);
		secList.remove(index);
		return sec;
	}
	
	public boolean canSee( int x , int y, int radius ) {
		for( Security security : secList ) {
			if(security.anyIntersection( x - 25 , y - 25 , 25 ) )
				return true;
			
		}
		return false;
		
		
	}
	
	

}
