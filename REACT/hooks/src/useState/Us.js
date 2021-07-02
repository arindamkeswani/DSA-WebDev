import React,{useState} from 'react'

function Us() {
    const [msgObj,setMessage] = useState({message:'',id:1});
    const handleChange =(e)=>{
        let val = e.target.value;
        // msgObj.message = val; //This will change the address of the obj
        // console.log(msgObj); 
        // setMessage({...msgObj,message:val}); //re-rendering will not take place because React sees that there is no change in address
        let obj  = {...msgObj,message:val};
        setMessage(obj)
        
    }
    return (
        <div>
            <input type='text' value={msgObj.message} onChange= {handleChange}></input>
            <p>{msgObj.message}</p>
        </div>
    )
}

export default Us
