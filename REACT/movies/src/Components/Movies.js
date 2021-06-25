import React, { Component} from 'react'
import { getMovies } from './MovieService';
import axios from 'axios';
// import axios from 'axios';
export default class Movies extends Component {
    constructor(props) {
        super(props);
        this.state = {
            // movies: getMovies(),
            movies:[],
            currSearchText:'',
            currPage: 1,
            limit: 4
        }
    }

    async componentDidMount(){
        let res = await axios.get('https://backend-react-movie.herokuapp.com/movies');
        console.log(res.data.movies);
        this.setState({
            movies:res.data.movies
        })

    }
    onDelete=(id)=>{
        console.log("");
        let filterArr = this.state.movies.filter(movieObj=>{
            return movieObj._id!=id
        })
        this.setState({
            movies: filterArr
        })
    }
    handleChange=(e)=>{
        let val = e.target.value;
        
        this.setState({
            currSearchText:val
        })
        //We are kind of creating two states for similar content. As the filter movies operation is temporary and occurs with the state change
        //  of currSearchText we can simply form the filterMovies array in the render method itself. So there is no need to make
        // it as a state.
        // if(val=='')
        // {
        //     this.setState({
        //     filterMovies:this.state.movies,
        //     currSearchText:''
        // })
        // return;
        // }
        // let filteredArr = this.state.movies.filter(movieObj=>{
        //     let title = movieObj.title.trim().toLowerCase();
        //     // console.log(title);
        //     return title.includes(val.toLowerCase());
        // })
        // this.setState({
        //     filterMovies:filteredArr,
        //     currSearchText:val
        // })
        // }


    }

    onStockSort=(e)=>{
        let className = e.target.className;
        console.log("Clicked Stock");
        if (className == 'fa fa-sort-asc') {
            let sortedArr= this.state.movies.sort(function(a,b){
                return a.numberInStock - b.numberInStock;
            })
            this.setState({
                movies:sortedArr
            })
        }else if(className== 'fa fa-sort-desc') {
            let sortedArr= this.state.movies.sort(function(a,b){
                return b.numberInStock - a.numberInStock;
            })
            this.setState({
                movies:sortedArr
            })
        }
        
    }

    onRateSort=(e)=>{
        let className = e.target.className;
        console.log("Clicked Rate");
        if (className == 'fa fa-sort-asc') {
            let sortedArr= this.state.movies.sort(function(a,b){
                return a.dailyRentalRate - b.dailyRentalRate;
            })
            this.setState({
                movies:sortedArr
            })
        }else if(className== 'fa fa-sort-desc') {
            let sortedArr= this.state.movies.sort(function(a,b){
                return b.dailyRentalRate - a.dailyRentalRate;
            })
            this.setState({
                movies:sortedArr
            })
        }
        
    }
    handlePageChange=(pageNumber)=>{
        this.setState({currPage:pageNumber});
    }
    handleLimit = (e) => {
        let num = Number(e.target.value)
        this.setState({ limit: num })
    }

    render() {
        let {movies,currSearchText, limit, currPage}=this.state;
        // let filterMovies =[];
        let filteredArr = [];
        if(currSearchText!='')
        {
            filteredArr = movies.filter(movieObj=>{
                    let title = movieObj.title.trim().toLowerCase();
                    
                    return title.includes(currSearchText.toLowerCase());
                })
        }
        else
        {
            filteredArr=movies;
        }

        let numberOfPages= Math.ceil(filteredArr.length/limit);
        let pageNumberArr=[];
        for(let i=0;i<numberOfPages;i++){
            pageNumberArr.push(i+1);
        }
        let si = (currPage - 1) * limit; //movies till prev page
        let ei = si + limit; //total movies, including movie numbers on current page
        filteredArr = filteredArr.slice(si, ei); // movie numbers on current page

        return (
            <div className='container'>
                <div className='row'>
                    <div className='col-3'>
                        <h1>Hello</h1>
                    </div>
                    <div className='col-9'>
                        <input onChange={this.handleChange} type='text'></input>
                        <table className="table">
                            <thead>
                                <tr>

                                    <th scope="col">Title</th>
                                    <th scope="col">Genre</th>
                                    <th scope="col">
                                        Stock
                                        <i className="fa fa-sort-asc" aria-hidden="true" onClick={this.onStockSort}></i>
                                        <i className="fa fa-sort-desc" aria-hidden="true" onClick={this.onStockSort}></i>
                                    </th>
                                    <th scope="col">
                                        Rate
                                        <i className="fa fa-sort-asc" aria-hidden="true" onClick={this.onRateSort}></i>
                                        <i className="fa fa-sort-desc" aria-hidden="true" onClick={this.onRateSort}></i>
                                    </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    filteredArr.map(movieObj => (
                                        <tr scope='row' key={movieObj._id}>
                                            <td>{movieObj.title}</td>
                                            <td>{movieObj.genre.name}</td>
                                            <td>{movieObj.numberInStock}</td>
                                            <td>{movieObj.dailyRentalRate}</td>
                                            <td><button type="button" className="btn btn-danger" onClick={()=>this.onDelete(movieObj._id)}>Delete</button></td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>

                        <nav aria-label="...">
                            <ul className="pagination">
                            {
                                    pageNumberArr.map((pageNumber)=>{
                                        let classStyleName = pageNumber==currPage? 'page-item active' : 'page-item'
                                        // the above let variable is used to define the class too be put on the li element.
                                        //  As this decides the blue backgroound.
                                        return(
                                            <li onClick={()=>this.handlePageChange(pageNumber)} className={classStyleName} key={pageNumber} >
                                                <span className="page-link">{pageNumber}</span>
                                            </li>
                                        )
                                    })
                                }
                            </ul>

                        </nav>
                    </div>
                </div>
            </div>

        )
    }
}

