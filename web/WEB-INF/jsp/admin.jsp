<%--
  Created by IntelliJ IDEA.
  User: 57246
  Date: 2020/10/20
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>
</head>
<body>
你好，欢迎来到软院找人，你可以输入电话号码，学号或教工号，QQ，姓名，邮件，可以找到联系人信息。
<form action="adminStudent" method="GET">
    请搜索：<input type="text" name="information">
    <br />
    <input type="submit" value="提交" />
</form>
<br/>
你也可以选择添加用户
<form action="addStudent" method="post">
    <p>ID: <input type="text" name="id"  /></p>
    <p>姓名: <input type="text" name="name" /></p>
    <p>手机: <input type="text" name="phone"  /></p>
    <p>QQ: <input type="text" name="qq"  /></p>
    <p>邮箱: <input type="text" name="email" /></p>
    <input type="submit" value="添加" />
</form>
<%
    System.out.println(request.getParameter("text"));
    if(request.getParameter("text")!=null) {
%>
<%="<p>"+request.getParameter("text") +"</p>"%>
<%
    }
%>

<br/>
<a href="${pageContext.request.contextPath}">回到首页</a>
</body>
</html>
