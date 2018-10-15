
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="menu">
        <% if(request.getSession().getAttribute("login") != null){
            int role = (int) request.getSession().getAttribute("role");
        if(role == 1){%>
            <a href="/students">Студенты</a>
        <%}
        if(role == 0){%>
            <a href="/teachers">Преподаватели</a>
        <%}
        }%>
    </div>

