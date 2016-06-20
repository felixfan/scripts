#' Build model and predict results using logistic regression
#'
#' @param data output of readData or readData2. 
#' @param ... further arguments to be passed to glm
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpLogisticRegression(data=mydata)
bpLogisticRegression <- function(data, ...){        
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        x.glm<- glm(Class ~ ., data=mytrain, family=binomial(link="logit"), ...)
        x.glm.prob <- predict(x.glm, type="response", newdata=mytest)
        
        m.prob.rocr <- prediction(x.glm.prob, mytest$Class)
        
        temp=list(list(m.prob.rocr),"glm")
        return(temp)
}
