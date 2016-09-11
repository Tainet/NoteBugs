<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>NoteBug</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:forward page="/controller" >
		<jsp:param name="command" value="main" />
	</jsp:forward>
</body>
</html>