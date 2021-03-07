function fn(){
    console.log("Line number 2 Hello");
    return "somehting from fn";
}

function fn1(){
    console.log("I am fn1");
    return "somehting from fn1";
}

function fn3(){
    console.log("I am fn3");
    // while(true){

    // }
    return "somehting from fn3";
}

console.log("before");
console.log("Line 20 sends", fn(), fn1(),fn3());
console.log("After");

///////////////////

function fn(){
    console.log("Line number 2 Hello");
    fn1();
    return "somehting from fn";
}

function fn1(){
    console.log("I am fn1");
    fn3();
    return "somehting from fn1";
}

function fn3(){
    console.log("I am fn3");
    // while(true){

    // }
    return "somehting from fn3";
}

console.log("before");
console.log("Line 20 sends", fn());
console.log("After");