View(DATA11)
Family.freq<-(table(DATA11[,1]))
Family.freq

View(DATA11_table)
Family.freq<-(table(DATA11_table[,1]))
Family.freq
#C:\Users\Stell\OneDrive\文档\PSDA PROJECT1\DATA11.xlsx
#~/PSDA PROJECT1/DATA11.xlsx

library(plotrix)
pie3D(main='Factor Motivated UTM Student to Adopt Healthy Lifestyle',DATA11_table$Frequency,labels=DATA11_table$`Which factor can motivate you to adopt a healthy lifestyle?  `,
    col=c("midnightblue","royalblue","steelblue","skyblue","lightcyan"),explode=0.1,)

library(plotrix)

x= c(27,18,12,3,5)
pct=c('41.54%','27.69%','18.46%','4.62%','7.69%')
labels=c('Family','Peer','Social Media','School','Others')
colors=c("midnightblue","royalblue","steelblue","skyblue","lightcyan")

png(file="data11.png",width=850,height=500)

pie3D(x,labels=paste(labels,pct),explode=0.1,height=0.05,main="Factors Motivating UTM Students to Adopt a Healthy Lifestyle",col=colors)

dev.off()

View(DATA12)
Family.freq<-(table(DATA12[,1]))
Family.freq

View(DATA12_table)
Family.freq<-(table(DATA12_table[,1]))
Family.freq

count<-c(12,13,13,13,9,1,1,2,1)
name<-c("0","1","2","3","4","5","6","7","16")
dotchart(count,
         labels = name,
         main = "Average Weekly Servings of Fruits",
         xlab="Frequency",
         xlim=c(0,14),
         ylab="Number of fruits"
)


num<-c(0,0,0, 0,0,0,0, 0,0,0, 0, 0,1,1, 1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4, 5,6,7, 7,16)
mean(num)
unique.value <-unique(num)
unique.match<- match(num,unique.value)
unique.freq<- tabulate(unique.match)
unique.max<- which.max(unique.freq)
num_mode<-unique.value[unique.max]

num_mode

mean(num)
median(num)
mean(num)

View(DATA13)
Family.freq<-(table(DATA13[,1]))
Family.freq

View(DATA13_table)
Family.freq<-(table(DATA13_table[,1]))
Family.freq

# Sample data
data <- c(24, 21,18,2)


# Create a histogram with custom parameters
hist(data,
     breaks =5,  # Number of bins
     col = "skyblue",  # Color of bars
     border = "darkblue",  # Border color of bars
     main = "Histogram of Daily Water Consumption ",  # Main title
     xlab = "Water Consumption(ml)",  # Label for the x-axis
     ylab = "Frequency",
     xlim = c(0,2000),
     ylim = c(0,24))  # Label for the y-axis


# Create a data frame with the provided data
consumption_data <- data.frame(
  Amount = c("Below 500", "500-1000","1000-1500", "Above 1500" ),
  Count = c(2, 21, 24, 18)
)

# Create a bar plot
barplot(consumption_data$Count, 
        names.arg = consumption_data$Amount, 
        col = c("palegreen","dodgerblue","plum","hotpink"), 
        main = 'Daily Water Consumption',
        xlab = "Amount of Water Consumed (mL)",
        ylab = "Frequency",
        ylim = c(0, max(consumption_data$Count) * 1.2),  # Set ylim for better visualization
        border = "black", 
        space = 0.5, 
        font.main = 1)

