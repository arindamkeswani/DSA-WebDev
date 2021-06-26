import React,{useState} from 'react'

function Counter() {

    const [count, setCount] = useState(0); //State Hooks run once
    
    //we pass initial value of our state to useState as an arg
    //returns pair of values, current State and a function that can be used to change the current state
    

    //Entire functions re renders on change in value
    const handleIncrement=()=>{
        setCount(count+1);
    }
    const handleDecrement=()=>{
        setCount(count-1);
    }
    return (
        <div>
            <h1>{count}</h1>
            <button onClick={handleIncrement}>+</button>
            <button onClick={handleDecrement}>-</button>
        </div>
    )
}

export default Counter
