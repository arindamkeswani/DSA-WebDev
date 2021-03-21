let url="https://github.com/topics";

let request=require("request");
let cheerio=require("cheerio");
let fs=require('fs');
let path=require('path');
let PDFDocument= require('pdfkit');

// const { string } = require("assert-plus");
// const { createInflate } = require("node:zlib");
request(url, cb)

console.log("Before")
function cb(error, response, html){
    if(error){
        console.log(error);
    }
    else{
        // console.log(html);
        printTopRepName(html);
    }
}

//subtask 1: Print topic names which links of Top 8 repositories
function printTopRepName(html){
    let selectorTool=cheerio.load(html);
    let topicsArray= selectorTool(".col-12.col-sm-6.col-md-4.mb-4 a");
    // let topicLinks= selectorTool(".d-flex.flex-wrap.flex-justify-start.flex-items-stretch.list-style-none.gutter.my-4 .topic-box.position-relative.hover-grow.height-full.text-center.border.color-border-secondary.rounded.color-bg-primary.p-5").attr("href");
    for(let i=0;i<topicsArray.length;i++){
        let link = selectorTool(topicsArray[i]).attr("href");
        // let topicname = selectorTool(topicsArray[i]).text();
        let fulllink= "https://github.com"+link;

        processRepoPage(fulllink);
        // console.log(link);
    }
    // console.log(name.text());
    // console.log(topicLinks)
}

function processRepoPage(url){
    request(url,cb);
    function cb(err,resp, html){
        if(err){
            console.log(err);
        }else{
            getRepoLinks(html);
        }
    }
}

function getRepoLinks(html){
    let selTool = cheerio.load(html);
    let topicElem= selTool(".h1-mktg");
    // console.log(topicElem.text());
    let repolinks= selTool("a.text-bold");

    let topicName=topicElem.text().trim();
    dirCreator(topicName);
    for(let i=0;i<8;i++){
        // let linkName=selTool(repolinks[i]).text();
        let link=selTool(repolinks[i]).attr("href");
        let repoName=link.split("/").pop().trim();

        // console.log(repoName);
        // console.log(link);

        // createFile(topicName, repoName);
        let fullRepoLink = "https://github.com"+link+"/issues";
        // console.log(fullRepoLink);
        getIssues(repoName, topicName, fullRepoLink);
    }
    console.log("________________")
}


function getIssues(repoName, topicName, link){
    request(link, cb);
    function cb(err,resp,html){
        if(err){///////////////////
            if(resp.statusCode == 404){
                console.log("No issues page found");
            }
            else{
                console.log(err);
            }
            
        }

        else{
            extractIssues(html, repoName, topicName);
        }
    }
}


function dirCreator(topicName){
    let pathFolder= path.join(__dirname,topicName);
    if(fs.existsSync(pathFolder)==false){
        fs.mkdirSync(pathFolder);
    }
}

function createFile(topicName, repoName){
    let pathofFile = path.join(__dirname, topicName, repoName+".json");
    if(fs.existsSync(pathofFile)==false){
        let createStream = fs.createWriteStream(pathofFile);
        createStream.end();
    }
}

function extractIssues(html, repoName, topicName){
    let selTool = cheerio.load(html);
    let issuesAnchor = selTool("a.Link--primary.v-align-middle.no-underline.h4.js-navigation-open.markdown-title");///////////////////
    let arr=[];
    
    // console.log(repoName);
    // console.log(topicName);
    // console.log(issuesAnchor.length);

    for(let i=0; i<issuesAnchor.length; i++){
        let name = selTool(issuesAnchor[i]).text();
        let link = selTool(issuesAnchor[i]).attr("href");

        arr.push({
            "Name":name,
            "Link":"https://github.com"+link
        })
    }

    // let filePath = path.join(__dirname, topicName, repoName+".json");
    // console.log(arr);
    let filePath = path.join(__dirname, topicName, repoName+".pdf");
    let pdfDoc = new PDFDocument;
    pdfDoc.pipe(fs.createWriteStream(filePath));
    pdfDoc.text(JSON.stringify(arr));
    pdfDoc.end();
    // fs.writeFileSync(filePath,JSON.stringify(arr));////////////////////////
    // console.table(arr);

}
console.log("After");