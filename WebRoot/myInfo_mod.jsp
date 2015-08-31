<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//String name=(String)request.getAttribute("workid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>基本信息展示首页</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<style type="text/css">
body {
	padding-top: 50px;
}

div.icon_in {
	background: url("img/modBg.png") no-repeat;
	width: 200px;
	height: 100px;
}

div.Room {
	width: 50px;
	height: 30px;
}

div.formEditStyle {
	padding-left: 30px;
}

h3.font_style {
	padding-top: 15px;
	text-align: left;
	padding-left: 15px;
}

h3.titlt_style {
	padding-left: 110px;
	font-size: 20px;
}

p.font_small_style {
	text-align: left;
	padding-left: 10px;
	padding-top: 10px;
	font-size: 15px;
}

p.font_bottom_style {
	text-align: left;
	padding-left: 10px;
	padding-top: 15px;
	font-size: 15px;
}

div.button_style {
	text-align: right;
}

img.button_bottom_style {
	width: 25px;
	height: 20px;
}
</style>
</head>
<body>

	<!-- 大屏横幅开始 -->
	<div>
		<h3 class="titlt_style">
			<strong>个人信息----我的资料</strong>
		</h3>
	</div>
	<!-- 大屏横幅结束 -->
	<div id="find" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form class="form-horizontal"
						style="margin-left: 100px;margin-right: 60px;" name="form_f">
						<table>
							<tr style="text-align: center;">
								<p style="font-size: 24px;font-weight: bolder;color: #dca7a7;">请输入修改信息：</p>
							</tr>
							<tr>
								<td>
									<div class="form-group">
										<div class="col-lg-10">
											<input type="text" id="content" class="form-control"
												name="content" value=""
												style="background: #8c9494;border: 0;" size=30>
										</div>
									</div>
								</td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td><input type="button"
									style="width: 100px;height: 30px;margin-left: 13px;border: 0;background-color: #245269;"
									onclick="_f_psw()" id="find_button" value="确定"></td>
								<td><input type="button"
									style="width: 100px;height: 30px;margin-left: 13px;border: 0;background-color: #245269;"
									value="取消" data-dismiss="modal"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 分栏开始 -->
	<div class="container">

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>姓名 </strong>
				</h3>

				<form name="form_name">
					<div class="formEditStyle">
						<input type="text" name="nameEditText" value="" maxlength=16
							size=6 style="background: #8c9494;border: 0px" readonly>
					</div>
				</form>
				<div class="button_style">
					<button class="btn btn-default" data-toggle="modal"
						data-target="#find" onclick="showFind('name');"
						style="background: url('img/Mod.png');height: 25px;width: 20px"></button>
				</div>
			</div>

		</div>

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>性别</strong>
				</h3>

				<form name="form_sex">
					<div class="formEditStyle">
						<input type="text" name="SexEditText" value="" maxlength=16 size=6
							style="background: #8c9494;border: 0px" readonly>
					</div>
				</form>
				<div class="button_style">
					<button class="btn btn-default" data-toggle="modal"
						data-target="#find" onclick="showFind('sex');"
						style="background: url('img/Mod.png');height: 25px;width: 20px"></button>
				</div>
			</div>

		</div>

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>年龄</strong>
				</h3>

				<form name="form_age">
					<div class="formEditStyle">
						<input type="text" name="ageEditText" value="" maxlength=16 size=6
							style="background: #8c9494;border: 0px" readonly>
					</div>
				</form>
				<div class="button_style">
					<button class="btn btn-default" data-toggle="modal"
						data-target="#find" onclick="showFind('age');"
						style="background: url('img/Mod.png');height: 25px;width: 20px"></button>
				</div>
			</div>

		</div>

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>邮箱</strong>
				</h3>

				<form name="form_email">
					<div class="formEditStyle">
						<input type="text" name="emailEditText" value="" maxlength=16
							size=6 style="background: #8c9494;border: 0px" readonly>
					</div>
				</form>
				<div class="button_style">
					<button class="btn btn-default" data-toggle="modal"
						data-target="#find" onclick="showFind('email');"
						style="background: url('img/Mod.png');height: 25px;width: 20px"></button>
				</div>
			</div>

		</div>

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>手机号</strong>
				</h3>

				<form id="form2" name="form_phone">
					<div class="formEditStyle">
						<input type="text" name="phoneEditText" value="" maxlength=16
							id="phoneEditText" size=6 style="background: #8c9494;border: 0px"
							readonly>
					</div>
				</form>
				<div class="button_style">
					<button class="btn btn-default" data-toggle="modal"
						data-target="#find" onclick="showFind('phone');"
						style="background: url('img/Mod.png');height: 25px;width: 20px"></button>
				</div>
			</div>

		</div>

		<div class="text-center col-md-3">

			<div class="icon_in">
				<h3 class="font_style">
					<strong>工号</strong>
				</h3>

				<form id="form1" name="form_wokid">
					<div class="formEditStyle">
						<input type="text" name="numberEditText" value=""
							id="numberEditText" maxlength=16 size=6 id="workid"
							style="background: #8c9494;border: 0px" readonly>
					</div>
				</form>
				
			</div>

		</div>
	</div>
	<!-- 分栏结束 -->

	<script src="scripts/jquery-1.11.0.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		var flag;
		var workId=${sessionScope.workid};
		$.post("login!after",{'workId':workId}, function(result) {
			var obj = eval("(" + result + ")");
			document.form_name.nameEditText.value = obj[0].name;
			document.form_sex.SexEditText.value = obj[0].sex;
			document.form_age.ageEditText.value = obj[0].age;
			document.form_email.emailEditText.value = obj[0].EMail;
			document.form_phone.phoneEditText.value = obj[0].phone;
			document.form_wokid.numberEditText.value = obj[0].workId;
		});
		function showFind(inset) {
			flag = inset;
			$("#find").modal({
				'backdrop' : 'static'
			});
		}
		function closeFind() {
			$("#find").modal('hide');
		}
		function _f_psw() {
			console.log(flag);
			console.log(name);
			if ($("#content").val() == "") {
				alert("can't null");
				return false;
			} else if (flag == 'name' || flag == 'age' || flag == 'sex'
					|| flag == 'email' || flag == 'phone' || flag == 'workId') {
				if (flag == 'name') {
					if ($("#content").val().length > 9) {
						alert("名字不能大于9个字！");
					} else {
						$.post("login!modify", {
							'content' : $("#content").val(),
							'flag' : flag,
							'workId' : workId
						}, function(result) {
							alert("success!");
							location.reload([ true ]);
						});
					}
				} else if (flag == 'age') {
					if (!/^[\d]{1,3}$/.test($("#content").val())) {
						alert("请正确填写年龄！");
					} else {
						$.post("login!modify", {
							'content' : $("#content").val(),
							'flag' : flag,
							'workId' : workId
						}, function(result) {
							alert("success!");
							location.reload([ true ]);
						});
					}
				} else if (flag == 'sex') {
					if ($("#content").val() != '男'
							&& $("#content").val() != '女') {
						alert("性别只能为男或者女！");
					} else {
						$.post("login!modify", {
							'content' : $("#content").val(),
							'flag' : flag,
							'workId' : workId
						}, function(result) {
							alert("success!");
							location.reload([ true ]);
						});
					}
				} else if (flag == 'email') {
					if (!/^[A-Za-z\d]+[A-Za-z\d\-_\.]*@([A-Za-z\d]+[A-Za-z\d\-]*\.)+[A-Za-z]{2,4}$/
							.test($("#content").val())) {
						alert("请正确输入邮箱！");
					} else {
						$.post("login!modify", {
							'content' : $("#content").val(),
							'flag' : flag,
							'workId' : workId
						}, function(result) {
							alert("success!");
							location.reload([ true ]);
						});
					}
				} else if (flag == 'phone') {
					if (!/^[\d]{11}$/.test($("#phone").val())) {
						alert("请正确填写手机号！");
					} else {
						$.post("login!modify", {
							'content' : $("#content").val(),
							'flag' : flag,
							'workId' : workId
						}, function(result) {
							alert("success!");
							location.reload([ true ]);
						});
					}
				} 

			}

		}
	</script>
</body>
</html>
