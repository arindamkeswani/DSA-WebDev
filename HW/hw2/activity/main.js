let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/match-results";

let request=require("request");
let cheerio=require("cheerio");
let fs=require('fs');
let path=require('path');
let PDFDocument= require('pdfkit');
const { ceiling } = require("prelude-ls");
// const { CLIENT_RENEG_LIMIT } = require("node:tls");

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
        printIPL(html);
    }
}

//subtask 1: Print all team names from the match table
function printIPL(html){
    let selectorTool=cheerio.load(html);
    let pathFolder= path.join(__dirname,"IPL 2020");
    if(fs.existsSync(pathFolder)==false){
        fs.mkdirSync(pathFolder);
    }
    
    let matchScoreLink= selectorTool(".match-info-link-FIXTURES");
    console.log(matchScoreLink.length,"matches were played.");
    for(let i=0;i<matchScoreLink.length;i++){

        // let allLinks=selectorTool(matchScoreLink[i]).find(".btn.btn-sm.btn-outline-dark.match-cta");
        let matchLink= selectorTool(matchScoreLink[i]).attr("href");
        // console.log(i,matchLink);
        let fullLink="https://www.espncricinfo.com"+matchLink;
        
        // console.log(fullLink);
        processScorePage(fullLink);

        

        
        
        // break;
    }


    
}
var cou=1;
function processScorePage(url){
    request(url,cb);
    function cb(err,resp, html){
        if(err){
            console.log(err);
        }else{
            console.log("Processing Match No.",cou++);
            // console.log(html);
            getRepoLinks(html);
        }
    }
}

function getRepoLinks(html){
    let selTool = cheerio.load(html);
    let batTable = selTool(".table.batsman");
    // let teamName= selTool(".match-info.match-info-MATCH .name-detail .name");
    let teamTable=selTool(".section-header.border-bottom.text-danger.cursor-pointer .header-title.label");
    // console.log("Team table length",teamTable.length, batTable.length);
    // let repolinks= selTool("a.text-bold");

    for(let i=0;i<batTable.length;i++){
        let teamName=(selTool(teamTable[i]).text()).split("INNINGS");
        let opp;
        if(i==0){
            opp=(selTool(teamTable[1]).text()).split("INNINGS")[0];
        }else{
            opp=(selTool(teamTable[0]).text()).split("INNINGS")[0];
        }
        // console.log(teamName, batTable.length);
        // let playerName=selTool(batTable[i]).find("tbody tr .batsman-cell");
        
        let singleInningBat=selTool(batTable[i]).find("tbody tr");

        
        
        // console.log(playerName.length, " ",singleInningBat.length);
        dirCreator(teamName[0]);
        
        
            
        // for(let k=0;k<playerName.length;k++){
            
        //     createFile(teamName[0],selTool(playerName[k]).text().trim());
        // }

        for(let j=0;j<singleInningBat.length-1;j+=2){
            let arr=[];

            let singleAllCol= selTool(singleInningBat[j]).find("td");
            
            let name =selTool(singleAllCol[0]).text();
            let Filepath= createFile(teamName[0],name.trim());
            let runs=selTool(singleAllCol[2]).text();
            let balls=selTool(singleAllCol[3]).text();
            let fours=selTool(singleAllCol[5]).text();
            let sixes=selTool(singleAllCol[6]).text();
            let sr =selTool(singleAllCol[7]).text();
            
            let res=selTool(".match-info.match-info-MATCH .description").text().split(",");
            let venue=res[1];
            let date=res[2];
            let result=selTool(".match-info.match-info-MATCH .status-text").text();
            // let opp;
            // if(i==0){
            //     opp=teamName[0];
            // }else{
            //     opp=teamName[0];
            // }
            

            let playerObj = {
                // "Player Name": playerName,
                "Runs": runs,
                "Balls": balls,
                "Fours": fours,
                "Sixes": sixes,
                "Strike Rate": sr,
                "Date": date,
                "Venue": venue,
                "Opponent": opp,
                "Result": result
            }
        // console.log(playerObj);
        arr.push(playerObj);
        // console.log(arr);
        // jsonFilePath=path.join(__dirname,"IPL 2020",teamName[0],name.trim()+".json");
        fs.appendFileSync(Filepath, JSON.stringify(arr, null,5));

        }
        
    }

    console.log("________________")
}


function dirCreator(teamName){
    let pathFolder= path.join(__dirname,"IPL 2020",teamName);
    if(fs.existsSync(pathFolder)==false){
        fs.mkdirSync(pathFolder);
    }
}

function createFile(topicName, repoName){
    let pathofFile = path.join(__dirname,"IPL 2020", topicName, repoName+".json");
    // console.log(pathofFile);
    if(fs.existsSync(pathofFile)==false){
        
        // let file = fs.createWriteStream(pathofFile);
        // file.end();
        
        fs.appendFileSync(pathofFile,'', function(err){
            if(err){
                throw err;
            }else{
                console.log(pathofFile);
            }

        })
        
    }
    return pathofFile;
}


console.log("After");