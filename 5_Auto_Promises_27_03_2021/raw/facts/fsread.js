let fs= require("fs");
console.log("Before");
//callback is an older way to do async programming
fs.readFile("f1.txt",function cb(err,data){
    if(err){
        console.log(err);
    }else{
        console.log("data->" + data);
    }
});

//promises is just an abstract object that holds a future value (a promised value)
//Its initial state is always "pending"

let promise = fs.promises.readFile("f1.txt");
console.log("Initial state:",promise);
console.log("After");
//consumer function is called when promise is fulfilled
promise.then(function(data){
    console.log(data);
});
//on rejection
promise.catch(function(err){
    console.log(err);
})
// setTimeout(function(){
//     console.log("Final state", promise);

// },2000);



