

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static String actualFolder = System.getProperty("user.dir")+"/src/";
	public static String inputFileName = "entrada.txt";
	public static String dinamicOutputFileName = "saida-dinamic.txt";
	public static String greedyOutputFileName = "saida-greedy.txt";
	
	public static List<String> readInputFile(){
		
		List<String> lines = new ArrayList<String>();
		Charset charset = Charset.forName("US-ASCII");
		Path file = Paths.get(actualFolder + inputFileName);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	lines.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		return lines;
	}
	
	public static void writeLine(String line, String fileName, OpenOption option) {
		Charset charset = Charset.forName("US-ASCII");
		Path file = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, option )) {
		    writer.write(line, 0, line.length());
		} catch (IOException x) {
			System.out.println(x);
			x.printStackTrace();
		}
	}

}
