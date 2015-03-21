import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*
 * This program reads in a file line by line, tokenizes
 * it and outputs the tokens in a stream (new-line character delimited).
 */

public class Tokenize {
	
	public static void main(String[] args){
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
	
		try {
			while((line = br.readLine()) != null){		
				String[] words = line.split("\\s+");		// split by whitespace
				String result = "";
				for (String word : words){
					word = word.replaceAll("\\W", "");		// remove non-word characters
					word = word.replaceAll("-", "");		// remove hyphen
					word = word.replaceAll("'", "");		// remove apostrophe
					word = word.toLowerCase();				// convert to lowercase
					result += word + "\n";					
				}
			
				bw.write(result);
				bw.flush();
			
			}
		} catch (IOException e) {
			System.out.println("Trouble reading input or writing output.");
		}
	}

}
