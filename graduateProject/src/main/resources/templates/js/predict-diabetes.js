



$("#go").click(function(){ 
		
		var data = {
				Pregnancies : $('#Pregnancies').val(),
				Glucose : $('#Glucose').val(),
				BloodPressure : $('#BloodPressure').val(),
				SkinThickness : $('#SkinThickness').val(),
				Insulin : $('#Insulin').val(),
				BMI : $('#BMI').val(),
				Age : $('#Age').val()
				
		}
		
		
		JSON.stringify(data);
		console.log(data);
		$.ajax({
	        type: "GET",
	        dataType: "jsonp",
	        data : data,
	        url: "http://localhost:5000/diabetes",
	        success: function (data) {
	        	var result = data.odd +"%";
	        	$('#textArea').empty();
	        	$('#textArea').append(result);
	            
	        }
	    });
}); 


function calculate(){
	
	$('#validheight').hide();
	$('#validweight').hide();
	
	var height = $('#height').val()/100;
	var weight = $('#weight').val();
	
	
	if(height == "" || weight == "")
	{
		if(height == "")
		{
			$('#validheight').show();
		}
		
		if(weight == "")
		{
			$('#validweight').show();
		}
	}
	else
	{
		var BMI = (weight / (height * height)).toFixed(2);
		$('#modalClose').click();
		$('#target').empty();
		
		var html = "<label for='BMI'>BMI Figure</label>" +
					"<input class = 'form-control' id='BMI' type='number' value='" + BMI + "'>";
		
		$('#target').append(html);
		
	}
}


/**
 * 
 */