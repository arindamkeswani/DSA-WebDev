//npm install puppeteer

let puppeteer=require("puppeteer");

//browser launch
let browserWillBeLaunched = puppeteer.launch({
    headless:false
});

//this is similar to the serial impplementation of callback functions
// browserWillBeLaunched.then(function(browserInstance){
//     //new tab opened
//     let newPagePromise= browserInstance.newPage();
//     newPagePromise
//     .then(function(newPage){
//         console.log("New tab opened");

//         let PageWillBeOpenedPromise = newPage.goto("https://www.pepcoding.com");
//         PageWillBeOpenedPromise.then(function(){
//             console.log("Page will be opened");
//         })
//     })
// })

//alt code, which is not nested, but is chained, for that will be:

browserWillBeLaunched.then(function(browserInstance){
    //new tab opened
    let newPagePromise= browserInstance.newPage();
    return newPagePromise;
    }).then(function(newPage){
        console.log("New tab opened");

        let PageWillBeOpenedPromise = newPage.goto("https://www.pepcoding.com");
        return PageWillBeOpenedPromise;
    }).then(function(){
        console.log("Page will be opened")
    }).catch(function(err){
        console.log(err);
    })