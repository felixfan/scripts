library(affy)
library(hgu133acdf)

setwd("/Users/nolan/Downloads/GEO/GSE1297")
untar("GSE1297_RAW.tar", exdir="data")
cels = list.files("data/", pattern = "cel") 

setwd("/Users/nolan/Downloads/GEO/GSE1297/data")
raw.data=ReadAffy(verbose=FALSE, filenames=cels, cdfname="hgu133acdf")

# perform RMA normalization (log2) {affy} -- method 1
data.rma.norm=rma(raw.data)
rma=exprs(data.rma.norm)
write.table(rma, file = "rma.affy.txt", quote = FALSE, sep = "\t")

# annotation
tt=cbind(row.names(rma),rma)
colnames(tt)=c("ProbID",sub('.cel.gz','',colnames(rma),ignore.case = TRUE))
rownames(tt)=NULL
tt[1:5,1:5]

require(RCurl)
myURL <- getURL("https://dl.dropboxusercontent.com/u/8272421/geo/HGU133A.na33.txt", ssl.verifypeer = FALSE)  
annot <- read.table(textConnection(myURL),header=TRUE,sep='\t')

# probe sets were mapped to Entrez Gene IDs. 
comb=merge(annot,tt,by.x="ProbeSetID",by.y="ProbID")
write.table(comb, file = "comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)

# If multiple probe sets corresponded to the same gene, 
# then the expression values of these probe sets were averaged.
comb2 <- subset(comb,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)

# Format values to 5 decimal places
out=format(out, digits=5)
write.table(out, file = "GSE1297.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)
