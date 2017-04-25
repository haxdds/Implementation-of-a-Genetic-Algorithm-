import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

class Bodies extends Object {

	private Handler handler;
	public Color color;
	public Bodies(float x, float y, Handler handler, Color color) {
		super(x, y, handler, color);
		this.handler = handler;
		this.color = color;
		velX = 5;
		velY = 5;
		
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	public void set_color(int r, int b, int g){
		
		color = new Color(r,b,g);
		
	}
	
	
	Random r = new Random();
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= GUI.HEIGHT - 32 ){
			velY *= -1;
		}
		
		if(x <= 0 || x >= GUI.WIDTH - 32){
			velX *= -1;
		}
		
		
		 
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	
}
