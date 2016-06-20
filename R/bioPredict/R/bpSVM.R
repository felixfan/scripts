#' Build model and predict results using support vector machines
#'
#' @param data output of readData or readData2. 
#' @param kernel the kernel used in training and predicting. Valid options are linear, polynomial, radial basis, sigmoid.
#' @param type Valid options are: C-classification, nu-classification.
#' @param gamma parameter needed for all kernels except linear.
#' @param cost cost of constraints violation.
#' @param cross  k-fold cross validation on the training data.
#' @param sampling sampling scheme. If sampling = "cross", a cross-times cross validation is performed. If sampling = "boot", nboot training sets of size boot.size (part) are sampled (with replacement) from the supplied data. If sampling = "fix", a single split into training/validation set is used, the training set containing a fix part of the supplied data.
#' @param ... further arguments to be passed to svm
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpSVM(data=mydata)
bpSVM <- function(data, kernel="radial", type="C", gamma=10^(-6:1),
                  cost = 10^(-2:2), cross=10, sampling="fix", ...){     
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        mytune <- tune(svm, Class~., data = mytrain, 
                           ranges = list(gamma = gamma, cost = cost), 
                           tunecontrol = tune.control(sampling = "fix"))
        
        bestGamma <- mytune$best.parameters[[1]]
        bestC <- mytune$best.parameters[[2]]
        cat("best Gamma= ", bestGamma, "; best Cost= ", bestC, "\n")
        cat("If the tuning results are on the margin of the parameters, then widen the parameters!")
        
        mysvm <- svm(Class~., data = mytrain, cost = bestC, gamma = bestGamma, 
                     probability = TRUE, kernel = kernel, type = type, cross = cross,...)
        m.prob <- predict(mysvm, type="prob", newdata=mytest, probability = TRUE)
        
        m.prob.rocr <- prediction(attr(m.prob, "probabilities")[,to], as.numeric(mytest$Class))
        
        temp=list(list(m.prob.rocr),"svm")
        return(temp)
}
