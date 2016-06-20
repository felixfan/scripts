#' Build model and predict results using random forest
#'
#' @param data output of readData or readData2. 
#' @param ... further arguments to be passed to randomForest
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpRandomForest(data=mydata)
bpRandomForest <- function(data, ...){       
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        x.rf <- randomForest(Class ~ ., data=mytrain, ...)
        x.rf.prob <- predict(x.rf, newdata=mytest, type="prob")
        
        m.prob.rocr <- prediction(x.rf.prob[,2], mytest$Class)
        
        temp=list(list(m.prob.rocr),"randomForest")
        return(temp)
}
