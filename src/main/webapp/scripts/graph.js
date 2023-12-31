const form = document.getElementById("formSelect")
const divCanvas = document.getElementById('div-canvas');
divCanvas.innerHTML = "<canvas id=\"canvas\" height=\"325\" width=\"325\"></canvas>"

const canvas = document.getElementById("canvas")

let ctx = canvas.getContext('2d');
const radiusInPixel = 25;
const centerX = 151.5
const centerY = 151.5
const widthAxisY = 3
const heightAxisX = 3
let radius = 0.1;

function validPixelXY(X, Y){
    return (!isNaN(X) && !isNaN(Y))
}

function convertPixelToCoordY(coord, radiusInPixel){
    return (centerY - coord) / radiusInPixel
}

function convertPixelToCoordX(coord, radiusInPixel){
    return (coord - centerX) / radiusInPixel
}

function validR(R){
    return (R !== "" && parseFloat(R) >= 0.1 && parseFloat(R) <= 3)
}

canvas.addEventListener('mousedown', function (event){
    const inputTextR = document.getElementById("formSelect:r_input")
    const errMsg = document.getElementById("errMsg")
    if (validR(inputTextR.ariaValueNow)) {
        errMsg.innerHTML = ""
        if (validPixelXY(event.offsetX, event.offsetY)) {
            const beanValueX = document.getElementById("graphSelect:graph-x")
            const beanValueY = document.getElementById("graphSelect:graph-y")
            const beanValueR = document.getElementById("graphSelect:graph-r")
            const btn = document.getElementById("graphSelect:sendBtnCanvas")

            beanValueX.value = convertPixelToCoordX(event.offsetX, radiusInPixel)
            beanValueY.value = convertPixelToCoordY(event.offsetY, radiusInPixel)
            beanValueR.value = inputTextR.ariaValueNow

            btn.click()
        }
    }else {
        errMsg.style.color = "red"
        errMsg.textContent = "Ошибка в радиусе(доступный диапозон [0.1;3]"
    }

})

function printPointFromTable(){
    const all_tr = document.querySelectorAll("#result-table tbody > tr")
    const last_tr = all_tr[all_tr.length - 1]
    printPoint(parseFloat(last_tr.cells[0].textContent),
                parseFloat(last_tr.cells[1].textContent),
                    parseFloat(last_tr.cells[2].textContent),
                    last_tr.cells[3].textContent.trim() === "Попал" ? "red" : "green")
}

function refreshGraph(){
    const inputTextR = document.getElementById("formSelect:r_input")
    const errMsg = document.getElementById("errMsg")
    if (validR(inputTextR.ariaValueNow)) {
        radius = parseFloat(inputTextR.ariaValueNow)
        draw(centerX, centerY, radiusInPixel * inputTextR.ariaValueNow, widthAxisY, heightAxisX)
        errMsg.innerHTML = ""
        return
    }
    errMsg.style.color = "red"
    errMsg.textContent = "Ошибка в радиусе(доступный диапозон [0.1;3]"

}

draw(centerX, centerY, radiusInPixel, widthAxisY, heightAxisX)
function draw(centerX, centerY, radiusInPixel, widthAxisY, heightAxisX){

    ctx.clearRect(0, 0, 325, 325);
    ctx.fillStyle = 'black'

    //четверть круга
    ctx.beginPath()
    ctx.moveTo(centerX, centerY)
    ctx.arc(centerX, centerY, radiusInPixel, 0, Math.PI/2, false)
    ctx.fillStyle = 'blue'
    ctx.fill()

    //квадрат
    ctx.beginPath()
    ctx.fillRect(centerX - radiusInPixel/2, centerY, radiusInPixel/2, radiusInPixel)

    //треугольник
    ctx.moveTo(centerX, centerY - radiusInPixel)
    ctx.lineTo(centerX - radiusInPixel, centerY)
    ctx.lineTo(centerX, centerY)
    ctx.fill()

    ctx.fillStyle = 'black'
    //оси
    ctx.beginPath()
    ctx.fillRect(centerX - widthAxisY/2, 25, widthAxisY, 250)
    ctx.fillRect(25, centerY - heightAxisX/2, 250, heightAxisX)

    // Y X
    ctx.font = "15px serif";
    ctx.fillText("Y", 155, 25);
    ctx.fillText("X", 275, 145);

    //верхняя стрелка
    ctx.moveTo(centerX, 27)
    ctx.lineTo(142, 35)
    ctx.moveTo(centerX, 22)
    ctx.lineTo(141, 34)
    ctx.lineTo(centerX, 27)
    ctx.fill()

    ctx.moveTo(centerX, 27)
    ctx.lineTo(162, 35)
    ctx.moveTo(centerX, 22)
    ctx.lineTo(163, 34)
    ctx.lineTo(centerX, 27)
    ctx.fill()

    //боковая стрелка
    ctx.moveTo(272, centerY)
    ctx.lineTo(264, 140)
    ctx.moveTo(276, centerY)
    ctx.lineTo(263, 139)
    ctx.lineTo(272, centerY)
    ctx.fill()

    ctx.moveTo(272, centerY)
    ctx.lineTo(264, 165)
    ctx.moveTo(276, centerY)
    ctx.lineTo(263, 164)
    ctx.lineTo(272, centerY)
    ctx.fill()

    //черточки
    ctx.fillStyle = 'black'
    ctx.fillRect(centerX - 4.5, centerY - radiusInPixel, 8, 2)
    ctx.fillRect(centerX - 4.5, centerY - radiusInPixel/2, 8, 2)
    ctx.fillRect(centerX - 4.5, centerY + radiusInPixel/2, 8, 2)
    ctx.fillRect(centerX - 4.5, centerY + radiusInPixel, 8, 2)

    ctx.fillRect(centerX - radiusInPixel, centerY - 4.5, 2, 8)
    ctx.fillRect(centerX - radiusInPixel/2, centerY - 4.5, 2, 8)
    ctx.fillRect(centerX + radiusInPixel/2, centerY - 4.5, 2, 8)
    ctx.fillRect(centerX + radiusInPixel, centerY - 4.5, 2, 8)

    ctx.font = "15px serif";
    ctx.fillText(radius.toString(), centerX + 4.5, centerY - radiusInPixel);
    ctx.fillText(radius.toString(), centerX + radiusInPixel, centerY - 4.5);
}

function printPoint(X, Y, R, color){
    draw(centerX, centerY, radiusInPixel * R, widthAxisY, heightAxisX)
    let x = centerX - 2 + radiusInPixel * X
    let y = centerY - 2 + (-radiusInPixel * Y)
    ctx.fillStyle = color
    ctx.fillRect(x, y, 4, 4)
}