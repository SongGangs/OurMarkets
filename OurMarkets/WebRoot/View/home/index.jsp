<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'home.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title></title>
<script src="/OurMarkets/JS/Common/jquery-1.10.2.min.js"></script>
<script src="/OurMarkets/JS/Common/layer.js"></script>
<script src="/OurMarkets/JS/Common/jquery.validate.min.js"></script>
<script src="/OurMarkets/JS/Common/bootstrapValidator.min.js"></script>
<script src="/OurMarkets/JS/Account/Account.js"></script>
<link href="/OurMarkets/CSS/Common/layer.css" rel="stylesheet" />
<link href="/OurMarkets/CSS/Account/Account.css" rel="stylesheet" />
<link href="/OurMarkets/CSS/Common/bootstrap.min.css" rel="stylesheet" />
<link href="/OurMarkets/CSS/Common/bootstrapValidator.min.css" rel="stylesheet" />

</head>

<body>
	<div>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="a_register" href="javascript:;"><span
					class="glyphicon glyphicon-user"></span> 注册</a></li>
			<li><a class="a_login" href="javascript:;"><span
					class="glyphicon glyphicon-log-in"></span> 登录</a></li>
		</ul>
	</div>
	<!--登陆界面-->
	<div id="login" class="floatDiv">
		<div class="well">
			<form id="login-from" method="post" class="form-horizontal" action="">
				<div class="input-group ">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="login_username"
						type="text" name="username" class="form-control "
						placeholder="请输入用户名" />
				</div>
				<div class="input-group ">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="login_password"
						type="password" name="password" class="form-control "
						placeholder="请输入密码" />
				</div>
				<div class="checkbox  mycheckbox">
					<label><input type="checkbox">记住密码</label>
				</div>
				<div class="text-right">
					<input type="button" id="loginBtn" class="btn btn-primary"
						value="登录"> <input type="button" class="btn btn-danger"
						onclick=" layer.closeAll('page'); " value="取消">
				</div>
				<a class="a_register" href="javascript:;">还没有账号？点我注册</a>
			</form>
		</div>
	</div>
	<!--注册界面-->
	<div id="register" class="floatDiv">
		<div class="well ">
			<!-- class都是bootstrap定义好的样式，验证是根据input中的name值 -->
			<form id="register-from" method="post"  class="form-horizontal" action="">
				<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
				<div class="form-group input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user" aria-hidden="true"></i></span> <input
						id="register_username" class="form-control" name="username"
						type="text" placeholder="由字母或数字或汉字组成">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input class="form-control"
						id="register_password" name="password" type="password"
						placeholder="必须包含6-16位字母或数字">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-ok"></i></span> <input class="form-control"
						id="register_confirm_password" name="confirm_password"
						type="password" placeholder="再次输入密码验证">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-phone"></i></span> <input class="form-control"
						id="register_phone" name="phone" type="text"
						placeholder="请输入11位手机号码">
				</div>
				<div class="form-group input-group">

					<span class="input-group-addon"><i
						class="glyphicon glyphicon-envelope"></i></span> <input
						class=" form-control " id="register_identifyCode"
						style="width: 200px" name="identifyCode" type="text"
						placeholder="请输入验证码"> <input type="button" class="btn"
						style="margin-left: 10px" value=" 获取验证码" />
				</div>

				<div class="text-right">
					<input type="button" id="registerBtn" class="btn btn-primary"
						value="登录"> <input type="button"
						class="btn btn btn-danger" onclick=" layer.closeAll('page'); "
						value="取消">
				</div>

				<a class="a_login" href="javascript:;">已有账号？点我登录</a>
			</form>
		</div>

	</div>

</body>
</html>
