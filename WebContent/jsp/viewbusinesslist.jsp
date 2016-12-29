<%@page import="java.util.StringTokenizer"%>
<%@page import="com.bizzlers.foundation.FDE.Tokanizer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Business List </title>


 <%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />


</head>

<body >
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
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a></li>
						<li><a href="http://localhost:8080/Bizzlers/html/registerCust.html"> Register Business </a></li>
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
				  
		<h5>
				
				<%
	@SuppressWarnings("unchecked")
	Vector<String> resultSets = (Vector<String>)request.getAttribute("result");

	String printString = null ;
	int bids[]= new int[50],cnt =0;
	
	String bid = (String) request.getSession().getAttribute("bids");
	
	
	
	StringTokenizer st = new StringTokenizer(bid);
	
	while(st.hasMoreTokens()){
		bids[cnt++] = Integer.parseInt(st.nextToken());
	}
	
	if (resultSets.size() <= 0 ){
		out.println(" <center> You have not registered any business yet </center><br/><br/>");
		out.println("&nbsp;&nbsp;&nbsp; <a href=http://localhost:8080/Bizzlers/html/registerCust.html>  Register Business </a>");
	}
	else{
		
		out.print("<h4> <center>  Select Your business to explore more    </center> </h4>");
		out.print("<ol class=none>");
	
	for(int i = 0 ;  i < resultSets.size() ; i ++ ){
		printString = resultSets.elementAt(i) ;
	
	 		out.print("<li>");
			out.print("<h4> <a href=http://localhost:8080/Bizzlers/ViewBusinessProfile?id="+ bids[i]  +">" + printString + "   </a> </h4> " ) ;
			out.print("</li>");
			
    	}//while
    	
	}//for
		out.print("</ol>");
			

	
%>
		</h5>
				
				
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">


			</div>
			
			<div class="box">
				
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