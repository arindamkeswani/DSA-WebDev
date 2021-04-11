let puppeteer = require("puppeteer");
let fs = require("fs");
let links = ["https://www.amazon.in", "https://www.flipkart.com", "https://paytmmall.com/"];
let pName = process.argv[2];

//get number of videos, views, watch time, list of videos. Store info in an excel file

//start by getting data from initial page, that is readily available
//then handle scrolling and loading portion

console.log("Before");
// let arr=document.querySelectorAll("#stats  .style-scope.ytd-playlist-sidebar-primary-info-renderer")
// let newarr=[]
// newarr.push(arr[0].innerText,arr[1].innerText)
(async function () {
    try {
        let browserInstance = await puppeteer.launch({
            headless: false,
            defaultViewport: null,
            args: ["--start-maximized"]
        });
        let newPage = await browserInstance.newPage();
        await newPage.goto("https://www.youtube.com/playlist?list=PLRBp0Fe2GpgnIh0AiYKh7o7HnYAej-5ph");

        let numViews=await getNoVidViews(newPage);
        await console.log(numViews[0]);
        await console.log(numViews[1]);
        let videoCount = numViews[0].split(" ")[0];
        Number(videoCount);

        // let timeAndTitle = await listOfVids(newPage);
        // await console.table(timeAndTitle)

        let pCurrentVideosCount = await scrollToBottom(newPage,"#video-title");
        while(videoCount-50>pCurrentVideosCount){
            pCurrentVideosCount = await scrollToBottom(newPage,"#video-title")
        }


        let timeDurArr = await newPage.evaluate(getStats,"span.style-scope.ytd-thumbnail-overlay-time-status-renderer", "#video-title" );
        for(let i=0; i<timeDurArr.length;i++){
            console.log(timeDurArr[i]);
        }

    } catch (err) {
        console.log(err);
    }

})();

async function getNoVidViews(newPage){

    function consoleFn(sel){
        let arr = document.querySelectorAll(sel)
        let newarr=[]
        newarr.push(arr[0].innerText,arr[1].innerText)
        return newarr;
    }

    let NumAndViews = newPage.evaluate(consoleFn,"#stats .style-scope.ytd-playlist-sidebar-primary-info-renderer")
    return NumAndViews;
}

async function scrollToBottom(page, title){
    function getLengthConsole(title){
        window.scrollBy(0, window.innerHeight);
        let titleElemArr = document.querySelectorAll(title);
        console.log("titlelength", titleElemArr.length);

        if(titleElemArr.length==899){
            console.log(titleElemArr);
        }

        return titleElemArr.length;
    }

    return page.evaluate(getLengthConsole,title);
}


function getStats(durSel, title){
    let durElemArr= document.querySelectorAll(durSel);
    let tElemArr= document.querySelectorAll(title);

    let nameDurArr=[]
    for(let i=0;i<durElemArr.length;i++){
        let duration = durElemArr[i].innerText;
        let t = tElemArr[i].innerText;

        nameDurArr.push(
            {title:t
            ,time:duration});
    }
    return nameDurArr;
}

async function listOfVids(newPage){ //get names of all videos in the paylist with their watchtime
    // #video-title.yt-simple-endpoint.style-scope.ytd-playlist-video-renderer //selector for video title
    //span.style-scope.ytd-thumbnail-overlay-time-status-renderer //sel for video time
    //initial data
    //scroll
    //repeat for next set of videos
    function consoleFn(dur,title){
        let durElemArr= document.querySelectorAll(dur);
        let tElemArr= document.querySelectorAll(title);

        let nameDurArr=[]
        for(let i=0;durElemArr.length;i++){
            let duration = durElemArr[i].innerText;
            let t = tElemArr[i].innerText;

            nameDurArr.push(
                {title:t
                ,time:duration});
        }
    }

    let ans= await newPage.evaluate(consoleFn,"span.style-scope.ytd-thumbnail-overlay-time-status-renderer", "a#video-title");
    return ans;
}