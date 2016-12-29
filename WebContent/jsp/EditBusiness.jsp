<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page import="java.util.Vector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of products</title>

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />

<style type="text/css"> @import "http://localhost:8080/Bizzlers/css/jquery.datepick.css"; </style>

<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>

<script type="text/javascript" src="http://localhost:8080/Bizzlers/js/jquery.datepick.js"></script>

<script type="text/javascript">

$(function() {
	$('#fddate').datepick({dateFormat: 'yyyy-mm-dd' ,
		minDate: new Date(1900, 1 - 1, 1), 
	    maxDate: new Date(), showTrigger: '#calImg'});
});
</script>

<script type="text/javascript"  charset="utf-8">
		$(document).ready(function(){

			var jVal = {

				'pname' : function() {

					$('body').append('<div id="nameInfo" class="info"></div>');

					var nameInfo = $('#nameInfo');
					var ele = $('#businessname');
					var pos = ele.offset();
					

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					if(ele.val().length < 4) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; name should be of at least 3 letters').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

				
						'desc' : function() {

					$('body').append('<div id="aboutInfo" class="info"></div>');

					var aboutInfo = $('#aboutInfo');
					var ele = $('#fdplace');
					var pos = ele.offset();

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					if(ele.val().length < 3) {
						jVal.errors = true;
							aboutInfo.removeClass('correct').addClass('error').html('&larr; place should be of at least 3 letters ').show();
							ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					} else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				

				'vDate' : function (){

					$('body').append('<div id="birthInfo" class="info"></div>');

					var birthInfo = $('#birthInfo');
					var ele = $('#fddate');
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
				
				'web' : function (){

					$('body').append('<div id="webInfo" class="info"></div>');

					var birthInfo = $('#webInfo');
					var ele = $('#web');
					var pos = ele.offset();

					birthInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+35
					});

					var patt = /^[\w\w\w]+\.[a-zA-Z0-9\-]+\.[a-zA-z0-9]{2,4}$/;
					if(!patt.test(ele.val()) && ele.val().length > 0 ) {
						jVal.errors = true;
							birthInfo.removeClass('correct').addClass('error').html('&larr; please enter valid website address ').show();
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
					jVal.pname();
					jVal.desc();
					jVal.vDate();
					jVal.web();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#businessname').change(jVal.pname);	
			$('#fdplace').change(jVal.desc);
			$('#fddate').change(jVal.vDate);
			$('#web').change(jVal.web);
		

		});
		</script>
		
    
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
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a></li>
						<%  int bid = (Integer)request.getSession().getAttribute("currentbid");
					
						 out.print("<li> <a href=http://localhost:8080/Bizzlers/ViewProducts?bid=" + bid + "> Edit Products </a> </li>");
						 out.print("<li> <a href=http://localhost:8080/Bizzlers/ViewServices?bid=" + bid + "> Edit Services </a> </li>");
						 out.print("<li> <a href=http://localhost:8080/Bizzlers/ViewTags?bid=" + bid + "> Edit Tags </a> </li>");
						 out.print("<li> <a href=http://localhost:8080/Bizzlers/ViewBusinessProfile?id=" + bid + "> Back </a> </li>");
						
						%>
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
				  <h4> <center>  Add Details  </center>  </h4>
		<h4> 
		
		<%

 ClassResultSet result  = (ClassResultSet)request.getAttribute("result");

%>
		
 				
<form id=jform  method="post" action="http://localhost:8080/Bizzlers/EditBusiness" >
		
		<table>
		<!--    -->
			<tr>
					<td align="right">Business Name *:</td>
		      		<td><input type="text" name='businessname' id='businessname' value=" <%=result.getFieldTwo()%> " /></td>   </tr>
			<tr> <td> <br/> </td></tr>
			<tr>
					<td align="right">Tagline:</td>
					<td><input type="text" name="tagline" id=tagline value="<%=result.getFieldThree() %>" /></td> </tr>
			<tr> <td> <br/> </td></tr>
			<tr>
					<td align="right">Formation *:</td>
					<td>
					<%
						if(result.getFieldFive().equals("Private")){
							out.print("<input type=radio name=form  id=private checked=true/> Private");
							out.print("<input type=radio name=form id=public /> Public ");
						}else{
							out.print("<input type=radio name=form  id=private /> Private");
							out.print("<input type=radio name=form id=public checked=true/> Public ");
						}	
					%>
					
					</td> </tr>
			<tr> <td> <br/> </td></tr>
			<tr>
					<td align="right">Founded Place *:</td>
					<td><input type="text" name="fdplace" id=fdplace value="<%=result.getFieldSix() %>" /></td> 		</tr>
			<tr> <td> <br/> </td></tr>
			<tr>
					<td align="right">Founded Date *:</td>
					<td><input type="text" name="fddate" id=fddate value="<%=result.getFieldSeven()%>" /></td>  		</tr>
			<tr> <td> <br/> </td></tr>
			<tr>
				<td align="right">Website :</td>
				<td><input type="text" name="web" id=web value="<%=result.getFieldEight() %>" /></td> 		

</tr>
			<tr> <td> <br/> </td></tr>
			
			<tr>
				<td align="right"> <input class=inputsubmit type='submit' value=' Edit ' id=send /> </td>
					</tr>
			<tr> <td> <br/> </td></tr>
			
						
			</table>
			</h4>
		<h5>
	 <I> Note : Fields with * are compulsary </I> </h5>
</form>

				
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