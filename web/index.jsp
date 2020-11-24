<%--
  Created by IntelliJ IDEA.
  User: 57246
  Date: 2020/10/19
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软软找人首页</title>
</head>
<body>
你好，欢迎来到软院找人，你可以输入电话号码，学号或教工号，QQ，姓名，邮件，可以找到联系人信息。
<form action="student/searchStudent" method="GET">
    请搜索：<input type="text" name="information">
    <br />
    <input type="submit" value="提交" />
</form>
</br>
</br>
<p>管理员和学生可以登录获取对应权限：</p>
<form action="login/dologin" method="GET">
    ID：<input type="text" name="id">
    密码：<input type="text" name="password">
    <br />
    <input type="submit" value="登录" />
</form>
</br>
<%--<a href="${pageContext.request.contextPath}/student/admin">登录</a>--%>
<%
    System.out.println(request.getParameter("msg"));
    if(request.getParameter("msg")!=null) {
%>
<%="<p>"+request.getParameter("msg") +"</p>"%>
<%
    }
%>

可以通过上传人脸照片搜索用户
<form action="student/doSearchFace" method="post" enctype="multipart/form-data">
    <label>上传人脸：</label><input type="file" name="face"><br>
    <input type="submit">
</form>
<%--<img src="https://console.bce.baidu.com/ai/s/facelib/face?appId=1981677&groupId=student&uid=201892001&faceId=35f77824ede5cccca9ad0f3bb567f640"--%>
<%--     width="400" height="325" border="0" />--%>
</body>
</html>
