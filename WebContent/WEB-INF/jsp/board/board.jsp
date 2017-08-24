<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판이당!</title>

<style>
/*list table*/
table.scroll_list {width:700px;border-collapse:collapse;border:1px solid #c4c4c4;margin:0;clear:both;scroll-x:hidden;font-size:12px}
table.scroll_list thead tr{background:#A0D9E2;height:30px;margin:0;color:#fff;;border:1px solid #c4c4c4;}
table.scroll_list td {padding:5px 5px;text-align:center;font-size:12px}
table.scroll_list tr:hover {background:#d5dbdd;}


</style>

<script type="text/javascript">
	function goDetail(boardNo) {
		location.href = "/board/view.do?boardNo=" + boardNo;
	}
</script>
</head>

<body>
	<%@ include file="/WEB-INF/common/top.jsp"%>
	<center>
		<p>
		<h1>board</h1>
		<img src="/images/Hugging_Face_Emoji_2028ce8b-c213-4d45-94aa-21e1a0842b4d_large.png" width="100px" height="100px" />
		<p>
		<table class="scroll_list" border="0" width="700px">
			<colgroup>
				<col style="width: 8%;" />
				<col style="width: *%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
			</colgroup>

			<thead>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list }" var="list">
					<tr>
						<td align=center>${list.boardNo }</td>
						<td style="cursor: pointer;"><b><a onclick="goDetail('${list.boardNo}')">${list.boardTitle }</a></b></font></td>
						<td align=center>${list.boardUser }</td>
						<td align=center>${list.boardDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<input type="button" onclick="javascript:history.go(-1)" value="뒤로">
			<a href="/board/writePage.do"><input type="button" value="글쓰기"></a>
		</p>
	</center>
</body>
</html>