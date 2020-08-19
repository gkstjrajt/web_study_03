<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 만든 에러 ㅎ</title>
</head>
<body>
예외가 발생함
<%=exception.getMessage() %>
</body>
</html>