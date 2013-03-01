<%-- 
    Document   : result
    Created on : Feb 11, 2013, 1:47:56 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    height: 1000,
                    width: 1000
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
    <body>
    <h7> District is   <%= request.getAttribute("district")%></h7><br>
    <table>
        <c:forEach items="${plantList}" var="plants">
            <tr>
                <td><a href="RdfController?search=${plants}"> <c:out value="${plants}" /></a></td>
              
            </tr>
        </c:forEach>
    </table>
    <table>
        <c:forEach items="${animalList}" var="animals">
            <tr>
                <td><a href="RdfController?search=${animals}"> <c:out value="${animals}" /></a></td>
               
            </tr>
        </c:forEach>
    </table>
    
    <h2>Plant pic: </h2>

    <img src="<%= request.getAttribute("plantPic")%>" height="400" width="400" >
     <h2>Animal pic: </h2>
    <img src="<%= request.getAttribute("animalPic")%>" height="400" width="400">
    <div id="markerdiv"></div>
</body>
</html>
