<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students By Course ID</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<div>
    <h3>已选该课程学生名单</h3>
    <table class="table">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>分数</th>
            <th>操作</th>
        </tr>
        <%
            List<Map<String, Object>> list = (ArrayList) request.getAttribute("studentsByCourseIDList");
            for (Map map : list) {
        %>
        <tr>
            <td><%= map.get("studentID") %></td>
            <td><%= map.get("name") %></td>
            <td><%= map.get("mark") == null ? "未打分" : map.get("mark") %></td>
            <td>
                <%
                    if (map.get("mark") == null) {
                %>
                <button class="btn btn-primary btn-sm" onclick='mark("<%= map.get("studentID") %>","<%= map.get("name") %>")'>打分</button>
                <%
                } else {
                %>
                <span class="text-muted">已打分</span>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<script>
    function mark(studentID,studentName) {
        var courseID = <%= request.getParameter("CourseID") %>;
        parent.document.getElementById("iframeMain").src = "toMark?studentID=" + studentID + "&studentName=" + studentName + "&courseID=" + courseID;
    }
</script>
</body>
</html>