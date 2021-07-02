import React,{useEffect, useState} from 'react'
//THIS WILL RUN INFINITELY DUE TO CONSTANT UPDATION OF VALUES IN useEffect, and subsequent re-rendering, and then useEffect runs after rendering, repeating the process
//This can be stopped by adding dependency array, which will only make useEffect run once
function Infinite() {
    const [count, setCount] = useState(0);
    useEffect(()=>{
        console.log("useEffect");
        let num = Math.random()*100;
        setCount(num);
    })
    console.log("Render");
    return (
        <div>
            <p>You clicked the button {count} times</p>    
            <button onClick= {()=>{setCount(count+1)}}>Click</button>
        </div>
    )
}

export default Infinite
