<%@ page import="com.jxd.eas.model.UserLogin" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户管理</title>
    <%@ include file="commonStyle.jsp" %>
    <style>
        /* 仅针对本页面的表格第一列（勾选框列）缩小内边距，减少与账户名的距离 */
        .user-table td:first-child,
        .user-table th:first-child {
            padding: 2px 4px;      /* 大幅缩小内边距 */
            text-align: center;    /* 勾选框居中 */
            width: 40px;           /* 固定窄宽度 */
        }
        .user-table td:nth-child(2),
        .user-table th:nth-child(2) {
            padding-left: 8px;     /* 账户名列左侧间距稍微缩小 */
        }
    </style>
</head>
<body>
<h3>用户账户管理</h3>
<div class="search-group">
    <input type="text" id="userName" class="form-control" value="${userName}" placeholder="请输入账户名：">
    <input type="button" class="btn btn-primary" value="搜索" onclick="queryUser()">
    <input type="button" class="btn btn-primary" value="重置密码" onclick="resetPwd()">
</div>
<div>
    <table class="table user-table"> <!-- 应用自定义样式 -->
        <tr>
            <th><input type="checkbox" id="all" onclick="chkAll()"></th>
            <th>账户名</th>
        </tr>
        <%
            List<UserLogin> list = (ArrayList)request.getAttribute("userList");
            if (list != null && list.size() > 0) {
                for (UserLogin userLogin : list) {
        %>
        <tr>
            <td><input type="checkbox" name="chk" value="<%=userLogin.getUserName()%>" onclick="isChk()"></td>
            <td><%=userLogin.getUserName()%></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td colspan="2">暂无数据</td></tr>
        <%
            }
        %>
    </table>

    <div class="pagination">
        <%
            int pages = (Integer) request.getAttribute("pages");
            for (int i = 1; i <= pages; i++) {
        %>
        <a href="/getUsers?page=<%=i%>&limit=${limit}"><%=i%></a>
        <%
            }
        %>
        <select name="limit" class="form-control" style="width:auto;display:inline-block;margin-left:10px;" onchange="chgLimit(this.value)">
            <option value="5" ${limit == 5 ? 'selected' : ''}>5</option>
            <option value="10" ${limit == 10 ? 'selected' : ''}>10</option>
            <option value="15" ${limit == 15 ? 'selected' : ''}>15</option>
            <option value="20" ${limit == 20 ? 'selected' : ''}>20</option>
        </select>
    </div>

</div>
<script>
    function queryUser() {
        var userName = document.getElementById("userName").value;
        window.location.href = '/getUsers?userName=' + userName;
    }

    function resetPwd() {
        var chks = document.getElementsByName("chk")
        var names = []
        for (let i = 0; i < chks.length; i++) {
            if (chks[i].checked) {
                names.push(chks[i].value)
            }
        }

        if (names.length == 0) {
            alert('请选择要重置密码的账户')
            return
        }

        if (confirm('确定要重置密码么？')) {
            var url = "/resetPwd?"
            for (var userName of names) {
                url += "userName=" + userName + "&"
            }

            url = url.substring(0, url.length - 1)
            window.location.href = url
        }
    }

    function chgLimit(limit) {
        window.location.href = "/getUsers?limit=" + limit
    }

    function chkAll() {
        var arrChk = document.getElementsByName("chk")
        var status = document.getElementById("all").checked

        for (let i = 0; i < arrChk.length; i++) {
            arrChk[i].checked = status
        }
    }

    function isChk() {
        var arrChk = document.getElementsByName("chk")
        for (let i = 0; i < arrChk.length; i++) {
            if (!arrChk[i].checked) {
                document.getElementById("all").checked = false
                break
            }
            document.getElementById("all").checked = true
        }
    }
</script>
</body>
</html>