<%@ page import="java.util.List" %>
<%@ page import="net.beans.image" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my collection</title>
    <link href="css/navigation.css" rel="stylesheet" type="text/css">
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <link href="css/imageList.css" rel="stylesheet" type="text/css">
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
                        <li><a href="uploading.jsp">上传</a></li>
                        <li><a href="${pageContext.request.contextPath}/myImageServlet">我的图片</a></li>
                        <li><a href="${pageContext.request.contextPath}/myFriendServlet">我的好友</a></li>
                        <li><a>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>

<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
<%
    session.setAttribute("currentPageUrl","/myCollection");
    List<image> imageList=(List<image>) request.getAttribute("image");
%>

<h1>我的收藏</h1>
<ul class="landscape">
    <%
    int maxIndex=imageList.size();
    int index=0;
    for (int i=0;i<maxIndex;i++){
    %>

    <li class="landscapeLi" style="padding: 10px;margin: 20px">
        <div class="landscapeImg">
            <img src="<%
            out.print("travel-images/square-medium/");
            out.print(imageList.get(i).getPATH());
            %>">
        </div>
        <h1 style="font-size: 20px"><%= imageList.get(i).getTitle()%></h1>
        <div class=""><%= imageList.get(i).getAuthor()%></div>
        <div class=""><%= imageList.get(i).getDescription()%></div>
        <ul style="list-style-type: none">
            <li style="float: right; padding-right: 100px"><p class="BUTTONLi" onclick="collect(<%= imageList.get(i).getImageID()%>)">取消收藏</p></li>
        </ul>
    </li>
    <%
    }
    %>


</ul>
<script>
    function collect(imageID) {
        var pageContext = document.getElementById("PageContext").value;
        console.log("start 数据连接开始 ");
        location.href=pageContext+"/myCollectionCancelServlet?id="+imageID;
        console.log("start 数据连接已完成 ");
    }

</script>
</body>
</html>
