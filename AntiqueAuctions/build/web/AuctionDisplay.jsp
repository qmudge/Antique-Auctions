<%--  
    Document   : AuctionDisplay
    Created on : 17 May 2017, 10:24:48 AM
    Author     : Quintin Mudge
    Description: Logged in area and page that displays active auctions.
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="181" >
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">

        <%--Page text and table styling.--%>
        <style>
            table, th, td {
                border: 2px solid black; margin: 10px; width: 50%; margin-left: auto;
                margin-right: auto; text-align: center; background-color: #ccc; 
            }

            .shadow {
                text-shadow: 2px 8px 6px rgba(0,0,0,0.2),
                         0px -5px 35px rgba(255,255,255,0.3);
            }
            
            a:hover {
                color: orange; 
            }
        </style>

        <title>Auction display</title>
    </head>
    <%
        /**
         * Test for session object to check if user value exists.
         */
        if (session.getAttribute("Username") == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You must be signed in to access this page');");
            out.println("location='AntiqueAuctions.jsp';");
            out.println("</script>");
        }
    %>
    <body style="background-color: #e7ecec; margin: 0px;">


        <%--Top menu, Supply's headings and links for navigation.--%>
        <header class="shadow" style="width: 100%; height: 40px; background-color: #d9dede;
                position: absolute; margin-top: -43px;">

            <%--Navigation links--%>
            <h3 style="margin-left: 170px; margin-top: 15px">
                <a href="AntiqueAuctions.jsp">
                    Home</a>&emsp;&emsp;<a href="logoffPage.jsp">Log out</a>&emsp;
                    
                <%
                    /**
                     * Displays the current value for user session.
                     */
                    out.println("<span style='font-size: 15px; color: #0066ff;'>");
                    out.println("Signed in as: " + session.getAttribute("Username"));
                    out.println("</span>");
                %>
            </h3>

            <%--Navigation links right hand side.--%>
            <h3 style="position: absolute; margin-left: 944px; margin-top: -40px;">
                <a href="SellItem.jsp">Sell an item</a>&emsp;&emsp; 
                <a href="ChangeDetails.jsp">My account details</a>
            </h3>
        </header>

        <%--Main heading with picture logo.--%>
        <h1 class="shadow" style="margin-left: 170px; color: #ff6600;
            font-size: 50px">ANTIQUE AUCTIONS</h1>

        <%--Hammer image.--%>   
        <img src="Images\\hammer.jpg" alt="hammer pic" style="width:320px; margin-left: 700px;
             height:80px; position: absolute;  margin-top: -90px;">

        <%--Main content container, Auctioned items.--%>
        <div style="background-image: url(Images\\AntiqueShop.JPG); border: solid 1px;
             border-radius: 6px; border-color: #b8e7fb; margin-left: 170px; width: 75%;
             height: 750px;">

            <%--Heading for auction display--%>
            <h1 class="shadow" style="text-align: center; border: solid 1px; border-radius: 6px;
                border-color: brown; background-color: goldenrod; letter-spacing: 1.5px; 
                margin-top: 0px">Active auctions
            </h1>

            <%-- start web service invocation --%>
            <%
                /**
                 * Web service operation, Gets all products from the database
                 * and displays them in a table. Each product has a form that
                 * sends product info to item details page for viewing.
                 */
                try {
                    org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                    org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                    /**
                     * String arrays holding product id's and names.
                     */
                    java.lang.String result = port.fetchProducts("products"); //product data from database
                    String[] productSeperate = result.split("\\["); //remove bracket
                    String[] prodID = productSeperate[1].replace("]", "").split(","); //product id's
                    String[] prodNames = productSeperate[2].replace("]", "").split(","); //product names

                    //displays table
                    out.println("<h2>");
                    out.println("<table>");
                    out.println("<tr><th>Item ID</th>");
                    out.println("<th>Item name</th>");
                    out.println("<th>More details</th></tr>");

                    //looping through items
                    for (int i = 0; i < prodNames.length; i++) {
                        out.println("<FORM NAME='getProd' action='ItemDetails.jsp' method ='post'>");

                        out.print("<tr><td>" + prodID[i] + "</td><td>" + prodNames[i] + "</td><td>");
                        out.print("<INPUT TYPE='hidden' name='id' value=" + prodID[i] + ">");
                        out.print("<INPUT TYPE='SUBMIT' style='width: 150px;' VALUE='View Item'");
                        out.println("</td></tr>");
                        out.println("</FORM>");

                    }
                    out.println("</table>");
                    out.println("</h2>");

                } catch (Exception ex) {
                    out.println("An error has occured.");
                }
            %>
        </div>


        <%--Copyright information--%>
        <footer style="text-align: center; position: fixed; bottom: 0; width: 100%;
                background-color: #08532b">Copyright © 2005-2017 Antique Auctions Inc. 
            All Rights Reserved.
        </footer>
    </body>
</html>
