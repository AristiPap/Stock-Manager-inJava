# Stock-Manager
Stock-Manager is an app, developed in java,that helps the user organise his stocks in one place and keep track
of their earnings through descriptive charts!

## Prerequisities
-	[JFreeChart 1.0.19](https://sourceforge.net/projects/jfreechart/files/1.%20JFreeChart/1.0.19/)
  >>After you have downloaded the JFreeChart,open the zip folder.Go to the lib folder and choose all the files contained
    .Then create a project in your editor but on the project categories choose Java with Ant and not Maven as it's much
      easier to setup your libray.Finally,on the Library section of the project,click right and choose Add JAR/Folder,and
      copy all the files from the lib file as said above.

## Download 

```bash
~$ git clone https://github.com/AristiPap/Stock-Manager-inJava 
```
## Description
In detail,the sourcecode files have the following use:
  
  ~>Interface:Helps the user signIn/signUp on the app either by searching his username on the list of users(seen in the
   UserRecords file)and confirming his existance on the "database".If the user chooses to signUp then we create a new user 
   and add him to the list with the rest of the users.Furthermore interface adds the stock of the user to his account
   
  ~>UserRecords:Contains a list of the users of the Stock-Manager.(As we can see on the source code,in the constructor we  
                create 3 individual users with no stocks,just to add history of users to the app)
                
  ~>User: Contains a list of the user's Stocks and initialises each user with his features(username,password)
  
  ~>StockCharacteristics: In the constructor with the String parameter we actually add a new Stock to the user's list.
                         Each stock also has an integer list that contains the diffrenet values the stock gets throughout a  
                         short period of time.So what the app does is add/subtract all these random values and get a 
                         variance of the cost of the stock.(this feature will help with the Line chart)
  
  ~>PieChartExample/LineChartExample: using functions from the JFreeChart we create a dataset(PieChart-> takes the final
                                    "cost" of the stock and divides it by the total earnings of the user so that we get the
                                     percentage of the partial gains from this stock.
                                     LineChart->takes the aliquot of the stock's cost from the Cost(integer list) and then 
                                     creates the graph)
  
  ~>Main: Creates the history of users for the app.Then calls the createInterface function,and creates the    
         PieChart/LineChart.
         Finally there is a function called HelpSell that compares the initial cost of the stock with the final (after the
         variances descibed above)and if the initailcost is lower then the program deletes that stock from the list of stocks
         of the user(sells the stock) else justs prints a message that it's not wise to sell ,as the stock is lucrative.
