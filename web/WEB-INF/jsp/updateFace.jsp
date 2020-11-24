<%--
  Created by IntelliJ IDEA.
  User: 57246
  Date: 2020/10/24
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传人脸</title>
</head>
<body>
请上传你的人脸数据
<form action="doUpdateFace" method="post" enctype="multipart/form-data">
    <label>上传人脸：</label><input type="file" name="face"><br>
    <input type="submit">
</form>
</body>
</html>
