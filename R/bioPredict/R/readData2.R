#' Reads two files: train and test data files
#' 
#' The input files should contains a column called "Class" and one or more columns traits. 
#' An optional column "ID", The separator is 'white space' or comma.
#'
#' @param train the name of the train file which the data is to be read from. 
#' @param test the name of the test file which the data is to be read from.
#' @param csv a logical value indicating whether the file is separated by comma
#' @param header a logical value indicating whether the file contains the names of the variables as its first line.
#' @param id a logical value indicating whether the file contains a column called "ID"
#' @param controlLabel the label of controls in the "Class" column 
#' @param ... further arguments to be passed to read.table or read.csv
#' @seealso \code{\link{readData}}
#' @export
#' @examples
#' # readData2("train.csv","test.csv")
readData2 <- function(train,test,csv=TRUE,header=TRUE,id=TRUE,controlLabel="Control",...)
{
        mydata <- ''
        mydata2 <- ''
	if(csv)
	{
	        mydata <- read.csv(train, header=header)
	        mydata2 <- read.csv(test, header=header)
	} else {
	        mydata <- read.table(train, header=TRUE)
	        mydata2 <- read.table(test, header=TRUE)
	}
	# some algorithms don't like missing values, so remove rows with missing values 
	mydata <- na.omit(mydata)
	mydata2 <- na.omit(mydata2)
	# remove the unique identifier, which is useless and would confuse the machine learning algorithms 
	if(id){
	        mydata$ID <- NULL
	        mydata2$ID <- NULL               
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
        
        if(mydata2$Class[1]!="Case" && mydata2$Class[1]!="Control"){
                for (i in 1:nrow(mydata2)){
                        if(mydata2$Class[i]==controlLabel){
                                mydata2$Class[i]="Control"
                        } else {
                                mydata2$Class[i]="Case"
                        }
                }
                mydata2$Class=as.factor(mydata2$Class)
        }
        
	### trait order
	### to: trait order, case first, to=1; control first, to=2
	if(mydata2$Class[1]=="Control"){
	        to=1
	} else {
	        to=2
	}
	
	mytrain <- mydata
        mytest <- mydata2

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