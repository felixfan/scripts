import urllib2
import gzip
import shutil


### immunoglobulin regions - hg18
f = open('immunoglobulin.hg18.txt', 'w')
f.write('chr2:88937989-89411302\n')
f.write('chr14:21159897-22090937\n')
f.write('chr14:105065301-106352275\n') 
f.write('chr22:20715572-21595082\n')
f.close()

### download cytoband
const = 500000   # add 500kb to both the left and right of these regions
cytoBandfile = urllib2.urlopen("http://hgdownload.cse.ucsc.edu/goldenPath/hg18/database/cytoBand.txt.gz")

with open('cytoBand.txt.gz','wb') as output:
    output.write(cytoBandfile.read())

with gzip.open('cytoBand.txt.gz', 'rb') as f_in, open('cytoBand.txt', 'wb') as f_out:
    shutil.copyfileobj(f_in, f_out)

### centromere
centromere = {}
f = open("cytoBand.txt")
for r in f:
    if -1 != r.find("acen"):
        arr = r.split()
        if not arr[0] in centromere:
            centromere[arr[0]] = [int(arr[1]), int(arr[2])]
        else:
            if int(arr[1]) < centromere[arr[0]][0]:
                centromere[arr[0]][0] = int(arr[1])
            if int(arr[2]) > centromere[arr[0]][1]:
                centromere[arr[0]][1] = int(arr[2])
f.close()
print '#centromere'
f = open("centromere.hg18.txt", 'w')
for k in sorted(centromere.keys()):
    print k, centromere[k][0] - const, centromere[k][1] + const
    f.write('{}{}{}{}{}\n'.format(k, ':', centromere[k][0] - const, '-', centromere[k][1] + const))
f.close()

### telomere
telomere = {}
f = open("cytoBand.txt")
for r in f:
    arr = r.split()
    if not arr[0] in telomere:
        telomere[arr[0]] = int(arr[2])
    else:
        if int(arr[2]) > telomere[arr[0]]:
            telomere[arr[0]] = int(arr[2])
f.close()
print '#telomere'
f = open('telomere.hg18.txt', 'w')
for k in sorted(telomere.keys()):
    print k, "1", const
    print k, telomere[k] - const, telomere[k]
    f.write('{}{}{}{}{}\n'.format(k, ':', '1', '-', const))
    f.write('{}{}{}{}{}\n'.format(k, ':', telomere[k]-const, '-', telomere[k]))
f.close()
