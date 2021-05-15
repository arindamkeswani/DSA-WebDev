Link to demonstration till Menubar formatting functionality: https://youtu.be/QAE0Z7Y3GOM

Features:
Grid has been formed from rows 1-100 and columns A-Z [Values and attributes are stored as objects of a cell in 2-D Array]
----------
Cell:
Put value in cell
Change value in cell
----------
These changes/operations are possible in a cell:
Earlier it was _____ - Can be replaced by _____ [From where]
Value-Value [Cell]
Formula-value [Cell]
value-Formula [Address Bar]
Formula-Formula [Address Bar]
----------
Formatting:
-Font family
-Font size
-Colour
-Background colour
-Bold, Italic, Underline
-Left/Center/Right Aligment
-Address bar shows cell address upon clicking
----------
TEST CASE 1: [Value to Value]
-Formula bar intakes value of a formula to be implements upon currently selected cell
    ->Blur ->Formula Container
    ->Get Cell addresses of formula ( A1 + A2) 
    ->Press Enter
    ->Get each value ( 10 + 20 )
    ->evaluate using either eval() or infix notation (Stack)
    ->Set in UI
    ->Set formula in database (2D-Array of objects)
----------
TEST CASE 2: [Value to Formula]
If value of parent cell is updated, value of all the children cells that depend on it are updated as well
    ->While setting a formula for a cell, set current cell as a child on the list of children in the parent cell's attribute
    ->Done on cell blur
    ->Then call current cell's children, re-evaluate value, do it via recursive call
    ->This is why storing cell formula is important
----------
TEST CASE 3: [Formula to Value]
If formula needs to be removed, changed
    ->Listener is placed on cell blur
    ->Address Bar
        ->Remove formula from DB
        ->Go to parent, remove current cell from children array
----------
TEST CASE 4: [Formula to another Formula]
If formula needs to be removed, changed
    ->Listener is placed on cell blur
    ->Address Bar
        ->Remove formula from DB
        ->evaluate using either eval() or infix notation (Stack)
        ->Set in UI
        ->Change previous formula in cell if it it not equal to new formula  (2D-Array of objects)
----------
Cycle detection is important in formula setting as that can lead to an infinite loop
Therefore, formula cannot be a cycle, so dependencies need to be checked using cycle detection algorithms