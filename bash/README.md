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