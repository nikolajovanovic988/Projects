/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-14 08:27:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/view/../common/navigation.jspf", Long.valueOf(1549878375000L));
    _jspx_dependants.put("/WEB-INF/view/../common/header.jspf", Long.valueOf(1549821592000L));
    _jspx_dependants.put("/WEB-INF/view/../common/footer.jspf", Long.valueOf(1549877481000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Todos</title>\n");
      out.write("<link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\t.footer {\n");
      out.write("\t\tposition: absolute;\n");
      out.write("\t\tbottom: 0;\n");
      out.write("\t\twidth: 100%;\n");
      out.write("\t\theight: 60px;\n");
      out.write("\t\tbackground-color: #f5f5f5;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>");
      out.write(' ');
      out.write('\n');
      out.write('\n');
      out.write("<nav class=\"navbar navbar-default\">\n");
      out.write("\n");
      out.write("\t<a href=\"/\" class=\"navbar-brand\">Brand</a>\n");
      out.write("\n");
      out.write("\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t<li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"\">Todos</a></li>\n");
      out.write("\t\t<li><a href=\"\">Phonebook</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\t\t<li><a href=\"/logout.do\">Logout</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("</nav>");
      out.write(" \t\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<p>Dear ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\n");
      out.write("\t\t<p>you have ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${todosNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" number of todos</p>\n");
      out.write("\t\t<p>you have ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${phonebookNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" numbers of phonebook numbers</p>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<footer class=\"footer\" >\n");
      out.write("\t\t<div>Copyright © Nikola Jovanovic</div>\n");
      out.write("\t</footer>\n");
      out.write("\n");
      out.write("\t<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
      out.write(' ');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
