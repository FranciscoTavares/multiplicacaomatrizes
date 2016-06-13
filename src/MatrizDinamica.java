

import java.util.HashMap;
import java.util.Map;

public class MatrizDinamica {

	//Entrada: vetor com as posições das matrizes. 
	public Map<String, int[][]> matrixChainOrder(int[] p) {
		Map<String, int[][]> result = new HashMap<String, int[][]>();
		
		int n = p.length-1;

		//m: o número mínimo de multiplicações escalares necessárias 
		// para se calcular a matriz
		int[][] m = new int[n][n]; 
		
		//s: contém as posições de melhor multiplicação. Os ks
		int[][] s = new int[n][n];

		int i; //linhas
		int j; //colunas
		int q; // qte de multiplicações escalares necessárias para se calcular a matriz
		int k; //posicoes de parentizacao 
		
		//preenche as diagonais com 0.
		for (i = 0; i < n; i++) { 
            m[i][i] = 0;
        }
		
		for (int l = 1; l < n; l++) {
            for (i = 0; i < n - l; i++) {
                j = i + l;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k < j; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
		
		result.put("m", m);
		result.put("s", s);
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
	
	public String printOptmalParents(int s[][], int i, int j) {
		StringBuilder text = new StringBuilder("");
		if (i == j) {
            text.append("A" + (i + 1));
        } else {
        	text.append("(");
        	text.append(printOptmalParents(s, i, s[i][j]));
        	text.append(printOptmalParents(s, s[i][j] + 1, j));
            text.append(")");
        }
        return text.toString();
    }
}
