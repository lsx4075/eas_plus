<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mark</title>
    <%@ include file="commonStyle.jsp" %>
</head>
<body>
<div>
    <h3>学生打分</h3>
    <form action="/mark" method="post" onsubmit="return chkMark()">
        <input type="hidden" name="courseID" value="<%=request.getParameter("courseID")%>">
        <table class="form-table">
            <tr>
                <td>学号</td>
                <td><input type="text" name="studentID" class="form-control" readonly value="<%=request.getParameter("studentID")%>"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="studentName" class="form-control" readonly value="<%=request.getParameter("studentName")%>"></td>
            </tr>
            <tr>
                <td>成绩</td>
                <td><input type="number" step="0.5" name="mark" id="mark" class="form-control"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" class="btn btn-primary" value="提交">
                    <input type="reset" class="btn btn-default" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    function chkMark() {
        var mark = document.getElementById("mark").value;
        if (mark === "") {
            alert("请填写成绩！");
            return false;
        }
        return confirm("确认提交成绩：" + mark + "分？");
    }
</script>
</body>
</html>