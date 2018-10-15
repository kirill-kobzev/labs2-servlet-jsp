<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 07.10.2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<Integer> list = (List<Integer>) request.getAttribute("list");
    for(Integer i: list){
        %>
    <%=i%><br>
    <%
    }
    %>
</body>
</html>
