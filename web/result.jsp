<%-- 
    Document   : result
    Created on : Feb 14, 2013, 8:52:38 PM
    Author     : Abhishek
--%>

<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Semantic Web Application</title>
        <link rel="stylesheet" href="style.css" type="text/css">
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="jquery-1.4.1.min.js"></script>
        <script type="text/javascript">
            var dummyMapObject = { map: null,bounds: null, mapTypeId: google.maps.MapTypeId.ROADMAP}
            $(document).ready(function() {
                $("#markerdiv").css({
                    height: 275,
                    width: 275
                });
               // alert('I am here');
                dummyMapObject.map = new google.maps.Map($('#markerdiv')[0], dummyMapObject);
                dummyMapObject.bounds = new google.maps.LatLngBounds();
                $.ajax({url : "MapServlet",
                    dataType : 'json',
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
                        <h2>District: <label><%= request.getAttribute("districtName")%></label> </h2>
                         <p>
                            Description: A hilly district in South-East Nepal
                            <br/>
                            Alt Range:
                            <br/>
                            Climate:
                         </p>
                    </div>
                    <div class="content_piece">
                        <h2>Plants (Most Common)</h2>
                          <ol>
                             <c:forEach items="${plantList}" var="plants">
                                    <li><a href="RdfController?search=${plants}"> <c:out value="${plants}" /></a></li>
                            </c:forEach>
                          </ol>
					
                        <p>
                            Also found: {Relationship}
                            <br/>
                            {List of most common similar plant...}
                            <br/>
                            Sisoo, Khair, Swertia spp, (Chiraito)
                        </p>
                        <p style="font-size: smaller; font-style: italic;">Source: Observation Database</p>
                    </div>
                    <div class="content_piece">
                        <h2>Animals (Most Common)</h2>
                        					
                    <ol>
                          <c:forEach items="${animalList}" var="animals">
                            <li> <a href="RdfController?search=${animals}"> <c:out value="${animals}" /></a> </li>  
                          </c:forEach>                                            
		    </ol>
                        <p>
                            Also found: {Relationship}
                            <br/>
                            {List of most common similar animals...}
                            <br/>
                            Leopard, Panther, Fox
                        </p>
                        <p style="font-size: smaller; font-style: italic;">Source: Observation Database</p>
                    </div>
                </div>
                <div class="right_content">
                    <div class="content_piece">
                        <p style="text-align: center;">Map showing occurrence for <i> <c:out value="${plantList.get(0)}"/> </i></p>
                        <div id="markerdiv" style="margin:auto; border: 1px solid black;" > </div>
                        <p style="font-size: smaller; font-style: italic;">Source: Observation Database</p>
                    </div>          
                    <div class="content_piece">
                        <p style="text-align: center;">Picture of <i> <c:out value="${plantList.get(0)}"/> </i> </p> 
                        <img class="right_content_box" src="<%= request.getAttribute("plantPic")%>" width="275px" height="275px" > 
                         <p style="font-size: smaller; font-style: italic;">Source: DBPedia</p>
                    </div>          
                    <div class="content_piece">
                        <p style="text-align: center;">Picture of <i> <c:out value="${animalList.get(0)}"/></i></p>  
                        <img class="right_content_box" src="<%= request.getAttribute("animalPic")%>" width="275px" height="275px" />
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
