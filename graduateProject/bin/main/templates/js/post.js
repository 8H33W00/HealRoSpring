/**
 * 
 */

$('#postBtn').on('click',function(){
	
	var data = {
			'nickname' :userNickName,
			'title' : $('#title').val(),
			'content': $('#content').val(),	
	}
	

	
	if(type == "coronary")
	{
		$.ajax({
	        url: 'createCoronary',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	else if(type == "diabete")
	{
		
	}
	else if(type == "cardio")
	{
		
	}
})