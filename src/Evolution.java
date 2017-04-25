import java.awt.Color;
import java.util.Set;

public class Evolution {
	
	private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
	
    public static Population evolve(Population pop){
    	Population new_pop = new Population(pop.size(),false);
		
    	if (elitism) {
            new_pop.save_individual(0, pop.get_fittest());
        }

        
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
		
		
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            new_pop.save_individual(i, newIndiv);
        }

        
        for (int i = elitismOffset; i < new_pop.size(); i++) {
            mutate(new_pop.get_individual(i));
        }

        
    	
    	
    	return new_pop;
	}
	
    
    
    public static Individual crossover(Individual indiv1, Individual indiv2) {
        
    	Individual newSol = new Individual();
    	newSol.generate_individual();
        
        for(ColorID color : indiv1.gene_map.keySet()){
        	for (int i = 0; i < indiv1.gene_length; i++) {
          
            	if (Math.random() <= uniformRate) {
            		newSol.set_gene(color,i,indiv1.gene_map.get(color)[i]);
            	} else {
                	newSol.set_gene(color,i,indiv2.gene_map.get(color)[i]);
            	}
        	}
        }
        
        return newSol;
    }
    
    
    public static void mutate(Individual indiv) {
     
    	
    	for(ColorID color : indiv.gene_map.keySet()){
    		for (int i = 0; i < indiv.gene_length; i++) {
        		if (Math.random() <= mutationRate) {
                	
                	byte gene = (byte) Math.round(Math.random());
                	indiv.set_gene(color, i, gene);
            	}
        	}
    	}
    }
    
    
    
    
    public static Individual tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.save_individual(i, pop.get_individual(randomId));
        }
        // Get the fittest
        Individual fittest = tournament.get_fittest();
        return fittest;
    }
	
	
}
