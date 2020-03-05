var selMonth = document.getElementById("selMonth");
var selYear = document.getElementById("selYear");
var divContent = document.getElementById("divContent");


function appendToSelect(num, selDom){
	var option = document.createElement("option");
	option.innerHTML = num;
	option.value = num;
	selDom.appendChild(option);
}
// 设置选择区域
function setSelectArea(){
	// 生成月份
	for(var i = 1; i <= 12; i++){
		appendToSelect(i, selMonth);
	}
	// 生成年份
	var year = new Date().getFullYear();
	var month = new Date().getMonth() + 1;
	for(var i = year - 100; i <= year + 100; i++){
		appendToSelect(i, selYear);
	}
	// 设置默认选中
	selYear.value = year;
	selMonth.value = month;
	// 设置事件
	selYear.onchange = function(){
		setCalendarContent();
	}
	selMonth.onchange = function(){
		setCalendarContent();
	}
	// 点击今天事件
	btnToday.onclick = function(){
		selYear.value = year;
		selMonth.value = month;
		setCalendarContent();
	}
}
// 根据选中的年份和月份，得到一些有用的信息
function getInfo(){
	var year = parseInt(selYear.value);
	var month = parseInt(selMonth.value);
	var obj = {
		year,
		month
	}
	// 是不是闰年,4年一闰，100年不闰，400年一闰
	obj.isLeap = year % 4 === 0 && year % 100 !== 0 || year % 400 === 0;
	// if (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0) {
	// 	obj.isLeap = true;
	// }esle{
	// 	obj.isLeap = false;
	// }

	// 计算本月有多少天
	if (month === 2) {
		obj.days = obj.isLeap ? 29 : 28;
		// if (obj.isLeap) {
		// 	obj.days = 29;
		// }else{
		// 	obj.days = 28;
		// }
	}else if(month <= 7){
		obj.days = month%2===0 ? 30 : 31;
	}else{
		obj.days = month%2===0 ? 31 : 30;
	}

	// 本月1号是星期几？
	var d = new Date(year, month - 1, 1);
	obj.dayOfWeek = d.getDay();
	if (obj.dayOfWeek === 0) {
		obj.dayOfWeek = 7;
	}

	return obj;
}
// 根据选中的年份和月份，设置日历内容部分
function setCalendarContent(){
	var obj = getInfo();
	// 根据当前的天数，设置内容区域
	divContent.innerHTML = "";
	// 加空的span
	for(var i = 0; i < obj.dayOfWeek - 1; i++){
		appendToSelect("",divContent,"span");
	}
	// 加数字
	var d = new Date();
	var y = parseInt(d.getFullYear());
	var m = parseInt(d.getMonth() + 1);
	var day = parseInt(d.getDate());
	for(var i = 1; i <= obj.days; i++){
		var span = document.createElement("span");
		span.innerHTML = i;
		divContent.appendChild(span);
		if (obj.year == y && obj.month == m && i == day) {
			span.className = "active";
		}
	}
}

setSelectArea();
setCalendarContent();