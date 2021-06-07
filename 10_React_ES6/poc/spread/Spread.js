// Spread symbol
//...
//it does shallow copy

// //Array
// arr=[3,5,4,2,1]
// narr=arr; //reference is attached. Upadting values in one will update both arrays as arrays, objects,functions are in heap memory
// narr[0]=1000;
// console.log(arr,narr);

//Using spread symbol
// narr=[...arr];
// narr[0]=1000;
// console.log(arr,narr);


//Objects
let state={
    name:"Ari",
    address:{
        city:"London",
        country:{
            CN:"United Kingdom",
            CC:"UK"
        }
    }
}

let copy={...state};

copy.address.city = "Delhi"; //will be changed in both state and copy due to high level copying, where nested objects receive address of original
copy.name="Arindam"; //changed only in copy

let copy={...state, address:{...state.address}};
copy.address.city = "Delhi"; //will be changed only in copy nested sub-object has been assigned new memory of its own, only at high level

let copy=JSON.parse(JSON.stringify(state)); //to do it for all nests in one go

//to check if any change has been made in any level of nesting, we can use '==' operator