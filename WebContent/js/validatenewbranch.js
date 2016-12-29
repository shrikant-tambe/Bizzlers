	
function formValidator(){
	var addr1 = document.getElementById('addr1');
	var addr2 = document.getElementById('addr2');
	var city = document.getElementById('city');
	var state = document.getElementById('state');
	var mob = document.getElementById('mob');
	var land = document.getElementById('land');
	var pin=document.getElementById('pin');
	var fax=document.getElementById('Fax');	
	
	// Check each input in the order that it appears in the form!
	if(isAddress(addr1, "Please enter Valid Addess Line 1 "))
	{
	    if(isAddress(addr2, "Please enter Valid Address Line 2 "))
	    {
	    	if(madeSelection(city, "Please Choose a city"))
	        {
	    		if(madeSelection(state, "Please Choose a state"))
	             {
	    			if(isNumeric(mob, "Please enter a valid mobile number"))
	                {
	    				if(isNumeric(land, "Please enter a valid landline number"))
						{	    
	    						if(isNumeric(pin,"Please Enter a valid no."))
	    						{
	    							if(isNumeric(fax,"Please enter a valid no."))
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

	return false;
	
}
