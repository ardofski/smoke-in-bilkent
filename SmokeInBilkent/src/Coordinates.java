import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Coordinates {

	ArrayList<Integer> xCoordinates;
	ArrayList<Integer> yCoordinates;
	String path;
	
	public Coordinates( String path) {
		xCoordinates = new ArrayList<Integer>();
		yCoordinates = new ArrayList<Integer>();
		this.path = path;
		try {
	    	   
	    	File file = new File( path ); 
		    if( file.canRead() ) {
		    	System.out.println( "okuuuuur" );
		    }
		    Scanner sc = new Scanner( file ); 
			  
		    while (sc.hasNextLine()) {
		    	String s = sc.nextLine();
		    	String[] parts = s.split(" ");
		    	String part1 = parts[0];
		    	String part2 = parts[1];
		    	int x = Integer.parseInt( part1 );
		    	int y = Integer.parseInt( part2 );
		    	xCoordinates.add( x );
		    	yCoordinates.add( y );
		    	System.out.println("sayýýýý : " +  x + " dsgfds " + y );
		    }
	       } catch (IOException e) {
	    	   e.printStackTrace();
	       }
	}

	     
}
