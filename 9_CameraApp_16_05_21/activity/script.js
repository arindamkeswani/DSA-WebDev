// let allConstraints = Navigator.MediaDevices.getSupportedConstraints();
// console.log(allConstraints);

let videoRecorder = document.querySelector("#record-video");
let capturebtn = document.querySelector("#capture");
let clearObj;
let videoElem = document.querySelector("video");
let timingElem = document.querySelector(".timing");
// let audioElem = document.querySelector("audio");
let allFilters = document.querySelectorAll(".filter");
let uiFilter = document.querySelector(".ui-filter");
let filterColor = "";
let zoomInElem = document.querySelector("#plus-container");
let zoomOutElem = document.querySelector("#minus-container");
let videoContainer=document.querySelector(".video-container");
let level = 1; //degree of zoom

let constraints = {
    video:true,
    audio:true,
}

let mediaRecorder;
let buffer=[];
let recordState = false;

navigator.mediaDevices.getUserMedia(constraints)
.then(function(mediaStream){
    // alert("Received media");

    //get feed from source object and make changes on ui accordingly
    videoElem.srcObject = mediaStream
    // audioElem.srcObject = mediaStream

    mediaRecorder = new MediaRecorder(mediaStream);
    mediaRecorder.addEventListener("dataavailable", function(e){
        buffer.push(e.data);
    })
    
    mediaRecorder.addEventListener("stop", function(e){
        let blob = new Blob(buffer, {type:"video/mp4"});
        const url = window.URL.createObjectURL(blob);
        addMediaToDB(url, "video");
        
        //download btn
        // let a = document.createElement("a");
        // //download
        // a.download = "file.mp4";
        // a.href = url;
        // a.click();
        buffer=[]
    })
})
.catch(function(err){
    console.log(err);
})




// let videoRecorder = document.querySelector("#record-video");

//recording functionality
videoRecorder.addEventListener("click",function(){
    if(!mediaRecorder){
        alert("Please allow permissions for camera and microphone.");
        return;
    }
    if(recordState==false){
        mediaRecorder.start();
        videoRecorder.classList.add("record-animation");
        startCounting();
        videoRecorder.innerHTML = "Recording...";
        recordState=true;
    }else{
        mediaRecorder.stop();
        videoRecorder.classList.remove("record-animation");
        videoRecorder.innerHTML = "Record";
        stopCounting();
        recordState=false;
    }
})

function startCounting(){

    timingElem.classList.add("timing-active");
    let timeCount=0;

    clearObj = setInterval(function(){
        
        let seconds = (timeCount%60)<10 ? `0${Number.parseInt(timeCount%60)}` : `${timeCount%60}`;
        let minutes = (timeCount/60)<10 ? `0${Number.parseInt(timeCount/60)}` : `${timeCount/60}`;
        let hours = (timeCount/3600)<10 ? `0${Number.parseInt(timeCount/3600)}` : `${timeCount/3600}`;
        timingElem.innerText = `${hours}:${minutes}:${seconds}`;
        timeCount++;
    },1000)
}

function stopCounting(){
    timingElem.classList.add("timing-active");
    timingElem.innerText = "00:00:00";
    clearInterval(clearObj);
}
capturebtn.addEventListener("click", function () {
    // create a canvas element
    // equal to your video frame
    capturebtn.classList.add("capture-animation");

    let canvas = document.createElement("canvas");
    canvas.width = videoElem.videoWidth;
    canvas.height = videoElem.videoHeight;

    let tool = canvas.getContext("2d");

    tool.scale(level, level); //zoom before drawing image
    let x = (canvas.width/ level-canvas.width)/2
    let y = (canvas.height/ level-canvas.height)/2
    // draw a frame on that canvas
    tool.drawImage(videoElem, x, y);
    
    //translucent
    if(filterColor){
        tool.fillStyle=filterColor;
        tool.fillRect(0,0,canvas.width,canvas.height);
    }
    
    // toDataUrl 
    let link = canvas.toDataURL();
    addMediaToDB(link, "img");
    // download 
    // let anchor = document.createElement("a");
    // anchor.href = link;
    // anchor.download = "file.png";
    // anchor.click();
    // anchor.remove();
    // canvas.remove();

    setTimeout(function(){
        capturebtn.classList.remove("capture-animation");
    },1000);
})


//filter apply
for(let i=0;i<allFilters.length;i++){
    allFilters[i].addEventListener("click", function(){
        //add filter to ui
        let color = allFilters[i].style.backgroundColor;
        if(color) {
            uiFilter.classList.add("ui-filter-active");
            uiFilter.style.backgroundColor = color;
            filterColor=color;
            console.log(color);
        }else{
            uiFilter.classList.remove("ui-filter-active");
            uiFilter.style.backgroundColor = "";   
            filterColor="";
        }
    })
}

//zoom in/out



zoomInElem.addEventListener("click", function(){
    
    if(level<3){
        level+=0.2;
        videoElem.style.transform= `scale(${level})`;
    }
})

zoomOutElem.addEventListener("click", function(){
    
    if(level>1){
        level-=0.2;
        videoElem.style.transform= `scale(${level})`;
    }
})