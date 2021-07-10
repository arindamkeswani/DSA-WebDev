`12/6/2021`

Arrow functions' or bind's `this` is the one that is lexically superior.
For eg: if function is passed in an object and called through it, like `object.fn()` then "this" will refer to the object.
Suppose a normal function in written inside `fn` say `abc`, then on calling it normallly will refer to the `window` object as its "this"
But if function `abc` was an arrow function, then it will point to its parent's this, which in this case would be the `object`.

Test:
* Q7:
```
    Fluffy
    Fluffy 
```
* Q8: `undefined` [Only function definiton is passed, so "this" points to window object, which does not have "message" attribute ]
* Q9:    Use bind function
```
    let nf= logMessage.bind(object);    
    nf();
```
- Q10:

`Hello World!` [As a normal function was called as a part of an object, therefore the "this" was the object itself]

`Goodbye undefined!` [Arrow functions use parents' "this" as their own "this", which in this case is the window object]

- React Docs : https://reactjs.org/docs/getting-started.html

- Components: Independent and re-usable pieces of code, like functions in JS. When changes are made in a component, the whole page does not re-render unlike DOM, where the entire DOM tree is built again (reflow), which is an expensive process.
    1. Class components (for Dynamic components)
    2. Functional components (for Static components)
    - Component name has to be a capital letter
- JSX - Mixture of HTML and JS for syntax simplicity for developers. `Babel` (is a JSX compiler that converts it to JS, which is understood by Browser)
- Return statement is compulsory (Only JSX allowed) 
- State is an object used to store component details
- `setState` is used becuase simply updating state value is not reflected on UI. This function re-renders the component.
----
`12/06/21`

`npx create-react-app todo`
To create a react app

`cd todo`
Go to the project folder in command line

`npm start`
To start React app after the installation is complete

- There can be only one default export in  a .js file
- Remove strict mode frmo public/src/index.js
- Root is in index.html file
- Empty the div inside App function
- Arrays/object should not be directly mutated. Use spread operator `...` instead
- If the parent gets re=rendered, the child gets re-rendered
----
`13/06/21`

- We only keep those attributes in state that reflect changed on UI
- HW: 
    1. Pagination (make formula and use slice. Use no of pages, page limit, number of pages for the formula). Bootstap pagination can be used in layouts
    2. Sort acc to stock or rate (Use object sorting and compareTo)
    3. Display genre-wise

----
`25/06/21`

- Component Lifecycle Methods
- 3 phases:
    1. Mounting (When element loads on screen)
        1. Constuctor
        2. Render
        3. ComponentDidMount
    2. Update (State change) [Cyclic, till unmounting happens]
        1. render
        2. ComponentDidUpdate
    3. Un-mounting (When element is removed from screen)
        1. ComponentWillUnmount
- Side Effects: Making calls to databases, network requests, etc. This can cause page freeze if called in constructor.
So we do this asyncronously in ComponentDidMount instead of constructor so that UI can load while we are still retrieving data

----
`26/6/21`
- Routing: npm i react-router-dom
- Multiple components can be rendered if overlapping path is found, we use switch to solve this
- Router compares all paths. Switch renders the first match found.
- Solution: in switch, most common path should be shifted at the bottom

- Hooks: functions that let you "hook into" React State & lifecycle methods from functional components. They dont work in class components.
    -> State, lifecycles
    Pros of using hooks: 
        1. Escape from boilerplate code of class components
        2. No more worry about handling .this
        3. Separation of logic
    
    eg:
    1. useState():-Hook that lets us add state to functional components
    
----
`2/7/21`
- Hooks
- The function returned by useState needs new object to update value in an object, unlike setState, which just overrides req value and the rest remains untouched. So we should use `spread (...)` operator to copy prev object then add our change, in order to prevent loss of values.
- In functional components, there is no render() function (unline class components), and this entire func runs on changing the state
- React keeps track of and does not initialise the useState again an again.
- To use side effects within functional components using `useEffect`. 
- It runs after every render.
- 1st Variation [No dependency array]:
    - useEffect = ComponentDidMount + ComponentDidUpdate (after every rendering)
- 2nd Variation [With dependency array]:
    - useEffect = ComponentDidMount (only one rendering)
- 3rd Variation [non-empty dependency array]:
    - useEffect runs only when value inside dependency array changes
- ComponentDidUpdate runs in order to prevent malfunction of WillUnmount in case of multiple props, as otherwise latter will not be able to find changed values and unmount the componemt. It basically removes listener from prev component, and attaches it to the next value sent by the props

----
`3/7/21`
- Context API: Provides a way to pass data through the component tree without having to pass props down manually at every level (props drilling). 
- When to use Context API: It is designed to share data that can be considered global for a tree of React components, eg user auth, theme
- `const MyContext = React.createContext(default value); //creates a context object`
    
    -> Consumption: Hook=>useContext
    
    -> `const val = useContext(value);`

    -> MyContext.Provider overrides default value in useContext with the entered value (add consumption and subscription)

    ->React.memo allows to prevent re-rendering of child (if consumption[useContext] is removed) when there is no value change in it (makes child and grandchild siblings)
- Firebase: Backend as a service
            ->APIs, storage, structure, authentication
            
            ->pre-existing functionalities (just need to consume, no need to get into the code)

----
`10/7/21`

In firestore, there are collections, that contain details of every user, which contains key value pairs for every attribute
