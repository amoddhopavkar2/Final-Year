#import library
library(arules)
library(tidyverse)
library(arulesViz)


#Read transaction
df<-read.transactions("/Users/amoddhopavkar2/Downloads/groceries.csv",sep=",")

#View Transaction
inspect(df[1:5])

#summarize whole data set
summary(df)

#Frequency plot of top 10 items
itemFrequencyPlot(df,topN=10,type="absolute")

# Get the rules
rules = apriori(df, parameter = list(supp = 0.03, conf = 0.3))

#Summarize the rules
summary(rules)

#Print the rules
inspect(rules)

#Sort the rules by confidence
rules = sort(rules, by = "confidence")
options(digits = 2)
inspect(rules)

#Inspect the reduntant rules
rules[is.redundant(rules)]
#if redundancy rules<-rules[!is.reduntant(rules)]

#plot the graphs for the rules
#plot(rules, method = "graph", engine = "interactive")
plot(rules, method = "paracoord")
plot(rules, method = "matrix", control = list(reorder = "none"))
