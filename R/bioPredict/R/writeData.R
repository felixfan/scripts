#' write output (measures) to a file
#'
#' @param data output of bpSVM
#' @param output name of output file
#' @param measure measure argument of performance() function from ROCR package
#' @param digits specify the number of decimal numbers
#' @param ... further arguments to be passed to write.table
#' @seealso \code{\link{writeData}}
#' @seealso \code{\link{bpSVM}}
#' @export
#' @examples
#' # writeData(data=mydata)
writeData <- function(data, output, measure=c("acc","sens","spec","auc","phi", "err","fpr","fnr",
                                               "ppv","npv","rpp","rnp","pcfall","pcmiss"),digits=3,...){
        b=vector()
        dName=vector()
        n=length(measure)
        m=length(data[[1]])
        for(i in 1:m){
                for(j in 1:n){
                        x <- performance(data[[1]][[i]], measure[j])
                        x.areas <- slot(x, "y.values")
                        b=c(b,mean(unlist(x.areas),na.rm=TRUE))                        
                }                    
        }
        
        ttt=paste('%.',digits,'f',sep='')
	b=sprintf(ttt,b)	
        s <- matrix(data=b,nrow=m,ncol=n,byrow=TRUE)
        s <- cbind(data[[2]],s)
        s=data.frame(s)
        names(s)=c("method",measure)
        write.table(s, output,row.names = FALSE,quote = FALSE,...)
        return(s)
}