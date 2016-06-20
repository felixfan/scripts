#' Build model and predict results using bagging for classification
#'
#' @param data output of readData or readData2. 
#' @param ... further arguments to be passed to bagging
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpBagging(data=mydata)
bpBagging <- function(data, ...){      
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        x.ip <- bagging(Class ~ ., data=mytrain, ...)
        x.ip.prob <- predict(x.ip, type="prob", newdata=mytest)
        
        m.prob.rocr <- prediction(x.ip.prob[,2], mytest$Class)
        
        temp=list(list(m.prob.rocr),"bagging")
        return(temp)
}
