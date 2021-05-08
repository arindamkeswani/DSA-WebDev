let addbtnContainer = document.querySelector(".add-sheet-container");
let sheetList= document.querySelector(".sheets-list");
let firstSheet = document.querySelector(".sheet");
let Allcells = document.querySelectorAll(".grid .col");
let addressBar = document.querySelector(".address-box");

let leftBtn = document.querySelector(".left");
let rightBtn = document.querySelector(".right");
let centerBtn = document.querySelector(".center");

let fontBtn = document.querySelector(".font-size");
let fontOptionBtn = document.querySelector(".font-family");

let boldBtn = document.querySelector(".bold");
let italicBtn = document.querySelector(".Italic");
let underlineBtn = document.querySelector(".underline");

let allAlignBtns = document.querySelectorAll(".alignment-container>*");

let colorBtn = document.querySelector(".color-container #color");
let bgColorBtn = document.querySelector(".color-container #bg-color");

let sheetDB = worksheetDB[0];

firstSheet.addEventListener("click", handleActiveSheet);

//Add sheet
addbtnContainer.addEventListener("click",function(){
    let sheetsArr = document.querySelectorAll(".sheet");
    let lastSheetElem = sheetsArr[sheetsArr.length - 1];
    let idx = lastSheetElem.getAttribute("sheetIdx");
    idx = Number(idx);
    let newSheet = document.createElement("div");
    newSheet.setAttribute("class","sheet");
    newSheet.setAttribute("sheetIdx",idx+1);
    newSheet.innerText = `Sheet ${idx + 1}`;
    
    //db
    // active set
    sheetsArr.forEach(function (sheet){
        sheet.classList.remove("active-sheet");
    })

    //page add
    sheetList.appendChild(newSheet);

    sheetsArr = document.querySelectorAll(".sheet");
    sheetsArr[sheetsArr.length - 1].classList.add("active-sheet");
    //2d array
    initCurrentSheetDB();
    sheetDB = worksheetDB[idx];
    //cell empty
    //new page element value empty
    initUI();
    //change sheet

    newSheet.addEventListener("click",handleActiveSheet);
})

//Handle formatting of sheet row
function handleActiveSheet(e){
    let mySheet = e.currentTarget;
    let sheetsArr = document.querySelectorAll(".sheet");
    sheetsArr.forEach(function (sheet){
        sheet.classList.remove("active-sheet");
    })
    if(!mySheet.classList[1]){
        mySheet.classList.add("active-sheet");
    }
    //index
    let sheetIdx = mySheet.getAttribute("sheetIdx");
    sheetDB = worksheetDB[sheetIdx - 1];
    setUI(sheetDB);
}

//Event to assign value to Address bar
for(let i=0;i<Allcells.length; i++){
    Allcells[i].addEventListener("click", function handleCell(){
        let rid=Number(Allcells[i].getAttribute("rid"));
        let cid=Number(Allcells[i].getAttribute("cid"));
        let rowAdd = rid+1;
        let colAdd = String.fromCharCode(cid+65);
        let address = colAdd + rowAdd;
        addressBar.value=address;
        let cellObject = sheetDB[rid][cid];

        // styling-> set 
        // object styling set 
        // UI 
        // cell

        // boldness
        if (cellObject.bold == true) {
            boldBtn.classList.add("active-btn")
        } else {
            boldBtn.classList.remove("active-btn");
        }
        // italic
        if (cellObject.italic == true) {
            italicBtn.classList.add("active-btn")
        } else {
            italicBtn.classList.remove("active-btn");
        }
        //underline
        if (cellObject.underline == true) {
            underlineBtn.classList.add("active-btn")
        } else {
            underlineBtn.classList.remove("active-btn");
        }
        // alignment
        for (let i = 0; i < allAlignBtns.length; i++) {
            allAlignBtns[i].classList.remove("active-btn");
        }
        // console.log(cellObject.halign);
        if (cellObject.halign == "left") {
            // left active
            leftBtn.classList.add("active-btn")
        } else if (cellObject.halign == "right") {
            rightBtn.classList.add("active-btn")
            // right active
        } else if (cellObject.halign == "center") {
            centerBtn.classList.add("active-btn")
        }

        //Font size
        let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
        // cell.style.fontSize = cellObject.fontSize;
        fontBtn.value = cellObject.fontSize;

        //Font family
        // cell.style.fontFamily = cellObject.fontFamily;
        fontOptionBtn.value=cellObject.fontFamily;
        
        //color
        colorBtn.value = cellObject.color;
        bgColorBtn.value = cellObject.bgColor;
    });
}

Allcells[0].click();
// ****************formatting*****************
//Align text left
leftBtn.addEventListener("click",function(){
    let address=addressBar.value;
    
    let {rid,cid}= getRidCidfromAddress(address);
    // console.log(rid,cid);
    let cell = document.querySelector(`.grid .col[rid="${rid}"][cid="${cid}"]`);
    console.log(cell.innerText);
    cell.style.textAlign="left";
    for (let i = 0; i < allAlignBtns.length; i++) {
        allAlignBtns[i].classList.remove("active-btn");
    }

    leftBtn.classList.add("active-btn");
    // db update 
    let cellObject = sheetDB[rid][cid];
    cellObject.halign = "left";
})

//Align text right
rightBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "right";

    for (let i = 0; i < allAlignBtns.length; i++) {
        allAlignBtns[i].classList.remove("active-btn");
    }
    rightBtn.classList.add("active-btn");
    // db update 
    let cellObject = sheetDB[rid][cid];
    cellObject.halign = "right";
})

//Align text center
centerBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "center";

    for (let i = 0; i < allAlignBtns.length; i++) {
        allAlignBtns[i].classList.remove("active-btn");
    }
    centerBtn.classList.add("active-btn");
    let cellObject = sheetDB[rid][cid];
    cellObject.halign = "center";

})

//Change font size
fontBtn.addEventListener("change", function () {
    let fontSize = fontBtn.value;
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    console.log(fontSize);
    cell.style.fontSize = fontSize+"px";

    let cellObject = sheetDB[rid][cid];
    cellObject.fontSize = fontSize;
})

//Make text bold
let boldIter=0;
boldBtn.addEventListener("click", function () {
    let isActive = boldBtn.classList.contains("active-btn");
    console.log(isActive)
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    let cellObject = sheetDB[rid][cid];
    if (isActive == false) {
        // cell text bold
        cell.style.fontWeight = "bold";
        boldBtn.classList.add("active-btn");
        cellObject.bold = true;
    } else {
        // cell text normal
        cell.style.fontWeight = "normal";
        boldBtn.classList.remove("active-btn");
        cellObject.bold = false;
    }
    // let address = addressBar.value;
    // let { rid, cid } = getRidCidfromAddress(address);
    // console.log(rid, cid);
    // let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    // //can also be done with boldBtn.classlist.contains("active-btn"); //return true or false
    // if(boldIter==0){
    //     cell.style.fontWeight = "bold";
    //     boldIter=1;
    //     boldBtn.classList.add("active-btn");
    // }else{
    //     cell.style.fontWeight = "normal";
    //     boldIter=0;
    //     boldBtn.classList.remove("active-btn");
    // }
    
})

//Make text Italic
let italicIter=0;
italicBtn.addEventListener("click", function () {
    let isActive = italicBtn.classList.contains("active-btn");
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    let cellObject = sheetDB[rid][cid];
    if (isActive == false) {
        // cell text bold
        cell.style.fontStyle = "italic";
        italicBtn.classList.add("active-btn");
        cellObject.italic = true
    } else {
        // cell text normal
        cell.style.fontStyle = "normal";
        italicBtn.classList.remove("active-btn");
        cellObject.italic = false
    }
    // let address = addressBar.value;
    // let { rid, cid } = getRidCidfromAddress(address);
    // console.log(rid, cid);
    // let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    
    // if(italicIter==0){
    //     cell.style.fontStyle = "italic";
    //     italicIter=1;
    //     italicBtn.classList.add("active-btn");
    // }else{
    //     cell.style.fontStyle = "normal";
    //     italicIter=0;
    //     italicBtn.classList.remove("active-btn");
    // }
    
})

//Make text underlined
let underlineIter=0;
underlineBtn.addEventListener("click", function () {
    let isActive = underlineBtn.classList.contains("active-btn");
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    let cellObject = sheetDB[rid][cid];
    if (isActive == false) {
        // cell text bold
        cell.style.textDecoration = "underline";
        underlineBtn.classList.add("active-btn");
        cellObject.underline = true
    } else {
        // cell text normal
        cell.style.textDecoration = "none";
        underlineBtn.classList.remove("active-btn");
        cellObject.underline = false
    }
    // let address = addressBar.value;
    // let { rid, cid } = getRidCidfromAddress(address);
    // console.log(rid, cid);
    // let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    
    // if(underlineIter==0){
    //     cell.style.textDecoration = "underline";
    //     underlineIter=1;
    //     underlineBtn.classList.add("active-btn");
    // }else{
    //     cell.style.textDecoration = "none";
    //     underlineIter=0;
    //     underlineBtn.classList.remove("active-btn");
    // }
    
})

//Change font family
fontOptionBtn.addEventListener("change", function () {
    let font = fontOptionBtn.value;
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    cell.style.fontFamily = font;

    let cellObject = sheetDB[rid][cid];
    cellObject.fontFamily = font;
    console.log(cellObject.fontFamily);
})

//change colour
colorBtn.addEventListener("input", function () {
    let colo = colorBtn.value;
    // console.log(colo);
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    cell.style.color = colo;

    let cellObject = sheetDB[rid][cid];
    cellObject.color = colo;
})

//change background colour
bgColorBtn.addEventListener("input", function () {
    let colo = bgColorBtn.value;
    // console.log(colo);
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    cell.style.backgroundColor = colo;
    let cellObject = sheetDB[rid][cid];
    cellObject.bgColor = colo;
})

//HELPER FUNCTIONS

//Get coordinates of cell
function getRidCidfromAddress(address){
    //A1
    let cellColAdr=address.charCodeAt(0);
    let cellrowAdr=address.slice(1);
    // console.log(cellColAdr);
    let cid= cellColAdr-65;
    let rid= Number(cellrowAdr)-1;
    return {rid, cid};
}

function initUI() {
    for (let i = 0; i < Allcells.length; i++) {
        // boldness
        Allcells[i].style.fontWeight = "normal";
        Allcells[i].style.fontStyle = "normal";
        Allcells[i].style.textDecoration = "none";
        Allcells[i].style.fontFamily = "Arial";
        Allcells[i].style.fontSize = "10px";
        Allcells[i].style.textAlign = "left";
        Allcells[i].innerText = "";
    }
}

for (let i = 0; i < Allcells.length; i++) {
    Allcells[i].addEventListener("blur", function handleCell() {
        let address = addressBar.value;
        let { rid, cid } = getRidCidfromAddress(address);
        let cellObject = sheetDB[rid][cid];
        let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
        cellObject.value = cell.innerText;
    });
}

function setUI(sheetDB) {
    for (let i = 0; i < sheetDB.length; i++) {
        for (let j = 0; j < sheetDB[i].length; j++) {
            let cell = document.querySelector(`.col[rid="${i}"][cid="${j}"]`);
            let { bold, italic, underline, fontFamily, fontSize, color, bgColor, halign, value } = sheetDB[i][j];
            cell.style.fontWeight = bold == true ? "bold" : "normal";
            cell.style.fontStyle = italic == true ? "italic" : "normal";
            cell.style.textDecoration = underline == true ? "underline" : "none";
            cell.style.fontFamily = fontFamily;
            cell.style.fontSize = fontSize;
            cell.style.color = color;
            cell.style.backgroundColor = bgColor;
            cell.style.textAlign = halign;
            cell.innerText = value;
        }
    }
}