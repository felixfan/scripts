#' Build model and predict results using different methods
#'
#' @param data output of readData or readData2. 
#' @param model methods will be used.
#' @seealso \code{\link{readData}}
#' @seealso \code{\link{readData2}}
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # bpComp(data=mydata)
bpComp <- function(data,model=c("rpart","ctree","bagging","svm","randomForest","glm")){
        mytest <- data[[1]]
        mytrain <- data[[2]]
        to <- data[[3]]
        
        models=vector()
        results=list()
        ttt=0
        
        ### rpart
        if(sum(grepl("rpart",model))>0){
                x.rp <- rpart(Class ~ ., data=mytrain, method="class")       
                x.rp.prob <- predict(x.rp, type="prob", newdata=mytest)
                x.rp.prob.rocr <- prediction(x.rp.prob[,2], mytest$Class)
                models=c(models,"rpart")
                ttt = ttt + 1
                results[[ttt]]=x.rp.prob.rocr                
        }
        
        ### ctree, party
        if(sum(grepl("ctree",model))>0){
                x.ct <- ctree(Class ~ ., data=mytrain)
                x.ct.prob <-  1- unlist(treeresponse(x.ct, mytest), use.names=F)[seq(1,nrow(mytest)*2,2)]
                x.ct.prob.rocr <- prediction(x.ct.prob, mytest$Class)
                models=c(models,"ctree") 
                ttt = ttt + 1
                results[[ttt]]=x.ct.prob.rocr
        }
        
        ### bagging, ipred
        if(sum(grepl("bagging",model))>0){
                x.ip <- bagging(Class ~ ., data=mytrain)
                x.ip.prob <- predict(x.ip, type="prob", newdata=mytest)        
                x.ip.prob.rocr <- prediction(x.ip.prob[,2], mytest$Class)
                models=c(models,"bagging")
                ttt = ttt + 1
                results[[ttt]]=x.ip.prob.rocr
        }
        
        ### SVM, e1071
        if(sum(grepl("svm",model))>0){
                x.svm <- svm(Class~., data = mytrain, probability = TRUE, kernel = "radial", type = "C")
                x.svm.prob <- predict(x.svm, type="prob", newdata=mytest, probability = TRUE)
                x.svm.prob.rocr <- prediction(attr(x.svm.prob, "probabilities")[,to], as.numeric(mytest$Class))
                models=c(models,"svm")
                ttt = ttt + 1
                results[[ttt]]=x.svm.prob.rocr
        }
        
        ### randomForest
        if(sum(grepl("randomForest",model))>0){
                x.rf <- randomForest(Class ~ ., data=mytrain)
                x.rf.prob <- predict(x.rf, newdata=mytest, type="prob")
                x.rf.prob.rocr <- prediction(x.rf.prob[,2], mytest$Class)
                models=c(models,"randomForest")
                ttt = ttt + 1
                results[[ttt]]=x.rf.prob.rocr
        }
        
        ### logistic regression
        if(sum(grepl("glm",model))>0){
                x.glm<- glm(Class ~ ., data=mytrain, family=binomial(link="logit"))
                x.glm.prob <- predict(x.glm, type="response", newdata=mytest)
                x.glm.prob.rocr <- prediction(x.glm.prob, mytest$Class)
                models=c(models,"glm")
                ttt = ttt + 1
                results[[ttt]]=x.glm.prob.rocr
        }
        temp<-list()
        temp[[1]]<-results
        temp[[2]]<-models
        return(temp)          
}
