
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<h1>上传</h1>

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

</body>
</html>
