

function init()
{
    window.navigator.geolocation.getCurrentPosition(current_position);
}
 
function current_position(position)
{

    
    mapInit( position.coords.latitude ,  position.coords.longitude);
    
}
 
window.addEventListener("load", init);
function mapInit(latitude,logitude)
{
	var mapOptions = {
		    center: new naver.maps.LatLng(latitude, logitude),
		    zoom: 15
		};

	var map = new naver.maps.Map('map', mapOptions);
	
	var MarkerOptions = {
			position : new naver.maps.LatLng(latitude, logitude),
			map : map
	}
	
	var marker = new naver.maps.Marker(MarkerOptions);
	
	MarkerOptions = {
			position : new naver.maps.LatLng(37.1595704, 127.1053),
			map : map
	}
	marker = new naver.maps.Marker(MarkerOptions);
}
