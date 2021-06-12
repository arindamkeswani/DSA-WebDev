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

