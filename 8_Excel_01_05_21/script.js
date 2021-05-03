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

firstSheet.addEventListener("click", handleActiveSheet);

let colorBtn = document.querySelector(".color-container #color");
let bgColorBtn = document.querySelector(".color-container #bg-color");

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
    //page add
    sheetList.appendChild(newSheet);
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
    });
}

//Align text left
leftBtn.addEventListener("click",function(){
    let address=addressBar.value;
    
    let {rid,cid}= getRidCidfromAddress(address);
    // console.log(rid,cid);
    let cell = document.querySelector(`.grid .col[rid="${rid}"][cid="${cid}"]`);
    console.log(cell.innerText);
    cell.style.textAlign="left";
})

//Align text right
rightBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "right";
})

//Align text center
centerBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "center";
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
})

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

//Make text bold
let boldIter=0;
boldBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    
    if(boldIter==0){
        cell.style.fontWeight = "bold";
        boldIter=1;
    }else{
        cell.style.fontWeight = "normal";
        boldIter=0;
    }
    
})

//Make text Italic
let italicIter=0;
italicBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    
    if(italicIter==0){
        cell.style.fontStyle = "italic";
        italicIter=1;
    }else{
        cell.style.fontStyle = "normal";
        italicIter=0;
    }
    
})

//Make text underlined
let underlineIter=0;
underlineBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    
    
    if(underlineIter==0){
        cell.style.textDecoration = "underline";
        underlineIter=1;
    }else{
        cell.style.textDecoration = "none";
        underlineIter=0;
    }
    
})

//Change font family
fontOptionBtn.addEventListener("change", function () {
    let font = fontOptionBtn.value;
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    console.log(font);
    cell.style.fontFamily = font;
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
})


Allcells[0].click();


