<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@page import="java.text.ParseException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>
<%@page import="com.bizzlers.foundation.platform.News" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Business List </title>


 <%  int bid =0;
 if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
 else 
  bid = (Integer)request.getSession().getAttribute("currentbid");
 
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />


<!-- Include java script for validation -->
    
</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Bizzlers</a></h1>
		</div>
		<div id="slogan">
			<h2> See your business growing with us  </h2>
		</div>
		<div id="slogan2">
			<h2> </h2>
		</div>
	</div>
	<div class="innertube">

<ul class="semiopaquemenu">
<li><a href="#" > &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp" class="selected">Home</a></li>
<li><a href="#" >News</a></li>

<li><a href="#">Feedback</a></li>
<li><a href="#">About Us</a></li>
<li><a href="#">Contact Us</a></li>
</ul>


<div class="bottombar"></div>

</div>
	
	<div id="page">
		<div id="content">
		 
			
			
				  <div class="box" id="content-box1">
				  	  
				<ul class="svertical">
						
						<li><a href=http://localhost:8080/Bizzlers/jsp/AddNews.jsp?bid=<%= bid  %>> Announce News </a></li>
						<li><a href=http://localhost:8080/Bizzlers/ViewProducts?bid=<%= bid  %>> Products </a></li>
						<li><a href=http://localhost:8080/Bizzlers/ViewServices?bid=<%= bid  %>> Services </a></li>
						<li><a href=http://localhost:8080/Bizzlers/ViewTags?bid=<%= bid  %>> Tags </a></li>
						<li><a href=http://localhost:8080/Bizzlers/jsp/AddProduct.jsp> Add Products </a></li>
						<li><a href=http://localhost:8080/Bizzlers/jsp/AddService.jsp> Add Services </a></li>
						<li><a href=http://localhost:8080/Bizzlers/jsp/AddTag.jsp>  Add Tags </a></li>
						<li><a href=http://localhost:8080/Bizzlers/jsp/newbranch.jsp>  Add New Branch </a></li>
						<li><a href=http://localhost:8080/Bizzlers/GetBusinessInfo> Edit Business </a></li>		
															
				</ul>
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<table>
			 <tr> <td> <input align="left" class=inputtext type="text" name="query" size="25"/> </td>
			<td><input  align="right" class=inputsubmit type="submit" value="Search" /> </td> </tr>
			</table>
			</form>
			
				    
			    <br/> 
				  <h4>      
		
				
<%

 ClassResultSet result  = (ClassResultSet)request.getAttribute("result");

%>
	
		<table>
		<tr><td><br/></td></tr>
			<tr>
					<td align="left">Business Name &nbsp; : &nbsp;&nbsp;</td> 
					<td><%=result.getFieldTwo() %></td> 				</tr>
<tr><td><br/></td></tr>

			<tr>			
					<td align="left">Tagline &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldThree() %></td> 				</tr>
					<tr><td><br/></td></tr>
			<tr>
					<td align="left">Category &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldEleven() %></td> </tr>
					<tr><td><br/></td></tr>			
			<tr>
					<td align="left">Formation &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldFive()	%></td>   				
			</tr>
			
			<tr><td><br/></td></tr>
			<tr>
					<td align="left">Founded Place &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldSix() %></td>			</tr>
			<tr><td><br/></td></tr>
			<tr>
					<td align="left">Founded Date &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldSeven() %></td>			</tr>
			<tr><td><br/></td></tr>
			
			<tr>
					<td align="left">Website  &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldEight() %></td>			</tr>
			<tr><td><br/></td></tr>
			</table>
	
		
		</h4>
			
			<!-- 
			 Display Branch Information
			 -->	
				
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">


			</div>
		
						<div class="box">
				<h3> News </h3>
<%
	Vector<ClassResultSet> list = new Vector<ClassResultSet>();

News newsObj = new News();

try {
	list = newsObj.getNewsByBid(bid);
} catch (ParseException e) {
	e.printStackTrace();
}

if(list.size() <= 0 ){
	out.print("<h3> No recent news </h3> <br/> ");
	out.print(" Click Here to <a href=http://localhost:8080/Bizzlers/jsp/AddNews.jsp?bid="+ bid +"> Announce </a>");	
}
else{

	out.print("<ul>");
	out.print("<marquee direction=up scrollamount=3 >");
	 out.print("<div class=date-list>");
	out.print("	<ul class=list date-list> ");
	int limit = list.size();
	if(list.size() > 3 )
		limit = 3;

	
	for(int i = 0 ; i < limit ; i ++ ){
		out.print("<li><h4> <span class=date>"+list.elementAt(i).getFieldFour()+"</span>   " + list.elementAt(i).getFieldTwo() + "</h4><br/><h5>"+ list.elementAt(i).getFieldThree() +"</h5></li>" );	
	}
	out.print("</ul> ");
	out.print("</div>");
	
	out.print("</marquee>");
out.print("</ul>");
}

list.removeAllElements();
%>			
			</div>

		
		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3> Bizzlers </h3>
				<a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a> <br/>
				<a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a> <br/>
		</div>
		<div id="page-bottom-sidebar">
			<h3>Connect with us</h3>
			<img src="" alt=fb></img> <img src="" alt=twitter></img> 
			<ul class="list">
				<li class="first"><a href="#"> &nbsp;</a></li>
				<li><a href="#">Contact us</a></li>
				<li class="last"><a href="#">About Us</a></li>
			</ul>
		</div>
		<br class="clearfix" />
	</div>

<div id="footer">
	Bizzlers.com
</div>
</div>
</body>
</html>
