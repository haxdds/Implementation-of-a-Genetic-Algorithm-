import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Object {
	
	protected float x, y;
	protected Color color;
	protected float velX, velY;
	protected Handler handler;
	
	public Object(float x, float y, Handler handler,Color color){
		this.x = x;
		this.y = y;
		
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	
	public void set_color(int r, int b, int g){
		color = new Color(r,b,g);
	}
	
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}

	public void setVelX(float velX){
		this.velX = velX;
	}
	public void setVelY(float velY){
		this.velY = velY;
	}
	public float getVelx(){
		return velX;
	}
	public float getVelY(){
		return velY;
	} 
	
	
}

