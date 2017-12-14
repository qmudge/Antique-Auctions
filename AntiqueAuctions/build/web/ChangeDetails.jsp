<%-- 
    Document   : ChangeDetails
    Created on : 19 May 2017, 7:45:53 AM
    Author     : Quintin Mudge
    Description: Displays current sessions users details and
                 allows for changes to be made.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            .shadow {
                text-shadow: 2px 8px 6px rgba(0,0,0,0.2),
                         0px -5px 35px rgba(255,255,255,0.3);
            }
            
            a:hover {
                color: orange; 
            }
        </style>

        <title>Change details</title>
    </head>

    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <%-- start web service invocation --%>
        <%
            /**
             * Allows the user to view their personal details and make changes.
             */
            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                java.lang.String user = request.getParameter("user"); //form values
                java.lang.String pass = request.getParameter("pass");
                java.lang.String mail = request.getParameter("mail");
                java.lang.String quest = request.getParameter("quest");
                java.lang.String questAnswer = request.getParameter("questAnswer");
                java.lang.String userTel = request.getParameter("telNumber");

                java.lang.String result = port.updateUser(user, pass, mail, quest, questAnswer, userTel);
                if (user == null) { //test username value.

                } else {
                    if (result != null) { //user session exists.
                        session.setAttribute("Username", null); //logs user out.
                        out.println("<script type=\"text/javascript\">"); //success message
                        out.println("alert('Account has been updated. Please sign in');");
                        out.println("location='LoginPage.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('An error occured');"); //failure message
                        out.println("location='RegisterUser.jsp';");
                        out.println("</script>");
                    }
                }
            } catch (Exception ex) {
                out.println("An error has occured.");
            }
        %>

        <%--Main heading, Container for page content.--%>
        <h1 style="position: absolute; margin-left: 415px; color: #ff6600 ;
            margin-top: 50px; font-size: 50px ">ANTIQUE AUCTIONS
        </h1>

        <%--Container for headings and Changing account details--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 125px;
             width: 40%; height: 548px;">

            <%--Form container--%>
            <div style="background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;
                 border-radius: 5px; width: 100%; height: 60px;">

                <%--Sub headings--%>
                <h2 style="margin-left: 70px;">Change your details</h2>                 

            </div>

                <%--Detail description tags.--%>
            <h3 style="position: absolute; margin-left: 45px; margin-top: 45px;">
                Username: </br></br></br> Email: </br></br></br> Telephone: </br></br></br> 
                Password: </br></br></br> Question: </br></br></br> Answer: </h3>

            <%--Form with 6 value fields--%>
            <FORM NAME="updateUser" action="ChangeDetails.jsp" method ="get" 
                  style="position: absolute; margin-left: 140px; margin-top: 28px">

                <%--User details, displays session values.--%>
                <INPUT TYPE="text" name="user" value="<%= session.getAttribute("Username")%>" 
                       readonly style="width: 200px; margin: 15px 0;
                       padding: 8px 20px; border-radius: 3px 3px 3px 3px;
                       border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" name="mail" value="<%= session.getAttribute("Email")%>" 
                       style="width: 200px; margin: 15px 0; padding: 8px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" name="telNumber" value="<%= session.getAttribute("Telephone")%>" 
                       style="width: 200px; margin: 15px 0; padding: 8px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" name= "pass" value="<%= session.getAttribute("Password")%>"
                       style="width: 200px; margin: 15px 0; padding: 8px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" name="quest" value="<%= session.getAttribute("Question")%>" 
                       style="width: 200px; margin: 16px 0; padding: 8px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" name="questAnswer" value="<%= session.getAttribute("Answer")%>" 
                       style="width: 200px; margin: 16px 0; padding: 8px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <%--Register user button--%>
                <INPUT TYPE="SUBMIT" VALUE="Update" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px;
                       margin: 8px 0; border: none; border-radius: 4px;cursor: pointer;">
            </FORM>

            <%--Link to home page--%>
            <h4 style="position: absolute; margin-top: 460px; margin-left: 50px ">
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
