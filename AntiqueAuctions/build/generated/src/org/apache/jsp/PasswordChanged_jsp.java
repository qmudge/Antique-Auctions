package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PasswordChanged_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Password Change</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #e7ecec;\">\n");
      out.write("        <h1>Password change result</h1>    ");
      out.write("<hr/>\n");
      out.write("        ");

            try {
                org.me.auction.CalculatorWS service = new org.me.auction.CalculatorWS();
                org.me.auction.AuctionWS port = service.getAuctionWSPort();
                // TODO initialize WS operation arguments here
                java.lang.String usename = request.getParameter("username");
                java.lang.String answer = request.getParameter("answer");
                java.lang.String newPassword = request.getParameter("password");

                java.lang.String result = port.passwordChange(usename, answer, newPassword);

                if (result.equals("notSame")) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Wrong answer to secret question');");
                    out.println("location='ChangePassword.jsp';");
                    out.println("</script>");

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Your password has been changed');");
                    out.println("location='LoginPage.jsp';");
                    out.println("</script>");
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        
      out.write("\n");
      out.write("        <a href=\"http://localhost:8080/AntiqueAuctions/LoginPage.jsp\">\n");
      out.write("            Sign in</a>&nbsp;&nbsp;\n");
      out.write("        <a href=\"http://localhost:8080/AntiqueAuctions/AntiqueAuctions.jsp\">Home</a>\n");
      out.write("        ");
      out.write("<hr/>\n");
      out.write("\n");
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
