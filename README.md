# InsightChallenge
Solutions to the Insight Data Engineering Coding Challenge. 

* Word Count
To solve this problem, a naive approach is to store the counts of all seen 
words in a hash table in memory, however this solution does not scale well 
to large input (when the domain of words is too large to fit in memory).
Instead, we use the stream and sort paradigm, where we sort all the words
(lexicographically), this ensures that all instances of a word are grouped
together. Now, we can just stream through instances of a word, accumulating 
its count and writing it out. To get better runtime performance, we can buffer
some of these word counts in a hash table in memory and spill them out to disk
when the number of entries in the table exceeds a threshold.

* Running Median
It is impossible to maintain the running median of an infinite input stream
with constant amount of memory. However, here we assume that we can make an
initial pass over the data and also the data is integral (word counts per 
line). Thus, we can determine the maximum number of words that occur in a line(let us call this k) by making a first pass over the data. 
Using this, we declare an array to store the frequency of word counts. 
In the second pass, for each new line that we 
encounter, we update the frequency table and compute the median from this
frequency table, which is an O(k) operation. Thus, the run-time complexity of
the operation is O(nk), where n is the total number of words in the input.  
