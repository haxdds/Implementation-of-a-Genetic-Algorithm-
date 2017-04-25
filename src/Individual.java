
import java.util.HashMap;

public class Individual {

	static int gene_length = 8;
	
	byte[] genes_red = new byte[gene_length];
	byte[] genes_blue = new byte[gene_length];
	byte[] genes_green = new byte[gene_length];
	
	HashMap<ColorID,byte[]> gene_map;
	
	int fitness = 0;
	
	
	
	public void generate_individual(){
		
		gene_map = new HashMap<ColorID, byte[]>();
		
		for(int k = 0; k < gene_length; k++){
			byte gene_red = (byte) Math.round(Math.random());
			byte gene_blue = (byte) Math.round(Math.random());
			byte gene_green = (byte) Math.round(Math.random());
			genes_red[k] = gene_red;
			genes_blue[k] = gene_blue;
			genes_green[k] = gene_green;
		}
		
		gene_map.put(ColorID.red,genes_red);
		gene_map.put(ColorID.blue,genes_blue);
		gene_map.put(ColorID.green,genes_green);
		
		
	}
	
	
	
	public int get_red(){
		return Fitness.binary_to_decimal(genes_red);
	}
	
	public int get_blue(){
		return Fitness.binary_to_decimal(genes_blue);
	}
	
	public int get_green(){
		return Fitness.binary_to_decimal(genes_green);
	}
	
	public void set_gene(ColorID color, int index , byte val){
		gene_map.get(color)[index] = val;
	}
	
	public byte get_gene(ColorID color, int index){
		return gene_map.get(color)[index];
	}
	
	
}
