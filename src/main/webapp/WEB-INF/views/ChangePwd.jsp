<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改管理员密码</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<div>
    <form action="/chgPwd" method="post" id="pwdForm" onsubmit="return chkAll()">
        <table class="form-table">
            <tr>
                <td>请输入账户名：</td>
                <td>
                    <input type="text" name="userName" id="userName" class="form-control" onblur="chkName()">
                    <span id="userNameErr" class="error-msg"></span>
                </td>
            </tr>
            <tr>
                <td>请输入旧密码：</td>
                <td>
                    <input type="password" name="oldPwd" id="oldPwd" class="form-control" onblur="chkOldPwd()">
                    <span id="oldPwdErr" class="error-msg"></span>
                </td>
            </tr>
            <tr>
                <td>请输入新密码：</td>
                <td>
                    <input type="password" name="newPwd" id="newPwd" class="form-control" onblur="chkNewPwd()">
                    <span id="newPwdErr" class="error-msg"></span>
                </td>
            </tr>
            <tr>
                <td>请确认密码：</td>
                <td>
                    <input type="password" name="confirmPwd" id="confirmPwd" class="form-control" onblur="chkConfirmPwd()">
                    <span id="confirmPwdErr" class="error-msg"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" class="btn btn-primary" value="确定">
                    <input type="reset" class="btn btn-default" value="重置">
                </td>
            </tr>
        </table>
    </form>
    <div>
        <p style="color: red">${msg}</p>
    </div>
</div>
<script>
    function chkName() {
        var userName = document.getElementById("userName").value;
        if (userName === "") {
            document.getElementById("userNameErr").innerHTML = "账户名不能为空";
            return false;
        } else if (userName != '${uname}') {
            document.getElementById("userNameErr").innerHTML = "账户名错误";
            return false;
        } else {
            document.getElementById("userNameErr").innerHTML = "";
            return true;
        }
    }

    function chkOldPwd() {
        var oldPwd = document.getElementById("oldPwd").value;
        if (oldPwd === "") {
            document.getElementById("oldPwdErr").innerHTML = "旧密码不能为空";
            return false;
        } else {
            document.getElementById("oldPwdErr").innerHTML = "";
            return true;
        }
    }

    function chkNewPwd() {
        var newPwd = document.getElementById("newPwd").value;
        if (newPwd === "") {
            document.getElementById("newPwdErr").innerHTML = "新密码不能为空";
            return false;
        } else {
            document.getElementById("newPwdErr").innerHTML = "";
            return true;
        }
    }

    function chkConfirmPwd() {
        var newPwd = document.getElementById("newPwd").value;
        var confirmPwd = document.getElementById("confirmPwd").value;
        if (confirmPwd === "") {
            document.getElementById("confirmPwdErr").innerHTML = "确认密码不能为空";
            return false;
        } else if (newPwd !== confirmPwd) {
            document.getElementById("confirmPwdErr").innerHTML = "两次输入的密码不一致";
            return false;
        } else {
            document.getElementById("confirmPwdErr").innerHTML = "";
            return true;
        }
    }

    function chkAll() {
        return chkName() && chkOldPwd() && chkNewPwd() && chkConfirmPwd();
    }

</script>
</body>
</html>