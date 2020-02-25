var HEALRO_REST_POST_URL = setRestUrl(); 

$( document ).ready(function() {
  
});


function setRestUrl(){
	var wholeUrl = window.location.href;
	var url = "http://"+wholeUrl.split("/")[2];
	return url;
}

function getView(func){
	location.href = HEALRO_REST_POST_URL+"/"+func;
	
}

function logout(){
	console.log('exec logout()');
    getView('logout');
}

function heartDiseasePredict()
{
	if(userNickName != null)
	{
		getView('predictHeartDisease');
	}
	else
	{
		getView('login');
	}
}

function heartDiseasePredict2()
{
	if(userNickName != null)
	{
		getView('predictHeartDisease2');
	}
	else
	{
		getView('login');
	}
}


function diabetesPredict()
{
	if(userNickName != null)
	{
		getView('predictDiabetes');
	}
	else
	{
		getView('login');
	}
}