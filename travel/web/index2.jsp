<%@ page import="net.beans.image" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link href="css/navigation.css" rel="stylesheet" type="text/css">
    <link href="css/public.css" rel="stylesheet" type="text/css">
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body onload="on()">
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
                        <li><a href="${pageContext.request.contextPath}/uploadServlet">上传</a></li>
                        <li><a href="${pageContext.request.contextPath}/myImageServlet">我的图片</a></li>
                        <li><a href="${pageContext.request.contextPath}/myFriendServlet">我的好友</a></li>
                        <li><a href="${pageContext.request.contextPath}/logoutServlet">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
<h1>首页</h1>

<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />

<%
    session.setAttribute("currentPageUrl","/index");
%>

<script>

    function on() {
        <%
        boolean stoprefresh=false;
        if (request.getAttribute("hot")==null){
          stoprefresh=true;
        }

        %>

        var pageContext = document.getElementById("PageContext").value;
        console.log("start 数据连接开始 ");
        if (<%=stoprefresh%>){
            location.href=pageContext+"/indexServlet";
        }
        console.log("start 数据连接已完成 ");
        showDIV();

    }
</script>


<%
    List<image> hotImages=(List<image>)request.getAttribute("hot");
    int index=0;
    int maxIndex=0;
    System.out.println("hotImage：  "+hotImages);
    if(hotImages!=null){
        maxIndex=hotImages.size();
        System.out.println("hotimageIndex 开始打印页面 "+ maxIndex);
        while (index<maxIndex){
            System.out.println("打印 hot image ID  "+hotImages.get(index).getImageID());
%>
<div id="<%=index%>" class="gallery" style="background-image: <%
  out.print("url(travel-images/large/");
  out.print(hotImages.get(index).getPATH());
  out.print(")");
  %> ">
    <h2>Author: <%= hotImages.get(index).getAuthor()%></h2>
    <h3>Title:  <%= hotImages.get(index).getTitle()%></h3>
    <p>Publish Time: <%= hotImages.get(index).getPublishTime()%></p>
    <a href="${pageContext.request.contextPath}/detailsServlet?id=<%= hotImages.get(index).getImageID()%>"  >learn more!</a>
    <% System.out.println("hotImages.get(index).getImageID()   "+hotImages.get(index).getImageID());%>
</div>
<%
            index++;
        }
    }
%>

<script>
    var myVar=setInterval(function () {
        showDIV()
    },3000);
    console.log("showid  ");
    var maxImage=<%= maxIndex%> ;
    var nowImage=0;
    function showDIV() {
        for (var i=0;i<maxImage;i++){
            console.log("showdiv  "+nowImage);
            if (nowImage===i){
                console.log("show   ");
                document.getElementById(nowImage).style.display="block";
            } else {
                console.log("none  ");
                document.getElementById(i).style.display="none";
            }
        }
        if ((1+nowImage)===maxImage){
            nowImage=0;
        }else {
            nowImage++;
        }

    }

</script>

<div class="HotPhoto">
    <ul>
        <%
            List<image> newImage=(List<image>) request.getAttribute("new");
            int newIndex=0;
            if (newImage!=null){

                int maxNewIndex=newImage.size();
                System.out.println("开始打印new image "+maxIndex);
                while (newIndex<maxNewIndex){
                    System.out.println("打印new image ID  "+newImage.get(newIndex).getImageID());
        %>

        <li>
            <div style="margin-top: 0;padding-top: 0">
                <a  href="/detailsServlet"></a>
                <img src="<%
              out.print("travel-images/small/");
              out.print(newImage.get(newIndex).getPATH());
          %>"  >
            </div>
            <h2>Author: <%= newImage.get(newIndex).getAuthor()%></h2>
            <h3>Topic:  <%= newImage.get(newIndex).getTopic()%></h3>
            <p style="font-size: small">Publish Time: <%= newImage.get(newIndex).getPublishTime()%> </p>
            <a href="${pageContext.request.contextPath}/detailsServlet?id=<%= newImage.get(newIndex).getImageID()%>" >learn more!</a>
            <% System.out.println("newImage.get(newIndex).getImageID()  "+newImage.get(newIndex).getImageID()); %>
        </li>
        <%
                    newIndex++;
                }
            }
        %>
    </ul>
</div>


</body>
</html>
