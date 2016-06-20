# 1. Allele Frequency

##  1.1 Exome Aggregation Consortium (ExAC)

The data set provided on [ExAC](http://exac.broadinstitute.org/) website spans 60,706 unrelated individuals sequenced as part of various disease-specific and population genetic studies.

```bash
wget ftp://ftp.broadinstitute.org/pub/ExAC_release/release0.3.1/ExAC.r0.3.1.sites.vep.vcf.gz .
gunzip ExAC.r0.3.1.sites.vep.vcf.gz
python prepareDB.py --input ExAC.r0.3.1.sites.vep.vcf --exac-count --out exac_count.txt
python prepareDB.py --input exac_count.txt --exac-freq --out exac031_freq.txt
```

## 1.2 NHLBI GO Exome Sequencing Project (ESP)

he current EVS data release (ESP6500SI-V2) is taken from 6503 samples drawn from multiple [ESP](http://evs.gs.washington.edu/EVS/) cohorts and represents all of the ESP exome variant data.

```bash
wget http://evs.gs.washington.edu/evs_bulk_data/ESP6500SI-V2-SSA137.GRCh38-liftover.snps_indels.vcf.tar.gz .
tar zxvf ESP6500SI-V2-SSA137.GRCh38-liftover.snps_indels.vcf.tar.gz
for chr in $(seq 1 22)
do
    python prepareDB.py --input ESP6500SI-V2-SSA137.GRCh38-liftover.chr$chr.snps_indels.vcf --esp-count --out chr$chr.txt
done
for chr in X Y
do
    python prepareDB.py --input ESP6500SI-V2-SSA137.GRCh38-liftover.chr$chr.snps_indels.vcf --esp-count --out chr$chr.txt
done
cat chr1.txt chr2.txt chr3.txt chr4.txt chr5.txt chr6.txt chr7.txt chr8.txt chr9.txt chr10.txt chr11.txt chr12.txt chr13.txt chr14.txt chr15.txt chr16.txt chr17.txt chr18.txt chr19.txt chr20.txt chr21.txt chr22.txt chrX.txt chrY.txt > esp_count.txt
python prepareDB.py --input esp_count.txt --esp-freq --out esp6500v2_freq.txt
```

## 1.3 1000 Genomes Project

```bash
for chr in $(seq 1 22)
do
    wget ftp://ftp.1000genomes.ebi.ac.uk/vol1/ftp/release/20130502/ALL.chr$chr.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz
done
wget ftp://ftp.1000genomes.ebi.ac.uk/vol1/ftp/release/20130502/ALL.chrX.phase3_shapeit2_mvncall_integrated_v1b.20130502.genotypes.vcf.gz
wget ftp://ftp.1000genomes.ebi.ac.uk/vol1/ftp/release/20130502/ALL.chrY.phase3_integrated_v2a.20130502.genotypes.vcf.gz
for chr in $(seq 2 22)
do
    gunzip ALL.chr$chr.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz
    python prepareDB.py --input ALL.chr$chr.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf --okg-freq --out chr$chr.txt
    rm ALL.chr$chr.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf
done
gunzip ALL.chrX.phase3_shapeit2_mvncall_integrated_v1b.20130502.genotypes.vcf.gz
python prepareDB.py --input ALL.chrX.phase3_shapeit2_mvncall_integrated_v1b.20130502.genotypes.vcf --okg-freq --out chr23.txt
gunzip ALL.chrY.phase3_integrated_v2a.20130502.genotypes.vcf.gz
python prepareDB.py --input ALL.chrY.phase3_integrated_v2a.20130502.genotypes.vcf --okg-freq --out chr24.txt
cat chr1.txt chr2.txt chr3.txt chr4.txt chr5.txt chr6.txt chr7.txt chr8.txt chr9.txt chr10.txt chr11.txt chr12.txt chr13.txt chr14.txt chr15.txt chr16.txt chr17.txt chr18.txt chr19.txt chr20.txt chr21.txt chr22.txt chr23.txt chr24.txt > 1000gR3_freq.txt
```
