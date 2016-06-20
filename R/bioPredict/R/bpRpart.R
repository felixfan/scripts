#' Build model and predict results using recursive partitioning and regression trees
#'
#' @param data output of readData or readData2. 
#' @param method one of "anova", "poisson", "class" or "exp".
#' @param ... further arguments to be passed to rpart
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpRpart(data=mydata)
bpRpart <- function(data, method="class", ...){        
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        x.rp <- rpart(Class ~ ., data=mytrain, method="class",...)
        x.rp.pred <- predict(x.rp, type="class", newdata=mytest)
        x.rp.prob <- predict(x.rp, type="prob", newdata=mytest)
        
        m.prob.rocr <- prediction(x.rp.prob[,2], mytest$Class)
        
        temp=list(list(m.prob.rocr),"rpart")
        return(temp)
}
