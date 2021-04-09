let fs=require("fs");

let frP= fs.promises.readFile("f1.txt");

let thenKP=frP.then(cb);
console.log("then's promise",thenKP);

function cb(data){
    console.log("data"+data);
    return fs.promises.readFile("f2.txt");
}

thenKP.then(function(data){
    console.log("thenKP's value",data);
})

console.log("After");
console.log("______________________________________");