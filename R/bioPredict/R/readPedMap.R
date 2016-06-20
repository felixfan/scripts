#' Reads PED/MAP file in PLINK format
#'
#' @param ped ped file contains training data or both training and testing data 
#' @param map map file matches the ped file
#' @param ped2 ped file contains testing data
#' @param map2 map file matches the ped2 file
#' @param prop proportion of the data will be used as training data
#' @param ... further arguments to be passed to read.table or read.table
#' @export
#' @examples
#' # readPedMap(ped="all.ped",map="all.map",prop=0.7)
#' # readPedMap(ped="train.ped",map="train.map",ped2="test.ped",map2="test.map")
readPedMap <- function(ped,map,ped2=NULL,map2=NULL,prop=0.8,...){
    myped <- read.table(ped,header=FALSE,stringsAsFactors=FALSE,colClasses = c("character"))
    mymap <- read.table(map,header=FALSE,stringsAsFactors=FALSE,colClasses = c("character"))
    m <- ncol(myped)
    n <- nrow(mymap)
    mydata <- data.frame()
    risk <- vector()
    
    results <- list()
    
    for(j in seq(7,m-1,2)){
        k <- (j - 5)/2
        risk[(mymap$V2)[k]] <- names(sort(table(c(myped[,j],myped[,j+1])))[1])
    }
    
    if(m ==  n * 2 + 6){
        for(i in 1:nrow(myped)){
            for(j in seq(7,m-1,2)){
                k <- (j - 5)/2                
                if(myped[i,j+1] == myped[i,j]){
                    if(myped[i,j] == risk[(mymap$V2)[k]]){
                        mydata[i,k] <- 2
                    }else{
                        mydata[i,k] <- 0
                    }
                }else{
                    mydata[i,k] <- 1
                }                                              
            }               
        }
    }else{
        cat("ped file and map file do not match!\n")
    }
    
    names(mydata)=mymap$V2
    mydata[,"Class"]=myped$V6
    
    rm(myped,mymap)
    
    mydata$Class=sub("1","control",mydata$Class)
    mydata$Class=sub("2","case",mydata$Class)
    
    mydata$Class=as.factor(mydata$Class)
    
    if(is.null(ped2) | is.null(map2)){
        index <- 1:nrow(mydata)
        inTrain <- sample(index, trunc(prop*length(index)))
        
        training <- mydata[inTrain,]
        testing <- mydata[-inTrain,]
        lev <- levels(testing$Class) 
        
        results[["training"]] <- training
        results[["testing"]] <- testing
        results[["levels"]] <- lev        
    }else{
        myped2 <- read.table(ped2,header=FALSE,stringsAsFactors=FALSE,colClasses = c("character"))
        mymap2 <- read.table(map2,header=FALSE,stringsAsFactors=FALSE,colClasses = c("character"))
        m <- ncol(myped2)
        n <- nrow(mymap2)
        mydata2 <- data.frame()
        
        if(m ==  n * 2 + 6){
            for(i in 1:nrow(myped2)){
                for(j in seq(7,m-1,2)){
                    k <- (j - 5)/2                    
                    if(myped2[i,j+1] == myped2[i,j]){
                        if(myped2[i,j] == risk[(mymap2$V2)[k]]){
                            mydata2[i,k] <- 2
                        }else{
                            mydata2[i,k] <- 0
                        }
                    }else{
                        mydata2[i,k] <- 1
                    }                                              
                }               
            }
        }else{
            cat("ped file and map file do not match!\n")
        }
        
        names(mydata2)=mymap2$V2
        mydata2[,"Class"]=myped2$V6
        
        rm(myped2,mymap2)
        
        mydata2$Class=sub("1","control",mydata2$Class)
        mydata2$Class=sub("2","case",mydata2$Class)
        
        mydata2$Class=as.factor(mydata2$Class)
       
        results[["training"]] <- mydata
        results[["testing"]] <- mydata2
        results[["levels"]] <- levels(mydata2$Class)    
    }
    return(results)
}
