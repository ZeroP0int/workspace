var personArr = [
	{name:'井海涵',src:'./src/img/1.png',des:'身高175cm',sex:'m',age:'14'},
	{name:'李扩',src:'./src/img/2.png',des:'性别undefined',sex:'undefined',age:'40'},
	{name:'赵昆',src:'./src/img/3.png',des:'体重100kg',sex:'m',age:'30'},
	{name:'刘力伟',src:'./src/img/4.png',des:'吃饭吧唧嘴',sex:'m',age:'35'},
	{name:'陈玉林',src:'./src/img/5.png',des:'学习贼认真',sex:'m',age:'23'},
];
// dom感受事件发生 => 更改状态 =>影响视图
// 需求的增加 事件越来越多 状态越来越多 管理状态 合并行为
// 初始化变量
var oUl = document.getElementsByTagName('ul')[0];
var oInput = document.getElementsByTagName('input')[0];
// 数据渲染页面
function renderPage(data){
	// 遍历
	var htmlStr = '';
	oUl.innerHTML = '';
	data.forEach(function(ele, index, self){
		htmlStr = htmlStr + '<li><img src="'+ ele.src +'"></img><p class="name">'+ ele.name +'</p><p class="des">'+ ele.des +'</p></li>'
	});
	oUl.innerHTML = htmlStr;
}
renderPage(personArr);
// 添加行为
oInput.oninput = function(){
	var filterText = this.value;
	// 根据过滤条件，过滤之后的数组
	var newArr = filterArrByText(personArr, filterText);
	renderPage(newArr);
}
// 根据文本进行过滤 纯函数
function filterArrByText(data, text){
	if (!text) {
		return data;
	}else{
		return data.filter(function(ele, index){
			// text存在于ele.name中
			// indexOf如果不存在则返回-1
			// 如果存在则返回子串所在的索引位
			if (ele.name.indexOf(text) != -1) {
				return true;
			};
		});
	}
}
// 按钮效果的切换
// 将类数组截取
// slice方法根据索引值进行截取并返回新的数组
var oBtnArr = [].slice.call(document.getElementsByClassName("btn"));
var lastActiveBtn = oBtnArr[2];
oBtnArr.forEach(function (ele, index, self){
	ele.onclick = function(){
		changeActive(this);
		renderPage(filterArrBySex(personArr, this.getAttribute("sex")));
	}
});
function changeActive(curActiveBtn){
	curActiveBtn.className = "btn active";
	lastActiveBtn.className = "btn";
	lastActiveBtn = curActiveBtn;
}
// 根据性别进行过滤
function filterArrBySex(data, sex){
	if (sex == "all") {
		return personArr;
	}else{
		return data.filter(function(ele, index, self){
			if (ele.sex == sex) {
				return true;
			}else{
				return false;
			}
		});
	}
}