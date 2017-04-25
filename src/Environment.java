import java.awt.Color;

public class Environment {
	
	public static int E_redval = 255;
	public static int E_blueval = 255;
	public static int E_greenval = 255;
	
	public static Color background_color = new Color(E_redval,E_blueval,E_greenval);
	
	public static int get_color_val(ColorID color){
		switch(color){
		case red:
			return E_redval;
		case blue:
			return E_blueval;
		case green:
			return E_greenval;
		default: 
			System.out.println("Pick Correct ColorID for get_color_val.");
			return 0;
		}
	}
	
	
	public static void setE_red(int i){
		E_redval = i;
	}
	
	public static void setE_blue(int i){
		E_blueval = i;
	}
	
	public static void setE_green(int i){
		E_greenval = i;
	}
	
	
	
	
	
	
	
	
	
}
