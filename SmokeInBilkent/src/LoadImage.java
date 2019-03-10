import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage extends Component {
          
    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImage( String path) {
       try {
    	   
    	   File file = new File( path );
    	   System.out.println( file.getPath() );
           img = ImageIO.read( file );
           //System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
       } catch (IOException e) {
    	   e.printStackTrace();
       }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }


}
