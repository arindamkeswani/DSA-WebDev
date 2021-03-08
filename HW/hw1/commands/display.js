let fs = require("fs");
let path = require("path");

function disp(file,i){
    fs.readFile(file, 'utf8', function (err,data) {
        if (err) {
            console.log("The file entered does not exist. Check the path for input path number " ,i+1, " again");
            return;
        }
        console.log(data);
      });
}

module.exports={
    dispFn: disp
}

// disp("D:\\Arindam\\Projects\\pepcoding\\HW\\hw2.txt.txt")