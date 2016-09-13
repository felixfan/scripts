# 1. Read lines in file into an array

```bash
mapfile -t a < file.txt
```

Note: works only with bash 4.0 or higher

# 2. For Loop Array

```bash
array=( one two three )
for i in "${array[@]}"
do
	echo $i
done
```

```bash
array=( one two three )
for i in $(seq 0 2)
do
	for j in $(seq 0 2)
	do
		if [ $j -gt $i ]; then
			echo ${array[$i]} ${array[$j]}
		fi
	done
done
```

# 3. Sum/average column 1 of a file

```bash
awk '{sum+=$1} END {print sum}' file.txt
awk '{sum+=$1} END {print sum/NR}' file.txt
```

# 4. Number each line in a file
```bash
sed = file.txt | sed 'N;s/\n/ /'
awk '{print NR,$0}' file.txt
```

# 5. Get unique entries in file based on column 2 (takes only the first instance)

```bash
awk '!arr[$2]++' file.txt
awk '!($2 in arr){print}{arr[$2]++}' file.txt
```

# 6. Print each line where the 5th field is equal/not equal to "abc123"

```bash
awk '$5 == "abc123"' file.txt
awk '$5 != "abc123"' file.txt
```

# 7. Print each line where the 1st field is between 1 and 22

```bash
awk '$1 >0 && $1 <23' file.txt
```

# 8. Print first two columns where the 1st field is “yes” or the 2nd field is “yes”

```bash
awk '$1=="yes" || $2=="yes"{print $1,$2}' file.txt
```

# 9. Print each line whose 7th field matches/does not match the regular expression

```bash
awk '$7  ~ /[a-f]/' file.txt
awk '$7  ~ /[1-4]/' file.txt
awk '$7  ~ /^[a-f]/' file.txt
awk '$7  !~ /[1-4]/' file.txt
awk '$7 ~/rs/' file.txt
awk '$7 !~/rs/' file.txt
```

# 10. Trim leading and/or trailing whitespace in a file

```bash
sed 's/^[ \t]*//' file.txt
sed 's/[ \t]*$//' file.txt
sed 's/^[ \t]*//;s/[ \t]*$//' file.txt
```

# 11. Delete blank lines in a file

```bash
sed '/^$/d' file.txt
```

# 12. Replace all occurances of “foo” with “bar” in the file

```bash
sed 's/foo/bar/g' file.txt
```

# 13. only replace the first instance in each line

```bash
sed 's/foo/bar/' file.txt
```

# 14. Extract every 4th line starting at the second line (line 2, 6, 10, ...)

```bash
sed -n '2~4p' file.txt
```

# 15. Count the number of unique lines in a file

```bash
sort file.txt | uniq | wc -l
```

# 16. Find number of lines shared by 2 files

```bash
sort file1 file2 | uniq -d
```

# 17. Find number of unique lines in 2 files

```bash
sort file1 file2 | uniq
```

# 18. Sort file by column

```bash
sort -k1,1 1.txt             # sort by first column
sort -k1,1 -n 1.txt          # sort by first column, numeric sort
sort -k1,1 -k3,3 -n 1.txt    # then use the third column as a tie breaker
sort -k1,1 -k3,3 -n -r 1.txt # reverse the order
```

# 19. Find the most common strings in column 2

```bash
cut -f2 file.txt | sort | uniq -c | sort -k1nr | head
```

# 20. Customize Split File Size using -b option

```bash
split -b2000000 test.txt        # 2Mb perl file
```

# 21. Customize the Number of Split Chunks using -n option

```bash
split -n20 test.txt             # create 20 chunks of split files
```

# 22. Customize Number of Lines using -l option

```bash
split -l5000 test.txt           # split files are created with 5000 lines
```

# 23. Do not generate empty output files with -e option

```bash
split -n20 -e test.txt
```

# 24. Join two files by matching the first fields

```bash
join FILE1 FILE2
```

# 25. Join two files by matching the first fields, ignore case using -i option

```bash
join -i FILE1 FILE2
```

# 26. Also print unpairable lines from file FILENUM using -a option

```bash
# where FILENUM is 1 or 2, corresponding to FILE1 or FILE2
join -a1 FILE1 FILE2           ## also print unpairable lines from FILE1
```

# 27. Print only unpaired lines using -v option

```bash
join -v FILE1 FILE2           ## only print unpaired lines
```

# 28. Join based on different columns from both biles using -1 and -2 option

```bash
join -1 2 -2 1 FILE1 FILE2
##join based on the second column of FILE1 and the first column of FILE2
```

# 29. paste is used to create columns of data with a user-specified delimiter.

```bash
paste a.txt b.txt # default tab
paste b.txt a.txt
paste -d ‘,’ a.txt b.txt
```

# 30. concatenate and print files

```bash
cat a.txt b.txt
```

# 31. Pick 10 random lines from a file

```bash
shuf file.txt | head -n 10
```

# 32. Print all possible 3mer DNA sequence combinations

```bash
echo {A,C,T,G}{A,C,T,G}{A,C,T,G}
```

# 33. sort by two fields (one numeric, one string) at the same time using sort

```bash
sort -k4,4n -k1,1 file.txt
```
