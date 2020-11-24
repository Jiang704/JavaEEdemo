<%--
  Created by IntelliJ IDEA.
  User: 57246
  Date: 2020/10/20
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生数据</title>
</head>
<body>
<h1>修改学生信息</h1>
<form action="Updata" method="post">
    <p>ID: <input type="hidden" name="id" value="${student.id}" /></p>
    <p>姓名: <input type="text" name="name" value="${student.name}" /></p>
    <p>手机: <input type="text" name="phone" value="${student.phone}" /></p>
    <p>QQ: <input type="text" name="qq" value="${student.qq}" /></p>
    <p>邮箱: <input type="text" name="email" value="${student.email}" /></p>
    <input type="submit" value="修改" />
</form>
<br/>
<a href="${pageContext.request.contextPath}">回到首页</a>
</body>
</html>
