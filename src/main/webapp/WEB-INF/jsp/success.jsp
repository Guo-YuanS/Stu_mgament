<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C/DTD HTML 4.01 Transitonal//EN">
<html>
<head>
    <title>My JSP 'success.jsp' starting page</title>
</head>
<body>
<br>
<a href="showAllServlet">查看所有用户</a>
</body>
</html>