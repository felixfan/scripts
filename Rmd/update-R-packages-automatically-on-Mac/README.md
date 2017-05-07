# Update R packages automatically after update R on Mac

## 1. install R e.g. R 3.4
## 2. start R -> Preference -> Startup -> check Add ~/Library/R/3.4/library in Default Library Paths
## 3. install Rstudio
## 4. install packages to ~/Library/R/3.4/library 
## 5. re-install newer R, e.g. 3.5
## 6. mv packages from ~/Library/R/3.4/library TO ~/Library/R/3.5/library
## 7. update.packages(ask=FALSE,checkBuilt=TRUE)
