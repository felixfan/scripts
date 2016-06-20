# bioPredict: genetic risk prediction using SNPs genotype data

## 1 Installation


```r
library(devtools)
install_github("felixfan/bioPredict")  # from GitHub
library(bioPredict)
```


## 2 Read in data


```r
download.file("https://dl.dropboxusercontent.com/u/8272421/bioinfor/test.csv", 
    "test.csv", method = "curl")
download.file("https://dl.dropboxusercontent.com/u/8272421/bioinfor/train.csv", 
    "train.csv", method = "curl")
mydata <- readData2(train = "train.csv", test = "test.csv")
```

```
101 traits were used to build the model
2968 individuals were used to train the model
1172 individuals in train dataset are cases
1796 individuals in train dataset are controls
1492 individuals were used to test the model
580 individuals in test dataset are cases
912 individuals in test dataset are controls
```


## 3 Single method

### 3.1 Build the model and predict the result


```r
# svm
svmResult <- bpSVM(data = mydata)
```

```
best Gamma=  1e-04 ; best Cost=  100 
If the tuning results are on the margin of the parameters, then widen the parameters!
```

```r
# rpart
rpartResult <- bpRpart(data = mydata)
# ctree
ctreeResult <- bpCtree(data = mydata)
# bagging
baggingResult <- bpBagging(data = mydata)
# randomForest
randomForestResult <- bpRandomForest(data = mydata)
# Logistic regression
logisticRegressionResult <- bpLogisticRegression(data = mydata)
```


### 3.2 Plot the result


```r
plotData(data = svmResult, output = "svm.png", format = "png")
```

```
pdf 
  2 
```

```r
plotData(data = rpartResult, output = "rpart.png", format = "png")
```

```
pdf 
  2 
```

```r
plotData(data = ctreeResult, output = "ctree.png", format = "png")
```

```
pdf 
  2 
```

```r
plotData(data = baggingResult, output = "bagging.png", format = "png")
```

```
pdf 
  2 
```

```r
plotData(data = randomForestResult, output = "rf.png", format = "png")
```

```
pdf 
  2 
```

```r
plotData(data = logisticRegressionResult, output = "logistic.png", format = "png")
```

```
pdf 
  2 
```


### 3.3 Write the statistic


```r
writeData(data = svmResult, output = "svm.txt")
```

```
       acc   sens   spec    auc    phi    err    fpr    fnr    ppv    npv
svm 0.6188 0.5956 0.6552 0.7517 0.2923 0.3812 0.3448 0.4044 0.7926 0.5791
       rpp    rnp pcfall pcmiss
svm 0.4981 0.5019 0.2074 0.4209
```

```r
writeData(data = rpartResult, output = "rpart.txt")
```

```
         acc   sens   spec   auc    phi    err    fpr    fnr   ppv    npv
rpart 0.6094 0.6679 0.5172 0.689 0.2927 0.3906 0.4828 0.3321 0.701 0.5516
        rpp   rnp pcfall pcmiss
rpart 0.596 0.404  0.299 0.4484
```

```r
writeData(data = ctreeResult, output = "ctree.txt")
```

```
         acc   sens   spec    auc    phi    err    fpr    fnr    ppv
ctree 0.6026 0.6175 0.5792 0.7173 0.2723 0.3974 0.4208 0.3825 0.7426
         npv    rpp    rnp pcfall pcmiss
ctree 0.5555 0.5411 0.4589 0.2574 0.4445
```

```r
writeData(data = baggingResult, output = "bagging.txt")
```

```
           acc   sens   spec    auc    phi    err    fpr    fnr    ppv
bagging 0.5929 0.6563 0.4932 0.6963 0.2034 0.4071 0.5068 0.3437 0.7244
         npv    rpp    rnp pcfall pcmiss
bagging 0.58 0.5982 0.4018 0.2756   0.42
```

```r
writeData(data = randomForestResult, output = "rf.txt")
```

```
                acc   sens   spec    auc    phi    err    fpr    fnr
randomForest 0.5868 0.6026 0.5619 0.6952 0.2086 0.4132 0.4381 0.3974
                ppv    npv    rpp    rnp pcfall pcmiss
randomForest 0.7379 0.5708 0.5387 0.4613 0.2621 0.4292
```

```r
writeData(data = logisticRegressionResult, output = "logistic.txt")
```

```
      acc   sens   spec    auc    phi   err    fpr    fnr    ppv    npv
glm 0.621 0.6009 0.6527 0.7526 0.2911 0.379 0.3473 0.3991 0.7894 0.5671
       rpp    rnp pcfall pcmiss
glm 0.5023 0.4977 0.2106 0.4329
```


### 4 Multiple methods

```r
compResult = bpComp(data = mydata, model = c("rpart", "ctree", "bagging", "svm", 
    "randomForest", "glm"))
plotData(data = compResult, output = "comp4.png", format = "png", col = c(1, 
    2, 3, 4, 5, 6), lty = c(1, 2, 3, 4, 5, 6))
```

```
pdf 
  2 
```

```r
writeData(data = compResult, output = "comp.txt")
```

```
                acc   sens   spec    auc    phi    err    fpr    fnr
rpart        0.6094 0.6679 0.5172 0.6890 0.2927 0.3906 0.4828 0.3321
ctree        0.6026 0.6175 0.5792 0.7173 0.2723 0.3974 0.4208 0.3825
bagging      0.5892 0.6379 0.5127 0.6891 0.2051 0.4108 0.4873 0.3621
svm          0.6043 0.5832 0.6374 0.7216 0.2594 0.3957 0.3626 0.4168
randomForest 0.5856 0.5969 0.5679 0.6983 0.2097 0.4144 0.4321 0.4031
glm          0.6210 0.6009 0.6527 0.7526 0.2911 0.3790 0.3473 0.3991
                ppv    npv    rpp    rnp pcfall pcmiss
rpart        0.7010 0.5516 0.5960 0.4040 0.2990 0.4484
ctree        0.7426 0.5555 0.5411 0.4589 0.2574 0.4445
bagging      0.7266 0.5589 0.5794 0.4206 0.2734 0.4411
svm          0.7725 0.5620 0.4974 0.5026 0.2275 0.4380
randomForest 0.7418 0.5718 0.5328 0.4672 0.2582 0.4282
glm          0.7894 0.5671 0.5023 0.4977 0.2106 0.4329
```

