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

    

<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>



<script type="text/javascript"  charset="utf-8">
$(document).ready(function(){

	var jVal = {

		'addr' : function() {

			$('body').append('<div id="nameInfo" class="info"></div>');

			var nameInfo = $('#nameInfo');
			var ele = $('#addr1');
			var pos = ele.offset();

			nameInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+35
			});

		 if(ele.val().length < 3) {
				jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html('&larr; please enter location ').show();
					ele.removeClass('normal').addClass('wrong');
			} 
			else {
					nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		'state' : function() {

			$('body').append('<div id="catInfo" class="info"></div>');

			var nameInfo = $('#catInfo');
			var ele = $('#state');
			var pos = ele.offset();
			var patt = /^[a-zA-Z ]+$/;

			nameInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+ 40
			});

			
			if(!patt.test(ele.val())) {
				jVal.errors = true;
				nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid state name  ').show();
				ele.removeClass('normal').addClass('wrong');
			}
			else if(ele.val().length < 3) {
				jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html('&larr; state name should be of at least 3 letters ').show();
					ele.removeClass('normal').addClass('wrong');
			} 
			else {
					nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		
		'city' : function() {

			$('body').append('<div id="stInfo" class="info"></div>');

			var nameInfo = $('#stInfo');
			var ele = $('#city');
			var pos = ele.offset();
			var patt = /^[a-zA-Z ]+$/;

			nameInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+ 40
			});

			
			if(!patt.test(ele.val())) {
				jVal.errors = true;
				nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid city name  ').show();
				ele.removeClass('normal').addClass('wrong');
			}
			else if(ele.val().length < 3) {
				jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html('&larr; city name should be of at least 3 letters ').show();
					ele.removeClass('normal').addClass('wrong');
			} 
			else {
					nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},
		
		'pin' : function() {

			$('body').append('<div id="extraInfo" class="info"></div>');

			var aboutInfo = $('#extraInfo');
			var ele = $('#pin');
			var pos = ele.offset();
			var pat = /^[0-9]+$/ ;

			aboutInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+12
			});

	
			 if(ele.val().length < 6 ) {
				jVal.errors = true;
					aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid 6 digit pin code ').show();
					ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
			} else if(!pat.test(ele.val())) {
				jVal.errors = true;
				nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid pin code ').show();
				ele.removeClass('normal').addClass('wrong');
			} else {
					aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},
		
		
		'mobile' : function() {

			$('body').append('<div id="mInfo" class="info"></div>');

			var aboutInfo = $('#mInfo');
			var ele = $('#mob');
			var pos = ele.offset();
			var pat = /^[0-9]+$/ ;

			aboutInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+12
			});

	
			 if(ele.val().length < 10 && ele.val().length > 0 && !pat.test(ele.val()) ) {
				jVal.errors = true;
					aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid 10 digit mobile number ').show();
					ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
			}  else {
					aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},
		
		'landline' : function() {

			$('body').append('<div id="lInfo" class="info"></div>');

			var aboutInfo = $('#lInfo');
			var ele = $('#landline');
			var pos = ele.offset();
			var pat = /^[0-9]+$/ ;

			aboutInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+12
			});

	
			 if(ele.val().length < 10 && ele.val().length > 0 && !pat.test(ele.val()) ) {
				jVal.errors = true;
					aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter valid 10 digit number ').show();
					ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
			}  else {
					aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
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
			jVal.addr();
			jVal.state();
			jVal.city();
			jVal.pin();
			jVal.mobile();
			jVal.landline();
			jVal.sendIt();
		});
		return false;
	});

	
	$('#addr1').change(jVal.addr);	
	$('#state').change(jVal.state);
	$('#city').change(jVal.city);
	$('#pin').change(jVal.pin);
	$('#mob').change(jVal.mobile);
	$('#landline').change(jVal.landline);
	
	


});
		</script>
    
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
				  <h3> <center>  Please Enter Contact Details </center> </h3>
		<h4>
		
		<form id=jform method="post" action="http://localhost:8080/Bizzlers/AddContact">
		<fieldset>
			<table>
			
			<tr> <td> <br/> </td> 	</tr>
				<tr>
					<td align="right">Address <font color=red>*</font>:</td>
					<td><input type='text' name='addr1' id=addr1 /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>
				<tr>
					<td align="right">Detail Address:</td>
					<td><input type='text' name='addr2' id=addr2 /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>

				<tr>
					<td align="right">State <font color=red>*</font>:</td>
					<td><input type=text name='state' id=state /></td>
				</tr>
				
<tr> <td> <br/> </td> 	</tr>
				<tr>
					<td align="right">City <font color=red>*</font>:</td>
					<td><input type=text name='city' id=city /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>

				<tr>
					<td align="right">Pin Code <font color=red>*</font>:</td>
					<td><input type='text' name='pin' id=pin /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>				
				<tr>
					<td align="right">Mobile No:</td>
					<td>+91<input type='text' name='mob' id=mob /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>
				<tr>
					<td align="right">Landline:</td>
					<td><input type='text' name='landline' id=landline /></td>
				</tr>
<tr> <td> <br/> </td> 	</tr>				
				
				
				<tr> <td align="right"> <input class="inputsubmit" type='submit' value='Submit' id=send /> </td> 	
				<td align="left"> <input class="inputsubmit" type=reset value='Clear' /> </td> </tr>
				
				<tr> <td> <br/> </td> 	</tr>
				
				
				</table>
				
				<tr>
					<i> <font color=black size=3> <p>&nbsp;&nbsp;&nbsp;&nbsp; Note : fields with  <font color=red>*</font>are compulsary  </p></font> </i> 
					
			
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

