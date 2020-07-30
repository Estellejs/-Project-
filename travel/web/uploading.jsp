
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploading</title>
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <link href="css/navigation.css" rel="stylesheet" type="text/css">
    
</head>
<body>

<header>
    <div class="nav">
        <nav id="navLeft">
            <ul>
                <li><a>Daddy旅行社</a></li>
                <li><a href="${pageContext.request.contextPath}/indexServlet"> 首页 </a> </li>
                <li><a href="${pageContext.request.contextPath}/searchServlet"> 搜索 </a> </li>
            </ul>
        </nav>
        <%
            System.out.println("username  " +session.getAttribute("username"));
        %>

        <div class="wrap" id="NotLogin">
            <ul class="level">
                <li>
                    <a href="" ><%=session.getAttribute("username")%></a>
                    <ul class="two">
                        <li><a href="${pageContext.request.contextPath}/myCollectionServlet">我的收藏</a></li>
                       <li><a href="${pageContext.request.contextPath}/myImageServlet">我的图片</a></li>
                        <li><a href="${pageContext.request.contextPath}/myFriendServlet">我的好友</a></li>
                        <li><a href="${pageContext.request.contextPath}/uploadServlet">上传</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>

<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<h1>上传图片</h1>


<div id="register_background" class="c2 hide" >
    <section id="register" style="text-align: left">
        <form action="${pageContext.request.contextPath}/uploadServlet" method="post"
              onsubmit="return validateForm()" >
            <p>
                标题<br>
                <input type="text" id="title" name="title" required >
            </p>
            <p>
                作者<br>
                <input type="text" id="author" name="author" required >
            </p>
            <p>
                主题<br>
                <input type="text" id="topic" name="topic" required >
            </p>
            <p>
                简介<br>
                <input type="text" id="description" name="description" required >
            </p>

            <p>
                国家<br>
                <input type="email" id="country" name="country" required >
            </p>

            <p>
                城市<br>
                <input type="email" id="city" name="city" required >
            </p>

            <p>
                <input type="submit"  value="提交">
            </p>
        </form>
    </section>
</div>

<script>
    function validateForm() {

        
    }
    
</script>



</body>
</html>
