package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AntiqueAuctions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .shadow {text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("            0px -5px 35px rgba(255,255,255,0.3);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        <title>Home page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <header style=\"width: 100%; height: 40px; background-color: #d9dede;\n");
      out.write("                position: absolute; margin-top: -43px;\">\n");
      out.write("            <h3 style=\"margin-left: 170px; margin-top: 15px\">Welcome!\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/LoginPage.jsp\">\n");
      out.write("                    Sign in</a> or <a href=\"http://localhost:8080/AntiqueAuctions/RegisterUser.jsp\">\n");
      out.write("                    Register</a>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("            </h3>\n");
      out.write("            <h3 style=\"position: absolute; margin-left: 700px; margin-top: -40px;\">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AuctionDisplay.jsp\"\n");
      out.write("                   >Active auctions </a>&emsp;&emsp; \n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/SellItem.jsp\">Sell an item</a>\n");
      out.write("                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("\n");
      out.write("                ");
/**
                     * Display for user being logged in.
                     */
                    out.println("<span style='font-size: 15px; color: #0066ff;'>");
                    if (session.getAttribute("Username") == null) { //tests if user is logged in.
                        out.println("Not signed in");

                    } else {
                        out.println("Signed in as: " + session.getAttribute("Username"));
                    }   //gets and displays session username.
                    out.println("</span>");
                
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                &emsp; <a href=\"http://localhost:8080/AntiqueAuctions/logoffPage.jsp\">Log out</a>\n");
      out.write("            </h3>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <h1 style=\"margin-left: 170px; color: #ff6600; font-size: 50px\">ANTIQUE AUCTIONS</h1>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <img src=\"Images\\\\hammer.jpg\" alt=\"hammer pic\" style=\"width:320px; \n");
      out.write("             margin-left: 700px; height:80px; position: absolute;  margin-top: -90px;\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div style=\"background-color: #e5f7fb; border: solid 1px; border-radius: 6px;\n");
      out.write("             border-color: #b8e7fb; margin-left: 170px; width: 75%; height: 599px;\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h2 style=\"color: brown; margin-left: 5px; margin-top: 40px; letter-spacing: 1px;           \n");
      out.write("                 font-style: italic\">Check out our</br>great range\n");
      out.write("                </br> of available\n");
      out.write("                </br> items!\n");
      out.write("            </h2>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h2 style=\"color: brown; margin-left: 10px; position: absolute; letter-spacing: 1.5px; \n");
      out.write("                margin-top: 320px; font-style: italic\">And so much</br>\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AuctionDisplay.jsp\">\n");
      out.write("                    more..</a> </br>\n");
      out.write("            </h2>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <img src=\"Images\\\\bicycle.jpg\" alt=\"bicycle pic\" style=\"width:300px;\n");
      out.write("                 margin-left: 170px; height:220px; position: absolute;\n");
      out.write("                 margin-top: -125px; border: solid 1px; border-color: #7cc3e1\">\n");
      out.write("            <h3 style=\"position: absolute; margin-top: 110px; margin-left: 270px;\n");
      out.write("                font-style: italic\">\n");
      out.write("                <u>Trendy cycles</u>\n");
      out.write("            </h3>\n");
      out.write("\n");
      out.write("            <img src=\"Images\\\\stereo.jpg\" alt=\"stereo pic\" style=\"width:300px; \n");
      out.write("                 margin-left: 550px; height:220px; position: absolute; margin-top: -125px;\n");
      out.write("                 border: solid 1px; border-color: #7cc3e1\">\n");
      out.write("            <h3 style=\"position: absolute; margin-top: 110px; margin-left: 650px;\n");
      out.write("                font-style: italic\">\n");
      out.write("                <u>Mega sounds</u>\n");
      out.write("            </h3>\n");
      out.write("\n");
      out.write("            <img src=\"Images\\\\golf.jpg\" alt=\"golf pic\" style=\"width:300px;\n");
      out.write("                 margin-left: 170px; height:220px; margin-top: 150px; border: solid 1px;\n");
      out.write("                 border-color: #7cc3e1\">\n");
      out.write("            <h3 style=\"position: absolute; margin-top: 7px; margin-left: 280px;\n");
      out.write("                font-style: italic\">\n");
      out.write("                <u>Pro golfer</u>\n");
      out.write("            </h3>\n");
      out.write("\n");
      out.write("            <img src=\"Images\\\\camera.jpg\" alt=\"camera pic\" style=\"width:300px;\n");
      out.write("                 margin-left: 75px; height:220px; position: absolute; margin-top: 151px;\n");
      out.write("                 border: solid 1px; border-color: #7cc3e1\">\n");
      out.write("            <h3 style=\"position: absolute; margin-top: 7px; margin-left: 625px; \n");
      out.write("                font-style: italic\"><u>Capture the moment</u>\n");
      out.write("            </h3>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <footer style=\"text-align: center; position: absolute; width: 100%; bottom: 0px;\n");
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
