//npm init -y //for dependencies
//npm install request
//npm install cheerio

let request=require("request");
let cheerio=require("cheerio");
request("https://www.google.com", cb )

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
    let selectElem= selectorTool("#SIvCob"); //ID of element
    // console.log(selectElem.text());
    console.log(selectElem.html());

}
console.log("After");