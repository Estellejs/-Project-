<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="css/public.css" type="text/css">
    <link rel="stylesheet" href="css/register.css" type="text/css">
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

        <p id="NotLogin"><a href="login.jsp"> 未登录 </a> </p>

    </div>
</header>
<h1>注册</h1>

<div id="register_background" class="c2 hide" >
    <section id="register" style="text-align: left">
        <div>${message}</div>
        <form action="${pageContext.request.contextPath}/registerServlet" method="post"
              onsubmit="return validateForm()" >
            <p>
                用户名<br>
                <input type="text" id="name" name="name" required onblur="checkUserName(this)">
                <span  id="name_span">用户名长度 4 至 15 位，包含 4 和 15</span>
            </p>
            <p>
                密码<br>
                <input type="password" id="password" name="password" required onblur="checkPassword(this)">
                <span id="password_span">密码长度 6 至 12 位，包含 6 和 12</span>
            </p>
            <p>
                请确认密码<br>
                <input type="password" id="repeatPassword" name="repeatPassword" required onblur="checkRepeatPassword(this)">
                <span  id="password2_span">两次密码须一致</span>
            </p>
            <p>
                邮箱<br>
                <input type="email" id="email" name="email" required onblur="checkEmail(this)">
                <span id="email_span">格式示例：xxxxxxxx@163.com</span>
            </p>

            <p>
                <input type="submit"  value="注册">
            </p>
        </form>
    </section>
</div>
<script>
    var  usernameRegex = /^\w{4,15}$/;
    var emailRegex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var passwordRegex = /^\w{6,12}$/;
    function byID(id) {
        return document.getElementById(id)
    }
    function checkUserName(node) {
        var username=node.value;
        if (!usernameRegex.test(username)){
            byID("name_span").style.color="red";
        }else {
            byID("name_span").style.color="green";
        }
    }
    function checkPassword(node) {
        var password=node.value;
        if (!passwordRegex.test(password)){
            byID("password_span").style.color="red";
        } else {
            byID("password_span").style.color="green";
        }
    }
    function checkEmail(node) {
        var email=node.value;
        if (!emailRegex.test(email)){
            byID("email_span").style.color="red";
        } else {
            byID("email_span").style.color="green";
        }
    }
    function checkRepeatPassword(node) {

        var password2=node.value;
        var password1=byID("password").value;
        console.log("111  "+password1+"   2222  "+password2);
        if (password1!==password2) {
            byID("password2_span").style.color="red";
        }else {
            byID("password2_span").style.color="green";
        }
    }
    function validateForm() {
        var flag=true;
        var usernameNode = byID("name"); //获得ID值为username的节点对象
        var username = usernameNode.value;   //获得usernameNode节点的值，即用户在username文本框内填写的值
        if(!usernameRegex.test(username)){    //验证获得到的值是否符合正则表达式
            byID("name_span").style.color = "red"; //如果不符合，则将ID值为username_span的节点对象内容变为红色
            flag = false;        //返回false，不提交

        }

        //校验密码
        var passwordNode = byID("password");  //获得ID值为password的节点对象
        var password = passwordNode.value;
        if(!passwordRegex.test(password)){
            byID("password_span").style.color = "red";
            flag = false;

        }

        //确认密码
        var rePasswordNode = byID("repeatPassword");  //获得ID值为rePassword的节点对象
        var rePassword = rePasswordNode.value;
        console.log("111  "+password+"   2222  "+rePassword);
        if(password!==rePassword){
            byID("password2_span").style.color="red";
            flag = false;

        }

        //校验邮箱
        var emailNode = byID("email");  //获得ID值为Email的节点对象
        var email = emailNode.value;
        if(!emailRegex.test(email)){
            byID("email_span").style.color = "red";
            flag = false;

        }
        console.log("flag   "+flag);
        if (flag===false) {
            window.alert("输入信息有误！")
        }
        return flag;
    }
    
</script>

</body>
</html>
