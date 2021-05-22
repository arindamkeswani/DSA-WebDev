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
        //download btn
        let a = document.createElement("a");
        //download
        a.download = "file.mp4";
        a.href = url;
        a.click();
        buffer=[]
    })
})
.catch(function(err){
    console.log(err);
})




// let videoRecorder = document.querySelector("#record-video");


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
    // draw a frame on that canvas
    tool.drawImage(videoElem, 0, 0);
    tool.fillStyle=filterColor;
    tool.fillRect(0,0,canvas.width,canvas.height);
    // toDataUrl 
    let link = canvas.toDataURL();
    // download 
    let anchor = document.createElement("a");
    anchor.href = link;
    anchor.download = "file.png";
    anchor.click();
    anchor.remove();
    canvas.remove();

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