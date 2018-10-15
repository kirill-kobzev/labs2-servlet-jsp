<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp"%>
    Вы вошли как <%=request.getSession().getAttribute("login") %>,
    <a href="/login?action=logout">выйти</a>
    <h1>Dashboard</h1>
</body>
</html>
