$(document).ready(function () {
	
	/*$.ajax({
		 type : 'GET',
         url : '/getSessionData',
        
        success : function(data) {
        	// Save the name in localStorage.
            localStorage.setItem('loggedInUser', data);
            alert(JSON.stringify(data));
         
        }
	});*/
	
	/*var name = localStorage.getItem('loggedInUser');
	 alert(name);*/
});

function signOut()
{
	alert("signOut");
	$.ajax({
		
        url : '/dhyanpraveshika-web/signOut',
	 });

}
/*
function login()
{
	var email = document.getElementByName("email");
	var password = document.getElementByName("password");
	alert(email);
	$.ajax({
		 type : 'post',
         url : '/home',
       
       success : function(data) {
       	// Save the name in localStorage.
    	   alert(data);
           localStorage.setItem('loggedInUser', data);
           alert(JSON.stringify(data));
        
       }
	});

}*/