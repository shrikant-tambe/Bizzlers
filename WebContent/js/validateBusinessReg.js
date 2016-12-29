function formValidator()
{
	// Make quick references to our fields
	var businessname = document.getElementById('businessname');
	var tagline = document.getElementById('tagline');
	var cat = document.getElementById('cat');
	//var firm = document.getElementById('firm');
	var fddate = document.getElementById('fddate');
	var fdplace = document.getElementById('fdplace');
	var web = document.getElementById('web');
	var addr= document.getElementById('addr');
	var detaddr = document.getElementById('detaddr');
	var state = document.getElementById('state');
	var city = document.getElementById('city');
	var cntno = document.getElementById('cntno');
	var rel = document.getElementById('rel');
	var fdate = document.getElementById('fdate');
	var tdate = document.getElementById('tdate');
	
	// Check each input in the order that it appears in$ the form!
	
	
	if(isAlphabet(businessname, "Please enter only letters for your name"))
	{
	    if(isAlphanumeric(tagline, "Please enter valid tagline"))
	    {
		if(madeSelection(cat, "Please choose the category"))
		{
			if(isAlphabet(fdplace, "Please enter valid place"))
			{
			    
				if(webvalidator(web, "Please enter a valid website"))
				{
				    if(isAlphanumeric(addr, "Please eneter the valid address"))
				     {
				    	if(isAlphanumeric(detaddr, "Please enter valid address"))
				    		{
				    			if(madeSelection(city, "Please choose the city"))
				    			{
				    				if(madeSelection(state, "Please choose the state"))
				    				{
				    					if(lengthRestriction2(cntno,10 ,"Enter 10 digit mobile number"))
				    					{
				    						if(isAlphabet(rel, "Please enter a valid relation"))
				    						{
				    						   if(isAlphanumeric(exinfo, "Please enter valid information"))
				    						   {
				    							    if(isEmpty(fddate, "Please Enter Founded Date"))
				    							    {
				    							    	if(isEmpty(fdate, "Please Enter Founded Date"))
				    							    	{
				    							    		if(isEmpty(tdate, "Please Enter Founded Date"))
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
				}
			    }
			 }
		  }
	    }
	 }
	
	return false;
	
}

