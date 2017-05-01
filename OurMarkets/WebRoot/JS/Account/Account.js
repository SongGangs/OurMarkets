1 /// <reference path="jquery-1.10.2.min.js" />
/// <reference path="jquery.validate.min.js" />


$(function() {
	/**
	      * 下面是进行插件初始化
	      * 你只需传入相应的键值对
	      * 
	      */
	//登陆表单
	//让当前表单调用validate方法，实现表单验证功能
	//这里使用jQuery .validate
	var validator_login = $("#login-from").validate({
		debug : true, //debug，如果这个参数为true，那么表单不会提交，只进行检查，调试时十分方便
		onkeyup : null, //当丢失焦点时才触发验证请求
		rules : {
			//配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
			username : {
				required : true //必填。如果验证方法不需要参数，则配置为true
			},
			password : {
				required : true,
				rangelength : [ 6, 16 ]
			}
		},
		messages : {
			username : {
				required : "请输入用户名"
			},
			password : {
				required : "请输入密码",
				rangelength : $.validator.format("密码长度为{0}-{1}个字符")
			}
		}
	});
	//这里使用bootstrapValidator
	var validator_register = $("#register-from").bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : { /*输入框不同状态，显示图片的样式*/
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : { /*验证*/
			username : { /*键名username和input name值对应*/
				validators : {
					notEmpty : { /*非空提示*/
						message : '用户名不能为空'
					},
//					stringLength : {
//						min : 4,
//						max : 30,
//						message : '用户名长度必须在4到30之间'
//					},
					threshold : 4, //有4字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，4字符以上才开始）
					remote : { //ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
						url : '/OurMarkets/API/Account/CheckuNickNameIsExist', //验证地址
						message : '用户已存在', //提示消息
						delay : 2000, //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST', //请求方式
						/**自定义提交数据，默认值提交当前input value*/
						data : {
							uNickName : function() {
								return $.trim($("#register_username").val());
							}
						}
					}
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : { /*长度提示*/
						min : 6,
						max : 16,
						message : '请输入长度为6-16个字符'
					},
					regexp : {
						regexp : /[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/, //必须包含字母和数字的正则表达式
						message : '必须包含字母和数字 '
					}
				}
			},
			confirm_password : {
				validators : {
					notEmpty : {
						message : '请再次输入密码'
					},
					identical : {
						field : "password",
						message : "两次密码必须一致"
					}
				}
			},
			phone : {
				validators : {
					notEmpty : {
						message : '手机号不能为空'
					},
					regexp : {
						regexp : /^1[3458]\d{9}$/,
						message : '手机号码不正确 '
					}
				}
			},
			identifyCode : {
				validators : {
					notEmpty : {
						message : '短信验证码不能为空'
					},
					stringLength : {
						min : 6,
						max : 6,
						message : '请输入正确长度的短信验证码'
					},
					numeric : {
						message : '短信验证码只能为数字'
					},
					threshold : 5,
					remote : {
						url : '/OurMarkets/API/Account/CheckSecurityCode', //验证地址
						message : '短信验证码不正确', //提示消息
						delay : 2000, //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST', //请求方式
						data : {
							securityCode : function() {
								return $.trim($("#register_identifyCode").val());
							}
						}
					}
				}
			}
		}
	});

	$(".a_login").on("click", function() {
		layer.closeAll('page');
		layer.open({
			type : 1, //此处以iframe举例
			id : 'Layer_Login', //设定一个id，防止重复弹出
			//area: ['500px', '320px'],
			title : '登陆',
			shade : 0.6, //遮罩透明度
			anim : 1, //0-6的动画形式，-1不开启
			content : $("#login"),
			end : function() { //重置validate的验证提示
				$("#login_username").val("");
				$("#login_password").val("");
				validator_login.resetForm(); //重置表单
			}
		});
		AutoFillCookie(); //查看Cookie记录里面是否有保存信息 有就自动填充
	});
	$(".a_register").on("click", function() {
		layer.closeAll('page');
		layer.open({
			type : 1, //Page层类型
			// area: ['500px', '405px'],
			title : '注册',
			shade : 0.6, //遮罩透明度
			anim : 1, //0-6的动画形式，-1不开启
			content : $("#register"),

			end : function() { //重置validate的验证提示
				$("#register_username").val("");
				$("#register_password").val("");
				$("#register_confirm_password").val("");
				$("#register_phone").val("");
				$("#register_identifyCode").val("");
				$("#register-from").data('bootstrapValidator').resetForm(true); //重置表单
			}
		});
	});
	$("#querySecurityCodeBtn").on("click", function() {
		$.post("/OurMarkets/API/Account/SendSecurityCode", {
			phoneNumber : $("#register_phone").val()
		}, function(data) {
			if (data.msg == "success") {
				layer.msg('短信验证码已发送', {
					icon : 1,
					time : 1000
				});
				$("#querySecurityCodeBtn").attr("disabled", true);
			} else {
				layer.msg('短信验证码发送失败', {
					icon : 5,
					time : 1000
				});
			}
		});
	});
	$("#loginBtn").on("click", function() {
		if ($("#login-from").valid()) {
			//如果验证成功
			$.post("/OurMarkets/API/Account/Login"
				, {
					uNickName : $.trim($("#login_username").val()),
					uPassword : $('#login_password').val()
				}
				, function(data) {
					if (data.msg == "success") {
						layer.msg('身份验证通过', {
							icon : 1,
							time : 1000
						});
						layer.closeAll('page');
						//如果记住账户密码被选中 就将登录信息存到Cookie中
						if ($("#login_rememberme").is(':checked')) {
							CookieUserInfo();
						}
					} else {
						layer.msg('身份验证失败', {
							icon : 5,
							time : 1000
						});
					}
				});
		}
	});

	$("#registerBtn").on("click", function() {
		if ($("#register-from").valid()) {
			//如果验证成功
			$.post("/OurMarkets/API/Account/Register",
				{
					uNickName : $.trim($("#register_username").val()),
					uPassword : $("#register_password").val(),
					uPhone : $("#register_phone").val()
				},
				function(data) {
					if (data.msg == "success") {
						layer.msg('用户注册成功', {
							icon : 1,
							time : 1000
						});
						layer.closeAll('page');
					} else {
						layer.msg('用户注册失败', {
							icon : 5,
							time : 1000
						});
					}
				});
		}
	});

	//初始化页面时验证是否记住了密码 
	function AutoFillCookie() {
		//当用户名和密码都不为null 并且也不为undefined时进行调用
		if ($.cookie("username") != undefined && $.cookie("password") != undefined) {
			$("#login_username").val($.cookie("username"));
			$("#login_password").val($.cookie("password"));
			$("#login_rememberme").attr('checked', 'true');
		}
	}
	//Cookie用户登录信息
	function CookieUserInfo() {
		$.cookie("username", $.trim($("#login_username").val()), {
			expires : 7
		}); // 存储一个带7天期限的 cookie   
		$.cookie("password", $("#login_password").val(), {
			expires : 7
		}); // 存储一个带7天期限的 cookie   
	}

});