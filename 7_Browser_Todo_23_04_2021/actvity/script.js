let colorBtn = document.querySelectorAll(".filter_color");
let mainContainer= document.querySelector(".main-container");
let body = document.body;
let plusButton = document.querySelector(".fa-plus");


for(let i=0;i<colorBtn.length;i++){
    colorBtn[i].addEventListener("click", function(e){
        
        let col=getComputedStyle(colorBtn[i]);
        // console.log(col.backgroundColor);
        // let color = colorBtn[i].classList[1];
        
        mainContainer.style.backgroundColor= col.backgroundColor;
    })
}

plusButton.addEventListener("click", createModal);


function createModal(){
    // let cColor=black;
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

function handleModal(modal_container){
    
    let cColor="black";
    let x;
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

            x = getComputedStyle(modalFilters[i]).backgroundColor;
            cColor= modalFilters[i].classList[1];
            // console.log("Coloe:",cColor);
        })


        
        
    }
    let textArea = document.querySelector(".modal_input");

    textArea.addEventListener("keydown", function (e) {
        if (e.key == "Enter"&&textArea.value!="") {
            console.log("Task ", textArea.value, "color ", cColor);
            //  remove modal
            modal_container.remove();
            // create taskBox
            createTask(cColor, textArea.value, x);
        }
    })
      
}


function createTask(color,task, x){
    let taskContainer=document.createElement("div");
    taskContainer.setAttribute("class", "task_container");
    taskContainer.innerHTML = `<div class="task_filter ${color} <style>background-color:${x}</style>"></div>
                                    <div class="task_desc_container">
                                        <h3 class="uid">#example</h3>
                                        <div class="task_desc">${task}</div>
                                    </div>
                                </div >`;
    mainContainer.appendChild(taskContainer);


    let tFilter = document.querySelectorAll(".task_filter"); 
    for(let i=0;i<tFilter.length;i++){
        let colWheel=0;
        tFilter[i].addEventListener("click", function () {
            // console.log(Math.floor(Math.random() * 4));

            let ColList = ["rgb(247, 184, 194)", "rgb(108, 108, 240)", "rgb(106, 175, 106)", "rgb(106, 175, 106)"];
            tFilter[i].style.backgroundColor = ColList[colWheel%ColList.length];
            colWheel++;
        })
        
    }
    
}


