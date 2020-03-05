(function(){
    // 创建轮播图对象的构造函数
    function Swiper(options){
        // 轮播图插入的位置
        this.wrap = options.wrap || $('body');
        // 轮播的图片列表
        this.imgList = options.imgList;
        // 存储展示区域的宽度
        this.showImgWidth = options.showImgWidth || $(this.wrap).width();
        // 轮播的动画类型
        this.animateType = options.animateType || "fade";
        // 是否展示左右切换按钮
        this.changeBtn = options.changeBtn;
        // 是否展示小圆点
        this.showPointBtn = options.showPointBtn;
        // 是否自动轮播
        this.isAuto = options.isAuto;
        this.imgWidth = options.imgWidth || $(this.wrap).width();
        this.imgHeight = options.imgHeight || $(this.wrap).height();
        this.imgNum = this.showImgWidth ?  Math.floor(this.imgList.length * this.imgWidth / this.showImgWidth) : this.imgList.length;
        // this.imgNum = this.imgList.length;
        this.nowIndex = 0;
        this.lock = true;
        // 初始化函数
        this.init = function(){
            // 创建轮播图结构
            this.createDom();
            // 初始化样式
            this.initStyle();
            // 绑定事件
            this.bindEvent();
            if (this.isAuto) {
                this.autoChange();
            }
        }
    }
    // 创建轮播图结构
    Swiper.prototype.createDom = function(){
        var oUl = $('<ul class="swiper-wrap"></ul>');
        var spotDiv = $('<div class="spot"></div>');
        this.imgList.forEach(function(item){
            $('<li><a href="#"><img src="' + item + '"></a></li>').appendTo(oUl);
            $('<span></span>').appendTo(spotDiv);
        });
        if (this.animateType == "animate") {
            var num = Math.floor(this.showImgWidth / this.imgWidth);
            for(var i = 0; i < num; i++){
                $('<li><a href="#"><img src="' + this.imgList[i] + '"></a></li>').appendTo(oUl);
            }
        }
        var leftBtn = $('<div class="btn left-btn">&lt;</div>');
        var rightBtn = $('<div class="btn right-btn">&gt;</div>');
        $(this.wrap).append(oUl);
        $(this.wrap).append(leftBtn).append(rightBtn);
        if (!this.changeBtn) {
            $('.btn', this.wrap).css({
                display: 'none'
            });
        }
        if (this.showPointBtn) {
            $(this.wrap).append(spotDiv);
        }
    }
    // 初始化样式
    Swiper.prototype.initStyle = function(){
        $(this.wrap).css({
            position: 'relative',
            overflow: 'hidden'
        });
        $('*', this.wrap).css({
            listStyle: 'none',
            textDecoration: 'none',
            padding: 0,
            margin: 0
        }).find('a').css({
            width: '100%',
            height: '100%',
            display: 'inline-block'
        });
        $('img', this.wrap).css({
            width: '100%',
            height: '100%'
        });
        if (this.animateType == "animate") {
            $('.swiper-wrap', this.wrap).css({
                // width: this.imgWidth * (this.imgNum + 1),
                width: this.animateType == 'fade' ? this.showImgWidth * this.imgNum : this.showImgWidth * this.imgNum + this.showImgWidth,
                height: this.imgHeight,
                position: 'absolute',
                // overflow: 'hidden'
            }).find('li').css({
                width: this.imgWidth,
                height: this.imgHeight,
                float: 'left'
            })
        }else {
            $('.swiper-wrap', this.wrap).css({
                width: this.showImgWidth,
                position: 'relative'
            }).find('li').css({
                position: 'absolute',
                left: 0,
                top: 0,
                width: this.imgWidth,
                height: this.imgHeight,
                display: 'none'
            }).eq(this.nowIndex).css({
                display: 'block'
            })
        }
        $('.btn', this.wrap).css({
            width: 30,
            height: 50,
            lineHeight: '50px',
            background: 'rgba(0, 0, 0, 0.5)',
            color: '#fff',
            textAlign: 'center',
            position: 'absolute',
            top: '50%',
            marginTop: -15,
            cursor: 'pointer'
        }).filter('.right-btn').css({
            right: 0
        });
        $('.spot', this.wrap).css({
            position: 'absolute',
            bottom: 10,
            width: '100%',
            textAlign: 'center',
            cursor: 'pointer'
        })
        $('.spot > span', this.wrap).css({
            display: 'inline-block',
            width: 10,
            height: 10,
            margin: '0 5px',
            borderRadius: '50%',
            background: '#fff'
        }).eq(this.nowIndex).css({
            background: 'red'
        });
    }
    // 绑定事件
    Swiper.prototype.bindEvent = function(){
        var self = this;
        $('.left-btn', this.wrap).click(function(){
            if (!self.lock) {
                return false;
            }
            if (self.nowIndex == 0) {
                if (self.animateType == "animate") {
                    $('.swiper-wrap', self.wrap).css({
                        left: -self.showImgWidth * self.imgNum
                        // left: -self.imgWidth * self.imgNum
                    });
                }
                self.nowIndex = self.imgNum - 1;
            }else {
                self.nowIndex --;
            }
            self.changeImg();
        });
        $('.right-btn', this.wrap).click(function(){
            if (!self.lock) {
                return false;
            }
            if (self.animateType == "fade" && self.nowIndex == self.imgNum - 1 ) {
                self.nowIndex = 0;
            }else if (self.animateType == "animate" && self.nowIndex == self.imgNum) {
                if (self.animateType == "animate") {
                    self.nowIndex = 0;
                    $('.swiper-wrap', self.wrap).css({
                        left: 0
                    });
                    self.nowIndex++;
                }
                // self.nowIndex = 1;
            }else {
                self.nowIndex ++;
            }
            self.changeImg();
        });
        $('.spot > span', this.wrap).click(function(){
            if (!self.lock) {
                return false;
            }
            self.nowIndex = $(this).index();
            self.changeImg();
        })
        $(this.wrap).mouseenter(function(){
            clearTimeout(self.timer);
        }).mouseleave(function(){
            if (self.isAuto) {
                self.autoChange();
            }
        })
    }
    Swiper.prototype.changeImg = function(){
        this.lock = false;
        var self = this;
        if (this.animateType == "fade") {
            $('.swiper-wrap > li', this.wrap).fadeOut().eq(this.nowIndex).fadeIn(function(){
                self.lock = true;
            });
            // $('.spot > span', this.wrap).css({
            //  background: "#fff"
            // }).eq(this.nowIndex).css({
            //  background: 'red'
            // });
        }else {
            $('.swiper-wrap', this.wrap).animate({
                left: -this.showImgWidth * this.nowIndex
                // left: -this.nowIndex * this.imgWidth
            }, function(){
                self.lock = true;
            });
        }
        $('.spot > span', this.wrap).css({
            background: "#fff"
        }).eq(this.nowIndex % this.imgNum).css({
            background: 'red'
        });
    }
    Swiper.prototype.autoChange = function(){
        var self = this;
        this.timer = setInterval(function(){
            $('.right-btn', self.wrap).trigger('click');
        },3000)
    }
    // $.extend()
    // fn == prototype
    // $.fn.extend()
    $.fn.extend({
        swiper: function(options){
            options.wrap = this;
            var obj = new Swiper(options);
            obj.init();
        }
    })
}())