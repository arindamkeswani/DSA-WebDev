// view
// tree
// flat
// organize
// help
let viewfnObj = require("./commands/view");
let helpfnObj = require("./commands/help");
let orgfnObj = require("./commands/organize");
let input = process.argv.slice(2);
// console.log(input);
// console.log(input);
let cmd = input[0]
switch (cmd) {
    case "view":
        //view as tree
        // view as flat 
        // recursion
        viewfnObj.viewfn(input[1], input[2])
        break;
    case "organize":
        orgfnObj.organizeFn(input[1]);
        break;
    case "help":
        helpfnObj.helpfn();
        break;

    default:
        console.log("Wrong command . Type help to see the list of all the commands");
}

















// // cpmmands->
// //view --treel --flat
//             // organize-> same folder, multiple folder
//             // help
// // node mycli.js view dirName mode
// // node mycli.js organize -/foldername
// //  node mycli.js help


// let {helpFn}=require("./commands/help");
// let {organizeFn}=require("./commands/organize");
// let {viewFn}=require("./commands/view");



// let input=process.argv.slice(2); //removes first two indexes
// let cmd= input[0]; //extracts first index after sliced value
// switch(cmd){
//     case "view":
//         viewFn();
//         break;
//     case "organize":
//         organizeFn();
//         break;
//     case "help":
//         helpFn();
//         break;
//     default:
//         console.log("Wrong command. Enter \"node mycli.js help\" to see list of all commands.")
    
// }





