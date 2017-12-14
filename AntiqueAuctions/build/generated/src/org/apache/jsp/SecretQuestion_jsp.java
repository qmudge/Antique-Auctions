package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SecretQuestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            \n");
      out.write("            a:hover {\n");
      out.write("                color: orange; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <title>Secret question page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"shadow\" style=\"background-color: #e7ecec\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div style=\"position: absolute; margin-top: 100px; margin-left: 450px;\n");
      out.write("             border: 2px solid #5e1a00; text-align: center\">\n");
      out.write("            <h1 style=\"color: brown\">Secret question</h1>\n");
      out.write("            <hr/>\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");

                String usersname = "";
                try {
                    /**
                     * Webservice operation for displaying secret question and
                     * changing users password.
                     */
                    org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                    org.me.auction.AuctionWS port = service.getAuctionWSPort(); //webservice connection

                    usersname = request.getParameter("username");
                    java.lang.String result = port.secretQuestion(usersname); //sends username as parameter

                    if (result == null) { //username does not match database.
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Username does not exist');");
                        out.println("location='ChangePassword.jsp';");
                        out.println("</script>");
                    } else {
                        out.println("<h2>" + result + "</h2>"); //displays question
                    }

                } catch (Exception ex) {
                    out.println("An error has occured.");
                }
            
      out.write("\n");
      out.write("            <hr/>\n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("            <FORM NAME=\"SecretQuestion\" action=\"PasswordChanged.jsp\" method =\"post\">\n");
      out.write("            \n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"hidden\" name=\"username\" \n");
      out.write("                       value=\"");
      out.print( usersname);
      out.write("\"> \n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"Answer\" name=\"answer\" required \n");
      out.write("                       pattern=\".{1,20}\" title =\"Answer required\" style=\"width: 300px;\n");
      out.write("                       margin: 10px 0; padding: 12px 20px; border-radius: 3px 3px 3px 3px;\n");
      out.write("                       border: 1px solid #ccc;\">\n");
      out.write("                </br>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <INPUT TYPE=\"text\" placeholder=\"New password\" name=\"password\" required \n");
      out.write("                       pattern=\".{3,20}\" title =\"Must contain atleast 3 characters\" \n");
      out.write("                       style=\"width: 300px; margin: 10px 0; padding: 12px 20px; \n");
      out.write("                       border-radius: 3px 3px 3px 3px; border: 1px solid #ccc;\">\n");
      out.write("\n");
      out.write("                <INPUT TYPE=\"SUBMIT\" VALUE=\"Change\" style=\"width: 50%; \n");
      out.write("                       background-color: #4CAF50; color: white; padding: 14px 20px; margin: 8px 0; \n");
      out.write("                       border: none; border-radius: 4px;cursor: pointer;\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <h4>\n");
      out.write("                    <a href=\"AntiqueAuctions.jsp\">Home</a>\n");
      out.write("                </h4>\n");
      out.write("                </br>\n");
      out.write("            </form>\n");
      out.write("        </div>       \n");
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
