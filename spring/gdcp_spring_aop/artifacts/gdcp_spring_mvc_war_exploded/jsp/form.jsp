<%--
  Created by IntelliJ IDEA.
  User: 恒心
  Date: 2020/10/24
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/show7" method="post">
    <input type="text" name="userList[0].name"><br>
    <input type="text" name="userList[0].addr"><br>
    <input type="text" name="userList[1].name"><br>
    <input type="text" name="userList[1].addr"><br>
    <input type="text" name="userList[2].name"><br>
    <input type="text" name="userList[2].addr"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
