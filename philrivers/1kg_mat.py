#coding=utf-8

import sys
import os
import os.path
from datetime import datetime

def get_inds(eas):
    inds = []
    f = open(eas)
    for r in f:
        r = r.strip()
        inds.append(r)
    f.close()
    return inds

def get_gtp0(ind, vcf, out):
    f0 = open(out, 'w')
    f = open(vcf)
    idx = None
    for r in f:
        r = r.strip()
        if r.startswith('##'):
            f0.write('{}\n'.format(r))
        elif r.startswith('#'):
            arr = r.split()
            if not ind in arr:
                sys.exit('Error: {} is not found in {}'.format(ind, vcf))
            idx = arr.index(ind)
            f0.write('{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n'.format(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[idx]))
        else:
            arr = r.split()
            if arr[5].find(',') == -1: # two alleles
                f0.write('{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n'.format(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[idx]))
            else: # > two alleles
                alts = arr[5].split(',')
                if arr[idx][:3] in ['0|0', '1|1', '0|1', '1|0']:
                    f0.write('{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n'.format(arr[0],arr[1],arr[2],arr[3],arr[4],alts[0],arr[6],arr[7],arr[8],arr[idx]))
                else:  # exclude other sites
                    pass
    f.close()
    f0.close()

def get_gtp(ind, vcf, dp, out):
    f0 = open(out, 'w')
    f = open(vcf)
    idx = None
    for r in f:
        r = r.strip()
        if r.startswith('##'):
            f0.write('{}\n'.format(r))
        elif r.startswith('#'):
            arr = r.split()
            if not ind in arr:
                sys.exit('Error: {} is not found in {}'.format(ind, vcf))
            idx = arr.index(ind)
            f0.write('{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n'.format(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[idx]))
        else:
            arr = r.split()
            if arr[4].find(',') == -1: # two alleles
                if arr[idx][:3] in ['0|1', '1|0', '1|1']: # rm homo ref, info col => .
                    if arr[idx][4:].isdigit() and int(arr[idx][4:]) >= dp:
                        f0.write('{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\n'.format(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],".",arr[8],arr[idx]))
            else: # > two alleles
                pass
    f.close()
    f0.close()

def merge_vcf(ind, start, end, prefix):
    vcf = ind + '.chr' + str(start) + '.vcf'
    out = prefix + '.' + ind + '.1kg.vcf'
    f0 = open(out, 'w')
    f1 = open(vcf)
    for r in f1:
        f0.write('{}'.format(r))
    f1.close()
    for c in xrange(start+1, end+1):
        vcf = ind + ".chr" + str(c) + ".vcf"
        f1 = open(vcf)
        for r in f1:
            if not r.startswith('#'):
                f0.write('{}'.format(r))
        f1.close()
    f0.close()
    for c in xrange(start, end+1):
        vcf = ind + ".chr" + str(c) + ".vcf"
        os.remove(vcf) if os.path.exists(vcf) else None

if __name__ == '__main__':
    if len(sys.argv) < 6:
        sys.exit('usage:\n{} eas.txt start end dp prefix\n'.format(sys.argv[0]))
    else:
        eas = sys.argv[1]
        start = int(sys.argv[2])
        end = int(sys.argv[3])
        dp = int(sys.argv[4])
        prefix = sys.argv[5]

        inds = get_inds(eas)
        n = len(inds)

        for i, k in enumerate(inds):
            print str(datetime.now())
            print 'processing {} of {} individuals ...'.format(i+1, n)
            for v in xrange(start, end + 1):
                vcf = 'chr' + str(v) + '.vcf'
                out = k + '.chr' + str(v) + '.vcf'
                get_gtp(k, vcf, dp, out)
            merge_vcf(k, start, end, prefix)

