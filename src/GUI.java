import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

class GUI extends Canvas implements Runnable{
	

	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 1040, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Random r;
	public Handler handler;
	HUD hud;
	private int redval = 175;
	private int blueval = 238;
	private int greenval = 238;
	private Color bcolor = new Color(redval,blueval,greenval);
	public GUI(){
		
		Environment.setE_red(redval);
		Environment.setE_blue(blueval);
		Environment.setE_green(greenval);
		
		hud = new HUD();
		r = new Random();
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(){
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_ENTER){
					Main.Genetic_Algorithm();
					for(int k = 0; k < handler.object.size(); k++){
						handler.object.get(k).set_color(Main.population.get_individual(k).get_red(),
								Main.population.get_individual(k).get_blue(),
								Main.population.get_individual(k).get_green());
					}
				}
				
				if(key == KeyEvent.VK_G){
					redval = r.nextInt(256);
					blueval = r.nextInt(256);
					greenval = r.nextInt(256);
					bcolor = new Color(redval,blueval,greenval);
					Environment.setE_red(redval);
					Environment.setE_blue(blueval);
					Environment.setE_green(greenval);
				}
				
			}
		});			
		
		new Window(WIDTH, HEIGHT, "Evolution",bcolor, this);
		//new Button(100,100);		
		
		r = new Random();
		for(int k = 0; k < Main.population_size ; k++){
		handler.addObject(new Bodies((float) (WIDTH*Math.random()), (float) (HEIGHT * Math.random()),
				handler,new Color(Main.population.get_individual(k).get_red()
						,Main.population.get_individual(k).get_red()
						,Main.population.get_individual(k).get_red())));
		}
		
		start();
		
	}
	
	


	public synchronized void start(){
		thread = new Thread(this);
		System.out.println("creating thread");
		thread.start();
		System.out.println("starting thread");
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}			
			if(running){
				render();
				frames++;				
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}			
		}
		stop();
	}
	
	
	private void tick(){
		handler.tick();
				
	}
	
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(bcolor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		hud.render(g);		
		
		g.dispose();
		bs.show();
	}
	
	
}
