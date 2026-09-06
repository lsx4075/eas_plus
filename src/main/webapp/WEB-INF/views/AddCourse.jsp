<%--
  Created by IntelliJ IDEA.
  User: 喜洋洋酱
  Date: 2026/8/25
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加或修改课程信息</title>
    <script src="../../js/jquery-2.1.1.js"></script>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<div>
    <h3>课程基本信息</h3>
    <c:if test="${empty course}">
    <form action="/addCourse" method="post">
        </c:if>
        <c:if test="${not empty course}">
        <form action="/editCourse" method="post">
            </c:if>
                <c:if test="${not empty course}">
                    <input type="hidden" name="id" value="${course.id}">
                </c:if>
            <table class="form-table">
                <tr>
                    <td>课程名称:</td>
                    <td><input type="text" name="courseName" class="form-control" value="${course.courseName}"></td>
                </tr>
                <tr>
                    <td>上课时间:</td>
                    <td>
                        <select name="courseTime" class="form-control">
                            <option value="周一" ${course.courseTime == '周一' ? 'selected' : ''}>周一</option>
                            <option value="周二" ${course.courseTime == '周二' ? 'selected' : ''}>周二</option>
                            <option value="周三" ${course.courseTime == '周三' ? 'selected' : ''}>周三</option>
                            <option value="周四" ${course.courseTime == '周四' ? 'selected' : ''}>周四</option>
                            <option value="周五" ${course.courseTime == '周五' ? 'selected' : ''}>周五</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>上课地点:</td>
                    <td><input type="text" name="classroom" class="form-control" value="${course.classroom}"></td>
                </tr>
                <tr>
                    <td>周数:</td>
                    <td><input type="number" name="classWeek" class="form-control" value="${empty course ? 18 : course.classWeek}"></td>
                </tr>
                <tr>
                    <td>课程类型:</td>
                    <td>
                        <select name="courseType" class="form-control">
                            <option value="必修课" ${course.courseType == '必修课' ? 'selected' : ''}>必修课</option>
                            <option value="选修课" ${course.courseType == '选修课' ? 'selected' : ''}>选修课</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>学分:</td>
                    <td>
                        <input type="number" name="score" step="0.5" class="form-control" value="${course.score}">
                    </td>
                </tr>
                <tr>
                    <td>所属学院：</td>
                    <td>
                        <select name="collegeID" id="college" class="form-control" onchange="loadTeachers(this.value,'')"></select>
                    </td>
                </tr>
                <tr>
                    <td>授课老师:</td>
                    <td>
                        <select name="teacherID" id="teacher" class="form-control"></select>
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
        var courseCollegeID = '${course.collegeID}'
        var courseTeacherID = '${course.teacherID}'

        $.ajax({
            url: "/getCollegeAjax",
            type: "get",
            async: true,
            dataType: 'json',
            success: function (arrCollege) {
                var el = document.getElementById("college");
                arrCollege.forEach(c => {
                    el.add(new Option(c.collegeName, c.collegeID))
                })

                if (courseCollegeID != "") {
                    el.value = courseCollegeID;
                }

                var collegeID = el.value;

                loadTeachers(collegeID, courseTeacherID)
            }
        })
    }

    //学院下拉框变化时，加载对应的老师下拉框
    function loadTeachers(collegeID, selectedTeacherID) {
        $.ajax({
            url: "/getTeacherWithIDByCollegeID",
            data: {collegeID: collegeID},
            type: "get",
            async: true,
            dataType: 'json',
            success: function (arrTeacher) {
                var el = document.getElementById("teacher");
                el.length = 0;
                arrTeacher.forEach(t => {
                    el.add(new Option(t.name, t.id))
                });
                if (selectedTeacherID != "") {
                    el.value = selectedTeacherID
                }
            }
        })
    }

    function cancel() {
        window.parent.document.getElementById("iframeMain").src = "/getCourses";
    }
</script>
</body>
</html>