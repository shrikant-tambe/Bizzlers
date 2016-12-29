<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title> User Profile Page </title>


 <%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");
}  
%>

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/autocom.css" />
 <script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jquery.min.js"></script> 
<script type="text/javascript" src="http://localhost:8080/Bizzlers/js/jquery.autocomplete.js"></script>


<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />

<style type="text/css"> @import "http://localhost:8080/Bizzlers/css/jquery.datepick.css"; </style>

<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>

<script type="text/javascript" src="http://localhost:8080/Bizzlers/js/jquery.datepick.js"></script>
<script type="text/javascript">

$(function() {
	$('#popupDatepicker').datepick({dateFormat: 'yyyy-mm-dd' ,
		minDate: new Date(1900, 1 - 1, 1), 
	    maxDate: new Date(), showTrigger: '#calImg'});
	
	$('#popupDatepicker2').datepick({dateFormat: 'yyyy-mm-dd' ,
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
					var patt = /^[a-zA-Z ]+$/;

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					

					if(!patt.test(ele.val())) {
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid name ').show();
						ele.removeClass('normal').addClass('wrong');
					}
					else if(ele.val().length < 3) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; name should be of at least 3 letters').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

				'cat' : function() {

					$('body').append('<div id="catInfo" class="info"></div>');

					var nameInfo = $('#catInfo');
					var ele = $('#category');
					var pos = ele.offset();
					var patt = /^[a-zA-Z ]+$/;

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					

					if(!patt.test(ele.val())) {
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid category ').show();
						ele.removeClass('normal').addClass('wrong');
					}
					else if(ele.val().length < 3) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; category should be of at least 3 letters').show();
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

				
				'extra' : function() {

					$('body').append('<div id="extraInfo" class="info"></div>');

					var aboutInfo = $('#extraInfo');
					var ele = $('#exinfo');
					var pos = ele.offset();

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					if(ele.val().length < 3 && ele.val().length > 0) {
						jVal.errors = true;
							aboutInfo.removeClass('correct').addClass('error').html('&larr; please  provide more information ').show();
							ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					} else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				
				
				'tag' : function() {

					$('body').append('<div id="tagInfo" class="info"></div>');

					var aboutInfo = $('#tagInfo');
					var ele = $('#tagline');
					var pos = ele.offset();

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 30
					});

					if(ele.val().length < 3 && ele.val().length > 0) {
						jVal.errors = true;
							aboutInfo.removeClass('correct').addClass('error').html('&larr; please  enter full tagline ').show();
							ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					} else {
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
				
				'vDate2' : function (){

					$('body').append('<div id="dateInfo" class="info"></div>');

					var birthInfo = $('#dateInfo');
					var ele = $('#popupDatepicker2');
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
				

				'relation' : function() {

					$('body').append('<div id="relInfo" class="info"></div>');

					var nameInfo = $('#relInfo');
					var ele = $('#rel');
					var pos = ele.offset();
					var patt = /^[a-zA-Z ]+$/;

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					

					if(!patt.test(ele.val())) {
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid relation ').show();
						ele.removeClass('normal').addClass('wrong');
					}
					else if(ele.val().length < 3) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; name should be of at least 3 letters').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
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
					jVal.cat();
					jVal.desc();
					jVal.vDate();
					jVal.vDate2();
					jVal.web();
					jVal.relation();
					jVal.extra();
					jVal.tag();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#businessname').change(jVal.pname);	
			$('#fdplace').change(jVal.desc);
			$('#popupDatepicker').change(jVal.vDate);
			$('#popupDatepicker2').change(jVal.vDate2);
			$('#web').change(jVal.web);
			$('#category').change(jVal.cat);
			$('#rel').change(jVal.relation);
			$('#exinfo').change(jVal.extra);
			$('#tagline').change(jVal.tag);
		

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
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Back </a></li>
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
				
					<form id=jform method="post" action="http://localhost:8080/Bizzlers/registerBusiness"  >
			<fieldset>
		<table>
		<tr> <td> <br/> </td> </tr>
			<tr>
					<td align="right">Business Name <font color=red >*</font>:</td>
					<td><input type="text" name="businessname" id="businessname"  /></td>
				</tr>
				
				<tr><td><br class=small /></td></tr>
				
			<tr>
					<td align="right">Tagline:</td>
					<td><input type="text" name="tagline" id="tagline" /></td>
				</tr>
				
				<tr> <td> <br/> </td> 	</tr>
				
			<tr>
					<td align="right">Category <font color=red >*</font>:</td>
					<td> <input type="text" name="category" id ="category" />	</td>
			
				</tr>
			
			<tr> <td> <br/> </td>
				</tr>
			
			<tr>
				<td align="right">Formation <font color=red >*</font>:</td>
				<td><select name=form ><option id=private > Private </option>  
						<option id=public > Public </option> 
				</select></td>
			</tr>
			
			<tr> <td> <br/> </td>
				</tr>
			
			<tr>
				<td align="right">Founded Place <font color=red >*</font>:</td>
				<td><input type="text" name="fdplace" id="fdplace" /></td>
			</tr>
			
				<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right">Founded Date <font color=red >*</font>:</td>
				<td><input type="text" name="fddate" id="popupDatepicker" /></td>
			</tr>
			
			<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right">Website:</td>
				<td><input type="text" name="web" id="web" /></td>
			</tr>
			
			<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right">Relation with firm <font color=red >*</font>:</td>
				<td><input type="text" name="rel" id="rel"/></td>
			</tr>
			
			<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right">Extra Information:</td>
				<td><input type="text" name="exinfo" id="exinfo" /></td>
			</tr>
			
			<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right">Joined firm from <font color=red >*</font>:</td>
				<td><input type="text" name="fdate"  id="popupDatepicker2"/></td>
			</tr>		
			
			<tr> <td> <br/> </td> </tr>
			
			<tr>
				<td align="right"> <input class="inputsubmit" type='submit' value='Submit' id=send /> </td>
				<td> <input class="inputsubmit" type=reset value='Clear' /> </td>
			</tr>
			<tr> <td> <br/> </td> </tr>
			
			</table>
			
			<i> <font color=black size=3 ></> <p>  &nbsp; &nbsp; &nbsp;  Note : Fields with <font color=red >*</font> are compulsary </p> </i>
			
			
	</fieldset>
	
	<script>
        $("#fdplace").autocomplete("getcities.jsp");
    </script>
    	
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