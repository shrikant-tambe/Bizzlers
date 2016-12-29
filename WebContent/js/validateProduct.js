
function formValidator(){
	// Make quick references to our fields
	
	
var pname=document.getElementById('pname');
var des=document.getElementById('des');

	
	// Check each input in the order that it appears in the form!
			if(isEmpty(pname,"Please enter product name"))
			{
				if(isEmpty(des,"Please enter product description. This will help you to get more attention"))
				{
							return true;
				}
			}
	
	
	return false;
	
}
