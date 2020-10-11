<%@ page import="me.ep.domain.UserVO"%>
<%@ include file="/include/getPrePath.jspf" %>
<jsp:useBean id="user" class="me.ep.domain.UserVO" scope="session" />
<jsp:setProperty name="user" property="*"/>
<%
request.setAttribute("user", user);
request.setAttribute("prePath", prePath);
RequestDispatcher reqDis = request.getRequestDispatcher("/LoginAction");
reqDis.forward(request, response);
%>