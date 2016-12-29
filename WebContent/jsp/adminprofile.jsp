<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="com.bizzlers.foundation.platform.News" %>
<%@ page import="java.util.Vector" %>
<%@page import="java.text.ParseException" %>
<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title> User Profile Page </title>
 <%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
} 
 int id=(Integer)request.getSession().getAttribute("uid");
 if(id != 1 )
	 response.sendRedirect("http://localhost:8080/Bizzlers/jsp/userprofile.jsp");
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />
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
<li><a href="#" class="selected">Home</a></li>
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
						<li><a href="http://localhost:8080/Bizzlers/ReviewCat"> Review New Categories </a></li>
						<li><a href=http://localhost:8080/Bizzlers/jsp/AddNews.jsp?bid=-1> Announce </a></li>
						<li><a href="http://localhost:8080/Bizzlers/jsp/passwordchange.jsp?attempt=0">Change Password</a></li>
					
				</ul>
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<div class="form-submit" >
			
			 <input class=inputtext type="text" name="query" size="30"/>
			<input class=inputsubmit type="submit" value="Search" />
			</div>
			</form>
			
			
			
			    
			    <br/> <br/>
				<h1> &nbsp; &nbsp; &nbsp;  Welcome  &nbsp; &nbsp; Administrator </h1> <br/><br/>
				<h4> Notifications</h4>
				<!-- 
				<ul class="list">
					<li class="first"><a href="#">Link 1</a></li>
					<li><a href="#">Link 2</a></li>
					<li class="last"><a href="#">Link 3</a></li>
				</ul>
				 -->
			</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">
				<!--  AD

				-->

			</div>
						<div class="box">
				<h3> News </h3>
<%
	Vector<ClassResultSet> list = new Vector<ClassResultSet>();

News newsObj = new News();

try {
	list = newsObj.getAdminNews();
} catch (ParseException e) {
	e.printStackTrace();
}

if(list.size() <= 0 )
	out.print("<h3> No recent news </h3>");

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
			<a href="http://localhost:8080/Bizzlers/ReviewCat"> Review Category </a><br/><br/>
			<a href=http://localhost:8080/Bizzlers/jsp/AddNews.jsp?bid=-1 > Announce </a><br/><br/>
			<a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a> <br/>
					
		</div>
		<div id="page-bottom-sidebar">
			<h3>Connect with us</h3>
			<img src="" alt=fb></img> <img src="" alt=twitter></img> 
			<ul class="list">
				<li class="first"><a href="#"> &nbsp;</a></li>
				<li><a href="#">Contact us</a></li>
				<li class=><a href="#">About Us</a></li>
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