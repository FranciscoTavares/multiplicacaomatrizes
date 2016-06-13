

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class MatrizDinamicaTest {

	MatrizDinamica matrizDinamica = new MatrizDinamica();
	
	@Test
	public void test() {
		int[] p = { 2, 3 ,7 };
		doTest(p, "(A1A2) 42" );
	}
	
	@Test
	public void test2() {
		int[] p = { 2, 3 ,7 , 2};
		doTest(p, "(A1(A2A3)) 54");
	}
	
	@Test
	public void test3() {
		int[] p = { 8, 3 ,1 , 10, 1};
		doTest(p, "(A1(A2(A3A4))) 37");
	}
	
	public void doTest(int[] p, String expected) {
		int n = p.length - 1;
		Map<String, int[][]> result = matrizDinamica.matrixChainOrder(p); 
		int[][] s = result.get("s");
		int[][] m = result.get("m");
		String toReturn = matrizDinamica.printOptmalParents(s, 0, n-1) + " " + m[0][n-1];
		assertEquals(expected, toReturn);
	}
}
