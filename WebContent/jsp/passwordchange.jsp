<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Change Password </title>

 <%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />
<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>
<script type="text/javascript"  charset="utf-8">
		$(document).ready(function(){

			var jVal = {

				
				'pass' : function() {

					$('body').append('<div id="catInfo" class="info"></div>');

					var nameInfo = $('#catInfo');
					var ele = $('#password');
					var pos = ele.offset();
					

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					
					 if(ele.val().length < 6) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; password should be of at least 6 letters').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				
				'passo' : function() {

					$('body').append('<div id="ocatInfo" class="info"></div>');

					var nameInfo = $('#ocatInfo');
					var ele = $('#opassword');
					var pos = ele.offset();
					

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					
					 if(ele.val().length < 1) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; please enter old password').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

				
				'pass2' : function() {

					$('body').append('<div id="cat2Info" class="info"></div>');

					var nameInfo = $('#cat2Info');
					var ele = $('#password2');
					var eleo = $('#password');
					var pos = ele.offset();
					

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					
					  if(ele.val() == eleo.val() )  {
						 	nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					} 
					else {
						
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; passwords does not match ').show();
						ele.removeClass('normal').addClass('wrong');
						
					}
				},
				
				'sendIt' : function (){
					if(!jVal.errors) {
						$('#jform').submit();
					}
				}
			};
			
			
			$('#send').click(function (){
				var obj = $.browser.webkit ? $('body') : $('html');
				obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
					jVal.errors = false;
					jVal.pass();
					jVal.pass2();
					jVal.passo();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#opassword').change(jVal.passo);
			$('#password').change(jVal.pass);
			$('#password2').change(jVal.pass2);
		});
		</script>
		



<!-- Include java script for validation -->
    
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
		<fieldset > <center>
		<form id=jform method="POST" action="/Bizzlers/PasswordChange">

		<table>
		<tr><td><br/></td></tr>
		<tr><td><br/></td></tr>
			<tr>
				<td align="left">Old Password <font color=red >*</font>:</td>
				<td><input type="password"  name="opassword" id=opassword /></td>
			</tr>
<tr><td></td><td><%
	if(request.getParameter("attempt").equals("flase"))	
	out.print("<div> <center> <font color=red size=2> Old password did not matched !!! </font> </center> </div>") ;
	%></td></tr>
<tr><td><br/></td></tr>
			<tr>
				<td align="left">New Password <font color=red >*</font>:</td>
				<td><input type="password" name="npassword" id=password /></td>
			</tr>
		<tr><td><br/></td></tr>
		<tr>
				<td align="left">Retype New Password <font color=red >*</font>:</td>
				<td><input type="password" name="npassword" id=password2 /></td>
			</tr>
		<tr><td><br/></td></tr>
		<tr><td><br/></td></tr>
		<tr><td align ="right"><input class=inputsubmit type='Submit' value='Change' id=send /></td> <td align="left"><input class=inputsubmit type=reset value='Clear' /></td></tr>
		
		<tr><td><br/></td></tr>
		</table>
	<i><font color=black size=3 ></> <p>  &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  Note : Fields with <font color=red >*</font> are compulsary </p> </i>

	</form></center></fieldset>
				
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
