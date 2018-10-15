<%@ page import="servlets.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kirill
  Date: 07.10.2018
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Student> list = (List<Student>) request.getAttribute("list");
    for(Student student: list){
%>
<%=student.getFamilyName()%><%=student.getName()%><%=student.getCity().getCityName()%><br>
<%
    }
%>
</body>
</html>
