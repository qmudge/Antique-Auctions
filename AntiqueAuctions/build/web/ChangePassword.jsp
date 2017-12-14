<%-- 
    Document   : ChangePassword
    Created on : 19 May 2017, 7:45:53 AM
    Author     : Quintin Mudge
    Description: Change password page.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%--Page text styling.--%>
        <style>
            .shadow {
                text-shadow: 2px 8px 6px rgba(0,0,0,0.2),
                         0px -5px 35px rgba(255,255,255,0.3);
            }
            
            a:hover {
                color: orange; 
            }
        </style>
        <title>Change password</title>

    </head>

    <%--Main heading, Container for page content--%>
    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">
        <h1 style="position: absolute; margin-left: 415px; color: #ff6600 ;
            margin-top: 100px; font-size: 50px ">ANTIQUE AUCTIONS</h1>

        <%--Container for headings and changing password content--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 175px;
             width: 40%; height: 450px;">

            <%--Form container--%>
            <div style="background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;
                 border-radius: 5px; width: 100%; height: 60px;">

                <%--Sub heading--%>
                <h2 style="margin-left: 70px;">Change your password</h2>    
            </div>

            <%--Form with 2 value fields--%>
            <FORM NAME="ChangePassword" action="SecretQuestion.jsp" method ="post"
                  style="position: absolute; margin-left: 50px; margin-top: 45px">

                <%--Users name input field--%>
                <INPUT TYPE="text" placeholder="Username" name="username" required 
                       pattern=".{3,20}" title ="Must contain between 3-20 characters"
                       style="width: 300px; margin: 10px 0; padding: 12px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <%--Submit button--%>
                <INPUT TYPE="SUBMIT" VALUE="Get secret question" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px;
                       margin: 8px 0; border: none;border-radius: 4px;cursor: pointer;">
            </FORM>

            <%--Link to home page--%>
            <h4 style="position: absolute; margin-top: 250px; margin-left: 50px ">
                <a href="AntiqueAuctions.jsp">Home</a>
            </h4>
        </div>

        <%--Copyright information--%>    
        <footer style="text-align: center; position: absolute; width: 100%; bottom: 0px;
                background-color: #08532b">Copyright © 2005-2017 Antique Auctions Inc.
            All Rights Reserved.
        </footer>
    </body>
</html>
