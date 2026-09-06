<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<h3>教师名单管理</h3>
<div class="search-group">
    <input type="text" id="teacherName" class="form-control" value="${teacherName}" placeholder="请输入姓名：">
    <input type="button" class="btn btn-primary" value="搜索" onclick="queryTeacher()">
    <input type="button" class="btn btn-primary" value="添加教师信息+" onclick="newTeacher()">
</div>
<div>
    <table class="table">
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>入职时间</th>
            <th>学历</th>
            <th>职称</th>
            <th>学院</th>
            <th>操作</th>
        </tr>
        <%
            List<Map<String,Object>> list = (ArrayList)request.getAttribute("teacherList");
            if (list != null && list.size() > 0) {
                for (Map map : list) {
        %>
        <tr>
            <td><%=map.get("id")%></td>
            <td><%=map.get("name")%></td>
            <td><%=map.get("sex")%></td>
            <td><%=map.get("birthday")%></td>
            <td><%=map.get("grade")%></td>
            <td><%=map.get("degree")%></td>
            <td><%=map.get("title")%></td>
            <td><%=map.get("collegeName")%></td>
            <td>
                <button type="button" class="btn btn-primary btn-sm" value="<%=map.get("id")%>" onclick="editTeacher(this.value)">修改</button>
                <button type="button" class="btn btn-danger btn-sm" value="<%=map.get("id")%>" onclick="delTeacher(this.value)">删除</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td colspan="9">暂无数据</td></tr>
        <%
            }
        %>
    </table>
    <div class="pagination">
        <%
            int pages = (Integer) request.getAttribute("pages");
            for (int i = 1; i <= pages; i++) {
        %>
        <a href="/getTeachers?page=<%=i%>&limit=${limit}"><%=i%></a>
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
    <div style="color: red">${msg}</div>
</div>
<script>
    function queryTeacher() {
        var teacherName = document.getElementById("teacherName").value;
        window.location.href = '/getTeachers?teacherName=' + teacherName;
    }
    function newTeacher() {
        window.location.href = "/toAddTeacher"
    }
    function editTeacher(id) {
        window.location.href = "/getOneTeacher?id=" + id
    }
    function delTeacher(id) {
        if (confirm('确定要删除所选教师么？')) {
            window.location.href = '/delTeacher?id=' + id
        }
    }
    function chgLimit(limit) {
        window.location.href = "/getTeachers?limit=" + limit
    }
</script>
</body>
</html>