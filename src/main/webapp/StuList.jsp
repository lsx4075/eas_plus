<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<h3>学生名单管理</h3>
<div class="search-group">
    <input type="text" id="stuName" class="form-control" value="${stuName}" placeholder="请输入姓名：">
    <input type="button" class="btn btn-primary" value="搜索" onclick="queryStu()">
    <input type="button" class="btn btn-primary" value="添加学生信息+" onclick="newStu()">
</div>
<div>
    <table class="table">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>入学时间</th>
            <th>学院</th>
            <th>操作</th>
        </tr>
        <%
            List<Map<String,Object>> list = (ArrayList)request.getAttribute("stuList");
            if (list != null && list.size() > 0) {
                for (Map map : list) {
        %>
        <tr>
            <td><%=map.get("id")%></td>
            <td><%=map.get("name")%></td>
            <td><%=map.get("sex")%></td>
            <td><%=map.get("birthday")%></td>
            <td><%=map.get("grade")%></td>
            <td><%=map.get("collegeName")%></td>
            <td>
                <button type="button" class="btn btn-primary btn-sm" value="<%=map.get("id")%>" onclick="editStu(this.value)">修改</button>
                <button type="button" class="btn btn-danger btn-sm" value="<%=map.get("id")%>" onclick="delStu(this.value)">删除</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td colspan="7">暂无数据</td></tr>
        <%
            }
        %>
    </table>
    <div class="pagination">
        <%
            int pages = (Integer) request.getAttribute("pages");
            for (int i = 1; i <= pages; i++) {
        %>
        <a href="/getStudents?page=<%=i%>&limit=${limit}"><%=i%></a>
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
    function queryStu() {
        var stuName = document.getElementById("stuName").value;
        window.location.href = '/getStudents?stuName=' + stuName;
    }
    function newStu() {
        window.location.href = "/AddStu.jsp"
    }
    function editStu(id) {
        window.location.href = "/getOneStu?id=" + id
    }
    function delStu(id) {
        if (confirm('确定要删除所选学生么？')) {
            window.location.href = '/delStu?id=' + id
        }
    }
    function chgLimit(limit) {
        window.location.href = "/getStudents?limit=" + limit
    }
</script>
</body>
</html>