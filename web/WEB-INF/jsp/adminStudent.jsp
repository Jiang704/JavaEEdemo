<%--
  Created by IntelliJ IDEA.
  User: 57246
  Date: 2020/10/20
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
<%@ page import="com.jiang.pojo.Student"%>
<%@ page import=" java.util.*, java.io.*"%>
<%!
    int page_num = 1;
    int max_count = 10;
    String information ;
    Iterator it;
    List<Student> findList;
    int count = 0;
%>
<%
    // System.out.println("开始初始化jsp");
    page_num = 1;
    max_count = 10;
    count = 0;
    if(request.getParameter("page")!=null)
        page_num = Integer.parseInt((String)request.getParameter("page"));
    if(request.getParameter("max_count")!=null)
        max_count = Integer.parseInt((String)request.getParameter("max_count"));
    information = (String) request.getParameter("information");
    findList =  (List<Student>) request.getAttribute("list");
    it = findList.iterator();

%>
<%="<h1>" + "已找到以下信息，每页最多显示"+ max_count+"条" + "</h1>"%>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>手机</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <%
        while (it.hasNext() ) {
            Student s = (Student) it.next();
            if(count<max_count*page_num && count >=max_count*(page_num-1)) {
    %>
    <tr>
        <th><%=s.getId()%></th>
        <th><%=s.getName()%></th>
        <th><%=s.getPhone()%></th>
        <th><%=s.getQq()%></th>
        <th><%=s.getEmail()%></th>
        <th><a href="${pageContext.request.contextPath}/student/ToUpdata<%="?id="+s.getId()%>">修改</a>  &nbsp; | &nbsp;
        <a href="${pageContext.request.contextPath}/student/ToDelete<%="?id="+s.getId()%>">删除</a></th>
    </tr>
    <%
            }
            count++;
            //System.out.println(count);
        }
    %>
</table>
<a href="<%="?information="+information+"&max_count="+ max_count +"&page=1"%> ">首页</a>

<%
    for(int i =1;i<(double)findList.size()/max_count+1;i++){
%>
<a href="<%="?information="+information+"&max_count="+ max_count +"&page="+i%> "><%=i%></a>
<%
    }
%>
<p><%="<p>共有" + count + "条数据</p>"%></p>
<%="<p>" + "目前每页最多显示"+ max_count+"条，可以进行修改" + "</p>"%>
<form action="searchStudent"  method="GET">
    请修改：<input type="text" name="max_count">
    <input type="hidden" name="information" value="<%=information%>" />
    <input type="hidden" name="page" value="1" />
    <br />
    <input type="submit" value="修改" />
</form>

<br/>
<a href="${pageContext.request.contextPath}">回到首页</a>
</body>
</html>
