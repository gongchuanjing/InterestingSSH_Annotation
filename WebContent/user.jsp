<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			function findById() {
				//1.得到录入的id值
				var userid = $("#userid").val();
				
				//2.向服务器发送请求
				$.post("${ pageContext.request.contextPath }/user_findById", {"id":userid}, function(data){
					alert(data);
				}, "json");
			}
		</script>
	</head>
	<body>
		ID：<input type="text" id="userid"/>
		<input type="button" value="查找" onclick="findById()"/>
	</body>
</html>