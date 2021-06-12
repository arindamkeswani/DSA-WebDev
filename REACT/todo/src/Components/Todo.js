import React, { Component } from 'react'

export default class Todo extends Component {
    constructor(props){
        super(props);
        this.state={
            tasks : [{id:1, txt:'Task 1'},{id:2, txt:'Task 2'},{id:3, txt:'Task 3'}],
            currTask:''
        }
    }
    handleChange=(e)=>{
        let val = e.target.value;
        // console.log(val);
        this.setState({currTask:val})
    }
    onSubmit=()=>{
        // this.state.push({id:this.state.tasks.length + 1, txt: this.tasks.currTask});
        // currTask='';
        let nta = [...this.state.tasks,{id:this.state.tasks.length+1, txt: this.state.currTask}]
        this.setState({
            tasks:nta,
            currTask:''
        })
    }

    onDelete=(id)=>{
        let nta = this.state.tasks.filter(task=>{
            return task.id!= id;
        })
        this.setState({
            tasks:nta
        })
    }
    render() {
        
        return (
            <>
                <InputComponent value={this.state.currTask} onChange={this.handleChange} onSubmit={this.onSubmit}></InputComponent>
                <TaskList tasks={this.state.tasks} onDelete={this.onDelete}></TaskList>
            </>
        )
    }
}

class InputComponent extends Component
{
    constructor(props){
        super(props);
    }
    render(){
        // console.log(props);
        return(
            <div className='input-container'>
                    <input onChange={this.props.onChange} value={this.props.value} type='text'></input>
                    <button onClick={this.props.onSubmit}>Add</button>
            </div>
        )
    }
}

class TaskList extends Component
{
    constructor(props)
    {
        super(props);
    }
    render(){
        // console.log(this.props);
        return(
            <div className="class-list">
                    <ul>{
                            this.props.tasks.map(task=>(
                                <li key={task.id}>
                                    <h1>{task.txt}</h1>
                                    {/* <button onClick={()=>this.onDelete(task.id)}>Delete</button>  */}
                                    <button onClick={()=>this.props.onDelete(task.id)}>Delete</button> 


                                    {/* arrow function makes "this" as the this.state (3 lines up) */}
                                    {/* <button onClick={function(){this.onDelete(task.id)}.bind(this)}>Delete</button> */}
                                </li>
                            ))
                        }
                    </ul>
            </div>
        )
    }
}