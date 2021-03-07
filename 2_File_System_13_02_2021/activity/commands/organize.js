let fs=require('fs');
let path=require('path');

let types = {
    media: ["mp4", "mkv", "mp3","png","jpg","jpeg"],
    archives: ['zip', '7z', 'rar', 'tar', 'gz', 'ar', 'iso', "xz"],
    documents: ['docx', 'doc', 'pdf', 'xlsx', 'xls', 'odt', 'ods', 'odp', 'odg', 'odf', 'txt', 'ps', 'tex','pptx'],
    app: ['exe', 'dmg', 'pkg', "deb"]
}


function dirCreator(dirpath){
    if(fs.existsSync(dirpath)==false){
        fs.mkdirSync(dirpath);
    }
    
}

const { dir } = require('console');
//organized_files->
//app
//media
//archives
//documents
//others




//mkdir,mkdirSync
// let input=process.argv.slice(2);
// let dirpath=input[0];




//traverse
//identify->test directory
//copy

function GetDirectoryName(dirpath){
    let strArr= dirpath.split(".");
    let ext=strArr.pop();
    //let ext=path.extname(dirpath);
    //console.log(ext);
    for(let key in types){
        for(let i=0;i<types[key].length;i++){
            if(types[key][i]==ext){
                return key;
            }
        }
        // types[type].includes
    }
    return "others";
}

function isFileorNOt(dirpath) {
    return fs.lstatSync(dirpath).isFile();
}
function listContent(dirpath) {
    return fs.readdirSync(dirpath);
}

function copyFiletoFolder(dirpath,destFolder){
    let orgFileName=path.basename(dirpath);
    let destFilePath = path.join(destFolder,orgFileName);
    fs.copyFileSync(dirpath,destFilePath);
}

function OrganizeDir(dirpath,orgFilePath){
    let isFile = isFileorNOt(dirpath);
    if (isFile == true) {
        let foldername= GetDirectoryName(dirpath)
        console.log(dirpath,"->",foldername);
        //dirpath->..../file.extension
        //orgFilePath->....organized_files/category/file.extension
        let destFolder=path.join(orgFilePath,foldername);
        copyFiletoFolder(dirpath,destFolder);

    } else {
        // let strArr = dirpath.split("\\");
        // let toPrint = strArr.pop();
        // console.log(indent, path.basename(dirpath));
        let content = listContent(dirpath);
        // recursion
        // console.log(content);
        for (let i = 0; i < content.length; i++) {
            // f10/f1.txt
            // let childPath = dirpath + "\\" + content[i];
            let childPath = path.join(dirpath, content[i]);
            OrganizeDir(childPath,orgFilePath);
        }
    }
}





function OrganizeFn(dirpath){
    let orgFilePath=path.join(dirpath,"organized_files")
    // console.log(orgFilePath);
    dirCreator(orgFilePath);
    // fs.mkdirSync(orgFilePath);

    for(let key in types){
        let innerdirPath=path.join(orgFilePath,key);
        dirCreator(innerdirPath);
    }

    //others
    let otherPath=path.join(orgFilePath,"others");
    dirCreator(otherPath);
    OrganizeDir(dirpath,orgFilePath);
}

module.exports={
    organizeFn: OrganizeFn
}
// const fs = require('fs-extra'); 
  
// // Async with promises: 
// fs.copy('D:\\HTML\\f1', 'D:\\HTML\\fsextra') 
// .then(() => console.log('Files copied successfully!')) 
// .catch(err => console.error(err));