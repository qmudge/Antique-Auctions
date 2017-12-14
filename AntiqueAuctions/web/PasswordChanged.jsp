<%-- 
    Document   : passwordChanged
    Created on : 02 Jun 2017, 8:53:40 PM
    Author     : Quintin Mudge
    Description: Secret question handler page.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Change page</title>
    </head>
    <body style="background-color: #e7ecec;">
        <h1>Password change result</h1>   
        <hr/>
        <%-- start web service invocation --%>
        <%
            try {
                /**
                 * Webservice operation that uses form values to check
                 * if answer to secret question is correct and displays a message.
                 */
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection.
                
                java.lang.String usename = request.getParameter("username"); //form values
                java.lang.String answer = request.getParameter("answer");
                java.lang.String newPassword = request.getParameter("password");

                java.lang.String result = port.passwordChange(usename, answer, newPassword); //values sent
                

                if (result.equals("notSame")) { //answer does not match.
                    out.println("<script type=\"text/javascript\">"); //failure message
                    out.println("alert('Wrong answer to secret question');");
                    out.println("location='ChangePassword.jsp';");
                    out.println("</script>");

                } else { //answer matches
                    out.println("<script type=\"text/javascript\">"); //success message
                    out.println("alert('Your password has been changed');");
                    out.println("location='LoginPage.jsp';"); //directed to login page
                    out.println("</script>");
                }
            } catch (Exception ex) {
                out.println("An error has occured.");
            }
        %>          
        <%-- end web service invocation --%><hr/>

    </body>
</html>
