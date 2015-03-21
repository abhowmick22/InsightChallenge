import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * This program finds the maximum number of words in a line for a
 * list of input files.
 */

public class MaxKey {

	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		Integer max = 0;
		
		try {
			while((line = br.readLine()) != null){	
				String[] words = line.split("\\s+");
				if(words.length > max)	max = words.length;		// running max
			}
			bw.write(max.toString());
			bw.flush();
		} catch (IOException e) {
			System.out.println("Trouble reading input or writing output.");
		}
	}
}
