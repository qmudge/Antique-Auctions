<%-- 
    Document   : SellItem
    Created on : 19 May 2017, 7:45:53 AM
    Author     : Quintin Mudge
    Description: Sell an item page.
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
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

        <title>Sell item page</title>
    </head>

    <%--Main heading, Container for page content--%>
    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <%-- start web service invocation --%>
        <%
            /**
             * webservice operation allows user to sell an item.
             */
            if (session.getAttribute("Username") != null) { //check for user logged in.
                try {
                    org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                    org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection
               
                    java.lang.String productName = request.getParameter("name");// item details
                    java.lang.String description = request.getParameter("description");
                    java.lang.String productPrice = request.getParameter("productPrice");
                    java.lang.String seller = request.getParameter("username");

                    if (productName == null) { //when page first loads
                        //DO nothing
                    } else { //item is submitted
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //date format
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date()); // todays date.
                        c.add(Calendar.DATE, 5); // number of days to add.
                        String newDate = sdf.format(c.getTime());// newDate is the new date.

                        //Item values to be stored
                        java.lang.String result = port.product(productName, description, productPrice, seller, newDate);
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Your item has been submitted and will be displayed on the auctions"
                                + " page.');");// success message
                        out.println("location='AuctionDisplay.jsp';");
                        out.println("</script>");
                    }

                } catch (Exception ex) {
                    out.println("An error has occured.");
                }

            } else {  // blocks non signed in user from viewing page.
                out.println("<script type=\"text/javascript\">"); //waring message
                out.println("alert('You must be signed in to access this page');");
                out.println("location='AntiqueAuctions.jsp';");
                out.println("</script>");
            }
        %>

        <%--Main heading--%>
        <h1 style="position: absolute; margin-left: 415px; color: #ff6600 ;
            margin-top: 100px; font-size: 50px ">ANTIQUE AUCTIONS
        </h1>

        <%--Container for headings and details for item content--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 175px;
             width: 40%; height: 440px;">

            <%--Form container--%>
            <div style="background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;
                 border-radius: 5px; width: 100%; height: 60px;">

                <%--Sub heading--%>
                <h2 style="margin-left: 70px;">Sell your item</h2> 

            </div>

            <%--Form with 5 value fields--%>
            <FORM NAME="product" action="SellItem.jsp" method ="post" 
                  style="position: absolute; margin-left: 50px; margin-top: 45px">

                <INPUT TYPE="hidden" name="username" value="<%= session.getAttribute("Username")%>">
                <%--Item details--%>
                <INPUT TYPE="text" placeholder="Item name" name="name" required pattern=".{3,20}" 
                       title ="Must contain between 3-20 characters" 
                       style="width: 300px; margin: 10px 0;padding: 12px 20px;
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">


                <h3 style="color: brown ">Item description :</h3>

                <textarea rows="4" cols="40" name="description" maxlength="100">
                </textarea>

                <%--Rand value symbol--%>
                <h3 style="position: absolute; margin-left:7px; margin-top: 19.2px">R</h3>
                <INPUT TYPE="text" placeholder="0" name="productPrice" 
                       required pattern="[0-9]{1,7}" 
                       title ="Must contain between 1-7 numbers. No cent values"
                       style="width: 300px; margin: 10px 0; padding: 12px 25px; 
                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;">
                </br>

                <%--Submit item information--%>
                <INPUT TYPE="SUBMIT" VALUE="Sell item" style="width: 50%; 
                       background-color: #4CAF50; color: white; padding: 14px 20px;
                       margin: 8px 0; border: none; border-radius: 4px; cursor: pointer;">
            </FORM>

            <%--Link to home page--%>
            <h4 style="position: absolute; margin-top: 355px; margin-left: 50px ">
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
