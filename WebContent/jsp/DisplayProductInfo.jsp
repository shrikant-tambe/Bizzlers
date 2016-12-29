<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Information</title>
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
				  	
				  	<!--
				  	 Display ad here 
				  	 
				  	 -->
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<div class="form-submit" >
			
			 <input class=inputtext type="text" name="query" size="30"/>
			<input class=inputsubmit type="submit" value="Search" />
			</div>
			</form>
			    
			    <br/> <h4> 
<%
    ClassResultSet result = (ClassResultSet)request.getAttribute("result");
%>

		<table>
		
		<tr><td><br/></td></tr>
			<tr>
					<td align="left"> Name &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldTwo() %></td> 				</tr>
<tr><td><br/></td></tr>

			<tr>			
					<td align="left"> Description  &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldFour() %></td> 				</tr>
					<tr><td><br/></td></tr>
			<tr>
					<td align="left">Category &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldEleven() %></td> </tr>
					<tr><td><br/></td></tr>			
			<tr>
					<td align="left">Category Description &nbsp; : &nbsp;&nbsp;</td>
					<td><%=result.getFieldTwelve()	%></td>   				
			</tr>
			
			<tr><td><br/></td></tr>
					
			</table>
	
		</h4>
		
				
<img src="images/product.jpg" alt =" No image uploaded ">

			</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">
				<!--  $$$$$$$$$ AD $$$$$$$$$$$$
				-->

			</div>
			
			<div class="box">
			
				<!--  $$$$$$$$$ AD $$$$$$$$$$$$
				-->
			
			
				</div>
			
			
		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3> Bizzlers </h3>
			
		</div>
		<div id="page-bottom-sidebar">
			<h3>Connect with us</h3>
			<img src="" alt=fb></img> <img src="" alt=twitter></img> 
			<ul class="list">
			
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