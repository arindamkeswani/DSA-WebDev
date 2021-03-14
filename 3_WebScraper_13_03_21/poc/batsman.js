//gets highest wicket taker
//https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard


//npm init -y //for dependencies
//npm install request
//npm install cheerio

let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard";

let request=require("request");
let cheerio=require("cheerio");
const { string } = require("assert-plus");
request(url, cb )

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
    let batTable = selectorTool(".table.batsman ");//.batsman-cell.text-truncate
    let teamTable=selectorTool(".section-header.border-bottom.text-danger.cursor-pointer .header-title.label");
    
    
    //get all bowler names and number of wickets taken
    for(let i=0;i<batTable.length;i++){
        let teamName=(selectorTool(teamTable[i]).text()).split("INNINGS");
        let name=selectorTool(batTable[i]).find("tbody tr .batsman-cell");
        
         
        for(let j=0;j<name.length;j++){
            console.log("\nName: ",selectorTool(name[j]).text(), "is in",teamName[0]);
        }
        
        // console.log("Name: ",teamName[0],teamName[1]);
        console.log("_____________________________");
        }
        
    
    // console.log(stringhtml);
    
    

    //compare wickets


}
console.log("After");