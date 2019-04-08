import operator
import sys

dictionary = {}
for line in open("b4_raw.txt"):
	for word in line.split():
		# if word.endswith('ssing'): 
		item = word.strip(",.:()-?!;'\xe2\x80\x9c\x99\x94\xa0").lower()
		if item in dictionary:
			dictionary[item] = dictionary[item] + 1
		else :
			dictionary[item] = 1  
sorted_dict = sorted(dictionary.items(), reverse=True, key=operator.itemgetter(1))
# print(sorted_dict)
if len(sys.argv) == 2:
	top_n = int(sys.argv[1])
else: 
	top_n = 10
for i in range (top_n):
	print(sorted_dict[i])