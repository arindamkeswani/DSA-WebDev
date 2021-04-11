let fs = require("fs");
let arr = ["f1.txt", "f2.txt", "f3.txt"];
console.log("before");
let frp = fs.promises.readFile(arr[0]);
for (let i = 1; i < arr.length; i++) {
    frp = frp.then(function (data) {
        console.log("content" + data); //prints value of arr[i-1] which was read earlier/in the previous iteration
        return fs.promises.readFile(arr[i]);
    })
}
console.log("after");

frp.then(function (data) {
    console.log("content" + data);
})