//npm init -y //for dependencies
//npm install request
//npm install cheerio

let url="https://www.espncricinfo.com/series/ipl-2020-21-1210595/delhi-capitals-vs-mumbai-indians-final-1237181/ball-by-ball-commentary"

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
    let allCommentaries= selectorTool(".d-flex.match-comment-padder.align-items-center .match-comment-wrapper .match-comment-long-text")//give class (CSS Selector) of all commentaries from website
    console.log(allCommentaries.length);
     //.text() and .html() does not work on indexes
    //rule-> if we use index, wrap it in cheerioSelector again
    let lastBComment=selectorTool(allCommentaries[0]).text();
    console.log(lastBComment);

}
console.log("After");