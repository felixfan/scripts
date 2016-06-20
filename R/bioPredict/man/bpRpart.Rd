\name{bpRpart}
\alias{bpRpart}
\title{Build model and predict results using recursive partitioning and regression trees}
\usage{
bpRpart(data, method = "class", ...)
}
\arguments{
  \item{data}{output of readData or readData2.}

  \item{method}{one of "anova", "poisson", "class" or
  "exp".}

  \item{...}{further arguments to be passed to rpart}
}
\description{
Build model and predict results using recursive
partitioning and regression trees
}
\examples{
# bpRpart(data=mydata)
}
\seealso{
\code{\link{readData}}

\code{\link{readData2}}

\code{\link{writeData}}

\code{\link{plotData}}
}

