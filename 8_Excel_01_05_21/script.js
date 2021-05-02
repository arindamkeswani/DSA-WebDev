let addbtnContainer = document.querySelector(".add-sheet-container");
let sheetList= document.querySelector(".sheets-list");
let firstSheet = document.querySelector(".sheet");
let Allcells = document.querySelectorAll(".grid .col");
// console.log(Allcells.classList);
let addressBar = document.querySelector(".address-box");
let leftBtn = document.querySelector(".left");
let rightBtn = document.querySelector(".right");
let centerBtn = document.querySelector(".center");
let fontBtn = document.querySelector(".font-size");

firstSheet.addEventListener("click", handleActiveSheet);


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

leftBtn.addEventListener("click",function(){
    let address=addressBar.value;
    
    let {rid,cid}= getRidCidfromAddress(address);
    // console.log(rid,cid);
    let cell = document.querySelector(`.grid .col[rid="${rid}"][cid="${cid}"]`);
    console.log(cell.innerText);
    cell.style.textAlign="left";
})

rightBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "right";
})

centerBtn.addEventListener("click", function () {
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    cell.style.textAlign = "center";
})

fontBtn.addEventListener("change", function () {
    let fontSize = fontBtn.value;
    let address = addressBar.value;
    let { rid, cid } = getRidCidfromAddress(address);
    console.log(rid, cid);
    let cell = document.querySelector(`.col[rid="${rid}"][cid="${cid}"]`);
    console.log(fontSize);
    cell.style.fontSize = fontSize+"px";
})

function getRidCidfromAddress(address){
    //A1
    let cellColAdr=address.charCodeAt(0);
    let cellrowAdr=address.slice(1);
    // console.log(cellColAdr);
    let cid= cellColAdr-65;
    let rid= Number(cellrowAdr)-1;
    return {rid, cid};
}

Allcells[0].click();
