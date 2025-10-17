<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String uname = "";
    String upwd = "";
    String status = "";
%>
<%
    uname = request.getParameter("uname");
    upwd = request.getParameter("upwd");
    if (uname.equals("dog") && upwd.equals("dog")) {
        status = "Login Successful";
    } else {
        status = "Login Failed";
    }
%>

<jsp:forward page="status.jsp">
    <jsp:param name="status" value='<%=status%>'/>
</jsp:forward>
