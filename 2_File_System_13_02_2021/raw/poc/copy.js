let fs=require("fs");
let path=require("path");
let input=process.argv.slice(2);
let srcFilePath=input[0];
let destFolderPath=input[1];

// fs.createReadStream(srcFilePath).pipe(fs.createWriteStream(destFolderPath));
let orgFileNamePath=path.basename(srcFilePath)
fs.copyFileSync(srcFilePath,path.join(destFolderPath,orgFileNamePath));
//src-> file->content is copied to dest->new file create->content copy