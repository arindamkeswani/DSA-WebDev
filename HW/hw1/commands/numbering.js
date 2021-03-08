//reduce line breaks
function numb(file){
    let flag=fs.existsSync(file);
    if(flag==true){
        fs.readFile(file, 'utf8', function(err, data) {
            var arr = data.toString().split('\n'),
                names = [];
            
            for (var i in arr) {
                // var trimmed = arr[i].trim();
                trimmed=arr[i];
                names.push(trimmed);
                
        
            }
            for(var i=0;i<names.length;i++){
                console.log(i+1,": ",names[i]);
            }
            
        });
    }
    else{
        console.log("Wrong file path entered");
    }
}

let fs = require('fs');
let path = require('path');

module.exports={
    numbFn: numb
}

