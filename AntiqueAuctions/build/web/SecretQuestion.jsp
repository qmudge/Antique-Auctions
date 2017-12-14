<%-- 
    Document   : SecretQuestion
    Created on : 02 Jun 2017, 1:47:25 PM
    Author     : Quintin Mudge
    Description: Asks the user for an answer to secret question, If
                 answered correctly changes their password.
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
        <title>Secret question page</title>
    </head>

    <body class="shadow" style="background-color: #e7ecec">

        <%--Main container and heading.--%>
        <div style="position: absolute; margin-top: 100px; margin-left: 450px;
             border: 2px solid #5e1a00; text-align: center">
            <h1 style="color: brown">Secret question</h1>
            <hr/>
            <%-- start web service invocation --%>
            <%
                String usersname = "";
                try {
                    /**
                     * Webservice operation for displaying secret question and
                     * changing users password.
                     */
                    org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                    org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                    usersname = request.getParameter("username");
                    java.lang.String result = port.secretQuestion(usersname); //sends username as parameter

                    if (result == null) { //username does not match database.
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Username does not exist');");
                        out.println("location='ChangePassword.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<h2>" + result + "</h2>"); //displays question
                    }

                } catch (Exception ex) {
                    out.println("An error has occured.");
                }
            %>
            <hr/>
            
            <%--Form which sends answer and new password.--%>
            <FORM NAME="SecretQuestion" action="PasswordChanged.jsp" method ="post">
            
                <%--Sends users name with form--%>
                <INPUT TYPE="hidden" name="username" 
                       value="<%= usersname%>"> 

                <INPUT TYPE="text" placeholder="Answer" name="answer" required 
                       pattern=".{1,20}" title ="Answer required" style="width: 300px;
                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;
                       border: 1px solid #ccc;">
                </br>
                <%--New password--%>
                <INPUT TYPE="text" placeholder="New password" name="password" required 
                       pattern=".{3,20}" title ="Must contain atleast 3 characters" 
                       style="width: 300px; margin: 10px 0; padding: 12px 20px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">

                <INPUT TYPE="SUBMIT" VALUE="Change" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px; margin: 8px 0; 
                       border: none; border-radius: 4px;cursor: pointer;">

                <%--Link to home page--%>
                <h4>
                    <a href="AntiqueAuctions.jsp">Home</a>
                </h4>
                </br>
            </form>
        </div>       
    </body>
</html>
