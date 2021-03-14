let fs= require("fs");
console.log("Before");


// // let data=fs.readFileSync("f1.txt");
// fs.readFile("f1.txt",cb); //callback function (cb) used. It will call the function but not execute it till the rest of the work is done. Basically it will prioritize doing the rest of the work instead of executing the function and do it later.
// //async is used to divert attention in case heavy load is encountered, in order to prevent delay in the execution of the rest of the program.
// fs.readFile("f2.txt",cb);
// fs.readFile("f3.txt",cb);
// fs.readFile("f4.txt",cb);
// function cb(err,data){ 
//     if(err){
//         console.log(err);
//     }else{
//         console.log("content->"+data);
//     }
    
// }
// // console.log("content->"+data);
// console.log("After");

////////////////////////dependent callback
fs.readFile("f1.txt",cb);

function cb(err,data){ 
    if(err){
        console.log(err);
    }else{
        console.log("content->"+data);
        fs.readFile("f2.txt",cb2);
    }
}

function cb2(err,data){ 
    if(err){
        console.log(err);
    }else{
        console.log("content->"+data);
        fs.readFile("f3.txt",cb3);
    }
}

function cb3(err,data){ 
    if(err){
        console.log(err);
    }else{
        console.log("content->"+data);
        fs.readFile("f4.txt",cb4);
    }
}

function cb4(err,data){ 
    if(err){
        console.log(err);
    }else{
        console.log("content->"+data);
    }
}
