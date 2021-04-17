<%--
  Created by IntelliJ IDEA.
  User: 恒心
  Date: 2020/10/24
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({name:"zhangsan",addr:"beijing"});
        userList.push({name:"lisi",addr:"shanghai"});
        userList.push({name:"wangwu",addr:"guangzhou"});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/show8",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=UTF-8"
        })
    </script>
</head>
<body>

</body>
</html>
