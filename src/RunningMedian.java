import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * This program finds the running median of word counts per line.
 * Input : A stream of text
 * Output : Running median till current point for every line read
 * 
 * An underlying assumption for bounded memory usage is that lines
 * contain no more than a finite, reasonably small number of words (e.g. 1000)
 */


public class RunningMedian {

	private static Long[] counts;						// histogram of word count frequency
	private static Long elementsRead;					// number of lines read from input
	
	public static void main(String[] args){
		
		int maxKey = Integer.parseInt(args[0]);			// get the maximum value of a key
		counts = new Long[maxKey + 1];					// index i corresponds to the 
														// number of lines with i words 
		for(int i = 0; i <= maxKey; i++)		
			counts[i] = 0L;
		elementsRead = 0L;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		double median = 0.0;
		
		try {
			while((line = br.readLine()) != null){		
				elementsRead++;
				int size;
				String[] words = line.split("\\s+");
				if(line.equals(""))	size = 0;
				else				size = words.length;
				counts[size]++;								// update counts
				median = getMedian();						// get median from the histogram
				bw.write(median + "\n");
				bw.flush();
			
			}
		} catch (IOException e) {
			System.out.println("Trouble reading input or writing output.");
			e.printStackTrace();
		}
		
	}
	
	// helper method to get the median from the histogram of word count frequency
	private static double getMedian(){
		
		Long sum = 0L;								// represents the number of elements with keys less than i
		double maxKey = (double) counts.length;
		int i = 0;	
		Long midPoint = (elementsRead / 2);			// number of elements which must have keys less than median
		double median = 0.0;
		
		if(elementsRead == 1){						// if only 1 element seen so far
			while(i <= maxKey){
				if(counts[i] > 0L)	return (double) i;		
				i++;
			}
		}
		
		if(elementsRead % 2 == 0){	
			double left = 0.0, right = 0.0;
			while(i <= maxKey && sum <= (midPoint-1)){
				sum += counts[i];			
				if(sum >= midPoint){
					left = i;			
				}
				i++;						
			}
			
			
			if(sum > midPoint)	right = i;	
			else{
				while(i <= maxKey && sum == midPoint){
					sum += counts[i];
					i++;
				}
				right = i - 1.0;
			}
			
			median = (left + right) / 2.0;			
			
		}
		else{
			while(i <= maxKey && sum <= midPoint){
				sum += counts[i];
				i++;
			}
			median = (double) i - 1.0;
		}
		
		return median;
	}
	
}
