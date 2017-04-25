import java.util.HashMap;

public class Population {
	
	Individual[] individuals;
	
	HashMap<Individual,Integer> fitness_map;
	
	
	
	public Population(int population_size, boolean initialize){
		
		individuals = new Individual[population_size];
		
		fitness_map = new HashMap<Individual, Integer>();
		
		
		if(initialize){
			for(int k = 0; k < population_size; k++){
				Individual indiv = new Individual();
				indiv.generate_individual();
				individuals[k] = indiv;			
			}		
		}
	}
	
	public Individual get_individual(int index){
		return individuals[index];
	}
	
	public void save_individual(int index,Individual indiv){
		individuals[index] = indiv;
	}
	
	public int size(){
		return individuals.length;
	}
	
	public int get_fitness(int index){
		return Fitness.get_fitness(this, individuals[index]);	
	}
	
	public int get_fittest_index(){
		int fittest_index = 0;
		
		for(int k = 1; k < size() ; k++){
			if(get_fitness(fittest_index) < get_fitness(k)){
				fittest_index = k;
			}
		}
		
		return fittest_index;
	}
	
	public Individual get_fittest(){
		int fittest_index = 0;
		
		for(int k = 1; k < size() ; k++){
			if(get_fitness(fittest_index) < get_fitness(k)){
				fittest_index = k;
			}
		}
		
		return individuals[fittest_index];
	}
	
	
}
