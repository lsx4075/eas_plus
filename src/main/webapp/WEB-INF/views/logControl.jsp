<%--
  Created by IntelliJ IDEA.
  User: 喜洋洋酱
  Date: 2026/8/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

&lt;%&ndash;session中没有用户名&ndash;%&gt;
<c:if test="${empty sessionScope.uname}">
  &lt;%&ndash;重定向到登录页面&ndash;%&gt;
  <c:redirect url="/toLogin"/>
</c:if>--%>
<%--登录拦截已由 LoginControlFilter 统一处理，此处无需重复检查--%>
