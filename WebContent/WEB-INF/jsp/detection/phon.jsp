<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%@ include file="/WEB-INF/common/top.jsp" %>
	<table border="1">
		<tr>
			<td>id</td>
			<td>전화번호</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.userId }</td>
				<td>${list.phonNo }</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<input type="button" onclick="javascript:history.go(-1)" value="뒤로">
</body>
</html>