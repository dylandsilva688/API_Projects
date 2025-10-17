<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 style="color: red; text-align: center">
    <%= request.getParameter("status")%>
</h1>
</body>
</html>
<jsp:include page="loginform.html" flush="true"/>