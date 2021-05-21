// let allConstraints = Navigator.MediaDevices.getSupportedConstraints();
// console.log(allConstraints);

let videoRecorder = document.querySelector("#record-video");
let capturebtn = document.querySelector("#capture");

let videoElem = document.querySelector("video");
// let audioElem = document.querySelector("audio");

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
        videoRecorder.innerHTML = "Recording...";
        recordState=true;
    }else{
        mediaRecorder.stop();
        videoRecorder.innerHTML = "Record";
        recordState=false;
    }
})

capturebtn.addEventListener("click", function () {
    // create a canvas element
    // equal to your video frame
    let canvas = document.createElement("canvas");
    canvas.width = videoElem.videoWidth;
    canvas.height = videoElem.videoHeight;
    let tool = canvas.getContext("2d");
    // draw a frame on that canvas
    tool.drawImage(videoElem, 0, 0);
    // toDataUrl 
    let link = canvas.toDataURL();
    // download 
    let anchor = document.createElement("a");
    anchor.href = link;
    anchor.download = "file.png";
    anchor.click();
    anchor.remove();
    canvas.remove();
})