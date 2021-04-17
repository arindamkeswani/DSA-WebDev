Problem Statement:
Automatic news gathering from the internet

Objectives:
-Get top 5 Articles from Google News based on user query
-Get top 5 Articles from Al Jazeera based on user query
-Summarize the text of each article
-Get a comparison of the total number of words in the original article vs the summarized article
-Analyze the sentiment of the original article
-Make separate folders for Google News and Al Jazeera
-Write all the above content in a PDF file
-Put all files in the respective source folder

Technologies/Libraries/Concepts used:
-Node JS
-cheerio
-puppetteer
-text-summary
-Sentiment
-Async await
-pdfkit

=To run the code, simply open the directory of the .js file and type the following in the terminal:

node jarvis.js "Your topic of choice"

-To avoid opening Chromium tabs, set headless property to "true".
-Since CSS selectors can be dynamic, one might want to update them regularly.