<%-- 
    Document   : ItemDetails
    Created on : 19 May 2017, 7:45:53 AM
    Author     : Quintin Mudge
    Description: Details about selected auctioned item.
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%--Page text styling.--%>
        <style>
            p {
                color: black; font-size: 20px;             
            }

            table, th, td {
                border: 1px solid black; width: 60%; margin-left: auto;
                margin-right: auto; text-align: center; background-color: #99ff99;       
            }

            .shadow {
                text-shadow: 2px 8px 6px rgba(0,0,0,0.2),
                         0px -5px 35px rgba(255,255,255,0.3);
            }
            
            a:hover {
                color: orange; 
            }           
        </style>
        <title>Item details Page</title>
    </head>

    <%--Main heading, Container for page content--%>
    <body class="shadow" style="background-color: #e7ecec; margin: 0px;">

        <h1 style="position: absolute; margin-left: 415px; color: #ff6600 ;
            margin-top: 25px; font-size: 50px ">ANTIQUE AUCTIONS</h1>

        <%--Container for headings and details for item content--%>    
        <div style="background-color: #e5f7fb; border: solid 1px; border-radius: 5px;
             border-color: #b8e7fb; margin-left: 400px; position: absolute;
             margin-top: 100px; width: 40%; height: 700px;">

            <%--Form container--%>
            <div style="background-color: #d9dede; border: solid 1px;
                 border-color: #b8e7fb; border-radius: 5px; width: 100%; height: 60px;">

                <%--Sub heading--%>
                <h2 style="margin-left: 200px">Item details</h2> 

            </div>

            <h3 style=" color: brown; ">
                <%-- start web service invocation --%>

                <%
                    String resultDate = "";
                    /**
                     * Webservice operation displays item details and checks if item
                     * closing date is before/after current date.
                     */
                    try {
                        org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                        org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                        java.lang.String itemID = request.getParameter("id"); 

                        if (itemID != null) { //test if an id value exists
                            String[] productResult = port.productDetails(itemID).split("_");//item values
                            session.setAttribute("id", productResult[0]);
                            session.setAttribute("price", productResult[3]);

                            //get current date
                            String dateNow = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                            
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");         
                            //convert two date strings into Date types
                            Date closingDate = sdf.parse(productResult[5]);
                            Date dateCurrent = sdf.parse(dateNow);

                            if (closingDate.compareTo(dateCurrent) >= 0) { //closing date is after current date
                                resultDate = productResult[5];

                            } else if (closingDate.compareTo(dateCurrent) < 0) { //closing date is after current date
                                resultDate = "CLOSED";
                            }

                            out.println("<table>"); //Table containing all item details.

                            out.println("<tr><td>ITEM ID: </td>" + "<td><p>" + productResult[0] + "</p></td></tr>");
                            out.println("<tr><td>ITEM NAME: </td>" + "<td><p>" + productResult[1] + "</p></td></tr>");
                            out.println("<tr><td>ITEM DESCRIPTION: </td>" + "<td><p>" + productResult[2] + "</p></td></tr>");
                            out.println("<tr><td>HIGHEST BID: </td>" + "<td><p>R" + productResult[3] + "</p></td></tr>");
                            out.println("<tr><td>SELLERS NAME: </td>" + "<td><p>" + productResult[4] + "</p></td></tr>");
                            out.println("<tr><td>CLOSING DATE: </td>" + "<td><p>" + resultDate + "</p></td></tr>");

                            out.println("</table>");

                        } else { // bid has been made, id is null            
                            int bidAmount = Integer.parseInt(request.getParameter("bid")); //current bid amount
                            int price = Integer.parseInt(session.getAttribute("price").toString()); //highest bid so far

                            java.lang.String finalDate = request.getParameter("checkDate");//date value as string

                            //Bid is atleast 5% more than previous amount and auction is not closed. 
                            if (bidAmount > price + price * 0.05 && !"CLOSED".equals(finalDate)) { 
                                
                                String prdID = session.getAttribute("id").toString();
                                String userInfo = session.getAttribute("Username").toString();

                                //send bid detail values.
                                java.lang.String result = port.bidMade(userInfo, prdID, request.getParameter("bid"));

                                out.println("<script type=\"text/javascript\">"); //success message
                                out.println("alert('Your bid has been placed');");
                                out.println("location='AuctionDisplay.jsp';");
                                out.println("</script>");

                            } else if (finalDate.equals("CLOSED")) { //Date has expired, can not bid anymore
                                out.println("<script type=\"text/javascript\">"); //error message.
                                out.println("alert('This auction has expired, Please make another selection');");
                                out.println("location='AuctionDisplay.jsp';");
                                out.println("</script>");
                            } else { //Bid amount is less than 5% higher than previous amount.
                                out.println("<script type=\"text/javascript\">"); //warning message
                                out.println("alert('Your bid amount is too low, Please enter a higher value.');");
                                out.println("location='AuctionDisplay.jsp';");
                                out.println("</script>");
                            }
                        }
                    } catch (Exception ex) {
                        out.println("An error has occured.");
                    }
                %>                       
            </h3>
            
            <%--Form for placing bids--%>
            <FORM NAME="bidProduct" action="ItemDetails.jsp" method ="post">

                <%--Rand value symbol--%>
                <h3 style="z-index: 999; position: absolute; margin-left: 191px; 
                    margin-top: 4.3px;">R
                </h3>

                <INPUT TYPE="text" placeholder="0" name="bid" required pattern="[0-9]{1,7}" 
                       title ="Must contain between 1-7 numbers. No cent values" 
                       style="width: 110px; margin-left: 185px; position: absolute;
                       border-radius: 3px 3px 3px 3px; padding: 7px 25px;
                       border: 1px solid #ccc;">

                <%--Stored date value--%>
                <INPUT TYPE="hidden" name="checkDate" value="<%= resultDate%>">

                <INPUT TYPE="SUBMIT" VALUE="Bid" style="width: 30%; position: absolute; 
                       margin-left: 185px; margin-top: 50px; background-color: #3399ff; 
                       color: white; padding: 14px 20px; border: none; border-radius: 4px;
                       cursor: pointer;">

            </FORM>
            <%--Link to home page--%>
            <h4 style="margin-left: 50px; margin-top: 100px">
                <a href="AntiqueAuctions.jsp">Home</a>
            </h4>
        </div>

        <%--Copyright information--%>    
        <footer style="text-align: center; position: fixed; bottom: 0; width: 100%;
                background-color: #08532b">Copyright © 2005-2017 Antique Auctions Inc.
            All Rights Reserved.
        </footer>
    </body>
</html>
