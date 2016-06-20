#' plot ROC Curve
#'
#' @param data output of bpComp
#' @param output name of the plot.
#' @param format plot format, can be "png","pdf","jpeg","bmp","postscript","tiff".
#' @param width the width of the device.
#' @param height the height of the device.
#' @param units The units in which height and width are given. Can be px (pixels), in (inches), cm or mm.
#' @param lty The line type. Line types can either be specified as an integer (0=blank, 1=solid (default), 2=dashed, 3=dotted, 4=dotdash, 5=longdash, 6=twodash)
#' @param col A specification for the plotting color.
#' @param lwd The line width, a positive number, defaulting to 1.
#' @param cex A numerical value giving the amount by which plotting text and symbols should be magnified relative to the default.
#' @param ... further arguments to be passed to plot
#' @seealso \code{\link{bpComp}}
#' @seealso \code{\link{plotData}}
#' @export
#' @examples
#' # plotData(data=mydata,output="test.png")
plotData <- function(data, output, format=c("png","pdf","jpeg","bmp","postscript","tiff"),
                     width=700, height=700, units="px",lty=3,col=1,lwd=2,cex=1.2,...){
        format <- match.arg(format)      
        if(format == "png"){
                if(! grepl(".png$",output,ignore.case = TRUE, perl = TRUE)){
                      output <- paste(output,".png",sep="")  
                }
                png(filename = output, width=width, height = height, units = units)
        }else if(format == "pdf"){
                if(! grepl(".pdf$",output,ignore.case = TRUE, perl = TRUE)){
                        output <- paste(output,".pdf",sep="")  
                }
                pdf(output)
        }else if(format == "jpeg"){
                if(! grepl(".jpe?g$",output,ignore.case = TRUE, perl = TRUE)){
                        output <- paste(output,".jpeg",sep="")  
                }
                jpeg(filename = output, width=width, height = height, units = units)
        }else if(format == "bmp"){
                if(! grepl(".bmp$",output,ignore.case = TRUE, perl = TRUE)){
                        output <- paste(output,".bmp",sep="")  
                }
                bmp(filename = output, width=width, height = height, units = units)
        }else if(format == "postscript"){
                if(! grepl(".ps$",output,ignore.case = TRUE, perl = TRUE)){
                        output <- paste(output,".ps",sep="")  
                }
                postscript(output)
        }else if(format == "tiff"){
                if(! grepl(".tiff$",output,ignore.case = TRUE, perl = TRUE)){
                        output <- paste(output,".tiff",sep="")  
                }
                tiff(filename = output, width=width, height = height, units = units)
        }
        
        n <- length(data[[1]])
        
        if(length(col) < n){
                col = rep(col, length.out=n)
        }
        if(length(lty) < n){
                lty = rep(lty, length.out=n)                
        }
        
        if(n==1){
                perf <- performance(data[[1]][[1]], "tpr","fpr")
                plot(perf, main="ROC curve", lty=lty[1],col=col[1],lwd=2,cex=1.2,...)
                auc <- performance(data[[1]][[1]], "auc")
                auc.areas <- slot(auc, "y.values")
                curve.area <- mean(unlist(auc.areas))
                mtext(sprintf("%s%1.4f", "Area under Curve = ", curve.area), side=3, line=0, cex=0.8)
                dev.off()
        }else if(n > 1){
                perf <- performance(data[[1]][[1]], "tpr","fpr")
                plot(perf, col=col[1], main="ROC curves", lty=lty[1],lwd=2,cex=1.2,...)
                
                for(i in 2:n){
                        perf <- performance(data[[1]][[i]], "tpr","fpr")
                        plot(perf, col=col[i], lty=lty[i],lwd=2,cex=1.2, add=TRUE)                        
                }
                legend("bottomright", legend=data[[2]], col=col,lty=lty,lwd=2,cex=1.2,...)
                dev.off()
        }      
}