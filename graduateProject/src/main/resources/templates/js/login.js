function signUp()
{
	$('#validselUserId').hide();
	$('#validselUserPwd').hide();
	$('#validselUserNm').hide();
	
	var userId = $('#selUserId').val();
	var userPwd = $('#selUserPwd').val();
	var userName = $('#selUserNm').val();
	
	if(userId == "" || userPwd == "" || userName == "")
	{
		
		if(userId == "")
		{
			$('#validselUserId').show();
		}
		
		if(userPwd == "")
		{
			$('#validselUserPwd').show();
		}
		
		if(userName == "")
		{
			$('#validselUserNm').show();
		}
		
		
		
	}
	else
	{
		
	var data ={
			userId : userId,
			userPwd : userPwd,
			userName : userName
	};
	
	console.log(data);
	
	$.ajax({
        url: 'signUp',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		console.log(response);
    		if(response == 1)
    		{
    			$('#modalClose').click();
    			}
    		else if(response == 2)
    		{
    			alert('Your ID Already Exists.');
    			}
    		else{
    			alert('Fail : Check Your Nickname If It Is English Or Not.')
    		}
    		
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
	}
}



function signIn()
{
	$('#validinputEmail').hide();
	$('#validinputPassword').hide();
	
	var userId = $('#inputEmail').val();
	var userPwd = $('#inputPassword').val();
	
	
	if(userId == "" || userPwd == "")
	{
		if(userId == "")
		{
			$('#validinputEmail').show();
		}
		
		if(userPwd == "")
		{
			$('#validinputPassword').show();
		}
	}
	else
	{
		
	
	var data ={
			userId : userId,
			userPwd : userPwd,
	};
	
	console.log(data);
	
	$.ajax({
        url: 'signIn',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		console.log(response);
    		if(response == 1)
    		{
    			getView('');
    			
    		}
    		else if(response == 2)
    		{
    			alert('Wrong Password');
    		}
    		else{
    			alert('There Is No ID');
    		}
    		
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
	}

}