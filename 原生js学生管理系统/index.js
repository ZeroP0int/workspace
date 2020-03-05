var menuList = document.getElementById("menu-list");
var tbody = document.getElementById("table-body");
var model = document.getElementById("model");
var editForm = document.getElementById("edit-form");
var tableData = [];
var size = 5;
var pageObj = {
	page : 1,
	size : size
}
function bindEvent(){
	// var menuList = document.getElementById("menu-list");
	menuList.addEventListener("click", changeMenu, false);
	var submitBtn = document.getElementById("add-student-btn");
	submitBtn.addEventListener("click", submitStudent, false);
	tbody.addEventListener("click", clickTable, false);
	var editSubmit = document.getElementById("edit-submit-btn");
	editSubmit.addEventListener("click", editStudentSubmit, false);
	var mask = document.getElementById("mask");
	mask.addEventListener("click", closeMask, false);
	var changePage = document.getElementById("page-list");
	changePage.addEventListener("click", findByPage, false);
	var renderPage = document.getElementsByTagName("dd")[0];
	renderPage.addEventListener("click", findByPage, false);
}
function closeMask(e){
	model.style.display = "none";
}
// 用来获取表单数据
// form包括新增学生的form，还有编辑学生的form
function getFormData(form){
	var name = form.name.value;
	var sex = form.sex.value;
	var sNo = form.sNo.value;
	var email = form.email.value;
	var birth = form.birth.value;
	var phone = form.phone.value;
	var address = form.address.value;
	if (!name || !sex || !sNo || !email || !birth || !phone || !address) {
		alert("信息填写不全，请检查！");
		return false;
	}
	var studentObj = {
		name : name,
		sex : sex,
		sNo : sNo,
		email : email,
		birth : birth,
		phone : phone,
		address : address
	};
	return studentObj;
}
function editStudentSubmit(e){
	e.preventDefault();
	var studentObj = getFormData(editForm);
	if (!studentObj) {
		return false;
	}
	transferData("api/student/updateStudent", studentObj, function(result){
		if (result.status == "success") {
			alert("修改成功！");
			editForm.reset();
			model.style.display = "none";
			getTableData();
			// var studentListDom = menuList.getElementsByTagName("dd")[0];
			// studentListDom.click();
		}
	});
	return false;
}
function clickTable(e){
	var tagName = e.target.tagName;
	if (tagName != "BUTTON") {
		return false;
	}
	// edit编辑按钮
	// 判断当前按钮是否是编辑按钮
	var isEdit = [].slice.call(e.target.classList).indexOf("edit");
	// console.log(isEdit);
	if (isEdit > 0) {
		// 获取编辑按钮对应的学生索引值
		var index = e.target.getAttribute("data-index");
		editStudent(tableData[index]);
	}else{
		var index = e.target.getAttribute("data-index");
		// 如果确认返回true，如果取消返回false
		var isDel = window.confirm("确认删除？");
		if (isDel) {
			transferData("api/student/delBySno", {sNo : tableData[index].sNo}, function(result){
				if (result.status == "success") {
					alert("删除成功！");
					getTableData();
					// form.reset();
					// var studentListDom = menuList.getElementsByTagName("dd")[0];
					// studentListDom.click();
				}
			});
		}
	}
}
function editStudent(data){
	model.style.display = "block";
	renderEditForm(data);
}
function renderEditForm(data){
	for(var prop in data){
		if (editForm[prop]) {
			editForm[prop].value = data[prop];
		}
	}
}
function changeMenu(e){
	// 事件源对象（目标对象）
	// console.log(e.target);
	var tagName = e.target.tagName;
	// console.log(tagName);
	if (tagName != "DD") {
		return false;
	}
	// dd获取左侧导航条可选元素
	var dd = this.getElementsByTagName("dd");
	// 将class类名为active的元素清理class类名
	for(var i = 0; i < dd.length; i++){
		// dd[i].className = "";
		// 所有类名存储在类数组中
		dd[i].classList.remove("active");
	}
	// e.target.className = "active";
	// 为当前选中元素添加class类名
	e.target.classList.add("active");
	var id = e.target.getAttribute("data-id");
	var content = document.getElementById(id);
	var contentActive = document.getElementsByClassName("content-active");
	for(var i = 0; i < contentActive.length; i++){
		contentActive[i].classList.remove("content-active");
	}
	content.classList.add("content-active");
	if (id == "student-list") {
		getTableData();
	}
}
// 新增学生
function submitStudent(e){
	// 取消默认事件
	e.preventDefault();
	var form = document.getElementById("add-student-form");
	var studentObj = getFormData(form);
	// Object.assign({},{}) = {}
	if (!studentObj) {
		return false;
	}
	transferData("api/student/addStudent", studentObj, function(result){
		if (result.status == "success") {
			alert("添加成功！");
			form.reset();
			var studentListDom = menuList.getElementsByTagName("dd")[0];
			studentListDom.click();
		}
	});
	// console.log(result);
	// result = {status : "success || fail", msg : ""}
	// if (result.status == "success") {
	// 	alert("添加成功！");
	// 	form.reset();
	// 	var studentListDom = menuList.getElementsByTagName("dd")[0];
	// 	studentListDom.click();
	// }else{
	// 	alert(result.msg);
	// }
	// 取消默认事件
	// return false;
}
// 获取表格数据
function getTableData(){
	// transferData("api/student/findAll",{},function(result){
	// 	tableData = result.data;
	// 	renderTable(result.data);
	// });
	transferData("api/student/findByPage", pageObj, function(result){
		tableData = result.data.findByPage;
		renderTable(tableData);
	});
}
function renderTable(data){
	var str = "";
	var sex = [];
	var age = [];
	for(var i = 0; i < data.length; i++){
		sex[i] = data[i].sex ? '女' : '男';
		age[i] = new Date().getFullYear() - data[i].birth;
		str += "<tr>\
					<td>"+ data[i].sNo +"</td>\
					<td>"+ data[i].name +"</td>\
					<td>"+ sex[i] +"</td>\
					<td>"+ data[i].email +"</td>\
					<td>"+ age[i] +"</td>\
					<td>"+ data[i].phone +"</td>\
					<td>"+ data[i].address +"</td>\
					<td>\
						<button class='btn edit' data-index="+ i +">编辑</button>\
						<button class='btn del' data-index="+ i +">删除</button>\
					</td>\
				</tr>"
	}
	tbody.innerHTML = str;
}
// url: 代表接口文档中的url
// param: 除了appkey之外的数据
// callback: 成功获取数据之后执行的函数
function transferData(url, param, callback){
	var result = saveData("http://api.duyiedu.com/" + url, Object.assign({
		appkey: "JingHaihan_1558881931248"
	},param));
	if (result.status == "success") {
		callback(result);
	}else{
		alert(result.msg);
	}
}
// 向后端存储数据
// url: http://api.duyiedu.com/api/student/findAll
// param:{appkey: JingHaihan_1558881931248} || appkey = JingHaihan_1558881931248
function saveData(url, param) {
    var result = null;
    var xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }
    if (typeof param == 'string') {
        xhr.open('GET', url + '?' + param, false);
    } else if (typeof param == 'object'){
        var str = "";
        for (var prop in param) {
            str += prop + '=' + param[prop] + '&';
        }
        xhr.open('GET', url + '?' + str, false);
    } else {
        xhr.open('GET', url + '?' + param.toString(), false);
    }
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                result = JSON.parse(xhr.responseText);
            }
        }
    }
    xhr.send();
    return result;
}
function findByPage(e){
	var tagName = e.target.tagName;
	var page = 0;
	if (tagName == "DD") {
		page = "1";
	}else{
		page = e.target.innerHTML;
	}
	pageObj.page = page;
	transferData("api/student/findByPage", pageObj, function(result){
		tableData = result.data.findByPage;
		renderTable(tableData);
	});
}
bindEvent();