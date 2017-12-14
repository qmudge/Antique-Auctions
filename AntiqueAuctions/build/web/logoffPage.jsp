<%--
    Document   : logoffPage
    Created on : 15 Jun 2017, 9:03:11 AM
    Author     : Quintin Mudge
    Description: Logs user out of current session.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log off page</title>
    </head>
    
    <%-- start web service invocation --%>
    <%
        /**
         * webservice operation allows user to sell an item.
         */
        if (session.getAttribute("Username") != null) { //user session exists.
            session.setAttribute("Username", null);
            out.println("<script type=\"text/javascript\">"); //Logged off message
            out.println("alert('You have been logged off');");
            out.println("location='AntiqueAuctions.jsp';");
            out.println("</script>");

        } else { //can only log off if there is an active user session.
            out.println("<script type=\"text/javascript\">"); //not logged in message.
            out.println("alert('You are not signed in');");
            out.println("location='AntiqueAuctions.jsp';");
            out.println("</script>");
        }
    %>
    <body>       
    </body>
</html>
