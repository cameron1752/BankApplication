package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      com.javaBeans.LoginManager LoginManager = null;
      synchronized (session) {
        LoginManager = (com.javaBeans.LoginManager) _jspx_page_context.getAttribute("LoginManager", PageContext.SESSION_SCOPE);
        if (LoginManager == null){
          LoginManager = new com.javaBeans.LoginManager();
          _jspx_page_context.setAttribute("LoginManager", LoginManager, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Your Bank</title>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap-4.4.1.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> \n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery-3.4.1.min.js\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("LoginManager"), "email", request.getParameter("email"), request, "email", false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("LoginManager"), "password", request.getParameter("password"), request, "password", false);
      out.write("\n");
      out.write("\t<!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/popper.min.js\"></script> \n");
      out.write("\t<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\"> <a class=\"navbar-brand\" href=\"#\">Your Bank</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent1\" aria-controls=\"navbarSupportedContent1\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"> <span class=\"navbar-toggler-icon\"></span> </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent1\">\n");
      out.write("              <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                <li class=\"nav-item active\"> <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a> </li>\n");
      out.write("                <li class=\"nav-item\"> <a class=\"nav-link\" href=\"#\">Contact Us</a> </li>\n");
      out.write("                <li class=\"nav-item dropdown\"> <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown1\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Services </a>\n");
      out.write("                  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown1\"> <a class=\"dropdown-item\" href=\"#\">New Account</a> <a class=\"dropdown-item\" href=\"#\">Edit Account</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">Delete Account</a> </div>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("              </ul>\n");
      out.write("                  <form class=\"form-inline my-2 my-lg-0\" action=\"login.jsp\">\n");
      out.write("                      <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Login</button>\n");
      out.write("                  </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <div class=\"card col-md-4 offset-xl-4\">\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("            <form action=\"landing.jsp\">\n");
      out.write("                <h5 class=\"card-title\">Login ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.javaBeans.LoginManager)_jspx_page_context.findAttribute("LoginManager")).getMessage())));
      out.write("</h5>\n");
      out.write("                <input type=\"text\" name=\"email\"><br>\n");
      out.write("                <input type=\"password\" name=\"password\"><br>\n");
      out.write("                <input type=\"submit\" value=\"login\"> <br>\n");
      out.write("                <a href=\"newAccount.jsp\">Create Account</a>  <a href=\"#\"> Forgot Password </a>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
