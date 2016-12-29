<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Business List </title>


 <%  
 if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
 
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />


<!-- Include java script for validation -->
    
</head>

<body background="../images/businessbg.jpg">
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
						<li><a href="http://localhost:8080/Bizzlers/EditProfile"> Edit Profile </a></li>
						<li><a href="http://localhost:8080/Bizzlers/jsp/passwordchange.jsp?attempt=0">Change Password</a></li>
						<li><a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a></li>
																
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
			
			<table>
			
			<tr><td><br></td></tr>
			
			
		<tr>	<td align="left">First Name:&nbsp;&nbsp;</td>
				<td><%=request.getAttribute("firstname") %></td>
			</tr>
<tr><td><br></td></tr>
			<tr>
				<td align="left">Middle Name: &nbsp;&nbsp;</td>
				<td>
				<%
				   if(request.getAttribute("middlename") == null)
					   out.print(" <i> Not Specified  </i> ");
				   else
					   out.print(request.getAttribute("middlename"));
				%>
				
				</td>
			</tr>
<tr><td><br></td></tr>


			<tr>
				<td align="left">Last Name:&nbsp;&nbsp;</td>
				<td><%=request.getAttribute("lastname") %></td>
			</tr>
<tr><td><br></td></tr>
			<tr>
				<td align="left">Date Of Birth:&nbsp;&nbsp;</td>
				<td><%=request.getAttribute("dob") %></td>
				
			</tr>
<tr><td><br></td></tr>
			<tr>
				<td align="left">Gender:&nbsp;&nbsp;</td>
				<td>
				<%
				   if(request.getAttribute("gender")== null)
					   out.print(" Not Specified ");
				   else 
					   out.print(request.getAttribute("gender"));
			
				%>
				</td>
			</tr>
			
			<tr><td><br></td></tr>
			
			</table>	
				
</h4>	
				
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">
				<!--  <h3> Explore your business  </h3>
				<div id="search">
				<form method="post" action="http://localhost:8080/Bizzlers/Login">
					<table>

						<tr><td>Username</td><td> <input class="inputtext" type="text" name="username" size="18"/></td></tr>
						<tr><td> </td><td> </td></tr>
						<tr><td>Password</td><td> <input class="inputtext"  type="password" name="password" size="18"/></td></tr>
						<tr><td> </td><td> </td></tr>

						<tr><td></td><td align="right"> <input class="inputsubmit" type="submit" value=" Submit "/></td></tr>
					</table>
				</form>
				<br/>
				 &nbsp;  &nbsp; <a href="#"> Forgot Password ? </a>  &nbsp; &nbsp; &nbsp; <a href="/Bizzlers/html/registerCust.html"> Register Here </a>
				 <br/>  <br/>
				</div>
				-->

			</div>
			<!-- 
			<div class="box">
				<h3> New Businesses </h3>
				<div class="date-list">
					<ul class="list date-list">
						<li class="first"><span class="date">2/08</span> <a href="#"> date 1 </a></li>
						<li><span class="date">2/05/12</span> <a href="#">date 2</a></li>
						<li class="last"><span class="date">1/31</span> <a href="#">date 3</a></li>
					</ul>
				</div>
			</div>
			 -->
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
