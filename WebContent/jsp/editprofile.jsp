<%@ page import="java.util.Vector" %>
<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view profile</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />
<style type="text/css"> @import "http://localhost:8080/Bizzlers/css/jquery.datepick.css"; </style>
<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>
<script type="text/javascript" src="http://localhost:8080/Bizzlers/js/jquery.datepick.js"></script>

<script type="text/javascript">

$(function() {
	$('#dob').datepick({dateFormat: 'yyyy-mm-dd' ,
		minDate: new Date(1900, 1 - 1, 1), 
	    maxDate: new Date(1998, 12-1, 31), showTrigger: '#calImg'});

	
});
</script>

<script type="text/javascript"  charset="utf-8">
		$(document).ready(function(){

			var jVal = {
				
				'name' : function() {

					$('body').append('<div id="aboutInfo" class="info"></div>');

					var aboutInfo = $('#aboutInfo');
					var ele = $('#firstname');
					var pos = ele.offset();
					var patt = /^[a-zA-Z][a-zA-Z ]+$/;
					

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					 if(ele.val().length < 1) {
						jVal.errors = true;
							aboutInfo.removeClass('correct').addClass('error').html('&larr; name cannt left blank ').show();
							ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					} else if(!patt.test(ele.val())) {
						jVal.errors = true;
						aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid name  ').show();
						ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					}
					else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				
				'mname' : function() {

					$('body').append('<div id="mInfo" class="info"></div>');

					var aboutInfo = $('#mInfo');
					var ele = $('#middlename');
					var pos = ele.offset();
					var patt = /^[a-zA-Z][a-zA-Z ]+$/;					

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					
					 if(!patt.test(ele.val()) && ele.val().length > 0) {
						jVal.errors = true;
						aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid name  ').show();
						ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					}
					else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				
				'lname' : function() {

					$('body').append('<div id="lInfo" class="info"></div>');

					var aboutInfo = $('#lInfo');
					var ele = $('#lastname');
					var pos = ele.offset();
					var patt = /^[a-zA-Z][a-zA-Z ]+$/;					

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					
					 if(!patt.test(ele.val()) && ele.val().length > 0) {
						jVal.errors = true;
						aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid name  ').show();
						ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					}
					else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

				'vDate' : function (){

					$('body').append('<div id="birthInfo" class="info"></div>');

					var birthInfo = $('#birthInfo');
					var ele = $('#popupDatepicker');
					var pos = ele.offset();

					birthInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 35
					});

					var patt = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/ ;

					if(!patt.test(ele.val())) {
						jVal.errors = true;
							birthInfo.removeClass('correct').addClass('error').html('&larr; type in date in correct format').show();
							ele.removeClass('normal').addClass('wrong');
					} else {
							birthInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
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
					jVal.name();
					jVal.mname();
					jVal.lname();
					jVal.vDate();
					jVal.sendIt();
				});
				return false;
			});

			
			
			$('#firstname').change(jVal.name);
			$('#middlename').change(jVal.mname);
			$('#lastname').change(jVal.lname);
			$('#dob').change(jVal.vDate);
					

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
						<li><a href="http://localhost:8080/Bizzlers/jsp/passwordchange.jsp">Change Password</a></li>
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
			
			
<form method="post" action="http://localhost:8080/Bizzlers/EditProfileAction" id=jform >
<table>

		<tr>	<td align="right">First Name:</td>
				<td><input type="text" name="firstname" id="firstname"  value="<%=request.getAttribute("firstname") %> "></td>
			</tr>
<tr><td><br/></td></tr>
			<tr>
				<td align="right">Middle Name:</td>
				<td><input type="text" name="middlename" id="middlename" value="<%=request.getAttribute("middlename") %> "></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td align="right">Last Name:</td>
				<td><input type="text" name="lastname" id="lastname" value="<%=request.getAttribute("lastname") %> "></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td align="right">Date Of Birth:</td>
				<td><input type="text" name="dob" id="dob" value="<%=request.getAttribute("dob") %>"></td>
				
			</tr>
			
				<tr><td></td><td><font color=gray size=3><i> you should be at least 14 years old </i></font> <br/><br/></td></tr>
			
			<tr>
				<td align="right">Gender:</td>
				<td><select name=gender >
				<% if(request.getAttribute("gender").equals("Male"))
						out.print("<option id=male selected=selected > Male </option><option id=female > Female </option>");
					else 
						out.print("<option id=male > Male </option><option id=female selected=selected > Female </option>");
				%> 
				<option > 
				</select></td>
				
			</tr>
			
			<tr><td><br/></td></tr>
			
			<tr>
				<td align="right"><input class=inputsubmit type="submit" name="edit" value="Save" is=send ></td>				
			</tr>
			
			<tr><td><br/></td></tr>
			
			
			</table>
			</form>
				
</h4>	
				
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