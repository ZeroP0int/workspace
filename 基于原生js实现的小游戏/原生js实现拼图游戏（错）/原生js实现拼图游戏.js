// 全局配置
var config = {
	width : 500,
	height : 500,
	row : 3,
	col : 3,
	img : "./img/lol.png",
	gameDom : document.getElementById("game")
}
// 每个小块的宽度和高度,和总方块数目
config.blockWidth = config.width / config.col;
config.blockHeight = config.height / config.row;
config.total = config.row * config.col;

var emptyBlock;


// 生成小方块的函数，直接添加到gameDom中
function createBlockDom(x, y, appendToPage,correctX,correctY){
	var dom = document.createElement("div");
	dom.style.width = config.blockHeight + "px";
	dom.style.height = config.blockHeight + "px";
	dom.style.background = `url("${config.img}")`;
	dom.style.border = "3px solid #fff";
	// 设置该样式，是为了让宽高包含边框的尺寸
	dom.style.boxSizing = "border-box";
	dom.style.position = "absolute";
	// 元素位置？从一个有限的坐标中随机取一个
	dom.style.left = x + "px";
	dom.style.top = y + "px";
	dom.correctX = correctX;
	dom.correctY = correctY;
	// 背景图位置？根据正确位置来算
	dom.style.backgroundPosition = "-${correctX}px -${correctY}px";
	dom.style.cursor = "pointer";
	dom.style.transition = "all .3s";

	dom.onclick = function(){
		// 将当前元素的坐标，与空白元素的坐标交换
		// 判断是否相邻
		var xdis = Math.abs(parseFloat(dom.style.left) - parseFloat(emptyBlock.style.left))
		xdis = parseInt(xdis);
		var ydis = Math.abs(parseFloat(dom.style.top) - parseFloat(emptyBlock.style.top))
		ydis = parseInt(ydis);
		if (xdis + ydis !== config.blockHeight && xdis + ydis !== config.blockWidth) {
			return;
		}

		var x = dom.style.left;
		var y = dom.style.top;
		dom.style.left = emptyBlock.style.left;
		dom.style.top = emptyBlock.style.top;
		emptyBlock.style.left = x;
		emptyBlock.style.top = y;
	}

	// if (isWin()) {
	// 	setTimeout(function(){
	// 		alert("德玛西亚！");
	// 	},300);
	// }

	if (appendToPage) {
		config.gameDom.appendChild(dom);
	}else{
		emptyBlock = dom;
	}
}

function isWin(){
	for(var i = 0; i < config.gameDom.children.length; i++){
		const dom = config.gameDom.children[i];
		if (parseInt(dom.correctX) !== parseInt(dom.style.left) || parseInt(dom.correctY) !== parseInt(dom.style.top)) {
			return false;
		}
	}
	return true;
}

// 得到一个数组，数组中包含所有正确的坐标
function getCorrectPoints(){
	var arr = [];
	// 循环行和列
	for(var i = 0; i < config.row; i++){
		for(var j = 0; j < config.col; j++){
			arr.push({
				x : j * config.blockWidth,
				y : i * config.blockHeight
			});
		}
	}
	return arr;
}

// 根据最大值和最小值得到一个随机数,无法取到最大值
function getRandom(min,max){
	var dec = max - min;
	return Math.floor(Math.random() * dec + min);
}

// 洗牌
function shuffle(arr){
	for(var i = 0; i < arr.lenght - 1; i++){
		// 随机生成下标，然后进行交换
		var index = getRandom(0,arr.length - 1);
		var temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}

// 生成游戏区域
function setGameArea(){
	// 初始化游戏根元素
	config.gameDom.style.width = config.width + "px";
	config.gameDom.style.height = config.height + "px";
	config.gameDom.style.border = "2px solid #ccc";
	config.gameDom.style.position = "relative";
	// 生成小方块（gameDom的子元素）
	// 得到正确坐标的数组
	var points = getCorrectPoints();
	shuffle(points);
	var correctPoints = getCorrectPoints();
	for(var i = 0; i < config.total; i++){
		if (i < config.total - 1) {
			createBlockDom(points[i].x, points[i].y, true, correctPoints[i].x, correctPoints[i].y);
		}else{
			createBlockDom(points[i].x, points[i].y, false, correctPoints[i].x, correctPoints[i].y);
		}
	}
}

setGameArea();