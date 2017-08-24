<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function logout(){
	document.topFrm.method = "post";
	document.topFrm.action = "/logout.do";
	document.topFrm.submit();
}

</script>

</head>
<body>
	<form id="topFrm" name="topFrm">
		<div style="float: right;">
			${userId }님. 환영합니다. <input onclick="logout()" type="button" value="logout">
		</div>
		<br/></p>
	</form>
</body>
</html>