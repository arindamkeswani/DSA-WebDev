DOM creates document object and renders tree of the html code
html elements are nodes of this tree



it is api between browser ui and the developer

Read: document.querySelector() ->gives node -> properties
create: d.createElement() ->creates html element
update: appendChild() -> will update tree to add element at the end of the parent
delete: d.remove() 

--------------
Margin->border->padding->element

box-sizing: border-box ->removes padding 

.inline ->height and cant be set (Eg: in span). They only take up the required space, but padding and margin can be given   
        ->they stay in the same line
        ->default display property is inline
        ->next element will come in same line

div->block level elements ->can set height width padding etc, with margin: 0 auto;
    ->default display property is block
    ->next element will come in next line

inline-block-> input type properties are inline block
            ->best of both. Take only required space, and margin and padding is given

display:flex ->makes elements flexible
    ->justify-content: for horizontal
    ->align-items: for vertical


Think of the page in terms of boxes
