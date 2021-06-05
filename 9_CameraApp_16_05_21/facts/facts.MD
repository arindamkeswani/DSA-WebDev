Camera feed
filters
zoom in 
Zoom out
Image can be stored (Browser local storage)
Video recording

1. Media stream
2. canvas api (for drawing)
3. index db (for local storage in browser)

Navigator-Browser representative
Window-Represents a (current )tab/page (Resize events are done here)
Document- Represents the HTML,CSS

Index DB
let req = indexedDB.open(name,version)
onupgradeneeded, onsuccess,onerror (3 mainly used methods)

if(current version (X) > version of DB in browser (Y)), upgradeneeded->success
if X < Y -> error
if x=y , successs, can be used for reading