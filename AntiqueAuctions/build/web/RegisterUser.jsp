<%-- 
    Document   : RegisterUser
    Created on : 19 May 2017, 7:45:53 AM
    Author     : Quintin Mudge
    Description: Register new user page.
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

        <title>Register user</title>
    </head>

    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <%-- start web service invocation --%>
        <%
            /**
             * Webservice operation which takes a new users details and stores
             * them inside the database.
             */
            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection.

                java.lang.String username = request.getParameter("username"); //get form data.
                java.lang.String email = request.getParameter("email");
                java.lang.String password = request.getParameter("password");
                java.lang.String question = request.getParameter("question");
                java.lang.String answer = request.getParameter("answer");
                java.lang.String telephone = request.getParameter("telephone");

                java.lang.String result = port.insertUser(username, email, password, question, answer, telephone);
                if (username == null) {  //test for form value.

                } else {
                    if (result.equals("inserted")) { //user details inserted into data base.
                        out.println("<script type=\"text/javascript\">"); //success message.
                        out.println("alert('Account has been created. Please sign in');");
                        out.println("location='LoginPage.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<script type=\"text/javascript\">"); //user already exists.
                        out.println("alert('UserName not available');"); //failure message.
                        out.println("location='RegisterUser.jsp';");
                        out.println("</script>");
                    }
                }

            } catch (Exception ex) {
                out.println("An error has occured.");
            }

        %>
        <%--Main heading for page--%>
        <h1 style="position: absolute; margin-left: 415px; color: #ff6600 ;
            margin-top: 50px; font-size: 50px ">ANTIQUE AUCTIONS
        </h1>

        <%--Container for headings and registering a new account content--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 125px;
             width: 40%; height: 568px;">

            <%--Form container--%>
            <div style="background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;
                 border-radius: 5px; width: 100%; height: 60px;">

                <%--Sub headings--%>
                <h2 style="margin-left: 70px;">Register</h2> 
                <h2 style="margin-left: 290px; position: absolute; margin-top: -63px ">
                    Already a member?&nbsp;&nbsp;
                    <a href="LoginPage.jsp">Sign in</a>
                </h2>

            </div>

            <%--Form with 6 value fields--%>
            <FORM NAME="RegisterUser" action="RegisterUser.jsp" method ="post"  
                  style="position: absolute; margin-left: 50px; margin-top: 45px">

                <%--User details--%>
                <INPUT TYPE="text" placeholder="Username" name="username" required 
                       pattern=".{3,20}" title ="Must contain between 3-20 characters"
                       style="width: 300px; margin: 10px 0; padding: 12px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="email" placeholder="Email" name="email" required 
                       pattern=".{3,20}" title ="Must contain between 3-20 characters and an @" 
                       style="width: 300px; margin: 10px 0; padding: 12px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="tel" placeholder="Tel-number" name="telephone" required 
                       pattern="[0-9]{10,10}" title ="Requires 10 digits" style="width: 300px; 
                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;
                       border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="password" placeholder="Password" name="password" required 
                       pattern=".{3,20}" title ="Must contain between 3-20 characters" 
                       style="width: 300px; margin: 10px 0; padding: 12px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" placeholder="Seceret question" name="question" required 
                       pattern=".{3,50}" title ="Must contain 3-50 characters" 
                       style="width: 300px; margin: 10px 0; padding: 12px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <INPUT TYPE="text" placeholder="Answer" name="answer" required 
                       pattern=".{3,20}" title ="Must contain between 3-20 characters" 
                       style="width: 300px; margin: 10px 0; padding: 12px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <%--Register user button--%>
                <INPUT TYPE="SUBMIT" VALUE="Register" name="submit" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px;
                       margin: 8px 0; border: none; border-radius: 4px;cursor: pointer;">
            </FORM>

            <%--Link to home page--%>
            <h4 style="position: absolute; margin-top: 477px; margin-left: 50px ">
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
