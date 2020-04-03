function init()
{
    window.navigator.geolocation.getCurrentPosition(current_position);
}
 
function current_position(position)
{
    var msg;
    
    msg = "Latitude: " + position.coords.latitude + ", " + "Longitude: " + position.coords.longitude;
    
    alert(msg);
}
 
window.addEventListener("load", init);
