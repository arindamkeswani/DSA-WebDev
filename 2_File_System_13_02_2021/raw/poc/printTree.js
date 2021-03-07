//filesystem work will be done by nodejs modules

let fs=require("fs");
let path=require("path");
function isFileChecker(dirPath){
    return fs.lstatSync(dirPath).isFile(); //checks whether it is a file or not
}

function readContent(dirPath){
    return fs.readdirSync(dirPath); //returns path content
}
function viewTree(dirPath, indent){
    //path->file or folder
    let isFile=isFileChecker(dirPath);
    if (isFile==true){
        console.log(indent,path.basename(dirPath)+"*");
    }
    else{
        //directory
        //console.log()
        //print path
        console.log(indent,path.basename(dirPath));

        //get children
        let children=readContent(dirPath);
        
        //call for view flat
        for(let i=0;i<children.length;i++){
            // console.log(children[children.length-1]);
            viewTree(path.join(dirPath,children[i]),indent+"\t");
        }
    }


}
// viewTree("d10","");
viewTree("D:\\Arindam\\Projects\\pepcoding\\2_File_System_13_02_2021","");