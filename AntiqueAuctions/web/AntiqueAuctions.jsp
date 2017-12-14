
<%--  
    Document   : AntiqueAuctions
    Created on : 17 May 2017, 10:24:48 AM
    Author     : Quintin Mudge
    Description: Welcome page for website, contains links to the rest of the site.
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

        <title>Home page</title>
    </head>

    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <%--Top menu, Left side. Supply's links to the rest of the site.--%>
        <header style="width: 100%; height: 40px; background-color: #d9dede;
                position: absolute; margin-top: -43px;">
            <h3 style="margin-left: 170px; margin-top: 15px">Welcome!
                <a href="LoginPage.jsp">Sign in</a> or 
                <a href="RegisterUser.jsp">Register</a>

                <%--Top menu, Right side menu's and links.--%>
            </h3>
            <h3 style="position: absolute; margin-left: 700px; margin-top: -40px;">
                <a href="AuctionDisplay.jsp">Active auctions </a>&emsp;&emsp; 
                <a href="SellItem.jsp">Sell an item</a>
                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

                <%/**
                     * Display for user being logged in.
                     */
                    out.println("<span style='font-size: 15px; color: #0066ff;'>");
                    if (session.getAttribute("Username") == null) { //tests if user is logged in.
                        out.println("Not signed in");

                    } else {
                        out.println("Signed in as: " + session.getAttribute("Username"));
                    }   //gets and displays session username.
                    out.println("</span>");
                %>
                <%--Logoff link--%>
                &emsp; <a href="logoffPage.jsp">Log out</a>
            </h3>
        </header>

        <%--Main heading with picture logo.--%>
        <h1 style="margin-left: 170px; color: #ff6600; font-size: 50px">ANTIQUE AUCTIONS</h1>

        <%--Hammer picture--%>
        <img src="Images\\hammer.jpg" alt="hammer pic" style="width:320px; 
             margin-left: 700px; height:80px; position: absolute;  margin-top: -90px;">

        <%--Main content container, item examples.--%>
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 6px;
             border-color: #b8e7fb; margin-left: 170px; width: 75%; height: 599px;">

            <%--Sales text paragraph.--%>
            <h2 style="color: brown; margin-left: 5px; margin-top: 40px; letter-spacing: 1px;           
                font-style: italic">Check out our</br>great range
                </br> of available
                </br> items!
            </h2>

            <%--Mini paragraph with link to auction display page.--%>
            <h2 style="color: brown; margin-left: 10px; position: absolute; letter-spacing: 1px; 
                margin-top: 320px; font-style: italic">And so much</br>
                <a href="AuctionDisplay.jsp">more..</a> </br>
            </h2>

            <%--Item example images with name descriptions.--%>
            <img src="Images\\bicycle.jpg" alt="bicycle pic" style="width:300px;
                 margin-left: 170px; height:220px; position: absolute;
                 margin-top: -125px; border: solid 1px; border-color: #7cc3e1">
            <h3 style="position: absolute; margin-top: 110px; margin-left: 270px;
                font-style: italic">
                <u>Trendy cycles</u>
            </h3>

            <img src="Images\\stereo.jpg" alt="stereo pic" style="width:300px; 
                 margin-left: 550px; height:220px; position: absolute; margin-top: -125px;
                 border: solid 1px; border-color: #7cc3e1">
            <h3 style="position: absolute; margin-top: 110px; margin-left: 650px;
                font-style: italic">
                <u>Mega sounds</u>
            </h3>

            <img src="Images\\golf.jpg" alt="golf pic" style="width:300px;
                 margin-left: 170px; height:220px; margin-top: 150px; border: solid 1px;
                 border-color: #7cc3e1">
            <h3 style="position: absolute; margin-top: 7px; margin-left: 280px;
                font-style: italic">
                <u>Pro golfer</u>
            </h3>

            <img src="Images\\camera.jpg" alt="camera pic" style="width:300px;
                 margin-left: 75px; height:220px; position: absolute; margin-top: 151px;
                 border: solid 1px; border-color: #7cc3e1">
            <h3 style="position: absolute; margin-top: 7px; margin-left: 625px; 
                font-style: italic"><u>Capture the moment</u>
            </h3>
        </div>

        <%--Copyright information--%>
        <footer style="text-align: center; position: absolute; width: 100%; bottom: 0px;
                background-color: #08532b">Copyright © 2005-2017 Antique Auctions Inc.
            All Rights Reserved.
        </footer>
    </body>
</html>
