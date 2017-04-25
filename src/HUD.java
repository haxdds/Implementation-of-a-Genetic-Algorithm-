import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private Handler handler;
	
		
	
	
		
		
		
		
		
		public void render(Graphics g){
			
		
			
			g.setColor(Color.BLACK);
			
			g.setFont(new Font("Serif", Font.BOLD,20));
			g.drawString("GENERATION: " + Main.generation, 15, 34);
			g.drawString("PRESS ENTER TO EVOLVE " , 15, 50);
			g.drawString("PRESS G TO CHANGE BACKGROUND COLOR " , 15, 65);
			
			//g.drawString("FPS: " , 500 , 32);
		}
		
}
