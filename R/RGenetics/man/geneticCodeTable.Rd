\name{geneticCodeTable}
\alias{geneticCodeTable}
\title{Genetic Code Table}
\usage{
  geneticCodeTable(DNA = TRUE)
}
\arguments{
  \item{DNA}{if 'TRUE', DNA code will be used, else, 'RNA'
  code will be used. Default is 'TRUE'}
}
\description{
  DNA Genetic Code Table
}
\examples{
geneticCodeTable()
geneticCodeTable(DNA=FALSE)
}
\seealso{
  \code{\link{codonToAAone}}

  \code{\link{codonToAAthree}}

  \code{\link{codonToAAoneRNA}}

  \code{\link{codonToAAthreeRNA}}
}

