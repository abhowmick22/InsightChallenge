#!/usr/bin/env bash

# get word-count for all input files
for file in wc_input/*;
do cat $file;
done | java -Xmx128m -cp bin/ Tokenize | sort -k1,1 | java -Xmx128m -cp bin/ WordCount > wc_output/wc_result.txt

# compute the max number of words in a line
MAX_KEY=$(for file in wc_input/*; do cat $file;done | java -Xmx128m -cp bin/ MaxKey)

# compute the running median of word count per line
for file in $(ls ./wc_input/* | sort);
do cat $file;
done | java -Xmx128m -cp bin/ RunningMedian $MAX_KEY > wc_output/med_result.txt
