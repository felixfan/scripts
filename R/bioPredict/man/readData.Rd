\name{readData}
\alias{readData}
\title{Reads a file: one file contains both train and test data}
\usage{
readData(file, prop = 1/3, csv = TRUE, header = TRUE, id = TRUE,
  controlLabel = "Control", seeds = NULL, ...)
}
\arguments{
  \item{file}{the name of the file which the data is to be
  read from.}

  \item{prop}{proportion of the data will be used as test
  data}

  \item{csv}{a logical value indicating whether the file is
  separated by comma}

  \item{header}{a logical value indicating whether the file
  contains the names of the variables as its first line.}

  \item{id}{a logical value indicating whether the file
  contains a column called "ID"}

  \item{controlLabel}{the label of controls in the "Class"
  column}

  \item{seeds}{random seed}

  \item{...}{further arguments to be passed to read.table
  or read.csv}
}
\description{
The input file should contains a column called "Class" and
one or more columns traits. An optional column "ID", The
separator is 'white space' or comma.
}
\examples{
# readData("data.csv")
}
\seealso{
\code{\link{readData2}}
}

