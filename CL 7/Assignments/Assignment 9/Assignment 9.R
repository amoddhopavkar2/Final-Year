library(tidyverse)
#Import Dataset
df<-read.csv("Train.csv",header = TRUE,na.strings =c(""," ","NA"))

#View the dataset
View(df)
#Check for NA
sum(is.na(df))

summary(df)

#Check the number of NA in each column
colSums(is.na(df))

#Datatype
str(df)

#Check for unique values
sapply(df,function(x)unique(x))

#Drop first column
df<-df[c(2:ncol(df))]
View(df)
unique(df$Item_Fat_Content)
unique(df$Outlet_Size)

#Calculate Mode
subset(df,df$Outlet_Size=="Small") 
subset(df,df$Outlet_Size=="Medium")
subset(df,df$Outlet_Size=="High")

#Imputation
df$Outlet_Size[which(is.na(df$Outlet_Size))]<-"Medium"
df$Item_Fat_Content[which(df$Item_Fat_Content=="LF")]<-"Low Fat"
df$Item_Fat_Content[which(df$Item_Fat_Content=="low fat")]<-"Low Fat"
df$Item_Fat_Content[which(df$Item_Fat_Content=="reg")]<-"Regular"

df$Item_Weight[which(is.na(df$Item_Weight))]<-mean(df$Item_Weight,na.rm=TRUE)

colSums(is.na(df))

#Changing to Categorical Type
df$Item_Fat_Content<-factor(df$Item_Fat_Content)
df$Outlet_Size<-factor(df$Outlet_Size)
df$Item_Type<-factor(df$Item_Type)
df$Outlet_Identifier<-factor(df$Outlet_Identifier)
df$Outlet_Location_Type<-factor(df$Outlet_Location_Type)
df$Outlet_Type<-factor(df$Outlet_Type)

str(df)

#Change to Numeric Type
df$Item_Fat_Content<-as.numeric(df$Item_Fat_Content)
df$Outlet_Size<-as.numeric(df$Outlet_Size)
df$Item_Type<-as.numeric(df$Item_Type)
df$Outlet_Identifier<-as.numeric(df$Outlet_Identifier)
df$Outlet_Location_Type<-as.numeric(df$Outlet_Location_Type)
df$Outlet_Type<-as.numeric(df$Outlet_Type)

str(df)

#Principal Component Analysis
pca <- prcomp(df, scale=TRUE) 
summary(pca)
plot(pca,type="l")

pca.var
pca.var.per

#Working of Variation 
pca.var <- pca$sdev^2
pca.var.per <- round(pca.var/sum(pca.var)*100, 1)
barplot(pca.var.per, main="Scree Plot", xlab="Principal Component", ylab="Percent Variation")
biplot(pca)

pca$x
###################
m = cov(df)
eigenV = eigen(m)
eigenV$vectors

