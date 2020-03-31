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


/**
 * 
 */