//https://www.espncricinfo.com/series/ipl-2020-21-1210595/match-results




//npm init -y //for dependencies
//npm install request
//npm install cheerio

let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/match-results";

let request=require("request");
let cheerio=require("cheerio");
const { string } = require("assert-plus");
request(url, cb)

console.log("Before")
function cb(error, response, html){
    if(error){
        console.log(error);
    }
    else{
        // console.log(html);
        extractHTML(html);
    }
}

function extractHTML(html){
    let selectorTool=cheerio.load(html);
    //get bowler table. This reduces problem size
    let matchcard = selectorTool(".col-md-8.col-16");//.batsman-cell.text-truncate
    
    
    
    //get all batsman names and number of wickets taken
    for(let i=0;i<matchcard.length;i++){
        // let teamName=(selectorTool(teamTable[i]).text()).split("INNINGS");
        let cardBtns=selectorTool(matchcard[i]).find(".btn.btn-sm.btn-outline-dark.match-cta");
        let matchLink= selectorTool(cardBtns[2]).attr("href");
        let fulllink="https://www.espncricinfo.com"+matchLink;
        
        

        //parallel (random order)
        printPotm(fulllink,i);

        //serial
        
    }

    
    
    


}


function printPotm(link,i){
    request(link,cb)
    function cb(err,response,html){
        if(err){
            console.log(err);
        }else{
            extractPotm(html,i);
        }
    }
}

function extractPotm(html,i){
    let selectorTool= cheerio.load(html)
    let playerElem= selectorTool(".best-player-name");
    let PotmName=playerElem.text();
    console.log(i,"POTM:", PotmName);
    
}

console.log("After");