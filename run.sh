#!/usr/bin/env bash

for file in wc_input/*;
do cat $file;
done | java -Xmx128m -cp bin/ Tokenize | sort -k1,1 | java -Xmx128m -cp bin/ WordCount > wc_output/wc_result.txt
