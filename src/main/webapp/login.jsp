<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp"%>

<% if("wrongUser".equals(request.getParameter("action"))){%>
    <div style="color:#AA0000">Неверное имя пользователя/пароль</div>
<% }%>
<% if("noAuth".equals(request.getParameter("action"))){%>
    <div style="color:#AA0000">Вы не авторизованы. Войдите в систему.</div>
<% }%>
<form action="/login" method="post">
    Логин:<br>
    <input type="text" name="login"><BR>
    Пароль:<BR>
    <input type="password" name="password"><BR>
    <input type="submit">
</form>
</body>
</html>
