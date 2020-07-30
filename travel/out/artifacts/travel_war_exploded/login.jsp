
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="css/public.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
</head>
<body>
<header>
    <div class="nav">
        <nav id="navLeft">
            <ul>
                <li><a>Daddy旅行社</a></li>
                <li><a href="index.jsp"> 首页 </a> </li>
                <li><a href="jsp/search.jsp"> 搜索 </a> </li>
            </ul>
        </nav>

        <p id="NotLogin"><a href="jsp/login.jsp"> 未登录 </a> </p>

    </div>
</header>
<h1>登录</h1>

<div id="login_background" class="c2 hide" >

    <div id="login" style="text-align: left">
        <div><%
            if (request.getAttribute("error")!=null){
                out.println(request.getAttribute("error"));
            }
        %></div>
        <form method="post"  action="${pageContext.request.contextPath}/loginServlet">
            <label for="name">用户名/邮箱：</label>
            <input type="text" id="name" autofocus="autofocus" value="<%
            if (request.getAttribute("name")!=null){
                out.print(request.getAttribute("name"));
            }%>" name="name" required>
            <span id="username-info"></span>
            <br>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" value="<%
             if (request.getAttribute("password")!=null){
                out.print(request.getAttribute("password"));
            }
                System.out.println("请求转发  "+request.getAttribute("password"));
            %>" autofocus="autofocus" required>
            <span id="password-info"></span>
            <br>
            <input type="submit" value="登录" name="submit" ></input>
            <a href="register.jsp" style="text-decoration: none">点击前往注册</a>
        </form>
    </div>
</div>
<script type="text/javascript">
</script>
</body>
</html>
