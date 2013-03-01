<%-- 
    Document   : index
    Created on : Feb 11, 2013, 1:38:14 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <div class="left_content">
                    <div class="content_piece">
                        <h2>Welcome!</h2>
                        <p>
                            Welcome to the home page for the semantic web application. This prototype will allow you to 
                            browse districts from the observation data and display data about common plant and animal species
                            from the DBPedia Ontology
                        </p>
                        <p>
                            <a href="LoadData">Begin</a>
                        </p>
                        <br/>
                    </div>
                </div>
                <div class="right_content">     
                    <div class="content_piece">
                        <form name="login" method="post" action="#">
                            <h3 style="text-align: center;">Login</h3>
                            <table border="0" cellpadding="0" cellspacing="0" align="center">
                              <tr>
                                <td>USER ID&nbsp;</td>
                                <td><input name="username" type="text" id="username" maxlength="15"></td>
                              </tr>
                              <tr>
                                <td>PASSWORD&nbsp;</td>
                                <td><input name="password" type="password" id="password" maxlength="10"></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                    <td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td><strong>
                                        <input name="Login" type="submit" value="Login" disabled="true" >
                                  <input name="Reset" type="reset" value="Reset" disabled="true">
                                </strong></td>
                              </tr>
                            </table>
                          </form>
                        <br/>
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

