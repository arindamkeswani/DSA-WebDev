//filesystem work will be done by nodejs modules

let fs=require("fs");
let path=require("path");
function isFileChecker(dirPath){
    return fs.lstatSync(dirPath).isFile(); //checks whether it is a file or not
}

function readContent(dirPath){
    return fs.readdirSync(dirPath); //returns path content
}
function viewFlat(dirPath){
    //path->file or folder
    let isFile=isFileChecker(dirPath);
    if (isFile==true){
        console.log(dirPath+"*");
    }
    else{
        //directory
        //console.log()
        //print path
        console.log(dirPath);
        //get children
        let children=readContent(dirPath);
        //call for view flat
        for(let i=0;i<children.length;i++){
            viewFlat(path.join(dirPath,children[i]));
        }
    }


}
viewFlat("d10");