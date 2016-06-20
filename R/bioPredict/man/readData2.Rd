\name{readData2}
\alias{readData2}
\title{Reads two files: train and test data files}
\usage{
readData2(train, test, csv = TRUE, header = TRUE, id = TRUE,
  controlLabel = "Control", ...)
}
\arguments{
  \item{train}{the name of the train file which the data is
  to be read from.}

  \item{test}{the name of the test file which the data is
  to be read from.}

  \item{csv}{a logical value indicating whether the file is
  separated by comma}

  \item{header}{a logical value indicating whether the file
  contains the names of the variables as its first line.}

  \item{id}{a logical value indicating whether the file
  contains a column called "ID"}

  \item{controlLabel}{the label of controls in the "Class"
  column}

  \item{...}{further arguments to be passed to read.table
  or read.csv}
}
\description{
The input files should contains a column called "Class" and
one or more columns traits. An optional column "ID", The
separator is 'white space' or comma.
}
\examples{
# readData2("train.csv","test.csv")
}
\seealso{
\code{\link{readData}}
}

