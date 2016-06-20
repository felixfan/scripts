library(affy)
library(hgu133plus2cdf)

#setwd("/Users/nolan/Downloads/GEO/GSE5281")
#untar("GSE5281_RAW.tar", exdir="data")
#cels = list.files("data/", pattern = "cel",ignore.case=TRUE) 

ec.cels=read.table("EC.list.txt",header=FALSE)
ec.cels=paste(as.character(ec.cels[,1]),".CEL.gz",sep='')

hip.cels=read.table("HIP.list.txt",header=FALSE)
hip.cels=paste(as.character(hip.cels[,1]),".CEL.gz",sep='')

mtg.cels=read.table("MTG.list.txt",header=FALSE)
mtg.cels=paste(as.character(mtg.cels[,1]),".CEL.gz",sep='')

pc.cels=read.table("PC.list.txt",header=FALSE)
pc.cels=paste(as.character(pc.cels[,1]),".CEL.gz",sep='')

sfg.cels=read.table("SFG.list.txt",header=FALSE)
sfg.cels=paste(as.character(sfg.cels[,1]),".CEL.gz",sep='')

vcx.cels=read.table("VCX.list.txt",header=FALSE)
vcx.cels=paste(as.character(vcx.cels[,1]),".CEL.gz",sep='')

setwd("/Users/nolan/Downloads/GEO/GSE5281/data")
raw.data1=ReadAffy(verbose=FALSE, filenames=ec.cels, cdfname="hgu133plus2cdf")
raw.data2=ReadAffy(verbose=FALSE, filenames=hip.cels, cdfname="hgu133plus2cdf")
raw.data3=ReadAffy(verbose=FALSE, filenames=mtg.cels, cdfname="hgu133plus2cdf")
raw.data4=ReadAffy(verbose=FALSE, filenames=pc.cels, cdfname="hgu133plus2cdf")
raw.data5=ReadAffy(verbose=FALSE, filenames=sfg.cels, cdfname="hgu133plus2cdf")
raw.data6=ReadAffy(verbose=FALSE, filenames=vcx.cels, cdfname="hgu133plus2cdf")

# perform RMA normalization (log2) {affy} -- method 1
data.rma.norm1=rma(raw.data1)
data.rma.norm2=rma(raw.data2)
data.rma.norm3=rma(raw.data3)
data.rma.norm4=rma(raw.data4)
data.rma.norm5=rma(raw.data5)
data.rma.norm6=rma(raw.data6)

rma1=exprs(data.rma.norm1)
rma2=exprs(data.rma.norm2)
rma3=exprs(data.rma.norm3)
rma4=exprs(data.rma.norm4)
rma5=exprs(data.rma.norm5)
rma6=exprs(data.rma.norm6)

write.table(rma1, file = "ec.rma.affy.txt", quote = FALSE, sep = "\t")
write.table(rma2, file = "hip.rma.affy.txt", quote = FALSE, sep = "\t")
write.table(rma3, file = "mtg.rma.affy.txt", quote = FALSE, sep = "\t")
write.table(rma4, file = "pc.rma.affy.txt", quote = FALSE, sep = "\t")
write.table(rma5, file = "sfg.rma.affy.txt", quote = FALSE, sep = "\t")
write.table(rma6, file = "vcx.rma.affy.txt", quote = FALSE, sep = "\t")

# annotation
tt1=cbind(row.names(rma1),rma1)
colnames(tt1)=c("ProbID",sub('.cel.gz','',colnames(rma1),ignore.case = TRUE))
rownames(tt1)=NULL

tt2=cbind(row.names(rma2),rma2)
colnames(tt2)=c("ProbID",sub('.cel.gz','',colnames(rma2),ignore.case = TRUE))
rownames(tt2)=NULL

tt3=cbind(row.names(rma3),rma3)
colnames(tt3)=c("ProbID",sub('.cel.gz','',colnames(rma3),ignore.case = TRUE))
rownames(tt3)=NULL

tt4=cbind(row.names(rma4),rma4)
colnames(tt4)=c("ProbID",sub('.cel.gz','',colnames(rma4),ignore.case = TRUE))
rownames(tt4)=NULL

tt5=cbind(row.names(rma5),rma5)
colnames(tt5)=c("ProbID",sub('.cel.gz','',colnames(rma5),ignore.case = TRUE))
rownames(tt5)=NULL

tt6=cbind(row.names(rma6),rma6)
colnames(tt6)=c("ProbID",sub('.cel.gz','',colnames(rma6),ignore.case = TRUE))
rownames(tt6)=NULL

require(RCurl)
myURL <- getURL("https://dl.dropboxusercontent.com/u/8272421/geo/HGU133Plus2.na33.txt", ssl.verifypeer = FALSE)  
annot <- read.table(textConnection(myURL),header=TRUE,sep='\t')

# probe sets were mapped to Entrez Gene IDs. 
comb.1=merge(annot,tt1,by.x="ProbeSetID",by.y="ProbID")
comb.2=merge(annot,tt2,by.x="ProbeSetID",by.y="ProbID")
comb.3=merge(annot,tt3,by.x="ProbeSetID",by.y="ProbID")
comb.4=merge(annot,tt4,by.x="ProbeSetID",by.y="ProbID")
comb.5=merge(annot,tt5,by.x="ProbeSetID",by.y="ProbID")
comb.6=merge(annot,tt6,by.x="ProbeSetID",by.y="ProbID")

write.table(comb.1, file = "ec.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)
write.table(comb.2, file = "hip.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)
write.table(comb.3, file = "mtg.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)
write.table(comb.4, file = "pc.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)
write.table(comb.5, file = "sfg.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)
write.table(comb.6, file = "vcx.comb.txt", quote = FALSE, sep = "\t",row.names=FALSE)

# If multiple probe sets corresponded to the same gene, 
# then the expression values of these probe sets were averaged.
comb2 <- NULL
out <- NULL
comb2 <- subset(comb.1,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.EC.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)

out <- NULL
comb2 <- NULL
comb2 <- subset(comb.2,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.HIP.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)

out <- NULL
comb2 <- NULL
comb2 <- subset(comb.3,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.MTG.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)

out <- NULL
comb2 <- NULL
comb2 <- subset(comb.4,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.PC.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)

out <- NULL
comb2 <- NULL
comb2 <- subset(comb.5,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.SFG.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)

out <- NULL
comb2 <- NULL
comb2 <- subset(comb.6,select=-c(ProbeSetID))
comb2 <- data.frame(lapply(comb2, as.character),stringsAsFactors=FALSE)
comb2 <- data.frame(lapply(comb2, as.numeric),stringsAsFactors=FALSE)
out <- aggregate(. ~ EntrezGene, data = comb2, mean)
out=format(out, digits=5)
write.table(out, file = "GSE5281.VCX.rma.affy.txt", quote = FALSE, sep = "\t",row.names=FALSE)
