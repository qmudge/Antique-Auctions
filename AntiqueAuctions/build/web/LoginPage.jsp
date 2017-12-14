<%-- 
    Document   : LoginPage
    Created on : 18 May 2017, 2:00:56 PM
    Author     : Quintin Mudge
    Description: User login page.
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

        <title>Login Page</title>
    </head>

    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <%-- start web service invocation --%>
        <%
            /**
             * Webservice operation that compares user name and password to
             * values stored in the database.
             */
            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection.

                java.lang.String userNm = request.getParameter("username"); //get form data.
                java.lang.String passWd = request.getParameter("password");

                java.lang.String result = port.login(userNm, passWd);
                String resultObj[] = result.split("_");//seperate string values.
                if (userNm == null) { //test for form value.

                } else {
                    if (result.equals("notMatch")) {  //no match found, shows error message.
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Username or password incorrect');");
                        out.println("location='LoginPage.jsp';");
                        out.println("</script>");
                    } else {
                        session.setMaxInactiveInterval(180); //session timeout.
                        session.setAttribute("Username", userNm); //set session values.
                        session.setAttribute("Password", passWd);
                        session.setAttribute("Email", resultObj[2]);
                        session.setAttribute("Question", resultObj[3]);
                        session.setAttribute("Answer", resultObj[4]);
                        session.setAttribute("Telephone", resultObj[5]);
                        response.sendRedirect("AuctionDisplay.jsp"); //redirect to auction page.
                    }
                }

            } catch (Exception ex) {
                out.println("An error has occured.");
            }

        %>
        
        <%--Main heading, Container for page content--%>
        <h1 style="position: absolute; margin-left: 415px; color: #ff6600;
            margin-top: 100px; font-size: 50px ">ANTIQUE AUCTIONS
        </h1>

        <%--Container for headings and register link--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 175px;
             width: 40%; height: 350px;">

            <%--Form and forgotten password link--%>
            <div style="background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;
                 border-radius: 5px; width: 100%; height: 60px;">

                <h2 style="margin-left: 70px;">Sign in</h2>
                <h2 style="margin-left: 290px; position: absolute; margin-top: -48px;">
                    Not a member?&nbsp;&nbsp;
                    <a style="font-size: 17px" href="RegisterUser.jsp">Register</a>
                </h2>
            </div>

            <%--Form with 3 value fields--%>
            <FORM NAME="login" action="LoginPage.jsp" method ="post" 
                  style="position: absolute; margin-left: 50px; margin-top: 45px">

                <INPUT TYPE="text" placeholder="Username" name="username" pattern=".{3,}" 
                       required title ="Must contain atleast 3 characters" style="width: 300px;
                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;
                       border: 1px solid #ccc;">
                </br>
                <INPUT TYPE="password" placeholder="Password" name="password" pattern=".{3,}" 
                       required title ="password field Cant be empty" style="width: 300px;
                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;
                       border: 1px solid #ccc;">
                </br>
                <INPUT TYPE="SUBMIT" VALUE="Login" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px; margin: 8px 0; 
                       border: none;border-radius: 4px;cursor: pointer;">
            </FORM>

            <%--Link to register page--%>
            <h4 style="position: absolute; margin-top: 250px; margin-left: 50px ">
                Forgot password?&nbsp;&nbsp;
                <a href="ChangePassword.jsp">Change</a>&nbsp;&nbsp;
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