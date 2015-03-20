import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*
 * This program reads in a file line by line, tokenizes
 * it and outputs the tokens in a stream (new-line delimited).
 */

public class Tokenize {
	
	public static void main(String[] args){
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
	
		try {
			while((line = br.readLine()) != null){			// for all lines in the input stream
				String[] words = line.split("\\s+");
				String result = "";
				for (String word : words){
					word = word.replaceAll("\\W", "");		// remove non-word characters
					word = word.toLowerCase();				// convert to lowercase
					result += word + "\n";					// delimit by new-line
				}
			
				bw.write(result);
				bw.flush();
			
			}
		} catch (IOException e) {
			System.out.println("Trouble reading input or writing output.");
			e.printStackTrace();
		}
	}

}
