//objects -> key:value pairs
//object literal
//way 1: classical oops: 
//class -> blueprint -> object -> instance
//way 2: JS
// prototype-> instance(object)

//prototype
// object literal defined
let cap={
    name: "Steve",
    lastName:"Rogers",
    address:{
        state:"New York",
        city:"Manhattan"
    },
    age:35,
    isAvenger:true,
    movies:["Civil war", "First Avenger", "Avenger"],
    sayHi: function(){
        console.log("Cap says Hi!");
        return "Blesseings from Cap";
    }
};

//GET
// console.log("Name is",cap.name);
// console.log("City is",cap.address.city);
// console.log("First movie was",cap.movies[1]);
// console.log("Announcement:",cap.sayHi()); //will internal execute print statement first, then rest of the returned values


// function getVal(){
//     // while(true){

//     // }
//     return Math.random()*10+1;
// }

// let a=10 + getVal();
// console.log("val of a",a);

// //SET
// cap.friends=["tony","bruce","peter"];
// //update
// cap.isAvenger=false;
// //DELETE
// delete cap.movies;
// console.log(".............");

// //for in loop
// for(let key in cap){
//     console.log("Key :",key, "|Value :",cap[key]); //same functioning in array
// }

// console.log(cap.bac)// does not exist so will return undefined

// let abc= "lastName";
// console.log(cap.abc); //will return undefined
// console.log(cap[abc]); //will retrieve value

//objects -> arrays for ease of usage

console.log(Object.keys(cap).length); 
