function getStyle (obj, attr) {
    if (obj.currentStyle) {
        return obj.currentStyle[attr];
    }else {
        return window.getComputedStyle(obj, false)[attr];
    }
}
function startMove (obj, data, func) {         
    clearInterval(obj.timer);
    var iSpeed;
    var iCur;
    var name;            
    startTimer = obj.timer = setInterval(function () {
        var bStop = true;
        for (var attr in data) {
            if (attr === 'opacity') {
                name = attr;
                iCur = parseFloat(getStyle(obj, attr)) * 100;
            }else {
                iCur = parseInt(getStyle(obj, attr));
            }
            iSpeed = ( data[attr] - iCur) / 8;

            if (iSpeed > 0) {
                iSpeed = Math.ceil(iSpeed);
            }else {
                iSpeed = Math.floor(iSpeed);
            }

            if (attr === 'opacity') {
                obj.style.opacity = ( iCur + iSpeed ) / 100; 
            }else {
                obj.style[attr] = iCur + iSpeed + 'px';
            }
            if ( Math.floor(Math.abs(data[attr] - iCur)) != 0 ) {
                bStop = false;
            }
        }
        if (bStop) {					
            clearInterval(obj.timer);
            if (name === 'opacity') {
                obj.style.opacity = data[name] / 100;
            }
            func();
        }
    },30);
} 

var timer = null;
var sliderPage = document.getElementsByClassName("sliderPage")[0];
var moveWidth = sliderPage.children[0].offsetWidth;
var num = sliderPage.children.length - 1;
var leftBtn = document.getElementsByClassName("leftBtn")[0];
var rightBtn = document.getElementsByClassName("rightBtn")[0];
var lock = true;
var index = 0;
var oSpan = document.getElementsByClassName("sliderIndex")[0].getElementsByTagName("span");
leftBtn.onclick = function(){
	autoMove("right->left");
}
rightBtn.onclick = function(){
	autoMove("left->right")
}
for(var i = 0; i < oSpan.length; i++){
	(function(myIndex){
		oSpan[i].onclick = function(){
			console.log(myIndex);
			lock = false;
			clearTimeout(timer);
			index = myIndex;
			startMove(sliderPage, {left: -index * moveWidth},function(){
				lock = true;
				timer = setTimeout(autoMove, 1500);
				changeIndex(index);
			});
		}
	})(i);
}
// direction
// 默认方向/点击右侧按钮 left->right/undefined
// 点击左侧按钮 right->left
function autoMove(direction){
	if (lock) {
		lock = false;
		clearTimeout(timer);
		if (!direction || direction == "left->right") {
			index++;
			startMove(sliderPage, {left:sliderPage.offsetLeft - moveWidth},function(){
				if (sliderPage.offsetLeft == -num * moveWidth) {
					index = 0;
					sliderPage.style.left= "0px";
				}
				timer = setTimeout(autoMove,1500);
				lock = true;
				changeIndex(index);
			});
		}else if(direction == "right->left"){
			if (sliderPage.offsetLeft == 0) {
				index = num;
				sliderPage.style.left = -num * moveWidth + "px";
			}
			index--;
			startMove(sliderPage,{left:sliderPage.offsetLeft + moveWidth},function(){
				timer = setTimeout(autoMove,1500);
				lock = true;
				changeIndex(index);
			});
		}
	}
}
function changeIndex(index){
	for(var i = 0; i < oSpan.length; i++){
		oSpan[i].className = "";
	}
	oSpan[index].className = "active";
}
timer = setTimeout(autoMove, 1500);