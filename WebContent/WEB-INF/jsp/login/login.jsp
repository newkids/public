<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="/js/jquery-1.11.0.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>

<script type="text/javascript">

function check(){
	var data = $("#frm").serialize();
	$.ajax({
		url: "/loginCheck.do",
		data: data,
		type: 'POST',
		dataType: 'json',
		success: function(result){
			if(result.pass){
				location.href = "/main.do";
			}else{
				alert(result.msg);
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"서버에서 예기치 못한 에러가 발생하였습니다.\n관리자에게 문의 바랍니다.");
		}
	})
}

function checking(){
	document.frm.method = "post";
	document.frm.action = "/loginCheck.do";
	document.frm.submit();
}
</script>

</head>
<body>
	<form id="frm" name="frm" >
	<center>
	<p>
	<p>	
	<p>
		<table>
			<tr>
				<td>id : </td>
				<td><input name="id" type="text" tabindex="1" maxlength="8"></td>
				<td rowspan="2"><input onclick="checking()" type="button" value="확인" tabindex="3" style="height: 50px; width: 50px"></td>
			</tr>
			<tr>
				<td>pw : </td>
				<td><input name="pw" type="password"  tabindex="2"></td>
			</tr>
		</table>
	</form>
</body>
</html>