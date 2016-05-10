import sys

'''
extract rows from one file by matching patterns in another file

usage: 

python extractRowsByFileCols.py inputFile patternFile infilecols patterncols > out.txt

e.g. extract rows from out.assoc by chr and pos in file pattern.txt
chr and pos in column 2 and 3 in pattern.txt
chr and pos in column 1 and 3 in out.assoc

python extractRowsByFileCols.py out.assoc pattern.txt 1,3 2,3 > out.txt

e.g. extract rows from out.assoc by SNP rsID in file pattern.txt
rsID in column 1 in pattern.txt
rsID in column 2 in out.assoc

python extractRowsByFileCols.py out.assoc pattern.txt 2 1 > out.txt

@Yanhui Fan (felixfanyh@gmail.com)
Last revised on 10 May 2016
'''

infile = sys.argv[1]
patternfile = sys.argv[2]
infilecols = sys.argv[3] # , seperated
patterncols = sys.argv[4] # , seperated


if len(infilecols) != len(patterncols):
	sys.exit('error: num of columns should be equal')

col1 = infilecols.split(',')
col2 = patterncols.split(',')

col1 = map(int, col1)
col2 = map(int, col2)

pats = []

f = open(patternfile)
tmp = []
for r in f:
	r = r.strip()
	arr = r.split()
	for i in range(len(arr)):
		j = i + 1
		if j in col2:
			tmp.append(arr[i])
	pats.append(tmp)
	tmp = []
f.close()

f = open(infile)
for r in f:
	r = r.strip()
	arr = r.split()
	tmp = []
	for i in range(len(arr)):
		j = i + 1
		if j in col1:
			tmp.append(arr[i])
	if tmp in pats:
		print r
f.close()
