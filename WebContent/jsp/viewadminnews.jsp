<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@page import="com.bizzlers.foundation.platform.News" %>
<%@ page import="java.util.Vector" %>
<%@page import="java.text.ParseException" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of products</title>

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
<li><a href="http://localhost:8080/Bizzlers/" >Home</a></li>
<li><a href="" class="selected">News</a></li>

<li><a href="">Feedback</a></li>
<li><a href="">About Us</a></li>
<li><a href="">Contact Us</a></li>
</ul>


<div class="bottombar"></div>

</div>
	
	<div id="page">
		<div id="content">
		 
			
			
				  <div class="box" id="content-box1">
				  	  
				<ul class="svertical">
						<li><a href="http://localhost:8080/Bizzlers/"> Home </a></li>
						<li> <a href=http://localhost:8080/Bizzlers > Back </a></li>
					 
				</ul>
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<div class="form-submit" >
			
			 <input class=inputtext type="text" name="query" size="30"/>
			<input class=inputsubmit type="submit" value="Search" />
			</div>
			</form>
			
				    
			    <br/> 
				 
	
				
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
	out.print("<h4> <marquee> News and updates of Bizzlers </marquee> </h4>");
	out.print("<ul>");

	out.print("<div class=date-list>");
	out.print("	<ul class=list date-list> ");
	int limit = list.size();
	if(list.size() > 10 )
		limit = 10;


	for(int i = 0 ; i < limit ; i ++ ){
		out.print("<li><h4> <span class=date>"+list.elementAt(i).getFieldFour()+"</span>   " + list.elementAt(i).getFieldTwo() + "</h4><br/><h5>"+ list.elementAt(i).getFieldThree() +"</h5></li>" );	
	}
	out.print("</ul> ");
	out.print("</div>");
	

out.print("</ul>");
}

list.removeAllElements();
%>

		</h5>
				
				
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">

			</div>
		
			<div class="box">
				
				<!--  ##############  ad s--> 
				
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