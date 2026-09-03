<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<h3>课程列表</h3>
<div class="search-group">
    <input type="text" id="courseNameForStu" class="form-control" value="${courseNameForStu}" placeholder="请输入课程名：">
    <input type="button" class="btn btn-primary" value="搜索" onclick="queryCourse()">
</div>
<div>
    <table class="table">
        <tr>
            <th>课程号</th>
            <th>课程名称</th>
            <th>授课老师</th>
            <th>上课时间</th>
            <th>上课地点</th>
            <th>周数</th>
            <th>课程类型</th>
            <th>学分</th>
            <th>操作</th>
        </tr>
        <%
            List<Map<String,Object>> list = (ArrayList)request.getAttribute("courseForStuList");
            if (list != null && list.size() > 0) {
                for (Map map : list) {
        %>
        <tr>
            <td><%=map.get("id")%></td>
            <td><%=map.get("courseName")%></td>
            <td><%=map.get("name")%></td>
            <td><%=map.get("courseTime")%></td>
            <td><%=map.get("classroom")%></td>
            <td><%=map.get("classWeek")%></td>
            <td><%=map.get("courseType")%></td>
            <td><%=map.get("score")%></td>
            <td>
                <button type="button" class="btn btn-primary btn-sm" value="<%=map.get("id")%>" onclick="chooseCourse(this.value)">选课</button>
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
    <div style="color: red">${msg}</div>
</div>
<script>
    function queryCourse() {
        var courseNameForStu = document.getElementById("courseNameForStu").value;
        window.location.href = '/getCoursesForStu?courseNameForStu=' + courseNameForStu;
    }

    function chooseCourse(courseID) {
        window.parent.document.getElementById("iframeMain").src = '/chooseCourse?courseID=' + courseID + '&studentID=${uname}';
    }
</script>
</body>
</html>