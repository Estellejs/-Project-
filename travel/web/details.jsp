<%@ page import="net.beans.image" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details</title>
    <link rel="stylesheet" href="css/public.css" type="text/css">
    <link rel="stylesheet" href="css/details.css" type="text/css">
</head>
<body>
<%
    session.setAttribute("currentPageUrl","/details");
%>
<header>
    <div class="nav">
        <nav id="navLeft">
            <ul>
                <li><a>Daddy旅行社</a></li>
                <li><a href="${pageContext.request.contextPath}/indexServlet"> 首页 </a> </li>
                <li><a href="jsp/search.jsp"> 搜索 </a> </li>
            </ul>
        </nav>

        <p id="NotLogin"><a href="login.jsp"> 未登录 </a> </p>

    </div>
</header>
<h1>详情</h1>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<% image image=(image) request.getAttribute("iamge");%>
<h2 style="font-size: 30px"> <%= image.getTitle()%></h2>
<h3>Author: <%= image.getAuthor()%></h3>

<div class="photo">
    <img src="<%
         out.print("travel-images/medium/");
         out.print(image.getPATH());
        System.out.println("检查path "+image.getPATH());
    %>">

</div>
<div style="font-size: 20px">
    <div class="textP"><%= image.getDescription()%></div>
</div>
<p><button type="button" name="collect" class="HOVER" style="font-size: 25px" id="collect" onclick="collect()">收藏</button></p>
<table class="gridtable">
    <tr>
        <th colspan="2">Image Details</th>
    </tr>
    <tr>
        <td>Head</td>
        <td><%= image.getHot()%></td>
    </tr>
    <tr>
        <td>Topic</td>
        <td><%= image.getTopic()%></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><%= image.getCountry()%></td>
    </tr>
    <tr>
        <td>City</td>
        <td><%= image.getCity()%></td>
    </tr>
    <tr>
        <td>Publish Time</td>
        <td><%= image.getPublishTime()%></td>
    </tr>

</table>
<script>
    function collect() {
        alert('用户未登录，无法添加！')
    }

</script>
</body>
</html>
