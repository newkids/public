<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="/js/jquery-1.11.0.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board VIEW</title>
<script type="text/javascript">


function modify(){
	document.frm.method="POST";
	document.frm.action="/board/modifyPage.do?boardNo=${map.boardNo }"
	document.frm.submit();
};

</script>
</head>
<body>
<%@ include file="/WEB-INF/common/top.jsp" %>
<center>
<p>
<h1>content</h1>
<img src="/images/Open_Book_Emoji_large.png" width="100px" height="100px"/>
<p>
<form id="frm" name="frm">

<input type="hidden" name="boardNo" id="boardNo" value="${map.boardNo }"/>
<table border=0 width="700px">
<colgroup>
<col style="width:15%;" />
		<col style="width:*%;" />
</colgroup>

<tr><th>제목</th>
<td><font size=2>${map.boardTitle }</font></td>
</tr>

<tr><th>글쓴이</th>
<td><font size=2>${map.boardUser }</font></td>
</tr>

<tr><th>내용</th>
<td><font size=2>${map.boardContent }</font></td>
</tr>
</table>
<p>
<input type="button" value="뒤로" onclick="javascript:history.go(-1)">
<a onclick="modify()"><input type="button" value="수정"></a>

</form>
</center>
</body>
</html>