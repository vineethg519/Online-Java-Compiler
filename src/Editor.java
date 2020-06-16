import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Editor extends HttpServlet 
  {
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
     {
    	    PrintWriter obj=response.getWriter();
    	    response.setContentType("text/html");
    	    obj.println("<html>");
	    obj.println("<title>Online Java Compiler</title>");
	    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
	    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
	    obj.println("<div style=\"position:absolute;top:100px;left:50px;\">");
	    obj.println("<form action=\"ojc\" method=\"post\">");
	    obj.println("<table border=1 width=500>");
	    obj.println("<tr><td><p style=\"font-family:calibri;font-weight:bold;font-size:22px;text-align:center;\">Welcome to Editor</p></td></tr>");
	    obj.println("<tr  height=400><td>");
	    obj.println("<table>");
	    obj.println("<tr><td><textarea rows=20 cols=90 name=\"program\" style='font-family:calibri;font-weight:bold;font-size:18px;'>Type your Java Program here...</textarea></td></tr>");
	    obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter Your Directory Name*:-<input type=\"textfield\" name=\"dirname\"  style='font-family:calibri;font-size:14px;font-weight:bold;' width=50/></td></tr>");
	    obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter File Name Including Extension*:-<input type=\"textfield\" name=\"filename\"  style='font-family:calibri;font-size:14px;font-weight:bold;' width=50/></td></tr>");
	    obj.println("<tr><td><input type=\"Submit\" value=\"Save File\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'></td></tr>");
	    obj.println("</table>");
	    obj.println("</td></tr></table>");
	    obj.println(" </form>");
	    obj.println(" </div>");
	    obj.println(" </body>");
	    obj.println("</html>");
      }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
      {
    	    PrintWriter obj=response.getWriter();
	    response.setContentType("text/html");
    	    obj.println("<html>");
	    obj.println("<title>Online Java Compiler</title>");
	    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
	    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
	    obj.println("<div style=\"position:absolute;top:100px;left:50px;\">");
	    obj.println("<form action=\"ojc\" method=\"post\">");
	    obj.println("<table border=1 width=500>");
	    obj.println("<tr><td><p style=\"font-family:calibri;font-weight:bold;font-size:22px;text-align:center;\">Welcome to Editor</p></td></tr>");
	    obj.println("<tr  height=400><td>");
	    obj.println("<table>");
	    obj.println("<tr><td><textarea rows=20 cols=90 name=\"program\" style='font-family:calibri;font-weight:bold;font-size:18px;'>Type your Java Program here...</textarea></td></tr>");
	    obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter Your Directory Name*:-<input type=\"textfield\" name=\"dirname\"  style='font-family:calibri;font-size:14px;font-weight:bold;' width=50/></td></tr>");
	    obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter File Name Including Extension*:-<input type=\"textfield\" name=\"filename\"  style='font-family:calibri;font-size:14px;font-weight:bold;' width=50/></td></tr>");
	    obj.println("<tr><td><input type=\"Submit\" value=\"Save File\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'></td></tr>");
	    obj.println("</table>");
	    obj.println("</td></tr></table>");
	    obj.println(" </form>");
	    obj.println(" </div>");
	    obj.println(" </body>");
	    obj.println("</html>");
      }
 }
