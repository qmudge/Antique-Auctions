package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegisterUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .shadow {\n");
      out.write("                text-shadow: 2px 8px 6px rgba(0,0,0,0.2),\n");
      out.write("                         0px -5px 35px rgba(255,255,255,0.3);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <title>Register user</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec; margin: 0px;\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            /**
             * Webservice operation which takes a new users details and stores
             * them inside the database.
             */
            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection.

                java.lang.String username = request.getParameter("username"); //get form data.
                java.lang.String email = request.getParameter("email");
                java.lang.String password = request.getParameter("password");
                java.lang.String question = request.getParameter("question");
                java.lang.String answer = request.getParameter("answer");
                java.lang.String telephone = request.getParameter("telephone");

                java.lang.String result = port.insertUser(username, email, password, question, answer, telephone);
                if (username == null) {  //test for form value.

                } else {
                    if (result.equals("inserted")) { //user details inserted into data base.
                        out.println("<script type=\"text/javascript\">"); //success message.
                        out.println("alert('Account has been created. Please sign in');");
                        out.println("location='LoginPage.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<script type=\"text/javascript\">"); //user already exists.
                        out.println("alert('UserName not available');"); //failure message.
                        out.println("location='RegisterUser.jsp';");
                        out.println("</script>");
                    }
                }

            } catch (Exception ex) {
                out.println("An error has occured.");
            }

        
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
      out.write("             width: 40%; height: 568px;\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div style=\"background-color: #d9dede; border: solid 1px; border-color: #b8e7fb;\n");
      out.write("                 border-radius: 5px; width: 100%; height: 60px;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h2 style=\"margin-left: 70px;\">Register</h2> \n");
      out.write("                <h2 style=\"margin-left: 290px; position: absolute; margin-top: -63px \">\n");
      out.write("                    Already a member?&nbsp;&nbsp;\n");
      out.write("                    <a href=\"LoginPage.jsp\">Sign in</a>\n");
      out.write("                </h2>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <FORM NAME=\"RegisterUser\" action=\"RegisterUser.jsp\" method =\"post\"  \n");
      out.write("                  style=\"position: absolute; margin-left: 50px; margin-top: 45px\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"Username\" name=\"username\" required \n");
      out.write("                       pattern=\".{3,20}\" title =\"Must contain between 3-20 characters\"\n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"email\" placeholder=\"Email\" name=\"email\" required \n");
      out.write("                       pattern=\".{3,20}\" title =\"Must contain between 3-20 characters and an @\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"tel\" placeholder=\"Tel-number\" name=\"telephone\" required \n");
      out.write("                       pattern=\"[0-9]{10,10}\" title =\"Requires 10 digits\" style=\"width: 300px; \n");
      out.write("                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;\n");
      out.write("                       border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"password\" placeholder=\"Password\" name=\"password\" required \n");
      out.write("                       pattern=\".{3,20}\" title =\"Must contain between 3-20 characters\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"Seceret question\" name=\"question\" required \n");
      out.write("                       pattern=\".{3,50}\" title =\"Must contain 3-50 characters\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"Answer\" name=\"answer\" required \n");
      out.write("                       pattern=\".{3,20}\" title =\"Must contain between 3-20 characters\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px;\n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"SUBMIT\" VALUE=\"Register\" name=\"submit\" style=\"width: 50%; \n");
      out.write("                       background-color: #4CAF50; color: white; padding: 14px 20px;\n");
      out.write("                       margin: 8px 0; border: none; border-radius: 4px;cursor: pointer;\">\n");
      out.write("            </FORM>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <h4 style=\"position: absolute; margin-top: 477px; margin-left: 50px \">\n");
      out.write("                <a href=\"AntiqueAuctions.jsp\">Home</a>\n");
      out.write("            </h4>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("    \n");
      out.write("        <footer style=\"text-align: center; position: absolute; width: 100%; bottom: 0px;\n");
      out.write("                background-color: #08532b\">Copyright © 2005-2017 Antique Auctions Inc. \n");
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
