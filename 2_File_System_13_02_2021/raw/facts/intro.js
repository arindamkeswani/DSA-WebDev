// no main
// top to bottom, left to right
//camel casing like java
console.log("Hello world");
//variable declare
let varName;
//statistically defined -> variable types=>statucally typed
//JS-> dynamically typed languages
//int varName
//initialize
//types-> primitives->number,string, boolean null defined
varName=10;
varName=1.2;
varName="string";
varName='another string';

varName=true;
varName=null
console.log("I am ",varName);

//JS (10 days)-> (Brenden Eich) -> netscape browser->(Java syntax, easy to code)
//JS-> Java->loops, conditional, breaks etc.

let number=23;
let flag=true;

for(let div=2;div*div<=number;div++ ){
    if(number%div==0){
        flag=false;
        break;
    }
}

if(flag==true){
    console.log(number," is prime");
}
else{
    console.log(number," is not prime");
}
//to run, open integrated terminal after right clicking on the file. Type "node filename.js"
