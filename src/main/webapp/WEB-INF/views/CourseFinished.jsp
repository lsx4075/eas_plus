<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已修课程</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<h3>已修课程</h3>
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
            <th>成绩</th>
        </tr>
        <%
            List<Map<String,Object>> list = (ArrayList)request.getAttribute("courseFinishedList");
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
            <td class="text-danger"><%=map.get("mark")%></td>
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
</div>
</body>
</html>