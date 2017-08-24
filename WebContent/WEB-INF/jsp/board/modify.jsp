<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="/js/jquery-1.11.0.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하고시펑?</title>
<script type="text/javascript">

function modCheck(){
	
if(!check()) return false;
	
	var data = $("#frm").serialize();
	
	$.ajax({
		url: '/board/modify.do',
		data: data,
		type: 'POST',
		dataType: 'json',
		success: function(result){
			alert("저장 되었습니다.");
			//location.href="/system/notice.do?seq=${vo.seq}";
			goBoardList();
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"서버에서 예기치 못한 에러가 발생하였습니다.\n관리자에게 문의 바랍니다.");
		}
	});
	
}

function delCheck(){
	if(!confirm("삭제 하시겠습니까?")) return false;
	else if(!check()) {
		return false;
	}
	
	
	$.ajax({
		url: '/board/delete.do?boardNo=${map.boardNo }',
		processData: false,
		contentType: false,
		data: false,
		type: 'POST',
		dataType: 'json',
		success: function(result){
			alert("삭제 되었습니다.");
			goBoardList();
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"서버에서 예기치 못한 에러가 발생하였습니다.\n관리자에게 문의 바랍니다.");
		}
	});
}

function check(){
	if($("#boardTitle").val()==""){
		alert("제목을 입력해 주세요.");
		$("#boardTitle").focus();
		return false;
	}
	
	if($("#boardUser").val()==""){
		alert("닉네임을 입력해 주세요.");
		$("#boardUser").focus();
		return false;
	}
	
	if($("#boardContent").val()==""){
		alert("내용을 입력해 주세요.");
		$("#boardContent").focus();
		return false;
	}
	
	if($("#boardPw").val()==""){
		alert("패스워드를 입력해 주세요.");
		$("#boardPw").focus();
		return false;
	}
	
	//비밀번호 유효성 체크
	if($("#boardPw").val() == "${map.boardPw}")
	return true;
	else {
		alert("비밀번호가 틀렸습니다.");
		$("#boardPw").focus();
		return false;
	}
	
	document.frm.method = "post";
	document.frm.action = "/board/modify.do";
	document.frm.submit();
	
	return true;
}

function goBoardList(){
	document.frm.method="POST";
	document.frm.action="/board/board.do";
	document.frm.submit();
}
</script>
</head>
<body>
<%@ include file="/WEB-INF/common/top.jsp" %>
<center>
<p>
<h1>modify</h1><img src="/images/peach.PNG" width="100px" height="100px"/>
<p>
<form name="frm" id="frm">
<table border=0>
	<tr>
		<th>제목</th><td><input type="text" name="boardTitle" id="boardTitle" value=${map.boardTitle }></td>
	</tr>
	<tr>
		<th>작성자</th><td><input type="text" name="boardUser" id="boardUser" value=${map.boardUser }></td>
	</tr>
	<tr>
		<th>내용</th><td><textarea rows=30 cols=100 id="boardContent" name="boardContent">${map.boardContent }</textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="password" name="boardPw" id="boardPw"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="뒤로" onclick="javascript:history.go(-1)">
			<input type="button" id="update" name="update" value="등록" onclick="modCheck()">
			<input type="button" id="delete" name="delete" value="삭제" onclick="delCheck()">
		</td>
	</tr>
	<tr>
	<td><input type="hidden" name="boardNo" value=${map.boardNo }></td>
	<td><input type="hidden" name="boardDate" value=${map.boardDate }></td></tr>
</table>
</form>
</center>
</body>
</html>