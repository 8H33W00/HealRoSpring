$(document).ready(function(){
    
		
		$('#coronaryTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		$('#cardioTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		$('#diabetesTb').DataTable({
			stateSave: true,
			language: {
				lengthMenu:
					  "Display <select class='browser-default custom-select ml-1 mr-1'>" +
			          '<option value="5">5</option>' +
			          '<option value="10">10</option>' +
			          '<option value="20">20</option>' +
			          '<option value="-1">All</option>' +
			          "</select>"
			},
			pageLength: 10,
			order: [[0, "desc"]],
			drawCallBack: function(){
			  $(".dataTables_paginate > .pagination").addClass("pagination-rounded");
			},
			columnDefs: [
				{ targets: 2, width: 150 }
			]
	    });
		
		
		$('#cardio').hide();
		$('#diabetes').hide();
		
});


$('#selectDisease').on('change',function(){
	var value = $('#selectDisease').val();
	
	if(value == 'coronary')
	{
		$('#cardio').hide();
		$('#diabetes').hide();
		$('#coronary').show();
	}
	else if(value == 'diabete')
	{
		$('#cardio').hide();
		$('#coronary').hide();
		$('#diabetes').show();
	}
	else if(value == 'cardio')
	{
		
		$('#diabetes').hide();
		$('#coronary').hide();
		$('#cardio').show();
	}
	
})