<%--
  Created by IntelliJ IDEA.
  User: 喜洋洋酱
  Date: 2026/8/26
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生操作页面</title>
    <link href="../../layui/css/layui.css" rel="stylesheet">
    <script src="../../js/jquery-2.1.1.js"></script>
    <style>
        .admin-header {
            height: 60px;
            line-height: 60px;
            padding: 0 15px;
            font-size: 18px;
            color: #fff;
            background-color: #393D49;
            position: relative;
        }

        .admin-header span {
            position: absolute;
            right: 20px;
            top: 50%;
            transform: translateY(-50%);
            border: 1px solid rgba(255,255,255,0.5);
            padding: 4px 16px;
            border-radius: 20px;
            background-color: rgba(255,255,255,0.1);
            font-size: 14px;
            color: #fff;
            display: inline-block;
            line-height: normal;
            margin-left: 10px;
        }

        .layui-layout-admin .layui-side {
            top: 60px;
        }
        .layui-layout-admin .layui-body {
            top: 60px;
            left: 200px;
            bottom: 0;
            overflow: auto;
        }
        #iframeMain {
            width: 100%;
            height: 100%;
            border: none;
        }
        .layui-side {
            background-color: #ffffff !important;
        }
        .layui-nav-tree .layui-nav-item {
            background-color: #ffffff !important;
        }
        .layui-nav-tree .layui-nav-item a {
            color: #333 !important;
            background-color: transparent !important;
        }
        .layui-nav-tree .layui-nav-item.layui-this a {
            background-color: #F0F8F8 !important;
            color: #3070B0 !important;
        }
        .layui-nav-tree .layui-nav-item.layui-this:after {
            background-color: #3070B0 !important;
        }
        .layui-nav-tree .layui-nav-item .layui-nav-more {
            display: none !important;
        }
    </style>
</head>
<body>
<%@include file="logControl.jsp"%>
<c:if test="${not empty uname}">
    <div class="admin-header">
        教务信息查询系统（学生）
        <span>${uname}</span>
    </div>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-side layui-bg-black">
            <ul class="layui-nav layui-nav-tree" lay-filter="adminNav">
                <li class="layui-nav-item layui-this"><a href="javascript:;" data-url="/getCoursesForStu">所有课程</a></li>
                <li class="layui-nav-item"><a href="javascript:;" data-url="/getCoursesUncompleted">已选课程</a></li>
                <li class="layui-nav-item"><a href="javascript:;" data-url="/getCoursesFinished">已修课程</a></li>
                <li class="layui-nav-item"><a href="javascript:;" data-url="ChangePwd.jsp">修改密码</a></li>
                <li class="layui-nav-item"><a href="/logOut" onclick="return confirm('确定要退出系统吗？')">退出系统</a></li>
            </ul>
        </div>
        <div class="layui-body">
            <iframe id="iframeMain" src="/getCoursesForStu" style="width: 100%" height="100%"></iframe>
        </div>
    </div>
    <script src="../../layui/layui.js"></script>
    <script>
        layui.use(function(){
            var element = layui.element;
            element.render('nav', 'adminNav');
        });

        $(document).ready(function () {
            $("ul[lay-filter='adminNav'] li>a").click(function () {
                var url = $(this).attr("data-url");
                if (url) {
                    $("#iframeMain").attr("src", url);
                }
            });
        });
    </script>
</c:if>
</body>
</html>