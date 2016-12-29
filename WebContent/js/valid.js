$(document).ready(function(){

	var jVal = {
		'fullName' : function() {

			$('body').append('<div id="nameInfo" class="info"></div>');

			var nameInfo = $('#nameInfo');
			var ele = $('#fullname');
			var pos = ele.offset();
			var patt = /^[a-zA-Z]+$/;

			nameInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+25
			});

			if(ele.val().length < 4) {
				jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html('&larr; name should be of at least 4 letters').show();
					ele.removeClass('normal').addClass('wrong');
			} 
			else if(!patt.test(ele.val())){
				jVal.errors = true;
				nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid name ').show();
				ele.removeClass('normal').addClass('wrong');
			}
			else {
					nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		'pname' : function() {

			$('body').append('<div id="nameInfo" class="info"></div>');

			var nameInfo = $('#nameInfo');
			var ele = $('#pname');
			var pos = ele.offset();
			

			nameInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+25
			});

			if(ele.val().length < 4) {
				jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html('&larr; product name should be of at least 3 letters').show();
					ele.removeClass('normal').addClass('wrong');
			} 
			else {
					nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		
		'birthDate' : function (){

			$('body').append('<div id="birthInfo" class="info"></div>');

			var birthInfo = $('#birthInfo');
			var ele = $('#birthday');
			var pos = ele.offset();

			birthInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+25
			});

			//var patt2 = /^[0-9]{2}\-[0-9]{2}\-[0-9]{4}$/i;
			var patt = /^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/i;

			if(!patt.test(ele.val())) {
				jVal.errors = true;
					birthInfo.removeClass('correct').addClass('error').html('&larr; type in date in correct format').show();
					ele.removeClass('normal').addClass('wrong');
			} else {
					birthInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		'gender' : function (){

			$('body').append('<div id="genderInfo" class="info"></div>');

			var genderInfo = $('#genderInfo');
			var ele = $('#woman');
			var pos = ele.offset();

			genderInfo.css({
				top: pos.top-10,
				left: pos.left+ele.width()+60
			});

			if($('input[name="gender"]:checked').length === 0) {
				jVal.errors = true;
					genderInfo.removeClass('correct').addClass('error').html('&larr; please select your gender').show();
					ele.removeClass('normal').addClass('wrong');
			} else {
					genderInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},
		
		'firm' : function (){

			$('body').append('<div id="genderInfo" class="info"></div>');

			var genderInfo = $('#genderInfo');
			var ele = $('#woman');
			var pos = ele.offset();

			genderInfo.css({
				top: pos.top-10,
				left: pos.left+ele.width()+60
			});

			if($('input[name="gender"]:checked').length === 0) {
				jVal.errors = true;
					genderInfo.removeClass('correct').addClass('error').html('&larr; please select your firm type ').show();
					ele.removeClass('normal').addClass('wrong');
			} else {
					genderInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},

		'email' : function() {

			$('body').append('<div id="emailInfo" class="info"></div>');

			var emailInfo = $('#emailInfo');
			var ele = $('#email');
			var pos = ele.offset();

			emailInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+25
			});

			var patt = /^.+@.+[.].{2,}$/i;

			if(!patt.test(ele.val())) {
				jVal.errors = true;
					emailInfo.removeClass('correct').addClass('error').html('&larr; please enter valid email adress').show();
					ele.removeClass('normal').addClass('wrong');
			} else {
					emailInfo.removeClass('error').addClass('correct').html('&radic;').show();
					ele.removeClass('wrong').addClass('normal');
			}
		},
		
		'desc' : function() {

			$('body').append('<div id="aboutInfo" class="info"></div>');

			var aboutInfo = $('#aboutInfo');
			var ele = $('#des');
			var pos = ele.offset();

			aboutInfo.css({
				top: pos.top-3,
				left: pos.left+ele.width()+12
			});

			if(ele.val().length < 1) {
				jVal.errors = true;
					aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter description').show();
					ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
			} else {
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
			jVal.pname();
			jVal.desc();
			jVal.sendIt();
		});
		return false;
	});

	
	$('#pname').change(jVal.pname);	
	$('#des').change(jVal.desc);
	
	

});