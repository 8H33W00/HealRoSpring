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
	    		
	    		getView('community?type=1');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
	else if(type == "diabete")
	{
		$.ajax({
	        url: 'createDiabete',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community?type=2');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
		
	}
	else if(type == "cardio")
	{
		$.ajax({
	        url: 'createCardio',
	        type: 'POST',
	        data: JSON.stringify(data),
	        contentType: 'application/json',
		    xhrFields: {
		        withCredentials: true
		    },
	    	success: function(response) {
	    		
	    		getView('community?type=3');
	        },
	        failure: function( response ) {
	     	   alert('fail');
	        }
		});
	}
})