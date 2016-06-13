

import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

public class Main {

	static MatrizDinamica dinamico = new MatrizDinamica();
	static MatrizGuloso greedy = new MatrizGuloso();
	
	public static void main(String[] args) {
		List<String> lines = FileUtil.readInputFile();
		
		FileUtil.writeLine("", FileUtil.dinamicOutputFileName,StandardOpenOption.CREATE);
		FileUtil.writeLine("", FileUtil.greedyOutputFileName,StandardOpenOption.CREATE);
		
		FileUtil.writeLine("", FileUtil.dinamicOutputFileName,StandardOpenOption.TRUNCATE_EXISTING);
		FileUtil.writeLine("", FileUtil.greedyOutputFileName,StandardOpenOption.TRUNCATE_EXISTING);
		
		for (int i = 1; i < lines.size(); i++) {
			String line = lines.get(i);
			System.out.println("line "+ i+ " : "+line);
			
			int[] p = extractP(line);
			String output = executeWithDinamic(p);
			FileUtil.writeLine(output, FileUtil.dinamicOutputFileName, StandardOpenOption.APPEND);

			output = executeWithGreedy(p);
			FileUtil.writeLine(output, FileUtil.greedyOutputFileName, StandardOpenOption.APPEND);
		}
	}
	
	private static String executeWithGreedy(int[] p) {
		Map<String, Object> result = greedy.matrixChainOrder(p, 1, p.length - 1);
		String toReturn = result.get("text") +" "+ result.get("mult") + "\n";
		return toReturn;
		
	}

	public static int[] extractP(String line) {
		String[] temp = line.split(" ");
		int[] p = new int[temp.length-1];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = Integer.parseInt(temp[i+1]);
		}
		
		return p;
	}
	
	public static String executeWithDinamic(int[] p){
		Map<String, int[][]> r = dinamico.matrixChainOrder(p); 
		int n = p.length - 1;
		int[][] s = r.get("s");
		int[][] m = r.get("m");
		String result = dinamico.printOptmalParents(s, 0, n-1) + " " + m[0][n-1] + "\n";
		System.out.println("\n"+result);
		return result;
	}
	
	public static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
