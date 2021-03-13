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
    let bowlersTable = selectorTool(".table.bowler");

    // let stringhtml="";
    // for(let i=0;i<bowlersTable.length;i++){
    //     stringhtml += selectorTool(bowlersTable[i]).html();
    // }
    var w=-1;
    var n;
    //get all bowler names and number of wickets taken
    for(let i=0;i<bowlersTable.length;i++){
        let singleInningBol=selectorTool(bowlersTable[i]).find("tbody tr");

        for(let j=0;j<singleInningBol.length;j++){
            let singleAllCol= selectorTool(singleInningBol[j]).find("td");
            let name =selectorTool(singleAllCol[0]).text();
            let wickets =selectorTool(singleAllCol[4]).text();

            if(wickets>w){
                w=wickets;
                n=name;
            }

            console.log("Name: ",name,"\t\tWickets: ",wickets);
        }
        console.log("_____________________________");
    }
    // console.log(stringhtml);
    console.log(`\nHighest wicket taker is ${n} with ${w} wickets`);
    

    //compare wickets


}
console.log("After");