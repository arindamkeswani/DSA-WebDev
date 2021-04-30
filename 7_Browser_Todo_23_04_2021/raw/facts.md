DOM creates document object and renders tree of the html code
html elements are nodes of this tree



it is api between browser ui and the developer

Read: document.querySelector() ->gives node -> properties
create: d.createElement() ->creates html element
update: appendChild() -> will update tree to add element at the end of the parent
delete: d.remove() 

--------------
Think of the page in terms of boxes
--------------
Margin->border->padding->element
--------------
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
--------------
flex-direction: column or row (justify-content and align items will work accordingly) ->default row

flex-wrap: will retain original dimensions and move extra elements to next row/column
------------------

Positioning:
Static: Default

Relative: Move relative to original position
Prefer moving top and left instead of right and bottom
Occupies original position

Absolute: Makes a new layer
top,left: new layer
does not occupy original position
if parent is relative, and child absolute then child is bound to parent box


------------------

event.currentTarget is the portion on which listener is added
event.target is the portion on which changes are made

------------------

Overflow: visible (will show full content)
        : hidden (Hides extra content) 
        : auto (Adds scroll bar as necessary)
        : scroll (Adds both hori and vert scroll bars)

------------------
word-break:break-all; //good for single words which might cause problem in Overflow property
------------------
contenteditable="true" enables user to edit text inside the div
readonly makes input box uneditable
