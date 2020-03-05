// 绑定事件函数
function bindEvent(){
	$('#menu-list').on('click', 'dd', function(){
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
		// var id = $(this).attr('data-id');
		var id = $(this).data('id');
		$('.content').fadeOut();
		$('#' + id).fadeIn();
	});
	// 添加学生页面的提交
	$('#add-student-btn').click(function(e){
		e.preventDefault();
		var data = $('#add-student-form').serializeArray();
		data = checkData(data);
		if (data) {
			transferData('api/student/addStudent', data, function(res){
				alert("提交成功！");
				$('#menu-list > dd[data-id=student-list]').trigger('click');
			});
		}
	});
}
// 数据交互的方法
function transferData(url, data, cb){
	$.ajax({
		url: 'http://api.duyiedu.com/' + url,
		type: 'get',
		data: $.extend({
			appkey: 'JingHaihan_1558881931248'
		}, data),
		success: function(res){
			if (res.status == 'success') {
				cb(res.data)
			}else{
				alert(res.msg);
			}
		}
	})
}
// 校验数据是否填写全
function checkData(data){
	var obj = {};
	var flag = true;
	data.forEach(function(item, index){
		obj[item.name] = item.value;
		if (!item.value) {
			flag = false;
		}
	});
	if (!flag) {
		return false;
	}
	return obj;
}
function init(){
	bindEvent();
	$('#menu-list > dd[data-id=student-list]').trigger('click');
}
init();