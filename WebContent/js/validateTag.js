
function formValidator(){
	// Make quick references to our fields
	
	
var tname=document.getElementById('tname');
var des=document.getElementById('des');

	
	// Check each input in the order that it appears in the form!
			if(isEmpty(tname,"Please enter Tag name"))
			{
				if(isEmpty(des,"Please enter Tag description. This will help you to get more attention"))
				{
							return true;
				}
			}
	
	
	return false;
	
}
