<%@ page import="com.jxd.eas.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加或修改学生信息</title>
    <script src="../../js/jquery-2.1.1.js"></script>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<div>
    <h3>学生基本信息</h3>
    <c:if test="${empty student}">
    <form action="/addStu" method="post">
        </c:if>
        <c:if test="${not empty student}">
        <form action="/editStu" method="post">
            </c:if>
            <input type="hidden" name="id" value="${student.id}">
            <table class="form-table">
                <tr>
                    <td>姓名:</td>
                    <td><input type="text" name="name" class="form-control" value="${student.name}"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <%
                            Student student = (Student) request.getAttribute("student");
                            if (student == null || ((student != null) && ("男".equals(student.getSex())))) {
                        %>
                        <label><input type="radio" name="sex" value="男" checked> 男</label>
                        <label><input type="radio" name="sex" value="女"> 女</label>
                        <%
                        } else {
                        %>
                        <label><input type="radio" name="sex" value="男"> 男</label>
                        <label><input type="radio" name="sex" value="女" checked> 女</label>
                        <%
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td>出生日期:</td>
                    <td><input type="date" name="birthday" class="form-control" value="${student.birthday}"></td>
                </tr>
                <tr>
                    <td>入学时间:</td>
                    <td><input type="date" name="grade" class="form-control" value="${student.grade}"></td>
                </tr>
                <tr>
                    <td>所属学院：</td>
                    <td>
                        <select name="collegeID" id="college" class="form-control"></select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;">
                        <input type="button" class="btn btn-default" value="取消" onclick="cancel()">
                        <input type="submit" class="btn btn-primary" value="确定">
                    </td>
                </tr>
            </table>
        </form>
</div>
<script>
    window.onload = function () {
        var collegeID = '${student.collegeID}'
        $.ajax({
            url: "/getCollegeAjax",
            type: "get",
            async: true,
            dataType: 'json',
            success: function (arrCollege) {
                var el = document.getElementById("college")
                arrCollege.forEach(function (c) {
                    el.add(new Option(c.collegeName, c.collegeID))
                })

                if (collegeID) {
                    el.value = collegeID
                }
            }
        })
    }
    function cancel() {
        window.parent.document.getElementById("iframeMain").src = "/getStudents";
    }
</script>
</body>
</html>