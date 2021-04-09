let fs=require("fs");

function promisewalareadfile(filepath){
    //wrap it inside promise object 
    //call resolve where you think the work has been completed->pass data
    //call reject where you is work is erroneous->call reject
    //resolve function->

    return new Promise(function(resolve,reject){
        fs.readFile(filepath, function cb(err,data){
            if(err){
                reject(err);
            }else{
                resolve(data);
            }
        });
    });
}

let frP=promisewalareadfile("f1.txt");
console.log(frP);
frP.then(function(data){
    console.log("data->"+data);
});

frP.catch(function(err){
    console.log("errnode