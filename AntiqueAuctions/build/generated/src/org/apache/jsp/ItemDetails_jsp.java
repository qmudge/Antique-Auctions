package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public final class ItemDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            p {\n");
      out.write("                color: black; font-size: 20px   \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table, th, td {\n");
      out.write("                border: 1px solid black; width: 60%; margin-left: auto;\n");
      out.write("                margin-right: auto; text-align: center; background-color: #99ff99;       \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .shadow {text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("                         0px -5px 35px rgba(255,255,255,0.3);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>Item details</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("        <h1 style=\"position: absolute; margin-left: 415px; color: #ff6600 ;\n");
      out.write("            margin-top: 25px; font-size: 50px \">ANTIQUE AUCTIONS</h1>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <div style=\"background-color: #e5f7fb; border: solid 1px; border-radius: 5px;\n");
      out.write("             border-color: #b8e7fb; margin-left: 400px; position: absolute;\n");
      out.write("             margin-top: 100px; width: 40%; height: 700px;\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div style=\"background-color: #d9dede; border: solid 1px;\n");
      out.write("                 border-color: #b8e7fb; border-radius: 5px; width: 100%; height: 60px;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h2 style=\"margin-left: 200px\">Item details</h2> \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <h3 class=\"shadow\" style=\" color: brown; \">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("                ");

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
                
      out.write("                       \n");
      out.write("            </h3>\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("            <FORM NAME=\"bidProduct\" action=\"ItemDetails.jsp\" method =\"post\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h3 style=\"z-index: 999; position: absolute; margin-left: 191px; \n");
      out.write("                    margin-top: 4.3px;\">R\n");
      out.write("                </h3>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"0\" name=\"bid\" required pattern=\"[0-9]{1,7}\" \n");
      out.write("                       title =\"Must contain between 1-7 numbers. No cent values\" \n");
      out.write("                       style=\"width: 110px; margin-left: 185px; position: absolute;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; padding: 7px 25px;\n");
      out.write("                       border: 1px solid #ccc;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"hidden\" name=\"checkDate\" value=\"");
      out.print( resultDate);
      out.write("\">\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"SUBMIT\" VALUE=\"Bid\" style=\"width: 30%; position: absolute; \n");
      out.write("                       margin-left: 185px; margin-top: 50px; background-color: #3399ff; \n");
      out.write("                       color: white; padding: 14px 20px; border: none; border-radius: 4px;\n");
      out.write("                       cursor: pointer;\">\n");
      out.write("\n");
      out.write("            </FORM>\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h4 style=\"margin-left: 50px; margin-top: 100px\">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AntiqueAuctions.jsp\">Home</a>\n");
      out.write("            </h4>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <footer style=\"text-align: center; position: fixed; bottom: 0; width: 100%;\n");
      out.write("                background-color: #08532b\">Copyright © 2005-2017 Antique Auctions Inc.\n");
      out.write("            All Rights Reserved.\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
