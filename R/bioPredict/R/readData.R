#' Reads a file: one file contains both train and test data
#' 
#' The input file should contains a column called "Class" and one or more columns traits. 
#' An optional column "ID", The separator is 'white space' or comma.
#'
#' @param file the name of the file which the data is to be read from. 
#' @param prop proportion of the data will be used as test data
#' @param csv a logical value indicating whether the file is separated by comma
#' @param header a logical value indicating whether the file contains the names of the variables as its first line.
#' @param id a logical value indicating whether the file contains a column called "ID"
#' @param controlLabel the label of controls in the "Class" column 
#' @param seeds random seed
#' @param ... further arguments to be passed to read.table or read.csv
#' @seealso \code{\link{readData2}}
#' @export
#' @examples
#' # readData("data.csv")
readData <- function(file, prop=1/3, csv=TRUE, header=TRUE,id=TRUE,controlLabel="Control",seeds=NULL,...)
{
        mydata <- ''
	if(csv)
	{
	        mydata <- read.csv(file, header=header,...)
	} else {
	        mydata <- read.table(file, header=header,...)
	}
	# some algorithms don't like missing values, so remove rows with missing values 
	mydata <- na.omit(mydata)
	# remove the unique identifier, which is useless and would confuse the machine learning algorithms 
	if(id){
                mydata$ID <- NULL   
	}
        
	# trait format
	if(mydata$Class[1]!="Case" && mydata$Class[1]!="Control"){
		for (i in 1:nrow(mydata)){
			if(mydata$Class[i]==controlLabel){
			        mydata$Class[i]="Control"
			} else {
			        mydata$Class[i]="Case"
			}
		}
		mydata$Class=as.factor(mydata$Class)
	}

	### trait order
	### to: trait order, case first, to=1; control first, to=2
	if(mydata$Class[1]=="Control"){
	        to=1
	}else{
	        to=2        
	}
	 
	### random sampling prop as test and 1 - prop as train
	index <- 1:nrow(mydata)
        if(! is.null(seeds)){
                set.seed(seeds)
        }
	testindex <- sample(index, trunc(length(index) * prop))
	mytest <- mydata[testindex,]
	mytrain <- mydata[-testindex,]

	### print stat
	cat(ncol(mytrain)-1, "traits were used to build the model\n")
	cat(nrow(mytrain), "individuals were used to train the model\n")
        cat(nrow(mytrain[which(mytrain$Class == "Case"),]), "individuals in train dataset are cases\n")
        cat(nrow(mytrain[which(mytrain$Class == "Control"),]),"individuals in train dataset are controls\n")
	cat(nrow(mytest), "individuals were used to test the model\n")
	cat(nrow(mytest[which(mytest$Class == "Case"),]), "individuals in test dataset are cases\n")
	cat(nrow(mytest[which(mytest$Class == "Control"),]),"individuals in test dataset are controls\n")
        
	### return
	temp<-list()
        temp[[1]]<-mytest
        temp[[2]]<-mytrain
	temp[[3]]<-to
        return(temp)
}