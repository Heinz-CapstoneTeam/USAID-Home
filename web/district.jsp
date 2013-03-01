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
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
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
                <div class="content_piece">
                    <h2>Choose a District</h2>
                    <p>
                        Select the district about which you would like to see more information and click on Submit.
                    </p>
                     <form action ="HomeServlet" method="GET">
                        <select name="district" >
                          <c:forEach items="${districtList}" var="location">   
                              <c:if test="${location.district=='Dhankuta' || location.district=='Koshi'}" >
                                 <option value="${location.locationid}"><c:out value="${location.district}" /></option>
                              </c:if>
                          </c:forEach>
                              <input type="submit" value="Submit" />
                    </form>     
                    <br/><br/><br/><br/><br/><br/>
                </div>
            </div>
            
            <div id="footer">
                <p>&copy; Carnegie Mellon University Heinz College Capstone Team 2013</p>
            </div>
        </div>        
    </body>
</html>
