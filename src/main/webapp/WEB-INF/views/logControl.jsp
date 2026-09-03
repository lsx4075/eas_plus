<%--
  Created by IntelliJ IDEA.
  User: 喜洋洋酱
  Date: 2026/8/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--session中没有用户名--%>
<c:if test="${empty sessionScope.uname}">
  <%--重定向到登录页面--%>
  <c:redirect url="Login.jsp"/>
</c:if>
