package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;

public final class AuctionDisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"refresh\" content=\"181\" >\n");
      out.write("        <meta http-equiv=\"Content-Type\"  content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            table, th, td {\n");
      out.write("                border: 2px solid black; margin: 10px; width: 50%; margin-left: auto;\n");
      out.write("                margin-right: auto; text-align: center; background-color: #ccc; \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .shadow {text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("            0px -5px 35px rgba(255,255,255,0.3);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <title>Auction display</title>\n");
      out.write("    </head>\n");
      out.write("    ");

                if (session.getAttribute("Username") == null) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('You must be signed in to access this page');");
                    out.println("location='AntiqueAuctions.jsp';");
                    out.println("</script>");
                }
                    
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <header style=\"width: 100%; height: 40px; background-color: #d9dede;\n");
      out.write("                position: absolute; margin-top: -43px;\">\n");
      out.write("            <h3 style=\"margin-left: 170px; margin-top: 15px\">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AntiqueAuctions.jsp\">\n");
      out.write("                    Home</a>&emsp;&emsp;<a href=\"http://localhost:8080/AntiqueAuctions/logoffPage.jsp\"\n");
      out.write("                                       >Log out</a>&emsp;\n");
      out.write("                ");

                    out.println("<span style='font-size: 15px; color: #0066ff;'>");
                    out.println("Signed in as: " + session.getAttribute("Username"));
                    out.println("</span>");
                
      out.write("\n");
      out.write("                \n");
      out.write("            </h3>\n");
      out.write("            <h3 style=\"position: absolute; margin-left: 944px; margin-top: -40px;\">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/SellItem.jsp\"\n");
      out.write("                   >Sell an item</a>&emsp;&emsp; \n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/ChangeDetails.jsp\"\n");
      out.write("                   >My account details</a></h3>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <h1 style=\"margin-left: 170px; text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("            0px -5px 35px rgba(255,255,255,0.3); color: #ff6600 ; font-size: 50px\">ANTIQUE AUCTIONS</h1>\n");
      out.write("        <img src=\"Images\\\\hammer.jpg\" alt=\"hammer pic\" style=\"width:320px; margin-left: 700px;\n");
      out.write("             height:80px; position: absolute;  margin-top: -90px;\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div style=\"background-image: url(Images\\\\AntiqueShop.JPG); border: solid 1px; border-radius: 6px; border-color: #b8e7fb;\n");
      out.write("             margin-left: 170px; width: 75%; height: 650px;\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1 style=\"text-align: center; border: solid 1px; border-radius: 6px; border-color: brown;\n");
      out.write("                background-color: goldenrod; letter-spacing: 1.5px; text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("            0px -5px 35px rgba(255,255,255,0.3); margin-top: 0px\">Active auctions</h1>\n");
      out.write("\n");
      out.write("            ");
 
                    try {
                        org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                        org.me.auction.AuctionWS port = service.getAuctionWSPort();

                        java.lang.String result = port.fetchProducts("products");
                        String[] productSeperate = result.split("\\[");
                        String[] prodID = productSeperate[1].replace("]", "").split(",");
                        String[] prodNames = productSeperate[2].replace("]", "").split(",");

                        out.println("<h2>");
                        out.println("<table>");
                        out.println("<tr><th>Item ID</th>");
                        out.println("<th>Item name</th>");
                        out.println("<th>More details</th></tr>");

                        for (int i = 0; i < prodNames.length; i++) {
                            out.println("<FORM NAME='getProd' action='ItemDetails.jsp' method ='post'>");

                            out.print("<tr><td>" + prodID[i] + "</td><td>" + prodNames[i] + "</td><td>");
                            out.print("<INPUT TYPE='hidden' name='id' value=" + prodID[i] + ">");
                            out.print("<INPUT TYPE='SUBMIT' style='width: 150px;' VALUE='View Item'");
                            out.println("</td></tr>");
                            out.println("</FORM>");
                            //session.setAttribute(prodID[i], prodNames[i]);
                        }

                        out.println("</table>");
                        out.println("</h2>");

                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }            
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <footer style=\"text-align: center; position: fixed; bottom: 0; width: 100%;\n");
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
