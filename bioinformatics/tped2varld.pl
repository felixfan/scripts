#!/usr/bin/perl -w
use strict;

use Getopt::Long;

### covert tped to varLD input format
### inputs are standard tped (ACGT code, -9 and 0 =>missing)
### Revised on 26 May 2014
### Yanhui Fan, nolanfyh@gmail.com

### tped should include markers on the same chromosome!!!!

my($tped, $out);

GetOptions ("tped=s"		=> \$tped,
			"out=s"		=> \$out);

if(!$tped)
{
print "
\@--------------------------------------------------@
|              tped2varld.pl version 1.0           |
|--------------------------------------------------|
|  (C) Yan-Hui Fan, GNU General Public License, v2 |
|--------------------------------------------------|
|       http://ipgwas.sourceforge.net/             |
\@--------------------------------------------------@

 --tped:    input tped file.
 --out:    output file name. (optional)
 
 perl tped2varld.pl --tped example.tped --out example.out\n";
exit;
}

$out ||= "examle.out";

open(f0, ">$out") || die "can not open $out: $!\n";
open(f1, $tped) || die "can not open $tped: $!\n";
while(<f1>)
{
chomp;
my @arr=split(/\s+/, $_);
print f0 "$arr[1]\t$arr[3]";
my %alleles;
	## minor/major allele
	for(my $j=4; $j<=$#arr; $j++)
	{
		$arr[$j]=uc($arr[$j]);
		if($arr[$j]=~/[A|C|G|T]/i){
			if(exists $alleles{$arr[$j]}){
				$alleles{$arr[$j]}++;
			}else{
				$alleles{$arr[$j]}=1;
			}			
		}
	}
	
	my @keys =keys %alleles;
	my ($minor, $major);
	if($#keys == 0){
		$minor=0;
		$major=$keys[0];
	}elsif($#keys == 1){
		if($alleles{$keys[0]} > $alleles{$keys[1]}){
			$minor=$keys[1];
			$major=$keys[0];
		}else{
			$minor=$keys[0];
			$major=$keys[1];
		}
	}else{
		die "More than 2 alleles were found!!!\n";
	}

	## recode
	for(my $j=4; $j<$#arr; $j+=2)
	{
		my $i=$j+1;
		$arr[$j]=uc($arr[$j]);
		$arr[$i]=uc($arr[$i]);
		if($arr[$j] eq $arr[$i] && $arr[$j] eq $minor){
			print f0 "\t1";
		}elsif($arr[$j]eq $arr[$i] && $arr[$j] eq $major){
			print f0 "\t3";
		}elsif(($arr[$j] eq $minor && $arr[$i] eq $major) || ($arr[$i] eq $minor && $arr[$j] eq $major)){
			print f0 "\t2";
		}else{
			print f0 "\t4";
		}
	}
	print f0 "\n";
}
close f1;
close f0;
