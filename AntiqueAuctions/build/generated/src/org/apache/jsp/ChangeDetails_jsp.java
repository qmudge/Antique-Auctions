package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangeDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .shadow {text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("                         0px -5px 35px rgba(255,255,255,0.3);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <title>Change details</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            /**
             * Allows the user to view their personal details and make changes.
             */
            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                java.lang.String user = request.getParameter("user"); //form values
                java.lang.String pass = request.getParameter("pass");
                java.lang.String mail = request.getParameter("mail");
                java.lang.String quest = request.getParameter("quest");
                java.lang.String questAnswer = request.getParameter("questAnswer");
                java.lang.String userTel = request.getParameter("telNumber");

                java.lang.String result = port.updateUser(user, pass, mail, quest, questAnswer, userTel);
                if (user == null) { //test username value.

                } else {
                    if (result != null) { //user session exists.
                        session.setAttribute("Username", null); //logs user out.
                        out.println("<script type=\"text/javascript\">"); //success message
                        out.println("alert('Account has been updated. Please sign in');");
                        out.println("location='LoginPage.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('An error occured');"); //failure message
                        out.println("location='RegisterUser.jsp';");
                        out.println("</script>");
                    }
                }
            } catch (Exception ex) {
                out.println("An error has occured.");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <h1 style=\"position: absolute; margin-left: 415px; color: #ff6600 ;\n");
      out.write("            margin-top: 50px; font-size: 50px \">ANTIQUE AUCTIONS\n");
      out.write("        </h1>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <div style=\"background-color: #e5f7fb; border: solid 1px; border-radius: 5px;\n");
      out.write("             border-color: #b8e7fb; margin-left: 400px; position: absolute; margin-top: 125px;\n");
      out.write("             width: 40%; height: 548px;\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div style=\"background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;\n");
      out.write("                 border-radius: 5px; width: 100%; height: 60px;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h2 style=\"margin-left: 70px;\">Change your details</h2>                 \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("            <h3 style=\"position: absolute; margin-left: 45px; margin-top: 45px;\">\n");
      out.write("                Username: </br></br></br> Email: </br></br></br> Telephone: </br></br></br> \n");
      out.write("                Password: </br></br></br> Question: </br></br></br> Answer: </h3>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <FORM NAME=\"updateUser\" action=\"ChangeDetails.jsp\" method =\"get\" \n");
      out.write("                  style=\"position: absolute; margin-left: 140px; margin-top: 28px\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name=\"user\" value=\"");
      out.print( session.getAttribute("Username"));
      out.write("\" \n");
      out.write("                       readonly style=\"width: 200px; margin: 15px 0;\n");
      out.write("                       padding: 8px 20px; border-radius: 3px 3px 3px 3px;\n");
      out.write("                       border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name=\"mail\" value=\"");
      out.print( session.getAttribute("Email"));
      out.write("\" \n");
      out.write("                       style=\"width: 200px; margin: 15px 0; padding: 8px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name=\"telNumber\" value=\"");
      out.print( session.getAttribute("Telephone"));
      out.write("\" \n");
      out.write("                       style=\"width: 200px; margin: 15px 0; padding: 8px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name= \"pass\" value=\"");
      out.print( session.getAttribute("Password"));
      out.write("\"\n");
      out.write("                       style=\"width: 200px; margin: 15px 0; padding: 8px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name=\"quest\" value=\"");
      out.print( session.getAttribute("Question"));
      out.write("\" \n");
      out.write("                       style=\"width: 200px; margin: 16px 0; padding: 8px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" name=\"questAnswer\" value=\"");
      out.print( session.getAttribute("Answer"));
      out.write("\" \n");
      out.write("                       style=\"width: 200px; margin: 16px 0; padding: 8px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"SUBMIT\" VALUE=\"Update\" style=\"width: 50%; \n");
      out.write("                       background-color: #4CAF50; color: white; padding: 14px 20px;\n");
      out.write("                       margin: 8px 0; border: none; border-radius: 4px;cursor: pointer;\">\n");
      out.write("            </FORM>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h4 style=\"position: absolute; margin-top: 460px; margin-left: 50px \">\n");
      out.write("                <a href=\"http://localhost:8080/AntiqueAuctions/AntiqueAuctions.jsp\">Home</a>\n");
      out.write("            </h4>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
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
