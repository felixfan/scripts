\name{writeData}
\alias{writeData}
\title{write output (measures) to a file}
\usage{
writeData(data, output, measure = c("acc", "sens", "spec", "auc", "phi",
  "err", "fpr", "fnr", "ppv", "npv", "rpp", "rnp", "pcfall", "pcmiss"),
  digits = 3, ...)
}
\arguments{
  \item{data}{output of bpSVM}

  \item{output}{name of output file}

  \item{measure}{measure argument of performance() function
  from ROCR package}

  \item{digits}{specify the number of decimal numbers}

  \item{...}{further arguments to be passed to write.table}
}
\description{
write output (measures) to a file
}
\examples{
# writeData(data=mydata)
}
\seealso{
\code{\link{writeData}}

\code{\link{bpSVM}}
}

