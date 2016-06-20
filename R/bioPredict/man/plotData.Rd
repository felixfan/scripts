\name{plotData}
\alias{plotData}
\title{plot ROC Curve}
\usage{
plotData(data, output, format = c("png", "pdf", "jpeg", "bmp", "postscript",
  "tiff"), width = 700, height = 700, units = "px", lty = 3, col = 1,
  lwd = 2, cex = 1.2, ...)
}
\arguments{
  \item{data}{output of bpComp}

  \item{output}{name of the plot.}

  \item{format}{plot format, can be
  "png","pdf","jpeg","bmp","postscript","tiff".}

  \item{width}{the width of the device.}

  \item{height}{the height of the device.}

  \item{units}{The units in which height and width are
  given. Can be px (pixels), in (inches), cm or mm.}

  \item{lty}{The line type. Line types can either be
  specified as an integer (0=blank, 1=solid (default),
  2=dashed, 3=dotted, 4=dotdash, 5=longdash, 6=twodash)}

  \item{col}{A specification for the plotting color.}

  \item{lwd}{The line width, a positive number, defaulting
  to 1.}

  \item{cex}{A numerical value giving the amount by which
  plotting text and symbols should be magnified relative to
  the default.}

  \item{...}{further arguments to be passed to plot}
}
\description{
plot ROC Curve
}
\examples{
# plotData(data=mydata,output="test.png")
}
\seealso{
\code{\link{bpComp}}

\code{\link{plotData}}
}

