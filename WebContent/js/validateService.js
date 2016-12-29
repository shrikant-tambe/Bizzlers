
function formValidator(){
	// Make quick references to our fields
	
	
var sname=document.getElementById('sname');
var des=document.getElementById('des');

	
	// Check each input in the order that it appears in the form!
			if(isEmpty(sname,"Please enter service name"))
			{
				if(isEmpty(des,"Please enter service description. This will help you to get more attention"))
				{
							return true;
				}
			}
	
	
	return false;
	
}
