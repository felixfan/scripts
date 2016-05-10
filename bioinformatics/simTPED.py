# -*- coding: utf-8 -*-

"""
generate a random tped/tfam file

random generate genotype, sex and phenotype
snp id: snp1, snp2, snp3, ...
snp pos: 1, 2, 3, ...
ind id: 1 1, 2 2, 3 3, ...

usage:
python simTPED.py num_ind num_snp chr out

e.g. 1000 individuals with 10000 SNPs on chromosome 1
python simTPED.py 1000 10000 1 chr1_sim

Revised on Mon May 10 2016
@author: Yanhui Fan (felixfanyh@gmail.com)
"""

import random
import sys

num_ind = int(sys.argv[1])
num_snp = int(sys.argv[2])
chrom = int(sys.argv[3])
out = sys.argv[4]

outtped = out+'.tped'
outtfam = out+'.tfam'

f = open(outtped, 'w')
for i in range(num_snp):
    a1 = random.choice(['A', 'C', 'G', 'T'])
    a2 = random.choice(['A', 'C', 'G', 'T'])
    while a1 == a2 :
        a2 = random.choice(['A', 'C', 'G', 'T'])
    s = str(chrom) + "\t" + "snp" + str(i+1) + "\t 0" + "\t" + str(i+1)
    f.write(s)
    for j in range(num_ind):
        f.write('\t')
        f.write(random.choice([a1, a2]))
        f.write('\t')
        f.write(random.choice([a1, a2]))
    f.write('\n')
f.close()

f = open(outtfam, 'w')
idx = 1
for i in range(num_ind):
	f.write(str(idx))
	f.write('\t')
	f.write(str(idx))
	f.write('\t0\t0')
	f.write('\t')
	f.write(str(random.choice([1,2])))
	f.write('\t')
	f.write(str(random.choice([1,2])))
	f.write('\n')
	idx += 1
f.close()

