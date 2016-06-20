#' Build model and predict results using conditional inference trees
#'
#' @param data output of readData or readData2. 
#' @param ... further arguments to be passed to ctree
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpCtree(data=mydata)
bpCtree <- function(data, ...){     
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        x.ct <- ctree(Class ~ ., data=mytrain, ...)
        x.ct.pred <- predict(x.ct, newdata=mytest)
        x.ct.prob <-  1- unlist(treeresponse(x.ct, mytest), use.names=F)[seq(1,nrow(mytest)*2,2)]
        
        m.prob.rocr <- prediction(x.ct.prob, mytest$Class)
        
        temp=list(list(m.prob.rocr),"ctree")
        return(temp)
}
