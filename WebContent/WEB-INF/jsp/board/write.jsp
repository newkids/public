<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="/js/jquery-1.11.0.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<script type="text/javascript">

$(function(){
	$(".btn_st1").click(function(){
		if($(this).attr("g") == "cancel"){		//	취소 버튼 클릭시
			history.back();
		}else if($(this).attr("g") == "save"){	//	저장 버튼 클릭시
			insert();
		}
	});
	
});

function textareaToHtml(textarea_val){
	return textarea_val.replace(/\n/g, "<br>");
}

function insert(){
	
	if(!validationCheck())	return false;
	
	$("#boardContent").val(textareaToHtml($("#textarea").val()));	// \n -> <br>
	var data = $("#frm").serialize();
	
	$.ajax({
		url: '/board/write.do',
		data: data,
		type: 'POST',
		dataType: 'json',
		success: function(result){
			alert("저장 되었습니다.");
			location.href="/board/board.do";
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"서버에서 예기치 못한 에러가 발생하였습니다.\n관리자에게 문의 바랍니다.");
		}
	});
}

function validationCheck(){
	if($("#boardUser").val() == ""){
		alert("닉네임을 입력해 주세요.");
		$("#boardUser").focus();
		return false;
	}
	
	if($("#boardTitle").val() == ""){
		alert("제목을 입력해 주세요.");
		$("#boardTitle").focus();
		return false;
	}
	
	if($("#textarea").val() == ""){
		alert("내용을 입력해 주세요.");
		$("#textarea").focus();
		return false;
	}
	
	if($("#boardPw").val() == ""){
		alert("비밀번호를 입력해 주세요.");
		$("#boardPw").focus();
		return false;
	}
	
	return true;
}

</script>
</head>
<body>
<%@ include file="/WEB-INF/common/top.jsp" %>

<center>

<p>
<h1>write</h1><img src="/images/pencil.png" width="100px" height="100px"/>
<p>
<form id="frm" name="frm">
<input type="hidden" id="boardContent" name="boardContent" value="">
<table border=0>

	<tr>
		<th>이름</th>
		<td><input type=text id="boardUser" name="boardUser"></td>
	</tr>

	<tr>
		<th>제목</th>
		<td><input type=text id="boardTitle" name="boardTitle"></td>
	</tr>


	<tr><th>내용</th>
		<td><textarea rows=30 cols=100 id="textarea" name="textarea"></textarea></td>
	</tr>
	
	<tr>
		<th>패스워드</th>
		<td><input type=password id="boardPw" name="boardPw"></td>
	</tr>
	
	<tr>
	<td colspan="2" align="right">
	<a g="save" class="btn_st1"><input type="button" value="저장"></a>
    <a g="cancel" class="btn_st1"><input type="button" value="취소"></a>
	</td>
	</tr>
</table>
</form>

</center>

</body>
</html>