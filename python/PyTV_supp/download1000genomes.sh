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

