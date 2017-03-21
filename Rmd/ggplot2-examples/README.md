# ggplot2 examples




```r
library(ggplot2)
library(reshape2)
data(Oxboys, package = "nlme")
diamonds = na.omit(diamonds)
msleep = na.omit(msleep)
mtcars = na.omit(mtcars)
Oxboys = na.omit(Oxboys)
mpg = na.omit(mpg)
mydata <- mtcars[, c(1,3,4,5,6,7)]
```

# 1. 散点图


```r
ggplot(mtcars, aes(x=mpg, y=wt)) + geom_point()
```

![](ggplot2_files/figure-html/unnamed-chunk-2-1.png)<!-- -->


```r
ggplot(mtcars, aes(x=mpg, y=wt)) + geom_point(aes(colour = factor(cyl)))
```

![](ggplot2_files/figure-html/unnamed-chunk-3-1.png)<!-- -->


```r
ggplot(mtcars, aes(x=mpg, y=wt)) + geom_point(colour = "darkblue")
```

![](ggplot2_files/figure-html/unnamed-chunk-4-1.png)<!-- -->


# 2. 柱状图


```r
ggplot(mpg, aes(class)) + geom_bar(fill="steelblue",colour="black")
```

![](ggplot2_files/figure-html/unnamed-chunk-5-1.png)<!-- -->

# 3. 直方图


```r
ggplot(diamonds, aes(carat)) + geom_histogram(bins = 30)
```

![](ggplot2_files/figure-html/unnamed-chunk-6-1.png)<!-- -->

# 4. 热图


```r
cormat <- round(cor(mydata),2)
melted_cormat <- melt(cormat)
head(melted_cormat)
```

```
  Var1 Var2 value
1  mpg  mpg  1.00
2 disp  mpg -0.85
3   hp  mpg -0.78
4 drat  mpg  0.68
5   wt  mpg -0.87
6 qsec  mpg  0.42
```


```r
ggplot(data = melted_cormat, aes(x=Var1, y=Var2)) + geom_raster(aes(fill=value))
```

![](ggplot2_files/figure-html/unnamed-chunk-8-1.png)<!-- -->


```r
ggplot(data = melted_cormat, aes(x=Var1, y=Var2)) + geom_raster(aes(fill=value), interpolate = TRUE)
```

![](ggplot2_files/figure-html/unnamed-chunk-9-1.png)<!-- -->

# 5. 箱线图


```r
ggplot(mpg, aes(x=class, y=hwy)) + geom_boxplot()
```

![](ggplot2_files/figure-html/unnamed-chunk-10-1.png)<!-- -->


```r
ggplot(mpg, aes(x=class, y=hwy)) + geom_boxplot() + geom_jitter(width = 0.2)
```

![](ggplot2_files/figure-html/unnamed-chunk-11-1.png)<!-- -->


```r
ggplot(mpg, aes(x=class, y=hwy)) + geom_boxplot() + coord_flip()
```

![](ggplot2_files/figure-html/unnamed-chunk-12-1.png)<!-- -->


```r
ggplot(mpg, aes(x=class, y=hwy)) + geom_boxplot(outlier.colour = "red", outlier.shape = 1)
```

![](ggplot2_files/figure-html/unnamed-chunk-13-1.png)<!-- -->





