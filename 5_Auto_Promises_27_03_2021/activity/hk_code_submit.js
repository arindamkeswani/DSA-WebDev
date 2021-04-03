let puppeteer= require("puppeteer");
let {password,email}=require("../../secrets");
let fs= require("fs");
console.log(password, email);
let gtab;

let browserPromise= puppeteer.launch({
    headless:false, //makes browser visible
    defaultViewport:null, //disables default view dimensions
    // args:["--incognito","--start-maximized"]
    args:["--start-maximized"],
    
})

browserPromise.then(function(browserInstance){
    let newTabPromise= browserInstance.newPage();
    return newTabPromise;
}).then(function(newTab){
    let loginPageWillBeOpenedPromise = newTab.goto("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login") //enter login page link
    gtab=newTab;
    return loginPageWillBeOpenedPromise;
})
.then(function () {
    // console.log("login Page opened");
    let emailWillBeTypedPromise = gtab.type("#input-1", email, { delay: 200 });
    return emailWillBeTypedPromise;
}).then(function () {
    let passwordWillBeTypedPromise = gtab.type("#input-2",
        password, { delay: 200 });
    return passwordWillBeTypedPromise;
})
.then(function(){
    let loginWillBeClickedPromise= gtab.click("button[data-analytics='LoginPassword']");
    let combinedPromise = Promise.all([loginWillBeClickedPromise,
        gtab.waitForNavigation({waitUntil:"networkidle0"})])
    return combinedPromise;
}).then(function(){
    console.log("Login done");
})
.then(function(){
    let IPKElementPromise=gtab.waitForSelector(".card-content h3[title='Interview Preparation Kit']",{visible:true})
    return IPKElementPromise;
})
.then(function(){
    let interviewWillBeClickedPromise= gtab.click(".card-content h3[title='Interview Preparation Kit']"); //this does not wait for navigation time
    let combinedPromise2 = Promise.all([interviewWillBeClickedPromise,
        gtab.waitForNavigation({waitUntil:"networkidle0"})]);
    return combinedPromise2;
    
})
.then(function(){
    let WarmUpElementPromise=gtab.waitForSelector("a[data-attr1='warmup']",{visible:true})
    return WarmUpElementPromise;
})

.then(function(){
    let WarmUpWillBeClickedPromise= gtab.click("a[data-attr1='warmup']");
    let Chal1ElementPromise=gtab.waitForSelector("a[data-attr1='sock-merchant']",{visible:true})
    let combinedPromise3 = Promise.all([WarmUpWillBeClickedPromise,
        gtab.waitForNavigation({waitUntil:"networkidle0"}),
        Chal1ElementPromise]); //added the waitForSelector in this promise.all array as well to reduce number of functions and increase compactness
    return combinedPromise3;
}).then(function(){
    console.log("Reached warm up page");
})
// .then(function(){
//     let Chal1ElementPromise=gtab.waitForSelector("a[data-attr1='sock-merchant']",{visible:true})
//     return Chal1ElementPromise;
// })
.then(function(){
    let Chal1WillBeClickedPromise= gtab.click("a[data-attr1='sock-merchant']");
    let combinedPromiseChal1 = Promise.all([Chal1WillBeClickedPromise,
        gtab.waitForNavigation({waitUntil:"networkidle0"})])
    return combinedPromiseChal1;
}).then(function(){
    console.log("Reached Challenge 1 page");
})
// .then(function(){
//     let questionSolverPromise= questionSolver();
//     return questionSolverPromise;
// })
// .then(function(){
//     //derive urls of each question
// })

.catch(function(err){
    console.log(err);
})


// function waitAndClick(selector){
//     return new Promise(function(resolve,reject){
//         let selectorWaitPromise= gtab.waitForSelector
//     })
// }
//HW: go to interview prep kit, go to warm up challenges, go to first question, go to editorial, unlock
// function questionSolver(){
//     return new Promise(function(resolve,reject){
//         //file read
//         fs.readFile("")
//         //file paste
//     })
// }
console.log("After");

