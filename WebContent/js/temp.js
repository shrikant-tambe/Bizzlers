$(document).ready(function(){

			var jVal = {

				'email' : function() {

					$('body').append('<div id="nameInfo" class="info"></div>');

					var nameInfo = $('#nameInfo');
					var ele = $('#username');
					var pos = ele.offset();
					var patt = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+ 40
					});

					

					if(!patt.test(ele.val())) {
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; please enter valid email ').show();
						ele.removeClass('normal').addClass('wrong');
					}
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

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

					
					 if(ele.val() == eleo.val() ) {
						 	nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					} 
					else {
						
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('&larr; passwords does not match ').show();
						ele.removeClass('normal').addClass('wrong');
						
					}
				},
				
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
					jVal.email();
					jVal.pass();
					jVal.pass2();
					jVal.name();
					jVal.mname();
					jVal.lname();
					jVal.vDate();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#username').change(jVal.email);	
			$('#password').change(jVal.pass);
			$('#password2').change(jVal.pass2);
			$('#firstname').change(jVal.name);
			$('#middlename').change(jVal.mname);
			$('#lastname').change(jVal.lname);
			$('#popupDatepicker').change(jVal.vDate);
					

		});
		

