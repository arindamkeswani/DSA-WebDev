//go to 3 websites (Amazon, Flipkart, PayTM Mall)
//search for a product, print product name and price of top 5 products on console
//first do it serially

let puppeteer = require("puppeteer");
let fs = require("fs");
let links = ["https://www.amazon.in", "https://www.flipkart.com", "https://paytmmall.com/"];
let pName = process.argv[2];

console.log("Before");
(async function () {
    try {
        let browserInstance = await puppeteer.launch({
            headless: false,
            defaultViewport: null,
            args: ["--start-maximized"]
        });
        let amazonArr = await getListingFromAmazon(links[0], browserInstance, pName);
        let flipkartArr = await getListingFromFlipkart(links[1], browserInstance, pName);
        let paytmArr = await getListingFromPaytm(links[2], browserInstance, pName);
        console.table(amazonArr);
        console.table(flipkartArr);
        console.table(paytmArr);
    } catch (err) {
        console.log(err);
    }
})();

//  product Name,url of amazon home page
// output-> top 5 matching product -> price Name print 
async function getListingFromAmazon(link, browserInstance, pName) {
    let newTab = await browserInstance.newPage();
    await newTab.goto(link);
    await newTab.type("#twotabsearchtextbox", pName, { delay: 200 });
    await newTab.click("#nav-search-submit-button[value='Go']");

    await newTab.waitForSelector(".a-price-whole", {visible:true}) //product card

    function consoleFn(priceSelector, pName){
        let priceArr = document.querySelectorAll(priceSelector);
        let nameArr = document.querySelectorAll(pName);
        let details=[];
        for(let i=0;i<5;i++){
            let pr = priceArr[i].innerText; //price number i
            let nm = nameArr[i].innerText; ////name number i
            details.push({
                Name:nm,
                Price:pr
            })
        }

        return details;

    }


    let detailsArr = await newTab.evaluate(consoleFn,".a-price-whole", ".a-size-medium.a-color-base.a-text-normal");
    // ".a-size-medium.a-color-base.a-text-normal"//product name selector
    // ".a-price-whole"//product price selector
    // console.log(detailsArr);
    return detailsArr;
}



async function getListingFromFlipkart(link, browserInstance, pName) {
    let newPage = await browserInstance.newPage();
    await newPage.setDefaultNavigationTimeout(0); 
    await newPage.goto(link);
    await newPage.click("._2KpZ6l._2doB4z");
    await newPage.type("._3704LK", pName);
    await newPage.click("button[type='submit']");
    // await newPage.waitForNavigation();
    await newPage.waitForSelector("._25b18c ._30jeq3", { visible: true }); //price
    
    await newPage.waitForSelector(".s1Q9rs", { visible: true }); //name
    function consoleFn(priceSelector, pNameSelector) { 
        let priceArr = document.querySelectorAll(priceSelector);
        let PName = document.querySelectorAll(pNameSelector);
        let details = [];
        for (let i = 0; i < 5; i++) {
            let Price = priceArr[i].innerText;
            let Name = PName[i].innerText;
            details.push({
                Name, Price
            })
        }
        return details;
    }
    return newPage.evaluate(consoleFn,
        "._25b18c ._30jeq3",
        ".s1Q9rs");
    //    ._4rR01T
    // ._30jeq3._1_WHN1

}
async function getListingFromPaytm(link, browserInstance, pName) {
    let newPage = await browserInstance.newPage();
    await newPage.goto(link);
    await newPage.type("#searchInput",pName,{ delay: 200 });
    await newPage.keyboard.press("Enter",{ delay: 200 });
    await newPage.keyboard.press("Enter");
    await newPage.waitForSelector(".UGUy", { visible: true });
    await newPage.waitForSelector("._1kMS", { visible: true });
    function consoleFn(priceSelector, pNameSelector) {
        let priceArr = document.querySelectorAll(priceSelector);
        let PName = document.querySelectorAll(pNameSelector);
        let details = [];
        for (let i = 0; i < 5; i++) {
            let Price = priceArr[i].innerText;
            let Name = PName[i].innerText;
            details.push({
                Name, Price
            })
        }
        return details;
    }
    return newPage.evaluate(consoleFn,
        "._1kMS",
        ".UGUy");


}