import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/* 
 * This program counts all the words from the input stream
 * and outputs the counts to standard output. The 
 * Input : A stream of tokens consisting of 1 word per line, 
 * sorted lexicographically.
 * Output : A stream of <word, count> pairs, for each word seen
 * in the input.
 */
public class WordCount {
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = null;
		String key = null;										// the word that we are currently getting count for
		Long count = 0L;										// the value of the word count
		
		try {
			while((input=br.readLine())!=null){
				if(!input.equals(key)){							// new key encountered
					if(key != null)	{
						bw.write(key + "\t" + count + "\n");		// write out old key-count
						bw.flush();
						count = 0L;
					}
					key = input;								// initialize new key
				}
				count++;										// increment count for current key
			}
			
			bw.write(key + "\t" + count + "\n");					// write out the last key-count
			bw.flush();
		} catch (IOException e) {
			System.out.println("Trouble reading input or writing output.");
			e.printStackTrace();
		}
		
	}
	
	
	
}
