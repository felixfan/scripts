# Visualize Correlation Matrices


```r
mydata <- mtcars[, c('mpg', 'cyl', 'disp', 'hp', 'carb')]
```

# 1. PerformanceAnalytics Package


```r
library("PerformanceAnalytics")
chart.Correlation(mydata, histogram=TRUE, pch=19)
```

![](README_files/figure-html/unnamed-chunk-2-1.png)<!-- -->

# 2. Corrr Package


```r
library(corrr)
mydata %>% correlate() %>% network_plot(min_cor=0.6)
```

![](README_files/figure-html/unnamed-chunk-3-1.png)<!-- -->

# 3. Psych Package


```r
library(psych)
pairs.panels(mydata, scale=TRUE)
```

![](README_files/figure-html/unnamed-chunk-4-1.png)<!-- -->

# 4. Corrplot Package


```r
library(corrplot)
corrplot.mixed(cor(mydata), order="hclust", tl.col="black")
```

![](README_files/figure-html/unnamed-chunk-5-1.png)<!-- -->

# 5. GGally Package


```r
library(GGally)
ggpairs(mydata)
```

![](README_files/figure-html/unnamed-chunk-6-1.png)<!-- -->

# 6. ggcorrplot Package


```r
library(ggcorrplot)
ggcorrplot(cor(mtcars), p.mat = cor_pmat(mtcars), hc.order=TRUE, type='lower')
```

![](README_files/figure-html/unnamed-chunk-7-1.png)<!-- -->

# Reference

- https://github.com/JamesMarquezDev/Jupyter-Notebooks-Statistic-Walk-Throughs-Using-R/blob/master/correlation_matrices_in_r.ipynb


