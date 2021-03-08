// view
// tree
// flat
// organize
// help
let displayObj = require("./commands/display");
let helpObj = require("./commands/help");
let displayAllObj = require("./commands/displayall");
let numberObj = require("./commands/numbering");
let numbnonObj = require("./commands/numbnonempty");
let redlineObj = require("./commands/redline");

let fs = require("fs");
let path = require("path");

let input = process.argv.slice(2);

let leng=input.length;
// console.log(leng);
let cmd = input[0];

function isFileorNOt(dirpath) {
    return fs.lstatSync(dirpath).isFile();
}

// let flag=isFileorNOt(input[0]);
if(cmd.startsWith("-") || cmd.startsWith("help")){
    switch(cmd){
        case "-s":
            // console.log("-s exec");
            redlineObj.redlFn(input[leng-1]);
            break;
        case "-n":
            numberObj.numbFn(input[leng-1]);
            break;
        case "-b":
            numbnonObj.numbnonFn(input[leng-1]);
            break;
        case "help":
            helpObj.helpFn();
            break;
        default:
            console.log("Wrong command . Type help to see the list of all the commands.");
            break;
    }
}
else{
    let flag=fs.existsSync(cmd);
    if(flag==true){
        if(leng>1){
            for(let i=0;i<leng;i++){
                displayObj.dispFn(input[i],i);
            }
        }
        else{
            displayObj.dispFn(cmd,0);
        }
        
    }
    else{
        console.log("The file entered does not exist. Check the path for input path number " ,1, " again");
    }
}





