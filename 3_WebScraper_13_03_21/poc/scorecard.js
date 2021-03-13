//https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard


//npm init -y //for dependencies
//npm install request
//npm install cheerio

let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/full-scorecard"

let request=require("request");
let cheerio=require("cheerio");
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
    // let selectElem= selectorTool("#SIvCob"); //ID of element
    // console.log(selectElem.text());
    let bowlTable= selectorTool(".table.bowler")//give class (CSS Selector) of all commentaries from website
    console.log(bowlTable.length);
     //.text() and .html() does not work on indexes
    //rule-> if we use index, wrap it in cheerioSelector again
    let bowlTablef=selectorTool(bowlTable[0]).html();
    let bowlTables=selectorTool(bowlTable[1]).html();
    console.log(bowlTablef);
    console.log("\n");
    console.log(bowlTables);

}
console.log("After");