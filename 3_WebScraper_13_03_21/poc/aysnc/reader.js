let fs= require("fs");
console.log("Before");


// let data=fs.readFileSync("f1.txt");
fs.readFile("f1.txt",cb); //callback function (cb) used. It will call the function but not execute it till the rest of the work is done. Basically it will prioritize doing the rest of the work instead of executing the function and do it later.
//async is used to divert attention in case heavy load is encountered, in order to prevent delay in the execution of the rest of the program.

function cb(err,data){ 
    if(err){
        console.log(err);
    }else{
        console.log("content->"+data);
    }
    
}
// console.log("content->"+data);
console.log("After");