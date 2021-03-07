// //functions arrays objects

// //function definition
// function fn(param){
//     console.log("Hello from fn");
//     console.log("Parameter was: ",param);
//     let rval=Math.random() >0.5?false:"very good";
//     return rval; //if no return value then undefined is returned if called in a variable
// }
// //function invokation
// // fn("Hello");
// // fn(null);
// // fn(["Hello","Hi","where"]);

// let rval=fn("Hello");
// console.log("Returned value is: ",rval);

//array
//array is a collection of homogenous data types
//array is a collection of anything
let arr;
arr=[1,
    1.1,
    "string",
    'char string',
    true,
    null,
     function sayHi(){
    console.log("fn inside sayHi");
    return "returned from array";
},
[1,2,3,4,5,6]
]

// for(let i=0;i<arr.length;i++){
//     console.log("idx : ",i," value :", arr[i]);
// }
// //get
// console.log("Value at index: ",arr[3]);

// console.log("Value", arr[arr.length-1][2]);

// console.log("fn is ",arr[6]);
// console.log("fn is ",arr[6]());


//push-> add last, pop->remove last
//unshift-> add First, shift -> remove last

// //slice
// let slicedArr= arr.slice(2,4); //out strting ad ending indexes. slice saves copy of sliced array
// console.log("Sliced array",slicedArr);
// console.log("Full array",arr);

// //remove
// let removedElementsArr= arr.splice(4,2); //input is starting index and number of elements to be removed. Elements permanently removed from array
// console.log("Removed element array",removedElementsArr);
// console.log("Full array",arr);

//split in array of values
let str="Hello Hi How are you";
let splitArray=str.split(" ");
console.log(splitArray);
//join
let joinedString= splitArray.join("+");
console.log(joinedString);