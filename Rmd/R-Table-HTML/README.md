# R Table HTML


```r
library("stargazer")
library("dplyr")
library("nycflights13")
library("AER") # Applied Econometrics with R
```


```r
daily <- flights %>%
  filter(origin == "EWR") %>%
  group_by(year, month, day) %>%
  summarise(delay = mean(dep_delay, na.rm = TRUE))

daily_weather <- weather %>%
  filter(origin == "EWR") %>%
  group_by(year, month, day) %>%
  summarise(temp   = mean(temp, na.rm = TRUE),
            wind   = mean(wind_speed, na.rm = TRUE),
            precip = sum(precip, na.rm = TRUE))

# Merge flights with weather data frames
both <- inner_join(daily, daily_weather) %>% 
  data.frame()  # Temporary fix

# Create an indicator for quarter
both$quarter <- cut(both$month, breaks = c(0, 3, 6, 9, 12), 
                                labels = c("1", "2", "3", "4"))

# Create a vector of class logical
both$hot <- as.logical(both$temp > 85)

head(both)
```

```
  year month day     delay    temp      wind precip quarter   hot
1 2013     1   1 17.483553 38.4800 12.758648      0       1 FALSE
2 2013     1   2 25.322674 28.8350 12.514732      0       1 FALSE
3 2013     1   3  8.450450 29.4575  7.863663      0       1 FALSE
4 2013     1   4 12.103858 33.4775 13.857309      0       1 FALSE
5 2013     1   5  5.696203 36.7325 10.836512      0       1 FALSE
6 2013     1   6 12.383333 37.9700  8.007511      0       1 FALSE
```

# The default summary statistics table


```r
stargazer(both, type = "html")
```


<table style="text-align:center"><tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>N</td><td>Mean</td><td>St. Dev.</td><td>Min</td><td>Max</td></tr>
<tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">year</td><td>364</td><td>2,013.000</td><td>0.000</td><td>2,013</td><td>2,013</td></tr>
<tr><td style="text-align:left">month</td><td>364</td><td>6.511</td><td>3.445</td><td>1</td><td>12</td></tr>
<tr><td style="text-align:left">day</td><td>364</td><td>15.679</td><td>8.784</td><td>1</td><td>31</td></tr>
<tr><td style="text-align:left">delay</td><td>364</td><td>15.080</td><td>13.883</td><td>-1.349</td><td>97.771</td></tr>
<tr><td style="text-align:left">temp</td><td>364</td><td>55.481</td><td>17.581</td><td>15.492</td><td>91.168</td></tr>
<tr><td style="text-align:left">wind</td><td>364</td><td>9.339</td><td>4.363</td><td>2.014</td><td>55.669</td></tr>
<tr><td style="text-align:left">precip</td><td>364</td><td>0.073</td><td>0.214</td><td>0.000</td><td>1.890</td></tr>
<tr><td style="text-align:left">hot</td><td>364</td><td>0.022</td><td>0.147</td><td>0</td><td>1</td></tr>
<tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr></table>

When supplied a data frame, by default stargazer creates a table with summary statistics. If the **summary** option is set to FALSE then stargazer will instead print the contents of the data frame. 


```r
# Use only a few rows
both2 <- both %>% slice(1:6)
stargazer(both2, type = "html", summary = FALSE, rownames = FALSE)
```


<table style="text-align:center"><tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">year</td><td>month</td><td>day</td><td>delay</td><td>temp</td><td>wind</td><td>precip</td><td>quarter</td><td>hot</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">2,013</td><td>1</td><td>1</td><td>17.484</td><td>38.480</td><td>12.759</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td style="text-align:left">2,013</td><td>1</td><td>2</td><td>25.323</td><td>28.835</td><td>12.515</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td style="text-align:left">2,013</td><td>1</td><td>3</td><td>8.450</td><td>29.457</td><td>7.864</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td style="text-align:left">2,013</td><td>1</td><td>4</td><td>12.104</td><td>33.477</td><td>13.857</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td style="text-align:left">2,013</td><td>1</td><td>5</td><td>5.696</td><td>36.733</td><td>10.837</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td style="text-align:left">2,013</td><td>1</td><td>6</td><td>12.383</td><td>37.970</td><td>8.008</td><td>0</td><td>1</td><td>FALSE</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr></table>

# Change which statistics are displayed

In order to customize which summary statistics are displayed, change any of the the following (logical) parameters, `nobs`, `mean.sd`, `min.max`, `median`, and `iqr`.  


```r
stargazer(both, type = "html", nobs = FALSE, mean.sd = TRUE, median = TRUE, iqr = TRUE)
```


<table style="text-align:center"><tr><td colspan="8" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>Mean</td><td>St. Dev.</td><td>Min</td><td>Pctl(25)</td><td>Median</td><td>Pctl(75)</td><td>Max</td></tr>
<tr><td colspan="8" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">year</td><td>2,013.000</td><td>0.000</td><td>2,013</td><td>2,013</td><td>2,013</td><td>2,013</td><td>2,013</td></tr>
<tr><td style="text-align:left">month</td><td>6.511</td><td>3.445</td><td>1</td><td>4</td><td>7</td><td>9.2</td><td>12</td></tr>
<tr><td style="text-align:left">day</td><td>15.679</td><td>8.784</td><td>1</td><td>8</td><td>16</td><td>23</td><td>31</td></tr>
<tr><td style="text-align:left">delay</td><td>15.080</td><td>13.883</td><td>-1.349</td><td>5.446</td><td>10.501</td><td>20.007</td><td>97.771</td></tr>
<tr><td style="text-align:left">temp</td><td>55.481</td><td>17.581</td><td>15.492</td><td>39.873</td><td>56.960</td><td>71.570</td><td>91.168</td></tr>
<tr><td style="text-align:left">wind</td><td>9.339</td><td>4.363</td><td>2.014</td><td>6.557</td><td>8.847</td><td>11.556</td><td>55.669</td></tr>
<tr><td style="text-align:left">precip</td><td>0.073</td><td>0.214</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.020</td><td>1.890</td></tr>
<tr><td style="text-align:left">hot</td><td>0.022</td><td>0.147</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td></tr>
<tr><td colspan="8" style="border-bottom: 1px solid black"></td></tr></table>

# Change which statistics are displayed (a second way)


```r
stargazer(both, type = "html", summary.stat = c("n", "p75", "sd"))
```


<table style="text-align:center"><tr><td colspan="4" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>N</td><td>Pctl(75)</td><td>St. Dev.</td></tr>
<tr><td colspan="4" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">year</td><td>364</td><td>2,013</td><td>0.000</td></tr>
<tr><td style="text-align:left">month</td><td>364</td><td>9.2</td><td>3.445</td></tr>
<tr><td style="text-align:left">day</td><td>364</td><td>23</td><td>8.784</td></tr>
<tr><td style="text-align:left">delay</td><td>364</td><td>20.007</td><td>13.883</td></tr>
<tr><td style="text-align:left">temp</td><td>364</td><td>71.570</td><td>17.581</td></tr>
<tr><td style="text-align:left">wind</td><td>364</td><td>11.556</td><td>4.363</td></tr>
<tr><td style="text-align:left">precip</td><td>364</td><td>0.020</td><td>0.214</td></tr>
<tr><td style="text-align:left">hot</td><td>364</td><td>0</td><td>0.147</td></tr>
<tr><td colspan="4" style="border-bottom: 1px solid black"></td></tr></table>

# Remove logical variables in the summary statistics


```r
stargazer(both, type = "html", summary.logical = FALSE)
```


<table style="text-align:center"><tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>N</td><td>Mean</td><td>St. Dev.</td><td>Min</td><td>Max</td></tr>
<tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">year</td><td>364</td><td>2,013.000</td><td>0.000</td><td>2,013</td><td>2,013</td></tr>
<tr><td style="text-align:left">month</td><td>364</td><td>6.511</td><td>3.445</td><td>1</td><td>12</td></tr>
<tr><td style="text-align:left">day</td><td>364</td><td>15.679</td><td>8.784</td><td>1</td><td>31</td></tr>
<tr><td style="text-align:left">delay</td><td>364</td><td>15.080</td><td>13.883</td><td>-1.349</td><td>97.771</td></tr>
<tr><td style="text-align:left">temp</td><td>364</td><td>55.481</td><td>17.581</td><td>15.492</td><td>91.168</td></tr>
<tr><td style="text-align:left">wind</td><td>364</td><td>9.339</td><td>4.363</td><td>2.014</td><td>55.669</td></tr>
<tr><td style="text-align:left">precip</td><td>364</td><td>0.073</td><td>0.214</td><td>0.000</td><td>1.890</td></tr>
<tr><td colspan="6" style="border-bottom: 1px solid black"></td></tr></table>

# Flip the table axes


```r
stargazer(both, type = "html", flip = TRUE)
```


<table style="text-align:center"><tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>year</td><td>month</td><td>day</td><td>delay</td><td>temp</td><td>wind</td><td>precip</td><td>hot</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">N</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td></tr>
<tr><td style="text-align:left">Mean</td><td>2,013.000</td><td>6.511</td><td>15.679</td><td>15.080</td><td>55.481</td><td>9.339</td><td>0.073</td><td>0.022</td></tr>
<tr><td style="text-align:left">St. Dev.</td><td>0.000</td><td>3.445</td><td>8.784</td><td>13.883</td><td>17.581</td><td>4.363</td><td>0.214</td><td>0.147</td></tr>
<tr><td style="text-align:left">Min</td><td>2,013</td><td>1</td><td>1</td><td>-1.349</td><td>15.492</td><td>2.014</td><td>0.000</td><td>0</td></tr>
<tr><td style="text-align:left">Max</td><td>2,013</td><td>12</td><td>31</td><td>97.771</td><td>91.168</td><td>55.669</td><td>1.890</td><td>1</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr></table>

# Control the number of decimal places


```r
stargazer(both, type = "html", flip=TRUE, digits = 1)
```


<table style="text-align:center"><tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>year</td><td>month</td><td>day</td><td>delay</td><td>temp</td><td>wind</td><td>precip</td><td>hot</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">N</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td></tr>
<tr><td style="text-align:left">Mean</td><td>2,013.0</td><td>6.5</td><td>15.7</td><td>15.1</td><td>55.5</td><td>9.3</td><td>0.1</td><td>0.02</td></tr>
<tr><td style="text-align:left">St. Dev.</td><td>0.0</td><td>3.4</td><td>8.8</td><td>13.9</td><td>17.6</td><td>4.4</td><td>0.2</td><td>0.1</td></tr>
<tr><td style="text-align:left">Min</td><td>2,013</td><td>1</td><td>1</td><td>-1.3</td><td>15.5</td><td>2.0</td><td>0.0</td><td>0</td></tr>
<tr><td style="text-align:left">Max</td><td>2,013</td><td>12</td><td>31</td><td>97.8</td><td>91.2</td><td>55.7</td><td>1.9</td><td>1</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr></table>

# Drop leading zeros from decimals


```r
stargazer(both, type = "html", flip=TRUE, digits = 1, initial.zero = FALSE)
```


<table style="text-align:center"><tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">Statistic</td><td>year</td><td>month</td><td>day</td><td>delay</td><td>temp</td><td>wind</td><td>precip</td><td>hot</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr><tr><td style="text-align:left">N</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td><td>364</td></tr>
<tr><td style="text-align:left">Mean</td><td>2,013.0</td><td>6.5</td><td>15.7</td><td>15.1</td><td>55.5</td><td>9.3</td><td>.1</td><td>.02</td></tr>
<tr><td style="text-align:left">St. Dev.</td><td>0.0</td><td>3.4</td><td>8.8</td><td>13.9</td><td>17.6</td><td>4.4</td><td>.2</td><td>.1</td></tr>
<tr><td style="text-align:left">Min</td><td>2,013</td><td>1</td><td>1</td><td>-1.3</td><td>15.5</td><td>2.0</td><td>0.0</td><td>0</td></tr>
<tr><td style="text-align:left">Max</td><td>2,013</td><td>12</td><td>31</td><td>97.8</td><td>91.2</td><td>55.7</td><td>1.9</td><td>1</td></tr>
<tr><td colspan="9" style="border-bottom: 1px solid black"></td></tr></table>

