import java.awt.Color;

public class Fitness {
	
	
	public static int get_fitness(Population pop, Individual indiv){
		int fitness = 0;
		
		fitness = (int) get_total_fitness(pop, indiv);
		
		
		return fitness;
	}
	
	
	public static double fitness_function(Population pop, int colorval, ColorID color){
		double fitness = 0;
		double maxfitness = 0;
		double sd = get_standard_deviation(pop,color);
		int Eval = Environment.get_color_val(color);
		
		fitness = -(power(colorval - Eval,2)/sd);
				
		return fitness;
	}
	
	public static double get_total_fitness(Population pop, Individual indiv){
		double totalfitness = 0;
		double redfitness;
		double bluefitness;
		double greenfitness;
		
		int redval = indiv.get_red();
		int blueval = indiv.get_blue();
		int greenval = indiv.get_green();
		
		redfitness = fitness_function(pop,redval,ColorID.red);
		bluefitness = fitness_function(pop,blueval,ColorID.blue);
		greenfitness = fitness_function(pop,greenval,ColorID.green);
		
		totalfitness = redfitness + bluefitness + greenfitness;
		
		return totalfitness;
	}
	
	
	
	
	
	
	
	public static double power(double i, double n){
		return (double) Math.pow(i, n);
	}
	
	
	
	
	public static double get_standard_deviation(Population population , ColorID color){
		double sd = 0;
		double variance = 0;
		double mean = Environment.get_color_val(color);
		
		for(int k = 0; k < population.size();k++){
			double val = binary_to_decimal(population.get_individual(k).gene_map.get(color));
			variance += power( val - mean , 2);
		}
		
		sd = (int) Math.sqrt(variance/population.size());
		return sd;
	}
	
	
	public static double get_mean(Population population, ColorID color){
		double sum = 0;
		double mean = 0;
		for(int k = 0; k < population.size(); k++){
		sum += binary_to_decimal(population.get_individual(k).gene_map.get(color));		
		}
		
		mean =  sum / population.size();
		return mean;
		
		
	}
	

	public static String toString(byte[] b){
		
		String binaryGene = "";		
		for(int k = 0 ; k < b.length; k++){
			String s=Byte.toString(b[k] );
			binaryGene += s;
		}
		
		return binaryGene;
	}
	
	
	
	
	public static int binary_to_decimal(byte[] b){		
		
		int decimalValue = Integer.parseInt(toString(b), 2);
		
		return decimalValue;
		
	}
	
	
}
