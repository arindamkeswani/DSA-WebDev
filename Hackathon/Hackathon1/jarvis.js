let puppeteer = require("puppeteer");
let fs = require("fs");
let url = "https://news.google.com/";
let query = process.argv[2];

let request=require("request");
let cheerio=require("cheerio");

let path=require('path');
let PDFDocument= require('pdfkit');

var summarize = require("text-summary");

(async function () {
    try {
        let browserInstance = await puppeteer.launch({
            headless: false,
            defaultViewport: null,
            args: ["--start-maximized"]
        });
        let fullSum = await getLinksFromGoogle(url, browserInstance, query);

        // await console.log(fullSum);
        // await getSum(fullSum[0],browserInstance);
        // await getSum(fullSum[1],browserInstance);
        // await getSum(fullSum[2],browserInstance);
        // await getSum(fullSum[3],browserInstance);
        // await getSum(fullSum[4],browserInstance);
        // await getSum(fullSum[5],browserInstance);
        // await getSum(fullSum[6],browserInstance);
        // await getSum(fullSum[7],browserInstance);
        // await getSum(fullSum[8],browserInstance);
        // await getSum(fullSum[9],browserInstance);


    } catch (err) {
        console.log(err);
    }
})();



async function getLinksFromGoogle(link, browserInstance, query) {
    let newTab = await browserInstance.newPage();
    await newTab.setDefaultNavigationTimeout(0); 
    await newTab.goto(link);
    await newTab.type("input[type='text'][aria-label='Search']", query, { delay: 100 });
    await newTab.keyboard.press('Enter');
    await newTab.waitFor(2000);
    let url = await newTab.url();
   
    request(url, cb)

    
    async function cb(error, response, html){
        if(error){
            console.log(error);
        }
        else{
            // console.log(html);
            await printTopArtName(html,browserInstance,query);
        }
    }
}



async function printTopArtName(html,browserInstance,query){
    let selectorTool= cheerio.load(html);
    let newsArray=  selectorTool(".ipQwMb.ekueJc.RD0gLb a");
    // console.log(newsArray);
    // for(let i=0;i<newsArray.length;i++){
    let linkArray = []
    for(let i=0;i<5;i++){
        let link =selectorTool(newsArray[i]).attr("href");
        let heading =selectorTool(newsArray[i]).text();
        
        let fulllink= await "https://www.news.google.com"+link.substring(1,);

        // processArtPage(fulllink);
        // getSum(fulllink, browserInstance);
        linkArray.push({fulllink,heading})
        // console.log(fulllink);
    }
    
    // console.log(linkArray[0]["heading"]); //retieve heading at index 0
    let ans= "";
    for(let i=0;i<linkArray.length;i++){
        // let ans_temp = await getSum(linkArray[i],browserInstance);
        // ans+=await ans+ ans_temp;
        ans= ans+ (i+1);
        ans= ans+ "\n\nTitle: " + linkArray[i]["heading"];
        ans= ans+ "\n\nSource: " + linkArray[i]["fulllink"];
        var singleContent = await getSum(linkArray[i]["fulllink"], browserInstance);
        ans+="\n\n"+singleContent;

        console.log("Article",i+1,"fetchecd");
    }
   
    await console.log("Completed");
    await console.log(ans);

    await createOP(ans,query);
    // return ans;
}

// function processArtPage(url){
//     request(url,cb);
//     function cb(err,resp, html){
//         if(err){
//             console.log(err);
//         }else{
//             getSum(html);
//         }
//     }
// }

async function getSum(url,browserInstance){
    // let selTool = cheerio.load(html);
    // let artContent= selTool("<p>")
    // let artText = selTool(artContent).text();
    // console.log(artContent);
    // // console.log(artText);
    var summarize = await require("text-summary");
    let newP = await browserInstance.newPage();
    await newP.setDefaultNavigationTimeout(0); 
    await newP.goto(url);
    // await newP.waitForNavigation({waitUntil:"domcontentloaded"});
    await newP.waitForSelector("p", 0);
    // await Promise.all([
    //     newP.waitForNavigation({waitUntil:"domcontentloaded"}), // The promise resolves after navigation has finished
    //     newP.goto(url), // Clicking the link will indirectly cause a navigation
    //   ]);
    
    
    // await newP.waitFor(15000);
    
    async function consoleFn(sel) {
        let t = await document.querySelectorAll(sel);
        
        // let PName = document.querySelectorAll(pNameSelector);
        let details=""
        // let details = [];
        if(t!=undefined){
            for (let i = 0; i < t.length; i++) {
                let text = await t[i].innerText;
                
               details = await details + text+"\n\n";
            }
            return details;
        }
        else{
            return "Unable to retrieve data from",url;
        }
        
        
    }

    // let artText = newP.evaluate(consoleFn,"p")
    // console.log(artText);
    let artText =await newP.evaluate(consoleFn,"p")
    var numberSentences = await 10;
    var summary = await summarize.summary(artText, numberSentences);

    // var Res=await summary.split(".");
    // var s=""
    // for(let i=0;i<Res.length;i++){
    //     s+=Res[i]+"\n\n";
    // }

    summary=await summary + "\n_____________________________________________________\n\n"
    // await console.log(summary);
    return await summary;

    
}

async function createOP(ans,query){
    // let pathFolder= await path.join(__dirname,query);
    // if(fs.existsSync(pathFolder)==false){
    //     fs.mkdirSync(pathFolder);
    // }

    let filePath = path.join(__dirname, query+".pdf");
    let pdfDoc = new PDFDocument;
    pdfDoc.pipe(fs.createWriteStream(filePath));
    pdfDoc.text(JSON.stringify(ans));
    pdfDoc.end();

}

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


