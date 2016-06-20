\name{bpSVM}
\alias{bpSVM}
\title{Build model and predict results using support vector machines}
\usage{
bpSVM(data, kernel = "radial", type = "C", gamma = 10^(-6:1),
  cost = 10^(-2:2), cross = 10, sampling = "fix", ...)
}
\arguments{
  \item{data}{output of readData or readData2.}

  \item{kernel}{the kernel used in training and predicting.
  Valid options are linear, polynomial, radial basis,
  sigmoid.}

  \item{type}{Valid options are: C-classification,
  nu-classification.}

  \item{gamma}{parameter needed for all kernels except
  linear.}

  \item{cost}{cost of constraints violation.}

  \item{cross}{k-fold cross validation on the training
  data.}

  \item{sampling}{sampling scheme. If sampling = "cross", a
  cross-times cross validation is performed. If sampling =
  "boot", nboot training sets of size boot.size (part) are
  sampled (with replacement) from the supplied data. If
  sampling = "fix", a single split into training/validation
  set is used, the training set containing a fix part of
  the supplied data.}

  \item{...}{further arguments to be passed to svm}
}
\description{
Build model and predict results using support vector
machines
}
\examples{
# bpSVM(data=mydata)
}
\seealso{
\code{\link{readData}}

\code{\link{readData2}}

\code{\link{writeData}}

\code{\link{plotData}}
}

