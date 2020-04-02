$( document ).ready(function() {
  
	$('#admin').hide();
	$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		
	if(nickname == userNickName)
	{
		$('#admin').show();
	}
});

function deletePost(id)
{
	if(type == 1)
	{
		getView("deleteCoronaryPost?id=" + id);
	}
	else if(type == 2)
	{
		getView("deleteDiabetePost?id=" + id);
	}
	else if(type == 3)
	{
		getView("deleteCardioPost?id=" + id);
	}
	

}

function createComment(id){
	
	var comment = $('#comment').val();
	if(comment == '')
	{
		alert('내용을 입력하세요');
		}
	else
	{
		getView("createComment?id=" + id);
	}
}

$('#commentBtn').on('click',function(){
	
	var comment = $('#comment').val();
	
	var data = {
			"type" : type,
			"comment" : comment,
			"num" : Id,
			"nickname" : userNickName
	}
	
	$.ajax({
        url: 'createComment',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
	    xhrFields: {
	        withCredentials: true
	    },
    	success: function(response) {
    		
    		if(type == 1)
    		{
    			getView('coronaryView?id='+Id);
    		}
    		else if(type == 2)
    		{
    			getView('diabeteView?id='+Id);
    		}
    		else if(type == 3)
    		{
    			getView('cardioView?id='+Id);
    		}
    		
        },
        failure: function( response ) {
     	   alert('fail');
        }
	});
})
/**
 * 
 */