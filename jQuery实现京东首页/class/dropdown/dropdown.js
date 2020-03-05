(function(){
	// 下拉列表构造函数
	// 创建下拉列表对象
	function DropDown(options){
		this.father = options.father;
		this.menuList = options.menuList;
		this.direction = options.direction || 'y';
		this.colWidth = options.colWidth;
		this.dropDownWidth = options.dropDownWidth;
		this.init = function(){
			this.createDom();
			this.initStyle();
			this.bindEvent();
		}
	}
	DropDown.prototype.createDom = function(){
		var self = this;
		var oDiv = $('<div class="my-dropdown"></div>');
		this.menuList.forEach(function(menu){
			var oDl = $('<dl></dl>');
			if (menu.title) {
				$('<dt>' +menu.title+ '</dt>').appendTo(oDl);
			}
			menu.items.forEach(function(item){
				$('<dd><a href="' +item.href+ '">'+item.name+'</a></dd>').appendTo(oDl);
			});
			if (self.direction == "x") {
				oDl.css({
					width: menu.itemWidth
				});
			}
			if (menu.colWidth) {
				$('dd', oDl).css({
					width: menu.colWidth
				});
			}
			oDiv.append(oDl);
		});
		$(this.father).append(oDiv);
	}
	DropDown.prototype.initStyle = function(){
		$(this.father).css({
			position: 'relative'
		}).find('.my-dropdown').css({
			position: 'absolute',
			width: this.dropDownWidth,
			background: '#fff',
			border: '1px solid #ccc',
			borderTop: 'none',
			display: 'none',
			left: -7,
			zIndex: 200
		}).find('dl').css({
			padding: '10px 0px 10px 15px',
			overflow: 'hidden',
			borderBottom: '1px solid #ccc'
		}).find('dt').css({
			fontWeight: 'bold'
		}).end().find('dd').css({
			width: this.colWidth,
			float: 'left',
			whiteSpace: 'nowrap'
		});
		if (this.direction == 'x') {
			$('.my-dropdown', this.father).css({
				position: 'absolute',
				right: -79,
				left: 'auto',
				padding: '15px 0'
			}).find('dl').css({
				float: 'left',
				borderBottom: 'none',
				borderLeft: '1px solid #ccc'
			});
		}
	}
	DropDown.prototype.bindEvent = function(){
		$('.my-dropdown dl dd', this.father).hover(function(){
			this.color = $(this).css('color');
			$('a', this).css({
				color: 'red'
			})
		},function(){
			$('a', this).css({
				color: this.color
			})
		});
		$(this.father).hover(function(){
			$(this).parent().css({
				background: '#fff'
			})
			$('.my-dropdown', this).show();
		},function(){
			$(this).parent().css({
				background: 'transparent'
			})
			$('.my-dropdown', this).hide();
		});
	}
	$.fn.extend({
		addDropdown: function(options){
			// 保存下拉列表添加到的位置
			options.father = this;
			// 创建一个下拉列表对象
			var obj = new DropDown(options);
			obj.init();
		}
	})
}())