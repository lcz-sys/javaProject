<%--
  Created by IntelliJ IDEA.
  User: 恒心
  Date: 2020/10/25
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/show15" method="post" enctype="multipart/form-data">
    名称:<input type="text" name="username"><br>
    文件名:<input type="file" name="uploadFile"><br>
    文件名:<input type="file" name="uploadFile"><br>
    文件名:<input type="file" name="uploadFile"><br>
    文件名:<input type="file" name="uploadFile"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
