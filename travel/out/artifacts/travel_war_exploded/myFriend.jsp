<%@ page import="java.util.List" %>
<%@ page import="net.beans.user" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my friend</title>
    <link href="css/navigation.css" rel="stylesheet" type="text/css">
    <link href="css/public.css" rel="stylesheet" type="text/css">
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
    session.setAttribute("currentPageUrl","/myFriend");
    List<user> userList=(List<user>) request.getAttribute("friend");
    System.out.println("好友数目   "+userList.size());
%>

<h1>我的好友</h1>
<p>点击好友姓名或邮箱前往他的收藏页</p>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>邮箱</th>
        <th>注册时间</th>
    </tr>
    <%
        int maxIndex=userList.size();
        int index=0;
        for (int i=0;i<maxIndex;i++){
    %>

    <tr>
        <td><a href="${pageContext.request.contextPath}/myFriendCollectionServlet?FID=<%= userList.get(i).getUID()%>"><%= userList.get(i).getUserName()%></a></td>
        <td><a href="${pageContext.request.contextPath}/myFriendCollectionServlet?FID=<%= userList.get(i).getUID()%>"><%= userList.get(i).getEmail()%></a></td>
        <td><%= userList.get(i).getDateJoined()%></td>
    </tr>

    <%
        }
    %>


</table>
</body>
</html>
