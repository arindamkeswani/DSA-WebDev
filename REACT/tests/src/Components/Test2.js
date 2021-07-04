import React, { useContext } from 'react'
import { NameContext, AgeContext } from './Test'
function Test2() {
    const name=useContext(NameContext);
    const age=useContext(AgeContext);
    return (
        <div>
            <h2>Name: {name}, Age:{age}</h2>
        </div>
    );
}

export default Test2
