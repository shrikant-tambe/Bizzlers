<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="description" content="" />
<meta name="keywords" content="" />
<title> User Profile Page </title>


 <%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />


<link rel="stylesheet" type="text/css" href="../css/autocom.css" />
 <script type="text/javascript"  src="../js/jquery.min.js"></script> 
<script type="text/javascript" src="../js/jquery.autocomplete.js"></script>

<style type="text/css"> @import "../css/jquery.datepick.css"; </style>
<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../js/jquery.datepick.js"></script>

<script type="text/javascript">


$("#category").autocomplete("http://localhost:8080/Bizzlers/jsp/getdata.jsp");
$("#fdplace").autocomplete("http://localhost:8080/Bizzlers/jsp/getcities.jsp");


$(function() {
	$('#popupDatepicker').datepick({dateFormat: 'yyyy-mm-dd' ,
		minDate: new Date(1900, 1 - 1, 1), 
	    maxDate: new Date(), showTrigger: '#calImg'});
	
	$('#popupDatepicker2').datepick({dateFormat: 'yyyy-mm-dd' ,
		minDate: new Date(1900, 1 - 1, 1), 
	    maxDate: new Date(), showTrigger: '#calImg'});
});
</script>



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
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a></li>
						<li><a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a></li>
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
				  <h3> <center>  Please Enter Details </center> </h3>
		<h4>
		
		<form onsubmit='return formValidator()' method="post" action="http://localhost:8080/Bizzlers/AddContact">
		<fieldset>
			<table>
				<tr>
					<td align="right">Address:</td>
					<td><input type='text' name='addr1' /></td>
				</tr>

				<tr>
					<td align="right">Detail Address:</td>
					<td><input type='text' name='addr2' /></td>
				</tr>

				<tr>
					<td align="right">City:</td>
					<td><input type=text name='city'/></td>
				</tr>

				<tr>
					<td align="right">State:</td>
					<td><input type=text name='state' /></td>
				</tr>

				<tr>
					<td align="right">Mobile No:</td>
					<td><input type='text' name='mob' /></td>
				</tr>

				<tr>
					<td align="right">Landline:</td>
					<td><input type='text' name='landline' /></td>
				</tr>
				
				<tr>
					<td align="right">Pin Code:</td>
					<td><input type='text' name='pin' /></td>
				</tr>
				</table>
			<input type='submit' value='Submit' />
		</fieldset>
	</form>
				
		</h4>
				
				
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

