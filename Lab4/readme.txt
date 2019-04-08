**USAGE: py separator.py [top_n]

top_n: top n words most frequently existed in the file

functions used:
- line.split(): split the file into lines (separated by \n)
- word.strip(",.:()-?!;'\xe2\x80\x9c\x99\x94\xa0") strip the word by two ends with characters listed
- data structure used to store: dictionary. 
Whenever reads a new word, if it was existed in dictionary, increase the value of that key by 1. 
Else add the new word to the dictionary and initalize the values of that key with 1
Sorted the items of dictionary by value and print out the top_n items with largest value

Warning: some utf-8 characters appeared inside the word has not been processed.
