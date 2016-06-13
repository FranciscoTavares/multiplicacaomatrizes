

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MatrizGuloso {

	//Entrada: vetor com as posições das matrizes. 
	public Map<String, Object> matrixChainOrder(int[] p, int init, int end) {

		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder text = new StringBuilder();
		int mult = 0;
		int k = 0;

		if (init == end) {
			
            text.append("A" + init);
        } else {
        	mult = Integer.MAX_VALUE;
        	
    		for (int i = init; i < end; i++) {
    			int q = p[init -1] * p[i] * p[end]; 
	            if( q < mult) {
	            	mult = q;
	            	k = i;
	            }
            }
        	
    		text.append("(");
    		
    		
        	Map<String, Object> r =  matrixChainOrder(p, init, k);
			mult = mult + (int)r.get("mult");
        	text.append(r.get("text"));
        	
        	r =  matrixChainOrder(p, k+1, end);
        	mult = mult + (int) r.get("mult");
        	text.append(r.get("text"));
        	
            text.append(")");
        }
		result.put("mult", mult);
		result.put("text", text.toString());
		 
		return result;
	}
	
	public void printMatriz(int[][] m) {
		
		for(int i = 0; i < m.length ; i++ ){
			System.out.print("|");
			
			for(int j = 0; j < m[i].length ; j++ ){
				System.out.print("  "+ m[i][j] + "  ");
			}
			
			System.out.println("|");
			
		}
		
	}
}
