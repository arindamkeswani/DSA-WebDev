import React, { useState, Component, useEffect, createContext, useContext } from 'react'
////////////////////Q1
// function Us() {
//     const [nameObj, setMessage] = useState({ name: 'Backbencher', age: 23 });
//     const handleNameChange = (e) => {
//         let val = e.target.value;
//         let obj = { ...nameObj, name: val };
//         // console.log(val);
//         setMessage(obj);
//     }

//     const handleAgeChange = (e) => {
//         let val = e.target.value;
//         let obj = { ...nameObj, age: val };
//         // console.log(val);
//         setMessage(obj);
//     }

//     return (
//         <div>
//             <form>
//                 <input type='text' value={nameObj.name} onChange={handleNameChange}></input>
//                 <input type='text' value={nameObj.age} onChange={handleAgeChange}></input>
//             </form>
//             <h2>Name: {nameObj.name}, Age: {nameObj.age}</h2>
//         </div>
//     )
// }

// export default Us

// export default class Profile extends Component {
//     state = {
//         name: "Backbencher",
//         age: 23,
//     };
//     onNameChange = (e) => {
//         this.setState({
//             name: e.target.value,
//         });
//     };
//     onAgeChange = (e) => {
//         this.setState({
//             age: e.target.value,
//         });
//     };
//     render() {
//         return (
//             <div>
//                 <form>
//                     <input
//                         type="text"
//                         value={this.state.name}
//                         onChange={this.onNameChange}
//                     />
//                     <input type="text"
//                         value={this.state.age}
//                         onChange={this.onAgeChange}
//                     />
//                     <h2>
//                         Name: {this.state.name}, Age: {this.state.age}
//                     </h2>
//                 </form>
//             </div>
//         );
//     }
// }

//////////////////////////////Q2

// export default class Us extends Component {
//     state = {
//         count: 0,
//     };
//     updateState = () => {
//         this.setState({
//             count: this.state.count + 1,
//         });
//     };
//     componentDidMount() {
//         console.log("Boom");
//     } componentDidUpdate() {
//         console.log("Boom");
//     }
//     render() {
//         return (
//             <div>
//                 <button onClick={this.updateState}>State: {this.state.count}</button>
//             </div>
//         );
//     }
// }


// function Us() {

//     useEffect(()=>{
//         console.log('render');
//     },[])
//     console.log('render');
//     const [count,setCount] =useState(0); 

//     return (
//         <div>
//             <button onClick={()=>{setCount(count+1)}}>State: {count}</button>
//         </div>
//     )
// }

// export default Us

//////////////////////Q3

// export default  class Us extends Component {
//     state = {
//         count: 0,
//     };
//     incrementCount = () => {
//         this.setState({
//             count: this.state.count + 1,
//         });
//     };
//     render() {
//         return (
//             <div>
//                 <button onClick={this.incrementCount}>Count: {this.state.count}</button>
//             </div>);
//     }
// }

// function Us() {

//     // useEffect(()=>{
//     //     console.log('render');
//     // },[])

//     const [count,setCount] =useState(0); 

//     return (
//         <div>
//             <button onClick={()=>{setCount(count+1)}}>Count: {count}</button>
//         </div>
//     )
// }

// export default Us

///////////////////////////////Q4
// export default function Us() {
//     const [count, setCount] = useState(0);
//     const [name, setName] = useState("");
//     useEffect(() => {
//         console.log("Count is updated");
//     },[count]);
//     return (
//         <div>
//             <button onClick={() => setCount(count + 1)}>State: {count}</button>
//             <input
//                 type="text"
//                 value={name}
//                 onChange={(e) => setName(e.target.value)}
//             />
//         </div>
//     );
// }

//////////////////////q5

// import React, { createContext, useContext } from 'react';
// const MyContext = createContext(1); const MyComponent = () => (
//     <>
//         <p>{useContext(MyContext)}</p>
//         <MyContext.Provider value={2}>
//             <p>{useContext(MyContext)}</p>
//         </MyContext.Provider>
//     </>
// );
// export default MyComponent;


////////////////Q6

// ReactDOM.render((
//     <Router>
//         <div>
//             <Route path="/" render={Home} />
//             <Route path="/login" render={Login} />
//         </div>
//     </Router>),
//     document.getElementById('root')
// );

////////////////////Q7
// import React from 'react';
// import { BrowserRouter, Route } from 'react-router-dom';
// const App = () => {
//     return (<div>App</div>)
// }
// const Dashboard = () => {
//     return (<div>Dashboard</div>)
// }
// const Profile = () => {
//     return (<div>Profile</div>)
// }
// const Router = () => {
//     return (<BrowserRouter>
//         <Route path='/' component={App}></Route>
//         <Route path='/dashboard/profile' component={Profile}></Route>
//         <Route path='/dashboard' component={Dashboard}></Route>
//     </BrowserRouter>
//     )
// }

///////////////////Q10
import Test2 from './Test2'
export const NameContext = React.createContext();
export const AgeContext = React.createContext();
// console.log(NameContext);
export class ProviderComponent extends Component {
    
    render() {
        
        return (
            <NameContext.Provider value="Backbencher">
                <AgeContext.Provider value="23">
                    <Test2 />
                </AgeContext.Provider>
            </NameContext.Provider>
        );
    }
}
// We have Test2 with following code.
// import React from 'react';

// function Test2() {
//     const nameValue = useContext(NameContext);
//     const ageValue = useContext(AgeContext);
//     console.log(nameValue);
//     return (
//         <div>
//             <NameContext.Consumer>
//             Name: {nameValue}
//             </NameContext.Consumer>
//              <h2>Name: {nameValue}, Age: {ageValue}</h2>
//         </div>
//     )
// }
// export default Test2

