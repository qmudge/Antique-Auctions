package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public final class SellItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sell item</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <body style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("        ");

            if (session.getAttribute("Username") != null) {
                try {
                    org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                    org.me.auction.AuctionWS port = service.getAuctionWSPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String productName = request.getParameter("name");
                    java.lang.String description = request.getParameter("description");
                    java.lang.String productPrice = request.getParameter("productPrice");
                    java.lang.String seller = request.getParameter("username");

                    if (productName == null) {
                        //DO nothing
                    } else {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date()); // todays date.
                        c.add(Calendar.DATE, 5); // number of days to add
                        String newDate = sdf.format(c.getTime());// newDate is the new date
                        

                        java.lang.String result = port.product(productName, description, productPrice, seller, newDate);
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Your item has been submitted and will be displayed on the auctions"
                                + " page.');");
                        out.println("location='AuctionDisplay.jsp';");
                        out.println("</script>");
                    }

                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You must be signed in to access this page');");
                out.println("location='AntiqueAuctions.jsp';");
                out.println("</script>");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <h1 style=\"position: absolute; margin-left: 415px; color: #ff6600 ;\n");
      out.write("            margin-top: 100px; font-size: 50px \">ANTIQUE AUCTIONS</h1>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <div style=\"background-color: #e5f7fb; border: solid 1px; border-radius: 5px;\n");
      out.write("             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 175px;\n");
      out.write("             width: 40%; height: 440px;\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div style=\"background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;\n");
      out.write("                 border-radius: 5px; width: 100%; height: 60px;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h2 style=\"margin-left: 70px;\">Sell your item</h2> \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <FORM NAME=\"product\" action=\"SellItem.jsp\" method =\"post\" \n");
      out.write("                  style=\"position: absolute; margin-left: 50px; margin-top: 45px\">\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"hidden\" name=\"username\" value=\"");
      out.print( session.getAttribute("Username"));
      out.write("\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"Item name\" name=\"name\" required pattern=\".{3,20}\" \n");
      out.write("                       title =\"Must contain between 3-20 characters\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0;padding: 12px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <h3 style=\"color: brown \">Item description :</h3>\n");
      out.write("\n");
      out.write("                <textarea rows=\"4\" cols=\"40\" name=\"description\" maxlength=\"100\">\n");
      out.write("                </textarea>\n");
      out.write("\n");
      out.write("                <h3 style=\"position: absolute; margin-left:7px; margin-top: 19.2px\">R</h3>\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"0\" name=\"productPrice\" required pattern=\"[0-9]{1,7}\" \n");
      out.write("                       title =\"Must contain between 1-7 numbers. No cent values\"\n");
      out.write("                       style=\"width: 300px; margin: 10px 0;\n");
      out.write("                       padding: 12px 25px; border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"SUBMIT\" VALUE=\"Sell item\" style=\"width: 50%; \n");
      out.write("                       background-color: #4CAF50; color: white; padding: 14px 20px; margin: 8px 0; \n");
      out.write("                       border: none; border-radius: 4px; cursor: pointer;\">\n");
      out.write("            </FORM>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h4 style=\"position: absolute; margin-top: 355px; margin-left: 50px \">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AntiqueAuctions.jsp\">Home</a>\n");
      out.write("            </h4>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <footer style=\"text-align: center; position: absolute; width: 100%; bottom: 0px;\n");
      out.write("                background-color: #08532b\">Copyright © 2005-2017 Antique Auctions Inc. All Rights Reserved.\n");
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
