import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener{

	int velocity;
		
	
	Student student;
		
		Controller( Student student){
			this.student = student;
			System.out.println("listener");
			velocity = student.speed;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			   if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		            System.out.println( student.direction() );
		            student.xVelocity = velocity;
		            
		        }
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	System.out.println( student.direction() );
		            student.xVelocity = -velocity;
		        }
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		        	System.out.println( student.direction() );
		            student.yVelocity = -velocity;
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	System.out.println( student.direction() );
		            student.yVelocity = velocity;
		        }
		        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		        	student.isSmoking = true;
		        }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println( student.direction() );
	            student.xVelocity = 0;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	        	System.out.println( student.direction() );
	            student.xVelocity = 0;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	        	System.out.println( student.direction() );
	            student.yVelocity = 0;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	        	System.out.println( student.direction() );
	            student.yVelocity = 0;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	        	student.isSmoking = false;
	        }
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            System.out.println("spaceeee ");
	        }
			
		}
		
		public boolean isFocusTraversable() {
		    return false;
		  }

		
		
	}