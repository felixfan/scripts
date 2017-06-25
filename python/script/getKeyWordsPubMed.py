#coding=utf8

import sys
from Bio import Entrez

your_email = sys.argv[1]
your_term = sys.argv[2]
max_n = int(sys.argv[3])
output = sys.argv[4]

Entrez.email = your_email

handle = Entrez.esearch(db="pubmed", retmax=max_n, term=your_term)
record = Entrez.read(handle)
pmids = record["IdList"] # PubMed IDs

keywords = []

n = len(pmids)
for i in range(0, n, 100):
    j = i + 100
    if j > n:
        j = n
    print 'downlowing keywords from paper {} to {} ...'.format(i+1, j)
    handle2 = Entrez.efetch(db="pubmed", rettype='medline', retmode='text', id=','.join(pmids[i:j]))
    record2 = handle2.read()
    arr = record2.split('\n')
    for k in arr:
        if k.startswith('OT '):
            keywords.append(k.split('-')[1])

keywords = set(keywords)
f = open(output, 'w')
for k in keywords:
    f.write('{}\n'.format(k))
f.close()
