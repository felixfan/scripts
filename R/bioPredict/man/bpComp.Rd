\name{bpComp}
\alias{bpComp}
\title{Build model and predict results using different methods}
\usage{
bpComp(data, model = c("rpart", "ctree", "bagging", "svm", "randomForest",
  "glm"))
}
\arguments{
  \item{data}{output of readData or readData2.}

  \item{model}{methods will be used.}
}
\description{
Build model and predict results using different methods
}
\examples{
# bpComp(data=mydata)
}
\seealso{
\code{\link{readData}}

\code{\link{readData2}}

\code{\link{writeData}}

\code{\link{plotData}}
}

