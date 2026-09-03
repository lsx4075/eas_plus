<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="../../layui/css/layui.css" rel="stylesheet">
    <script src="../../layui/layui.js"></script>
    <script src="../../js/jquery-2.1.1.js"></script>
    <style>
        body { background: #F8F8F8; display: flex; justify-content: center; align-items: center; height: 100vh; }
        .login-box {
            background: #fff;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 400px;
        }
        .login-box h2 { text-align: center; color: #3070B0; }
        .login-box table { width: 100%; }
        .login-box td { padding: 8px 5px; }
        .login-box .btn { width: 100%; }
        .login-box .form-control { width: 100%; }
        .login-box .error { color: red; text-align: center; margin-top: 10px; }
    </style>
</head>
<body>
    <%
        String cookieUname = "";
        String cookiePwd = "";
        String cookieRole = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("rememberUname".equals(c.getName())) cookieUname = c.getValue();
                if ("rememberPwd".equals(c.getName())) cookiePwd = c.getValue();
                if ("rememberRole".equals(c.getName())) cookieRole = c.getValue();
            }
        }
    %>
    <div class="login-box">
        <h2>教务信息查询系统</h2>
        <form action="/login" method="post">
            <table>
                <tr>
                    <td>请选择登录角色:</td>
                    <td>
                        <select name="user" class="form-control" onchange="clearNameAndPwd()">
                            <option value="2" <%="2".equals(cookieRole) ? "selected" : ""%>>管理员</option>
                            <option value="1" <%="1".equals(cookieRole) ? "selected" : ""%>>教师</option>
                            <option value="0" <%="0".equals(cookieRole) ? "selected" : ""%>>学生</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>请输入账户:</td>
                    <td><input type="text" name="uname" id="uname" class="form-control" value="<%=cookieUname%>"></td>
                </tr>
                <tr>
                    <td>请输入密码:</td>
                    <td><input type="password" name="pwd" id="pwd" class="form-control" value="<%=cookiePwd%>"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="remember" value="1" <%=!Objects.equals(cookieUname, "") ? "checked" : ""%>> 记住密码
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" class="btn btn-primary" value="登录"></td>
                </tr>
            </table>
        </form>
        <div class="error">${msg}</div>
    </div>
    <script>
        function clearNameAndPwd() {
            var el1 = document.getElementById("uname")
            var el2 = document.getElementById("pwd")
            if (el1.value !== '' || el2.value !== '') {
                el1.value = '';
                el2.value = '';
            }
        }
    </script>
</body>
</html>