# -*- coding: utf-8 -*-
"""
Created on Wed Jun 15 10:50:18 2016

@author: felixfan
"""

import sys
import argparse
import time

def run_time(starttime):
    usedtime = time.time() - starttime
    print
    print "Time used:",
    if usedtime >=60:
        ts = int(usedtime) % 60
        usedtime = int(usedtime) / 60
        tm = int(usedtime) % 60
        usedtime = int(usedtime) / 60
        th = int(usedtime) % 60
        if th > 0:
            print "%d hours"  % th,
            print "%d minutes"  % tm,
        elif tm > 0:
            print "%d minutes"  % tm,
    else:
        ts = usedtime
    print '%.2f seconds' % ts
    print "Finished at ",
    print time.strftime("%H:%M:%S %d %b %Y")

def prepare_count_exac(infile, outfile):
    cols = ['CHR', 'POS', 'REF', 'ALT', 
                'AC_ExAC', 'AC_AFR', 'AC_AMR', 'AC_EAS', 'AC_FIN', 'AC_NFE', 'AC_OTH', 'AC_SAS', 
                'AN_ExAC', 'AN_AFR', 'AN_AMR', 'AN_EAS', 'AN_FIN', 'AN_NFE', 'AN_OTH', 'AN_SAS']
    fr = open(infile)
    fw = open(outfile, 'w')

    fw.write('#')
    fw.write(cols[0])
    for z in cols[1:]:
        fw.write('\t{}'.format(z))
    fw.write('\n')

    n = 0
    for r in fr:
        if not r.startswith('#'):
            n += 1
            r = r.strip()
            arr = r.split()
            fw.write(arr[0])
            for z in (arr[1], arr[3], arr[4]):
                fw.write('\t{}'.format(z))
            ar = arr[7].split(';')
            for z in cols[4:]:
                flag = False
                for y in ar:
                    if y.startswith(z+'='):
                        vs = y.split('=')
                        fw.write('\t{}'.format(vs[1]))
                        flag = True
                        break
                if not flag:
                    sys.exit('can not find {} at chromosome {}:{}'.format(z, arr[0], arr[1]))
            fw.write('\n')
    fr.close()
    fw.close()
    print 'write {} variants to {}'.format(n, outfile)

def prepare_freq_exac(infile, outfile):
    cols = ['CHR', 'POS', 'REF', 'ALT', 
                'Freq_ExAC', 'Freq_AFR', 'Freq_AMR', 'Freq_EAS', 'Freq_FIN', 'Freq_NFE', 'Freq_OTH', 'Freq_SAS']
    fr = open(infile)
    fw = open(outfile, 'w')

    fw.write('#')
    fw.write(cols[0])
    for z in cols[1:]:
        fw.write('\t{}'.format(z))
    fw.write('\n')

    n = 0
    for r in fr:
        if not r.startswith('#'):
            n += 1
            r = r.strip()
            arr = r.split()
            fw.write(arr[0])
            for z in (arr[1:4]):
                fw.write('\t{}'.format(z))
            for i in xrange(4,12):
                j = i + 8
                if -1 == arr[i].find(','): # one alt
                    if int(arr[j]) == 0 or int(arr[i]) == 0:
                        fw.write('\t.')
                    else:
                        frq = 1.0 * int(arr[i]) / int(arr[j])
                        fw.write('\t{:.2e}'.format(frq))
                else: # multiple alt
                    frq = ''
                    ac = arr[i].split(',')
                    idx = 0
                    for k in ac:
                        idx += 1
                        if int(arr[j]) == 0 or int(k) == 0:
                            if idx == 1:
                                frq = '.'
                            else:
                                frq += ',.'
                        else:
                            tmp = 1.0 * int(k) / int(arr[j])
                            if idx == 1:
                                frq = '{:.2e}'.format(tmp)
                            else:
                                frq += ',{:.2e}'.format(tmp)
                    fw.write('\t{}'.format(frq))
            fw.write('\n')
    fr.close()
    fw.close()
    print 'write frequency of {} variants to {}'.format(n, outfile)

def prepare_count_esp(infile, outfile):
    cols = ['CHR', 'POS', 'REF', 'ALT', 'AC_EA', 'AN_EA', 'AC_AA', 'AN_AA', 'AC', 'AN']
    fr = open(infile)
    fw = open(outfile, 'w')

    fw.write('#')
    fw.write(cols[0])
    for z in cols[1:]:
        fw.write('\t{}'.format(z))
    fw.write('\n')

    n = 0
    for r in fr:
        if not r.startswith('#'):
            n += 1
            r = r.strip()
            arr = r.split()
            fw.write(arr[0])
            for z in (arr[1], arr[3], arr[4]):
                fw.write('\t{}'.format(z))
            ar = arr[7].split(';')
            for z in ('EA_AC', 'AA_AC', 'TAC'):
                flag = False
                for y in ar:
                    if y.startswith(z+'='):
                        vs = y.split('=')
                        vss = vs[1].split(',')
                        if len(vss) ==2:
                            fw.write('\t{}\t{}'.format(vss[0], sum(int(x) for x in vss)))
                            flag = True
                            break
                        elif len(vss) > 2:
                            fw.write('\t{}\t{}'.format(','.join(vss[0:-1]), sum(int(x) for x in vss)))
                            flag = True
                            break
                        else:
                            sys.exit('less than two alleles')
                        if not flag:
                            sys.exit('can not find {} at chromosome {}:{}'.format(z, arr[0], arr[1]))
            fw.write('\n')
    fr.close()
    fw.close()
    print 'write {} variants to {}'.format(n, outfile)

def prepare_freq_esp(infile, outfile):
    cols = ['CHR', 'POS', 'REF', 'ALT', 'Freq_EA', 'Freq_AA', 'Freq_ESP']
    fr = open(infile)
    fw = open(outfile, 'w')

    fw.write('#')
    fw.write(cols[0])
    for z in cols[1:]:
        fw.write('\t{}'.format(z))
    fw.write('\n')

    n = 0
    for r in fr:
        if not r.startswith('#'):
            n += 1
            r = r.strip()
            arr = r.split()
            fw.write(arr[0])
            for z in (arr[1:4]):
                fw.write('\t{}'.format(z))
            for i in xrange(4,10,2):
                j = i + 1
                if -1 == arr[i].find(','): # one alt
                    if int(arr[j]) == 0 or int(arr[i]) == 0:
                        fw.write('\t.')
                    else:
                        frq = 1.0 * int(arr[i]) / int(arr[j])
                        fw.write('\t{:.2e}'.format(frq))
                else: # multiple alt
                    frq = ''
                    ac = arr[i].split(',')
                    idx = 0
                    for k in ac:
                        idx += 1
                        if int(arr[j]) == 0 or int(k) == 0:
                            if idx == 1:
                                frq = '.'
                            else:
                                frq += ',.'
                        else:
                            tmp = 1.0 * int(k) / int(arr[j])
                            if idx == 1:
                                frq = '{:.2e}'.format(tmp)
                            else:
                                frq += ',{:.2e}'.format(tmp)
                    fw.write('\t{}'.format(frq))
            fw.write('\n')
    fr.close()
    fw.close()
    print 'write frequency of {} variants to {}'.format(n, outfile)

def prepare_freq_1000g(infile, outfile):
    cols = ['CHR', 'POS', 'REF', 'ALT', 'Freq_1000g', 'Freq_EAS', 'Freq_EUR', 'Freq_AFR', 'Freq_AMR', 'Freq_SAS']
    fr = open(infile)
    fw = open(outfile, 'w')

    fw.write('#')
    fw.write(cols[0])

    for z in cols[1:]:
        fw.write('\t{}'.format(z))
    fw.write('\n')

    n = 0
    for r in fr:
        if not r.startswith('#'):
            n += 1
            r = r.strip()
            arr = r.split()
            fw.write(arr[0])
            for z in (arr[1], arr[3], arr[4]):
                fw.write('\t{}'.format(z))
            ar = arr[7].split(';') # info
            for z in ('AF', 'EAS_AF', 'EUR_AF','AFR_AF','AMR_AF','SAS_AF'):
                flag = False
                for y in ar:
                    if y.startswith(z+'='):
                        vs = y.split('=')
                        if -1==vs[1].find(','):
                            if vs[1]=='1' or vs[1]=='0':
                                fw.write('\t{}'.format(vs[1]))
                            else:
                                fw.write('\t{:.2e}'.format(float(vs[1])))
                        else:
                            frq =''
                            vss = vs[1].split(',')
                            if vss[0] == '1' or vss[0] == '0':
                                frq += vss[0]
                            else:
                                frq += '{:.2e}.format(float(vss[0]))'
                            for y in vss[1:]:
                                if y =='1' or y == '0':
                                    frq += ',{}'.format(y)
                                else:
                                    frq += ',{:.2e}'.format(float(y))
                            fw.write('\t{}'.format(frq))
                        flag = True
                if not flag:
                    sys.exit('can not find {} at chromosome {}:{}'.format(z, arr[0], arr[1]))
            fw.write('\n')       
    fr.close()
    fw.close()
    print 'write frequency of {} variants to {}'.format(n, outfile)

if __name__ == '__main__':
    starttime = time.time()
    desc = '''prepare database for annotation'''
    parser = argparse.ArgumentParser(description=desc)
    parser.add_argument('-v', action='version', version='%(prog)s 1.2.0')
    ### input
    parser.add_argument('--input', help='input file', required=True, type=str)
    ### filters
    parser.add_argument('--exac-count', help='extract ExAC allele counts', action='store_true')
    parser.add_argument('--exac-freq', help='calculate ExAC allele frequency', action='store_true')
    parser.add_argument('--esp-count', help='extract ESP allele counts', action='store_true')
    parser.add_argument('--esp-freq', help='calculate ESP allele frequency', action='store_true')
    parser.add_argument('--okg-freq', help='extract 1000g allele frequency', action='store_true')
    ### output
    parser.add_argument('--out', help='output file', type=str, default='output.txt')
    ###args
    args = vars(parser.parse_args())
    INFILE = args['input'] if 'input' in args else None
    OUTFILE = args['out']
    EXAC_COUNT = args['exac_count'] if 'exac_count' in args else False
    EXAC_FREQ = args['exac_freq'] if 'exac_freq' in args else False
    ESP_COUNT = args['esp_count'] if 'esp_count' in args else False
    ESP_FREQ = args['esp_freq'] if 'esp_freq' in args else False
    OKG_FREQ = args['okg_freq'] if 'okg_freq' in args else False
    ###log
    print "@-------------------------------------------------------------@"
    print "|        prepareDB      |      v1.0.0       |   20 Jun 2016   |"
    print "|-------------------------------------------------------------|"
    print "|  (C) 2016 Felix Yanhui Fan, GNU General Public License, v2  |"
    print "|-------------------------------------------------------------|"
    print "|    For documentation, citation & bug-report instructions:   |"
    print "|            http://felixfan.github.io/PyVCF                  |"
    print "@-------------------------------------------------------------@"
    print "\n\tOptions in effect:"
    print "\t--input", INFILE
    if EXAC_COUNT:
        print '\t--exac-count'
    elif EXAC_FREQ:
        print '\t--exac-freq'
    elif ESP_COUNT:
        print '\t--esp-count'
    elif ESP_FREQ:
        print '\t--esp-freq'
    elif OKG_FREQ:
        print '\t--okg-freq'
    print "\t--out", OUTFILE
    print
    ###run
    if EXAC_COUNT:
        prepare_count_exac(INFILE, OUTFILE)
    elif EXAC_FREQ:
        prepare_freq_exac(INFILE, OUTFILE)
    elif ESP_COUNT:
        prepare_count_esp(INFILE, OUTFILE)
    elif ESP_FREQ:
        prepare_freq_esp(INFILE, OUTFILE)
    elif OKG_FREQ:
        prepare_freq_1000g(INFILE, OUTFILE)
    ###run time
    run_time(starttime)
