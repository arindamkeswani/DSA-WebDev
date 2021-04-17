let puppeteer = require("puppeteer");
let fs = require("fs");
let url = "https://news.google.com/"; //link to the first news source
let url2 = "https://www.aljazeera.com/"; //link to the second news source
let query = process.argv[2]; //stores the user-entered search query

let request=require("request");
let cheerio=require("cheerio");

let path=require('path');
let PDFDocument= require('pdfkit');

var summarize = require("text-summary");
var os = require("os");

var Sentiment = require('sentiment');


(async function () {
    try {
        let browserInstance = await puppeteer.launch({ //launch the browser
            headless: false, //will open the browser. Setting it to "true" will only use the back-end
            defaultViewport: null, 
            args: ["--start-maximized"] //open the window to full size
        });
        await getLinksFromAlJ(url2, browserInstance, query, os, Sentiment); //function to store content from Al Jazeera
        await getLinksFromGoogle(url, browserInstance, query, os, Sentiment); //function to store content from Google news
        


    } catch (err) {
        console.log(err);
    }
})();



async function getLinksFromGoogle(link, browserInstance, query, os, Sentiment) { //async function is used
    let newTab = await browserInstance.newPage(); //open a new tab
    await newTab.setDefaultNavigationTimeout(0);  //this will wait for the page to load indefinitely. Use this with precaution.
    await newTab.goto(link); //go to the source
    await newTab.type("input[type='text'][aria-label='Search']", query, { delay: 100 }); //Enter search terms
    await newTab.keyboard.press('Enter'); 
    await newTab.waitFor(2000);
    let url = await newTab.url(); //get url of the search results page
   
    request(url, cb)

    
    async function cb(error, response, html){
        if(error){
            console.log(error);
        }
        else{
            await printTopArtName(html,browserInstance,query, os, Sentiment); //this will get the top 5 article links (Google) and call for their processing
        }
    }
}



async function printTopArtName(html,browserInstance,query, os, Sentiment){
    var os = require("os");
    let selectorTool= cheerio.load(html); //load html of the search results web page
    let newsArray=  selectorTool(".ipQwMb.ekueJc.RD0gLb a"); //selector for articles. May be dynamic so keep updating
    
    let linkArray = []  //store top 5 article links
    for(let i=0;i<5;i++){
        let link =selectorTool(newsArray[i]).attr("href"); //retrieve link for each article
        let heading =selectorTool(newsArray[i]).text(); //retrieve Title for each article
        
        let fulllink= await "https://www.news.google.com"+link.substring(1,);

        
        linkArray.push({fulllink,heading}) //push both into the array
        
    }
    await console.log("Top 5 links retrieved");
    // console.log(linkArray[0]["heading"]); //retrieve heading at index 0
    let ans= "";
    for(let i=0;i<linkArray.length;i++){
        //formatting of the returned output
        ans= ans+ (i+1)+".";
        ans= ans+"\n\nTitle: " + linkArray[i]["heading"];
        ans= ans+"\n\nSource: " + linkArray[i]["fulllink"];
        var singleContent = await getSum(linkArray[i]["fulllink"], browserInstance,os, Sentiment);
        ans+="\n\n"+singleContent;

        console.log("Article",i+1,"fetched (Google)"); //Display message on the console, signalling completion of that article's processing
    }
   
    await console.log("Completed"); //Signalling completion of the news source
    await console.log(ans); //print to check if the output is proper

    await createOP(ans,"Google News",query); //create PDF File, the appropriate folder, with the appropriate file name
    
}




async function getLinksFromAlJ(link, browserInstance, query, os, Sentiment) {
    let newTab = await browserInstance.newPage(); //open a new tab
    await newTab.setDefaultNavigationTimeout(0); //this will wait for the page to load indefinitely. Use this with precaution.
    await newTab.goto(link); //go to the source
    await newTab.waitFor(15000); //deliberately waiting for the selectors to load
    await newTab.click(".icon.icon--search"); //click of search button
    // await newTab.waitFor(200);
    await newTab.waitForSelector("input[type='search']");  //wait for search bar
    await newTab.type("input[type='search']", query, { delay: 100 }); ///type query
    await newTab.keyboard.press('Enter');
    await newTab.waitFor(2000);
    let url = await newTab.url(); //get url of the search results page
   
    request(url, cb)

    
    async function cb(error, response, html){
        if(error){
            console.log(error);
        }
        else{
            // console.log(html);
            await printTopArtAlj(html,browserInstance,query, os, Sentiment); //this will get the top 5 article links (Al Jazeera) and call for their processing
        }
    }
}



async function printTopArtAlj(html,browserInstance,query, os, Sentiment){
    var os = require("os");
    let selectorTool= cheerio.load(html); //load html of the search results web page
    let newsArray=  selectorTool(".gc__title a"); //selector for articles. May be dynamic so keep updating
    //REST OF THE FUNCTION IS SIMILAR TO printTopArtName()
    let linkArray = []
    for(let i=0;i<5;i++){
        let link =selectorTool(newsArray[i]).attr("href");
        let heading =selectorTool(newsArray[i]).text();
        
        let fulllink= await link;

        
        linkArray.push({fulllink,heading})
        
    }
    await console.log("Top 5 links retrieved");
    // console.log(linkArray[0]["heading"]); //retieve heading at index 0
    
    let ans= "";
    for(let i=0;i<linkArray.length;i++){
        // let ans_temp = await getSum(linkArray[i],browserInstance);
        // ans+=await ans+ ans_temp;
        ans= ans+ (i+1)+".";
        ans= ans+"\n\nTitle: " + linkArray[i]["heading"];
        ans= ans+"\n\nSource: " + linkArray[i]["fulllink"];
        var singleContent = await getSum(linkArray[i]["fulllink"], browserInstance,os, Sentiment); //pass each article link for processing
        ans+="\n\n"+singleContent;

        console.log("Article",i+1,"fetched (Al Jazeera)");
    }
   
    await console.log("Completed");
    await console.log(ans);

    await createOP(ans,"AlJazeera",query);
    return ans;
}




async function getSum(url,browserInstance, os,Sentiment){ //summarizes the text from the article, gives its sentiment, and returns it
    
    
    var sentiment = new Sentiment();
    try{
        var summarize = await require("text-summary");  //this library will summarize the text 
        let newP = await browserInstance.newPage(); //open article on a new tab
        await newP.setDefaultNavigationTimeout(0);  
        await newP.goto(url);
        // await newP.waitForNavigation({waitUntil:"domcontentloaded"}); ////////REJECTED APPROACH
        await newP.waitForSelector("p", 0);
        // await Promise.all([   ////////REJECTED APPROACH
        //     newP.waitForNavigation({waitUntil:"domcontentloaded"}), // The promise resolves after navigation has finished
        //     newP.goto(url), // Clicking the link will indirectly cause a navigation
        //   ]);
        
        
        // await newP.waitFor(15000);
        
        async function consoleFn(sel,os) {
            // var os = require("os");
            let t = await document.querySelectorAll(sel);
            
            // let PName = document.querySelectorAll(pNameSelector);
            let details=""
            // let details = [];
            if(t!=undefined){
                for (let i = 0; i < t.length; i++) {
                    let text = await t[i].innerText;
                    
                details = await details + text+ os.EOL;
                }
                return details;
            }
            else{
                return "Cannot to retrieve data from",url,"\n\n_____________________________________________________\n\n";
            }
            
            
        }

        // let artText = newP.evaluate(consoleFn,"p")
        // console.log(artText);
        let artText =await newP.evaluate(consoleFn,"p",os) //evaluate the page

        var sent = await sentiment.analyze(artText); //get sentiment value from sentiment library

        let noOfWordsOrig = await artText.split(" ").length; //get number of words from the original article

        var numberSentences = await 10; //number of sentences that we want the article summarized to
        var summary = await summarize.summary(artText, numberSentences); //get summary

        
        let noOfWordsSum = summary.split(" ").length; //get number of words from the summarized article

        //format the output
        summary=await summary + "\n\nNumber of words in the original article: "+noOfWordsOrig;
        summary=await summary + "\n\nNumber of words in the summarized article: "+noOfWordsSum;
        summary=await summary + "\n\nSentiment (less than 0 for negative, more than 0 for positive): "+sent.score;
        
        summary+="\n\n_____________________________________________________\n\n";
        
        return await summary; //return value of the processed text

    }catch(err){
        console.log(err);
        // return "Unable to retrieve data, but here's the link!--> "+ url+"\n\n_____________________________________________________\n\n";
        return "Unable to retrieve data from this source, please visit the link to view the complete article."
    }
    
    
}

async function createOP(ans,fold,query){
    let pathFolder= await path.join(__dirname,fold);
    if(fs.existsSync(pathFolder)==false){ //check if folder exists
        fs.mkdirSync(pathFolder); //if folder does not exist, create it
    }

    let filePath = path.join(__dirname,fold, query+".pdf"); 
    let pdfDoc = new PDFDocument;
    pdfDoc.pipe(fs.createWriteStream(filePath)); //create new file
    pdfDoc.text(ans); //add content to the PDF file
    pdfDoc.end();

}



////////////////////////////////////////////////////ROUGH SPACE////////////////////////////////////////////////////
//SUMMARIZE THE TEXT
// 


// var text = "Robert John Downey Jr. (born April 4, 1965)[8] is an American actor and producer. His career has been characterized by critical and popular success in his youth, followed by a period of substance abuse and legal troubles, before a resurgence of commercial success in middle age. In 2008, Downey was named by Time magazine among the 100 most influential people in the world,[9][10] and from 2013 to 2015, he was listed by Forbes as Hollywood's highest-paid actor.[9][11]At the age of five, he made his acting debut in Robert Downey Sr.'s film Pound in 1970. He subsequently worked with the Brat Pack in the teen films Weird Science (1985) and Less Than Zero (1987). In 1992, Downey portrayed the title character in the biopic Chaplin, for which he was nominated for the Academy Award for Best Actor and won a BAFTA Award. Following a stint at the Corcoran Substance Abuse Treatment Facility on drug charges, he joined the TV series Ally McBeal, for which he won a Golden Globe Award. He was fired from the show in the wake of drug charges in 2000 and 2001. He stayed in a court-ordered drug treatment program and has maintained his sobriety since 2003. Initially, bond completion companies would not insure Downey, until Mel Gibson paid the insurance bond for the 2003 film The Singing Detective.[12] He went on to star in the black comedy Kiss Kiss Bang Bang (2005), the thriller Zodiac (2007), and the action comedy Tropic Thunder (2008); for the latter he was nominated for an Academy Award for Best Supporting Actor. Downey gained global recognition for starring as Tony Stark / Iron Man in ten films within the Marvel Cinematic Universe, beginning with Iron Man (2008). He has also played the title character in Guy Ritchie's Sherlock Holmes (2009), which earned him his second Golden Globe, and its sequel, Sherlock Holmes: A Game of Shadows (2011)."
// var numberSentences = 5;
// // var question = "What is the age?";

// var summary = summarize.summary(text, numberSentences);

// // var summaryWithQuestion = summarize.summaryWithQuestion(question, text, numberSentences);

// var Res=summary.split(".");
// for(let i=0;i<Res.length;i++){
//     console.log(Res[i]);
// }


