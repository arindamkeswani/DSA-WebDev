//gets highest wicket taker
//https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard


//npm init -y //for dependencies
//npm install request
//npm install cheerio

let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard";

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
    let batTable = selectorTool(".table.batsman");//.batsman-cell.text-truncate
    // let teamTable=selectorTool(".section-header.border-bottom.text-danger.cursor-pointer .header-title.label");
    
    
    //get all batsman names and number of wickets taken
    for(let i=0;i<batTable.length;i++){
        // let teamName=(selectorTool(teamTable[i]).text()).split("INNINGS");
        let name=selectorTool(batTable[i]).find("tbody tr .batsman-cell a");
        
         
        for(let j=0;j<name.length;j++){
            let link = selectorTool(name[j]).attr("href");  //.find("a").attr("href"); 
            let name2=selectorTool(name[j]).text();

            // console.log(name2,link);
            printBirthday(link, name2);
        }
        // console.log("____________________________");
    }
    
    // console.log(stringhtml);
    
    

    //compare wickets


}


function printBirthday(link,name){
    request(link,cb)
    function cb(err,response,html){
        if(err){
            console.log(err);
        }else{
            extractBirthday(html,name)
        }
    }
}

function extractBirthday(html,name){
    let selectorTool= cheerio.load(html)
    let birthdayElem= selectorTool(".ciPlayerinformationtxt span");
    let birthday=selectorTool(birthdayElem[1]).text();
    console.log(name+" was born on "+birthday);
}

console.log("After");