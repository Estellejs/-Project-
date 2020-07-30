
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
    <link  rel="stylesheet" href="../css/search.css" type="text/css">
    <link  rel="stylesheet" href="../css/public.css" type="text/css">
</head>
<body>
<header>
    <div class="nav">
        <nav id="navLeft">
            <ul>
                <li><a>Daddy旅行社</a></li>
                <li><a href="../index.jsp"> 首页 </a> </li>
                <li><a href="search.jsp"> 搜索 </a> </li>
            </ul>
        </nav>

        <p id="NotLogin"><a href="../login.jsp"> 未登录 </a> </p>

    </div>
</header>
<h1>搜索</h1>

<div>
    <form method="post"  action="${pageContext.request.contextPath}/searchServlet">
        <div id="box" class="box">
            <input type="text">
            <input type="submit" value="搜索">
        </div>
        <div>
            <label>搜索方式 </label>
            <label>标题</label>
            <input type="radio" name="list1" value="title">
            <label>主题</label>
            <input type="radio" name="list1" value="topic">
        </div>
        <div>
            <label>排序方式 </label>
            <label>时间</label>
            <input type="radio" name="list2" value="time">
            <label>热度</label>
            <input type="radio" name="list2" value="hot">
        </div>
    </form>
</div>

<h1>搜索结果</h1>



</body>
</html>
