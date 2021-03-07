function fn(){
    console.log("I was called from lib");
}

let a=20;
let private=40;

module.exports={
    fxn:fn,
    varName:a
}