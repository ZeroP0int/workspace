// 单对象编程的方式

var game = {
	redBall:document.getElementById("move"),
	timeNode:document.getElementById("timer"),
	createTimer:null,
	timer:null,
	num:0,
	movePlus:{
		outer:document.getElementById("outer"),
		iWidth:document.getElementById("outer").offsetWidth,
		iHeight:document.getElementById("outer").offsetHeight,
		speedX:10,
		speedY:10
	},
	init : function(){
		// 创建小绿球
		this.createBall(this.movePlus);
		// 拖拽小红球
		this.dragBall(this.moveBall);
		// 计时
		this.timeRun();
	},
	timeRun:function(){
		var self = this;
		this.timer = setInterval(function(){
			self.num++;
			self.timeNode.innerHTML = "已经坚持" + self.num + "秒";
		},1000);
	},
	dragBall:function(obj){
		var self = this;
		this.redBall.onmousedown = function(e){
			e = e || window.event;
			var on_x = e.pageX;
			var on_y = e.pageY;
			document.onmousemove = function(e){
				var cha_x = e.pageX - on_x;
				var cha_y = e.pageY - on_y;
				self.redBall.style.left = self.redBall.offsetLeft + cha_x + "px";
				self.redBall.style.top = self.redBall.offsetTop + cha_y + "px";
				on_x = e.pageX;
				on_y = e.pageY
				// 边界检测
				// 左边
				if (self.redBall.offsetLeft < 0) {
					self.clearTimer();
					alert("游戏结束！已经坚持" + self.num + "秒");
					window.location.reload();
				}
				// 右边
				if (self.redBall.offsetLeft + self.redBall.offsetWidth > obj.iWidth) {
					self.clearTimer();
					alert("游戏结束！已经坚持" + self.num + "秒");
					window.location.reload();
				}
				if (self.redBall.offsetTop < 0) {
					self.clearTimer();
					alert("游戏结束！已经坚持" + self.num + "秒");
					window.location.reload();
				}
				if (self.redBall.offsetTop + self.redBall.offsetHeight > obj.iHeight) {
					self.clearTimer();
					alert("游戏结束！已经坚持" + self.num + "秒");
					window.location.reload();
				}
			}
			this.onmouseup = function(e){
				document.onmousemove = null;
			}
		}
	},
	createBall:function(obj){
		var movePlus = obj;
		// 创建一个小绿球的类
		function Green(movePlus){
			this.ball = document.createElement("div");
			this.ball.className = "green";
			// 让小球随机生成在outer的顶部
			this.iwCurrent = Math.floor(Math.random() * (movePlus.iWidth - 50));
			this.ball.style.left = this.iwCurrent + "px";
			movePlus.outer.appendChild(this.ball);
			this.speedX = Math.floor(Math.random() * movePlus.speedX);
			this.speedY = Math.floor(Math.random() * movePlus.speedY);
			this.iWidth = movePlus.iWidth;
			this.iHeight = movePlus.iHeight;
		}
		var newBall = new Green(movePlus);
		this.moveBall(newBall,this.redBall);
		var self = this;
		this.createTimer = setInterval(function(){
			var newBall = new Green(movePlus);
			self.moveBall(newBall,self.redBall);
		},2000)
	},
	moveBall:function(obj, redBall){
		var self = this;
		obj.ball.getTimer = setInterval(function(){
			self.crashCheck(obj, redBall);
			var newLeft = obj.speedX + obj.ball.offsetLeft;
			var newTop = obj.speedY + obj.ball.offsetTop;
			// 反弹运动
			// 左壁
			if (newLeft < 0) {
				obj.speedX *= -1;
			}
			// 右壁
			if (newLeft > obj.iWidth - obj.ball.offsetWidth) {
				obj.speedX *= -1;
			}
			// 上壁
			if (newTop < 0) {
				obj.speedY *= -1;
			}
			if (newTop > obj.iHeight - obj.ball.offsetHeight) {
				obj.speedY *= -1;
			}
			obj.ball.style.left = newLeft + "px";
			obj.ball.style.top = newTop + "px";
		},50);
	},
	crashCheck:function(obj, redBall){
		var greenX1 = obj.ball.offsetLeft + Math.floor(obj.ball.offsetWidth / 2);
		var greenY1 = obj.ball.offsetTop + Math.floor(obj.ball.offsetWidth / 2);
		var redX2 = redBall.offsetLeft + Math.floor(redBall.offsetWidth / 2);
		var redY2 = redBall.offsetTop + Math.floor(redBall.offsetWidth / 2);

		var dx = Math.abs(greenX1 - redX2);
		var dy = Math.abs(greenY1 - redY2);
		var dis = Math.floor(Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2)));
		var R = obj.ball.offsetWidth/2 + redBall.offsetWidth/2;
		if (dis < R) {
			this.clearTimer();
			alert("游戏结束！已经坚持" + this.num + "秒");
			window.location.reload();
		}
	},
	clearTimer:function(){
		clearInterval(this.createTimer);
		clearInterval(this.timer);
		var outer = this.movePlus.outer;
		var allBalls = outer.getElementsByClassName("green");
		for(var i = 0; i < allBalls.length; i++){
			clearInterval(allBalls[i].getTimer);
		}
	}
}
game.init();