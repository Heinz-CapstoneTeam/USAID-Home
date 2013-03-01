<%-- 
    Document   : result
    Created on : Sep 21, 2012, 3:14:51 PM
    Author     : deepakga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- To make sure that display is properly sized as per the device -->
<!DOCTYPE html>
<html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
                <link rel="stylesheet" href="style.css" type="text/css">
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="jquery-1.4.1.min.js"></script>
        <script type="text/javascript">
            var dummyMapObject = { map: null,bounds: null, mapTypeId: google.maps.MapTypeId.ROADMAP}
            $(document).ready(function() {
                $("#markerdiv").css({
                    height: 350,
                    width: "95%"
                });
               // alert('I am here');
                dummyMapObject.map = new google.maps.Map($('#markerdiv')[0], dummyMapObject);
                dummyMapObject.bounds = new google.maps.LatLngBounds();
                $.ajax({url : "MapServlet",
                    dataType : 'json',
                    data: { species : "<%= request.getAttribute("search")%>"},
                    error : function() {
                        alert("Error Occured");
                    },
                    success : function(data) {
                        $.each(data.jsonArray, function(index) {
                            var lat ;
                            var lng ;
                            $.each(data.jsonArray[index], function(key, value) {
                               // alert(key + ' : ' + value);
                                if(key=='latitude'){
								
                                    lat = value;
                                // lat = 17.74033553;
                                }else if(key=='longitude'){
								
                                    lng = value;
                               //  lng= 83.25067267;
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
        <div id="page_container">
            <div id="header">
                <h1>USAID-CAPSTONE: SEMANTIC WEB APPLICATION</h1>
            </div>
            <div id="navbar">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                </ul>
            </div>
            <div id="content">
                <div class="left_content">
                    <div class="content_piece">
                        <h2>Animal: <%= request.getAttribute("search")%>    </h2>
                        <p align="justify"> 
                            <b> <i> Abstract </i></b> - <%= request.getAttribute("commnts")%>
                        </p>
                        <p style="font-size: smaller; font-style: italic;">Source: DBPedia</p>
                        <br/>
                    </div>
                    <div class="content_piece">
                        <p style="text-align: center;">Map showing observed locations</p>  
                        <div id="markerdiv" style="margin:auto; border: 1px solid black;" > </div>
                        <p style="font-size: smaller; font-style: italic;">Source: Observation Database</p>
                    </div>     
                </div>
                <div class="right_content">     
                    <div class="content_piece">
                        <p style="text-align: center;"><b><%= request.getAttribute("search")%> </b> </p>
                        <img src="<%= request.getAttribute("image")%>" class="right_content_box" width="275px" height="200px" />
                        <p style="font-size: smaller; font-style: italic;">Source: DBPedia</p>
                    </div>          
                    <div class="content_piece">
                        <p style="text-align: center;"><u><b>Classification</b></u></p>
                        <table>
                            <tr>
                                <td><b>Kingdom:</b></td>
                                <td> <i> <%= request.getAttribute("kingdom")%> </i> </td>
                            </tr>
                            <tr>
                                <td><b>Class:</b></td>
                                <td><i> <%= request.getAttribute("class")%></i></td>
                            </tr>
                            <tr>
                                <td><b>Order:</b></td>
                                <td> <i> <a href="<%= request.getAttribute("orderURL")%>"> <%= request.getAttribute("order")%></a> </i></td>
                            </tr>
                            <tr>
                                <td><b>Family:</b></td>
                                <td><i> <%= request.getAttribute("familia")%></i></td>
                            </tr>
                            <tr>
                                <td><b>Phylum:</b></td>
                                <td><i> <%= request.getAttribute("phylum")%> </i></td>
                            </tr>
                            <tr>
                                <td><b>Conservation Status:</b></td>
                                <td><i> <%= request.getAttribute("conservationStatus")%> </i></td>
                            </tr>
                        </table>
                    <p style="font-size: smaller; font-style: italic;">Source: DBPedia</p>
                    </div>          
                </div>
                &nbsp;<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
            
            <div id="footer">
                <p>&copy; Carnegie Mellon University Heinz College Capstone Team 2013</p>
            </div>
        </div>        
    </body>
</html>
