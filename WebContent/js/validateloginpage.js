
function formValidator()
{
	
	var username=document.getElementById('username');
	var password = document.getElementById('password');
	 


		// Check each input in the order that it appears in the form!
						if( isEmpty(username,"Plese enter Username "))
						{
							if(isEmpty(password, "Please enter password"))
							{
								return true;
							}
						}
		
		return false;
	 
}


