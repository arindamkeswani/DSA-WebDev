'use strict';

let colorBtn = document.querySelectorAll(".filter_color");
let mainContainer= document.querySelector(".main-container");
let body = document.body;
let plusButton = document.querySelector(".fa-plus");
let crossButton = document.querySelector(".fa-times");
let deleteState=false;
let bothElementsArr = document.querySelectorAll(".icon-container");

let taskArr=[];

if(localStorage.getItem("allTask")){
    taskArr = JSON.parse(localStorage.getItem("allTask"));
    //UI
    for(let i=0; i<taskArr.length; i++){
        let {task, id, colorCl, color } = taskArr[i];
        
        createTask(colorCl, task,color,false ,id);
    }
}

for(let i=0;i<colorBtn.length;i++){
    colorBtn[i].addEventListener("click", function(e){
        
        let col=getComputedStyle(colorBtn[i]);
        // console.log(col.backgroundColor);
        // let color = colorBtn[i].classList[1];
        
        mainContainer.style.backgroundColor= col.backgroundColor;
    })
}

plusButton.addEventListener("click", createModal);
crossButton.addEventListener("click", setDeleteState);

function createModal(){

    let modal_container = document.querySelector(".modal_container");
    if(modal_container==null){
        let modal_container = document.createElement("div");
        modal_container.setAttribute("class","modal_container");
        modal_container.innerHTML = `<div class="input_container">
                                        <textarea class="modal_input" placeholder="Enter your task here"></textarea>
                                    </div>
                                    <div class="modal_filter_container">
                                        <div class="filter pink"></div>
                                        <div class="filter blue"></div>
                                        <div class="filter green"></div>
                                        <div class="filter black"></div>
                                    </div>`;
        body.appendChild(modal_container);

    //event listener
    handleModal(modal_container);
    }
    
    let textarea = modal_container.querySelector(".modal_input")
    textarea.value = "";


    
}

function handleModal(modal_container){
    
    let cColor="black";
    var x;
    var fin=3;
    let modalFilters=document.querySelectorAll(".modal_filter_container .filter");

    modalFilters[3].classList.add("border"); //add border to last filter by default

    for(let i=0; i< modalFilters.length;i++){ 
        modalFilters[i].addEventListener("click",function(){
            //remove border from existing filter
            modalFilters.forEach((filter)=>{
                filter.classList.remove("border");
            })

            //add border to clicked filter
            modalFilters[i].classList.add("border")

            fin=i;
            

            cColor= modalFilters[i].classList[1];
            // console.log("Coloe:",cColor);
        })

       
        
        
    }
    console.log(fin);
    
    let textArea = document.querySelector(".modal_input");

    textArea.addEventListener("keydown", function (e) {
        if (e.key == "Enter"&&textArea.value!="") {
            console.log("Task ", textArea.value, "color ", getComputedStyle(document.querySelectorAll(".modal_filter_container .filter")[fin]).backgroundColor);
            //  remove modal
            //store colour
            var col=getComputedStyle(document.querySelectorAll(".modal_filter_container .filter")[fin]).backgroundColor;
            //remove modal
            modal_container.remove();
            
            
            
            // create taskBox
            createTask(cColor, textArea.value,col,true );
        }
    })
      
}


function createTask(color,task, x, flag,id){
    // console.log(x);
    let taskContainer=document.createElement("div");

    let uifn = new ShortUniqueId();
    let uid = id || uifn();
    taskContainer.setAttribute("class", "task_container");
    taskContainer.innerHTML = `<div class="task_filter ${color} <style>background-color:${x}</style>"></div>
                                    <div class="task_desc_container">
                                        <h3 class="uid">#${uid}</h3>
                                        <div class="task_desc" contenteditable="true">${task}</div>
                                    </div>
                                </div >`;
    mainContainer.appendChild(taskContainer);


    



    let tFilter = document.querySelectorAll(".task_filter"); 
    let finColour=x;
    for(let i=0;i<tFilter.length;i++){
        let colWheel=0;
        tFilter[i].addEventListener("click", function () { //this block will change color on task on clicking
            

            let ColList = ["rgb(247, 184, 194)", "rgb(108, 108, 240)", "rgb(106, 175, 106)", "rgb(20, 20, 20)"];
            let colCl=["pink","blue","green","blue"]; //colour class

            tFilter[i].style.backgroundColor = ColList[colWheel%(ColList.length+1)];
            let colClChanged = colCl[colWheel%(ColList.length+1)];

            finColour=ColList[colWheel%(ColList.length+1)];
            
            console.log(tFilter[i].classList[1]);
            tFilter[i].classList.remove(tFilter[i].classList[1]);
            tFilter[i].classList.add(colClChanged);

            colWheel++;
        })
        
    }

    if(flag == true){
        let obj = {"task":task, "id":`${uid}`,"colorCl":color,"color":finColour };
        
        taskArr.push(obj);
        let finalArr = JSON.stringify(taskArr);
        localStorage.setItem("allTask", finalArr);
    }

    
    taskContainer.addEventListener("click", delTask);

    let taskDesc = taskContainer.querySelector(".task_desc");
    taskDesc.addEventListener("keypress", editTask);


}

function setDeleteState(e){
    console.log("State changed");
    let crossButton = e.currentTarget;

    let parent = crossButton.parentNode;
    if(deleteState==false){
        parent.classList.add("active");
    }else{
        parent.classList.remove("active");
    }

    deleteState=!deleteState;



    // console.log("Reached del task function");
    // let task=document.querySelectorAll(".task_container");
    // console.log(task);

    // for(let i=0;i<task.length;i++){
        
    //     task[i].addEventListener("click", function () { //this block will delete task
    //         task[i].remove(".task_container");
    //     })
        
    // }
}

function delTask(e){
    console.log("reached delete task");
    let taskContainer = e.currentTarget;
    if(deleteState){
        //local storage search->remove
        let uidElem = taskContainer.querySelector(".uid");
        let uid = uidElem.innerText.split("#")[1]; 

        console.log(uid);
        // console.log(taskArr);
        for(let i=0; i<taskArr.length; i++){
            let {id} = taskArr[i];
            console.log(id,uid);

            if(id == uid){
                taskArr.splice(i,1);
                let finalTaskArr=JSON.stringify(taskArr);
                localStorage.setItem("allTask", finalTaskArr);
                taskContainer.remove();
                break;
            }
        }
        // taskContainer.remove();
    }
}

function editTask(e){
    let taskDesc = e.currentTarget;
    let uidElem = taskDesc.parentNode.children[0];
    let uid = uidElem.innerText.split("#")[1];

    for(let i=0;i<taskArr.length; i++){
        let {id} = taskArr[i];
        console.log(id, uid);
        if(id==uid){
            taskArr[i].task = taskDesc.innerText;
            let finalTaskArr = JSON.stringify(taskArr);
            localStorage.setItem("allTask", finalTaskArr);

            break;
        }
    }
}