<%@ page language="java" %>
<%
if(request.getSession().getAttribute("session_name") == null){ 
	response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}/* get the cookie value from client browser*/
String cookieName = "cookie_name";
String cookieValue=null;
Cookie cookies [] = request.getCookies ();
Cookie myCookie = null;
if (cookies != null){
	for (int i = 0; i < cookies.length; i++){
		if (cookies [i].getName().equals (cookieName)){
			myCookie = cookies[i];
			break;
		}
	}
}
cookieValue=myCookie.getValue();
%> 
<br>
<p>Welcome: <%=cookieValue%>.
<%

%>
<br>
session value:-<%=session.getAttribute("session_name")%>
<br>
Last logging date and time:- <%=session.getAttribute("date")%>
<br>
<br>
<a href="http://localhost:8080/Bizzlers/jsp/logout.jsp">Logout</a> 
