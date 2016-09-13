# statistics for management and economics study notes

# 1. What is Statistics?

- **population** is the group of all items of interest to a statistics practitioner. A descriptive measure of a population is called a **parameter**.
- **sample** is a set of data drawn from the studied population. A descriptive measure of a sample is called a **statistic**.

# 2. Graphical Descriptive Techniques I

## 2.1 Types of Data and Information

- **Interval data** are real numbers, such as heights, weights, incomes, and distances. We also refer to this type of data as **quantitative** or **numerical**.
- The values of **nominal data** are categories. the values are not numbers but instead are words that describe the categories. Nominal data are also called **qualitative** or **categorical**.
- **Ordinal data** appear to be nominal, but the difference is that the order of their values has meaning.

## 2.2 Describing a Set of Nominal Data

- A **bar chart** is often used to display frequencies; 
- A **pie chart** graphically shows relative frequencies.
- The bar chart focuses on the frequencies and the pie chart focuses on the proportions

# 3. Graphical Descriptive Techniques II

## 3.1 Describing a Set of Interval Data

## 3.1.1 Histogram

A **histogram** is created by drawing rectangles whose bases are the intervals and whose heights are the frequencies.

## 3.1.1.1 Determining the Number of Class Intervals

$$NumberOfClassIntervals = 1 + 3.3 log(n)$$ 


$$ClassWidth = \frac{LargestObservation - SmallestObservation}{NumberOfClasses}$$

## 3.1.2 Stem-and-Leaf Display

The first step in developing a stem-and-leaf display is to split each observation into two parts, a stem and a leaf. There are several different ways of doing this. For example, the number 12.3 can be split so that the stem is 12 and the leaf is 3. Another method can define the stem as 1 and the leaf as 2 (ignoring the 3). After each stem, we list that stem’s leaves, usually in ascending order. The advantage of the stem-and-leaf display over the histogram is that we can see the
actual observations.

```
Stem  Leaf
0     000000000111112222223333345555556666666778888999999
1     000001111233333334455555667889999
2     0000111112344666778999
3     001335589
4     124445589
5     022224556789
```

## 3.2 Describing time-series Data

**cross-sectional data** classifies data by type, **time-series data** classifies them according to whether the observations are measured at the same time or whether they represent measurements at successive points in time. Time-series data are often graphically depicted on a **line chart**, which plots the value of the variable on the vertical axis and the time periods on the horizontal axis.    

## 3.3 Describing the Relationship between Two Interval Data

In applications where one variable depends to some degree on the other variable, we label the dependent
variable Y and the other, called the independent variable, X. In interpreting the results of a scatter diagram it is important to understand that if two variables are linearly related it does not mean that one is causing the other. **Correlation is not causation**.

# 4. Numerical Descriptive Techniques

## 4.1 Measure of Central Location

### 4.1.1 Arithmetic Mean

$$\mu=\frac{\sum_{i=1}^Nx_{i}}{N}$$

$$\bar x=\frac{\sum_{i=1}^nx_{i}}{n}$$

### 4.1.2 Median

The median is calculated by placing all the observations in order (ascending or descending). The observation that falls in the middle is the median. When there is an even number of observations, the median is determined by averaging the two observations in the middle.

### 4.1.3 Mode

The mode is defined as the observation (or observations) that occurs with the greatest frequency.

### 4.1.4 Mean, Median, Mode: Which Is Best?

The mean is generally our first selection. One advantage the median holds is that it is not as sensitive to extreme values as is the mean. The mode is seldom the best measure of central location.

### 4.1.5 Geometric mean

$$(1+R_{g})^n=(1+R_{1})(1+R_{2})\cdots(1+R{n})$$

## 4.2 Measures of Variability

### 4.2.1 Range

```
Range = Largest observation − Smallest observation
```

### 4.2.2 Variance

$$\sigma^2=\frac{\sum_{i=1}^N(x_{i}-\mu)^2}{N}$$

$$s^2=\frac{\sum_{i=1}^n(x_{i}-\bar x)^2}{n-1}$$

### 4.2.3 Standard Deviation

$$\sigma = \sqrt{\sigma ^2}$$
$$s = \sqrt{s ^2}$$

### 4.2.4 Chebysheff’s Theorem

The proportion of observations in any sample or population that lie within k standard deviations of the mean is at least

$$1 - \frac{1}{k^2}, k>1$$

### 4.2.5 Coefficient of Variation

$$CV = \frac{\sigma}{\mu}$$

$$cv = \frac{s}{\bar x}$$

## 4.3 Measures of Relative Standing and Box Plots

### 4.3.1 Percentile

The $P_{th}$ percentile is the value for which P percent are less than that value and (100 – P)% are greater than that value.

### 4.3.2 Locating Percentiles

$$L_{p} = (n+1)\frac{P}{100}$$

where $L_{p}$ is the location of the $P_{th}$ percentile.        

Placing the 10 observations in ascending order we get

```
0 0 5 7 8 9 12 14 22 33
```

The location of the 25th percentile is   

$$L_{25} = (10+1)\frac{25}{100} = 2.75$$

The $25_{th}$ percentile is three-quarters of the distance between the second (which is 0) and the third (which is 5) observations. Three-quarters of the distance is

```
(.75)(5 − 0) = 3.75
```

Because the second observation is 0, the $25_{th}$ percentile is 0 + 3.75 = 3.75.

### 4.3.3 Interquartile Range

$$InterquartileRange = Q_{3} − Q_{1}$$

### 4.3.4 Box Plots

This technique graphs five statistics: the minimum and maximum observations, and the first, second, and third quartiles. The three vertical lines of the box are the first, second, and third quartiles. The lines extending to the left and right are called **whiskers**. Any points that lie outside the whiskers are called **outliers**. The whiskers extend outward to the smaller of 1.5 times the interquartile range or to the most extreme point that is not an outlier.

## 4.4 Measures of Linear Relationship

### 4.4.1 Covariance

$$\sigma_{xy} = \frac{\sum_{i=1}^N(x_{i}-\mu_{x})(y_{i}-\mu_{y})}{N}$$

$$s_{xy} = \frac{\sum_{i=1}^n(x_{i}-\bar x)(y_{i}-\bar y)}{n-1}$$

### 4.4.2 Coefficient of Correlation

$$\rho=\frac{\sigma_{xy}}{\sigma_{x}\sigma_{y}}$$

$$r=\frac{s_{xy}}{s_{x}s_{y}}$$

### 4.4.3 Least Squares Method

$$\hat y = b_{0} + b_{1}x$$

The coefficients $b_{0}$ and $b_{1}$ are derived using calculus so that we minimize the sum of squared deviations:

$$\sum_{i=1}^n(y_{i}-\hat{y_{i}})^2$$

Least Squares Line Coefficients:   

$$b_{1} = \frac{s_{xy}}{s_{x}^2}$$
$$b_{0} = \bar y - b_{1}\bar x$$

### 4.4.4 Coefficient of Determination

Coefficient of determination $R^2$ is calculated by squaring the coefficient of correlation. The coefficient of determination measures the amount of variation in the dependent variable that is explained by the variation in the independent variable.

### 4.4.5 Interpreting Correlation

**Correlation is not Causation**



