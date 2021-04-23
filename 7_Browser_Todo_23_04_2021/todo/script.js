let input = document.querySelector(".input_box");
let ul=document.querySelector(".task-list");

input.addEventListener("keydown", function(e){ //e is the event object
    //e object -> descrive -> event

    // console.log("Some key was pressed");
    console.log("Event log",e);

    if(e.key=="Enter"){
        // console.log("User wants to enter a task");
        let task=input.value;
        console.log(task);


        //create task
        let li = document.createElement("li");
        li.innerText= task;

        //remove the task on double clicking
        li.addEventListener("dblclick",function(){
            li.remove();
        })

        //automatically assign is to class "task"
        li.setAttribute("class","task")
        
        //add the element at the end
        ul.appendChild(li);

        input.value=""; //clear value in the input text box after hitting enter
    }
});