# rPlotter https://github.com/woobe/rPlotter
library(rPlotter)
pal_r <- extract_colours("https://upload.wikimedia.org/wikipedia/commons/3/30/Googlelogo.png", num_col = 5)
pie(rep(1, 5), col = pal_r, main = "Palette based on GOOGLE Logo")
