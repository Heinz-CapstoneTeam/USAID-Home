<!DOCTYPE html>
<html>
<head>
<title>Google Maps</title>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="jquery-1.4.1.min.js"></script>
<script type="text/javascript">
var dummyMapObject = { map: null,bounds: null, mapTypeId: google.maps.MapTypeId.ROADMAP}
$(document).ready(function() {
  $("#markerdiv").css({
		height: 500,
		width: 600
	});
  dummyMapObject.map = new google.maps.Map($('#markerdiv')[0], dummyMapObject);
  dummyMapObject.bounds = new google.maps.LatLngBounds();

    $.ajax({url : "MapServlet",
            dataType : 'json',
            error : function() {
                alert("Error Occured");
            },
            success : function(data) {
                alert('I have reached here');
                $.each(data.jsonArray, function(index) {
                    var lat = null;
                    var lng = null;
                    $.each(data.jsonArray[index], function(key, value) {
                        alert(key + ' : ' + value);
                        if(key=='latitude'){
                          lat = value;
                        }else if(key=='longitude'){
                          lng = value;
                        }
                        if(lng!=null && lat!=null){
                          var point = new google.maps.LatLng(parseFloat(lat),parseFloat(lng));
                          // extend the bounds to include the new point
                          dummyMapObject.bounds.extend(point);
                          var marker = new google.maps.Marker({
                                  position: point,
                                  map: dummyMapObject.map
                          });
                          var infoWindow = new google.maps.InfoWindow();
                          google.maps.event.addListener(marker, 'click', function() {
                                  infoWindow.open(dummyMapObject.map, marker);
                          });
                          dummyMapObject.map.fitBounds(dummyMapObject.bounds);
                        }
                     }); 
                     lat = null;
                     lng = null;
                });

            }
        });
});
</script>
</head>
<body><div id="markerdiv"></div>
</body>
</html>