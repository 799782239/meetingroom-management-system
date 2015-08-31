<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>自定义表格样式</title>
<link href="styles/table.css" rel="stylesheet" />
<script src="scripts/jquery-1.11.0.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
</head>
<body onload="GetUserMeeting()">
	<table id="UserMeeting">
		<caption>
			<h2 style="text-align: left;">会议通知</h2>
		</caption>
		<thead>
			<tr>
				<th>会议室</th>
				<th>时间</th>
				<th>会议主题</th>
				<th>操作</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		function GetUserMeeting() {
			var url = "login!myMeeting";
			var WorkID = ${sessionScope.workid};
			$
					.post(
							url,
							{
								'WorkID' : WorkID
							},
							function(result) {
								var meeting = JSON.parse(result);
								//console.log(result);
								for (var i = 0; i < result.length; i++) {
									var newTr = UserMeeting.insertRow();
									var newTd0 = newTr.insertCell();
									var newTd1 = newTr.insertCell();
									var newTd2 = newTr.insertCell();
									var newTd3 = newTr.insertCell();
									newTd0.innerHTML = meeting[i].room;
									newTd1.innerHTML = meeting[i].time;
									newTd2.innerHTML = meeting[i].title;
									newTd3.innerHTML = '<a href="#" name="'
											+ meeting[i].id
											+ '" onclick="deleteMeeting(this.name)" data-dismiss="modal">删除</a>';
								}
							});
		}
		function deleteMeeting(MeetingId) {
			console.log(MeetingId);
			$.post("login!meetingdelete", {
				'id' : MeetingId
			}, function(result) {

			});
		}
	</script>
</body>
</html>
