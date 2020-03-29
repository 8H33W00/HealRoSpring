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
	getView("deletePost?id=" + id);

}

/**
 * 
 */