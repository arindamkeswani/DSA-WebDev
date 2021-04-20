Problem Statement:
Summarizing and analyzing top 5 news articles using Puppeteer & Cheerio (Node JS)
_______________________________________________________________________________________________
Objectives:

-Get top 5 Articles from Google News based on user query

-Get top 5 Articles from Al Jazeera based on user query

-Summarize the text of each article

-Get a comparison of the total number of words in the original article vs the summarized article

-Analyze the sentiment of the original article

-Make separate folders for Google News and Al Jazeera

-Write all the above content in a PDF file

-Put all files in the respective source folder

_______________________________________________________________________________________________
Technologies/Libraries/Concepts used:

-Node JS

-cheerio

-puppetteer

-text-summary

-Sentiment

-Async await

-pdfkit

_______________________________________________________________________________________________
-To run the code, simply open the directory of the .js file and type the following in the terminal:

node jarvis.js "Your topic of choice"
_______________________________________________________________________________________________
-To avoid opening Chromium tabs, set headless property to "true".
_______________________________________________________________________________________________
-Since CSS selectors can be dynamic, one might want to update them regularly.
_______________________________________________________________________________________________
Raw folder contains random test files and hold no relevance to the main project
jarvis.js in the main file that should be run.
_______________________________________________________________________________________________
A lot of extra awaits have been added. This was for test purposes and their presence does not really affect the functioning. So feel free to ignore them.
_______________________________________________________________________________________________
Inconsistencies in one or two article retrievals per query are expected as different websites behave uniquely, therefore it is infeasible to have a common solution for each of them that works every time.
_______________________________________________________________________________________________
Project video link:

https://www.youtube.com/watch?v=0iODXmcvg9o&t=2s
