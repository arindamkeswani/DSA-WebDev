import React,{useEffect, useState} from 'react'

function Uewc() {

    useEffect(()=>{
        console.log('useEffect');
        document.title= `Clicked ${count} times`;

        //cleanUp
        return()=>{
            //before 2nd useEffect is called after change in values, this return (which has prev value) runs before running useEffect
            alert(`I will be called before next useEffect is called: ${count}`);
        }
    },[]) //on adding dependency, it behaves like ComponentWillUnmount, and alert is shown only once, when the component is removed
    console.log('render');
    const [count,setCount] =useState(0); 

    return (
        <div>
            <p>{count}</p>
            <button onClick={()=>{setCount(count+1)}}>Click</button>
        </div>
    )
}

export default Uewc
