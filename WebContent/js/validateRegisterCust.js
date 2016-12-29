function formValidator(){
	// Make quick references to our fields
	var firstname = document.getElementById('firstname');
	var lastname = document.getElementById('lastname');
	var addr = document.getElementById('addr');
	var mob = document.getElementById('mob');
	var pin = document.getElementById('pin');
	var state = document.getElementById('state');
	var city = document.getElementById('city');
	var username=document.getElementById('username');
	var email = document.getElementById('email');
	
	// Check each input in the order that it appears in the form!
	if(isAlphabet(firstname, "Please enter only letters for your name"))
	{
	    if(isAlphabet(lastname, "Please enter only letters for your name"))
	    {
		if(isAddress(addr, "Numbers and Letters Only for Address"))
		{
			if(isNumeric(mob, "Please enter a valid mobile number")&& lengthRestriction2(mob,10,"Enter 10 digit mobile number"))
			{
			    if(isNumeric(pin, "Please enter a valid pin number"))
			    {
				if(madeSelection(state, "Please Choose a State"))
				{
				    if(madeSelection(city, "Please Choose a city"))
				     {
					if(lengthRestriction(username, 6, 8))
					{
						if(emailValidator(email, "Please enter a valid email address"))
						{
							return true;
						}
					}
				     }
				}
			    }
			}
		
		}
	   }
	}
	
	
	return false;
	
}

