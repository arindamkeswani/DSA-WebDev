- `Arguments`
    
    If we log "arguments" within a function, it will return an array-like object.
    Object contains `numerated keys`, with the `parameters` passed to function as `values` on the object

- Write function that takes in n numbers, and returns sum
    ```
    function f(){
        let sum=0;
        for(let x in arguments){
            sum+=arguments[x];
        }
        return sum;
    }

    console.log(f(1,2,3));
    ```

- Write function that takes in "a" or "m" as string followed by 'n' numbers, and returns sum or product, based on "a" or "m" respectively
    ```
    function f(){
        int n=arguments.length;
        if(arguments[0]==="a"){
            let ans=0;
            
            for(int i=1;i<n;i++){
                ans+=arguments[x];
            }
            
            return ans;
        }
        else{
            let ans=1;
            
            for(int i=1;i<n;i++){
                ans*=arguments[x];
            }
            return ans;
        }
        
    }

     console.log(f("m",1,2,3));
    console.log(f("a",1,2,3));
    ```

---

- String functions

    - Slice
    ```
    let str="the end";
    let newString = str.slice(0,5); //extract a part of/complete string.
    //start index is included, end index is excluded. So it works till end index-1;
    //Putting only start idx returns string from start idx till end
    ```
    Original string is not changed. 

    - Replace

    Only replaces first occurence from the start. Does not change original string
    ```
    let str = "the moon is sweet"
    let newString = str.replace("moon", "sugar")
    ```
    Strings are immutable
    
    - toUpperCase/toLowerCase
    ```
    let s="abS";
    let sNewUp=s.toUpperCase();
    let sNewLo=s.toLowerCase();

    console.log(sNewUp);
    console.log(sNewLo);
    ```

    - trim()

    Removes extra spaces from left and right.
    Use Case: API keys
    ```
    let s="      sdcojbsdc  ";
    let sNew = s.trim();
    console.log(sNew);
    ```
    - ASCII Values
    ```
    let s="ABC";
    console.log(s.charCodeAt(0));
    //Output: 65
    //It gives ASCII val of char at index
    ```

    - split()

    converts string to array
    ```
    let s="Rahul Ramesh John";
    let arr=s.split(" ");

    console.log(arr)
    ```
---
- Array Methods
    - push

        Changes original array, adds element at end

    ```
    let a=[1,2,3]
    a.push(4);
    console.log(a);
    ```

    - pop

        Changes original array, removes last element of arr, returns it
    ```
    let a=[1,2,3]
    let b=a.pop();
    console.log(a);
    console.log(b);
    ```

    - join

        Converts array to string based on joining string
    ```
    let a=[1,2,3,4,5]
    let s=a.join("+");

    console.log(s);
    ```

    - shift

    removes first element in array
    ```
    let a=[3,1,2,3]
    a.shift();
    //return the removed element as well
    ```

    - unshift

    adds element to the start of array. Changes original array
    ```
    let a=[3,1,2,3]
    a.unshift(5);
    ```

    length and slice() is defined in array, and works like string too

---
Create a function which has a local array in closure, this function will return another function, which will take 2 arguments, 2nd being optional, such that returned function is "f", following FIFO principle

```
function queue(){
    let arr=[]
    return f(op, value){
        if(op==="insert"){
            arr.push(value);
        }
        else if(op==="out"){
            arr.shift();
        }
        else{
            console.log(arr);
        }
    };
}

//FIFO
//let f=queue();
//f("insert", 2);
//f("out")
//f("show")
```
---

- Type conversion
    - Convert one data type to another
    - 2 types: Explicit, Implicit
    - Implicit: Converts on its own
    - Explicit: User converts explicitly

    - alert() does implicit type conversion. That is why contents of objects arent displayed

    - `typeof true` returns a string "boolean". 
    - `typeof typeof true` returns string
    - `Number(undefined)` returns NaN
    - `Number(null)` returns 0
    - `Number(true)` returns 1
    - `Number(false)` returns 0
    - `Number("true")` returns NaN
    - `Number("      5   ")` returns 5. Trims on its own

    - Check MDN article for truthy and falsey values
---
- JSON conversion
    - JSON.stringify
        =>converts a JS object to string
        ```
        let o={
            "Rahul",
        };

        console.log(o);
        let stringWhichContainsObject = JSON.stringify(o));
        console.log(stringWhichContainsObject);



        ```

    - JSON.parse
        => converts a string back to JS object

        ```
        let originalObj = JSON.parse(stringWhichContainsObject);
        console.log(originalObj);
        ```

        ```
        let fs = require("fs");
        fs.writeFileSync("test.txt", JSON.stringify(o))

        let buffer = fs.readFileSync(".test.txt", JSON.parse(o))
        console.log(buffer);
        ```

    - flatten an object
        - Remove nesting and have all keys in same level

        ```
        address:{
            city: "Delhi:
            pincode: 226001
        }
        ```
            will be converted to
        ```
        address_city:"Delhi"
        address_pincode: 226001
        ```

        ```
        function flattenObj(obj, parent, res={} ){
            for(let key in obj){
                let propName = parent ? parent + "_" + key : key;
                if(typeOf obj[key] === typeof {} && !Array.isArray(obj[key])){
                    flattenObj(obj[key], propName, res);
                }
                else{
                    res[propName]=obj[key];
                }
            }
            return res;
        }
        ```