/// <reference path="jquery-1.10.2.min.js" />
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
					} /*最后一个没有逗号*/
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
					remote : {
						//写短信对比验证逻辑
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

	$("#loginBtn").on("click", function() {
		if ($("#login-from").valid()) {
			var mydata = '{"uNickName":"' + $("#login_username").val() + '","uPassword":"'
				+ $('#login_password').val() + '"}';
				//如果验证成功

			$.post("/OurMarkets/API/Account/Login"
				, {
					uNickName : $("#login_username").val(),
					uPassword : $('#login_password').val()
				}
				, function(data) {
					// Successful requests get here
					// Update the page elements
					alert(data.msg);
				});
		//			$.ajax({
		//				data : "uNickName=" + $("#login_username").val() + "&uPassword=" + $("#login_password").val(),
		//				//data:mydata,
		//				type : "POST",
		//				contentType : 'application/json;charset=utf-8',
		//				dataType : 'json',
		//				url : "/OurMarkets/Account/Login",
		//				success:function(data){
		//					alert(data.msg);
		//				},
		//				error:function(){
		//					alert('System is wrong.');					
		//				}
		//			});
		}
	});

	$("#registerBtn").on("click", function() {
		//如果验证成功
		$.post("/OurMarkets/Account/Login",
			{
				uNickName : $("#login_username").val(),
				uPassword : $("#login_password").val()
			},
			function(data) {
				layer.msg(data, {
					title : "提示",
					icon : 5,
					time : 1000
				});
				layer.closeAll('page');
				alert(data);
			});
	});
});