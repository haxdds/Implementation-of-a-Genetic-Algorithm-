import java.awt.Color;
import java.util.Random;

public class Main {
	
	
	public static Population population;
	public static int generation;
	public static boolean ending_conditions_met;
	public static int population_size;
	public static Random r;
	
	
	public static void main(String[] args){
		r = new Random(); 
		
		population_size = 25 + r.nextInt(26);
		population = create_starting_population();
		
		GUI gui = new GUI();
		
		
		
	}
	
	public static Population create_starting_population(){
		Population temp_population = new Population(population_size, true);
		
		generation = 1;
		
		return temp_population;
	}
	
	

	public static void Genetic_Algorithm(){
		
							
			
			
			System.out.println("Generation: " + generation +  " Fittest: R:" + population.get_fittest().get_red() + 
				", B:"+ population.get_fittest().get_blue()+ ", G:" + population.get_fittest().get_green());
			
			
			population = Evolution.evolve(population);
			
			
			generation ++;
			
			

	
}
	
}
