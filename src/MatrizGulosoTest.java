
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrizGulosoTest {

	MatrizGuloso matrizDinamica = new MatrizGuloso();
	
	@Test
	public void test() {
		int[] p = { 2, 3 ,7 };
		Map<String, Object> result = matrizDinamica.matrixChainOrder(p, 1, p.length - 1);
		String toReturn = result.get("text") +" "+ result.get("mult");
		System.out.println(toReturn);
		
		assertEquals("(A1A2) 42", toReturn);
	}

	@Test
	public void test2() {
		int[] p = { 2, 3 ,7 , 2};
		Map<String, Object> result = matrizDinamica.matrixChainOrder(p, 1, p.length - 1); 
		String toReturn = result.get("text") +" "+ result.get("mult");

		System.out.println(toReturn);
		assertEquals("(A1(A2A3)) 54", toReturn);
	}

	@Test
	public void test3() {
		int[] p = { 8, 3 ,1 , 10, 1};
		Map<String, Object> result = matrizDinamica.matrixChainOrder(p, 1, p.length - 1); 
		
		String toReturn = result.get("text") +" "+ result.get("mult");
		System.out.println(toReturn);
		assertEquals("((A1A2)(A3A4)) 42", toReturn);
	}
	
}
