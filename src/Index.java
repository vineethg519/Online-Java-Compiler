import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Index extends HttpServlet 
  {
 		public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
 	    	{
   			    PrintWriter obj=response.getWriter();
			    response.setContentType("text/html");
			    obj.println("<html>");
			    obj.println("<title>Online Java Compiler</title>");
			    obj.println("<script type=\"text/javascript\">function move(){    location.href=\"FileChoose\" }</script>");
			    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
    			    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
			    obj.println("<div style=\"position:absolute;top:200px;left:100px;\">");
			    obj.println("<form action=\"Editor\" method=\"post\">");
			    obj.println("<table border=0><tr><td width=250>");
			    obj.println("<input type=\"button\" value=\"Choose Java File\" onClick=\"move()\" style='background-color:#99CCFF;font-family:calibri;text-align:center;font-size:34px; font-weight:bold;' width=350/><td/>");
			    obj.println("<td width=250><img src='web/images/java1.jpg' /></td>");
			    obj.println("<td width=250><input type=\"Submit\" value=\"Create Java File\" style='background-color:#99CCFF;font-family:calibri;font-size:34px;text-align:center; font-weight:bold;' width=350/></td>");
			    obj.println("</tr></table>");
			    obj.println("</form>");
			    obj.println("</div>");
			    obj.println("</body>");
			    obj.println("</html>");
  			}
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  			{
			    PrintWriter obj=response.getWriter();
			    response.setContentType("text/html");
			    obj.println("<html>");
			    obj.println("<title>Online Java Compiler</title>");
			    obj.println("<script type=\"text/javascript\">function move(){    location.href=\"FileChoose\" }</script>");
			    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
			    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
			    obj.println("<div style=\"position:absolute;top:200px;left:100px;\">");
			    obj.println("<form action=\"Editor\" method=\"post\">");
			    obj.println("<table border=0><tr><td width=250>");
			    obj.println("<input type=\"button\" value=\"Choose Java File\" onClick=\"move()\" style='background-color:#99CCFF;font-family:calibri;text-align:center;font-size:34px; font-weight:bold;' width=350/><td/>");
			    obj.println("<td width=250><img src='web/images/java1.jpg' /></td>");
			    obj.println("<td width=250><input type=\"Submit\" value=\"Create Java File\" style='background-color:#99CCFF;font-family:calibri;font-size:34px;text-align:center; font-weight:bold;' width=350/></td>");
			    obj.println("</tr></table>");
			    obj.println("</form>");
			    obj.println("</div>");
			    Enumeration paramNames = request.getParameterNames();
			    String fName = (String)paramNames.nextElement();
			    String[] fValues = request.getParameterValues(fName);
			    String pName = (String)paramNames.nextElement();
			    String[] pValues = request.getParameterValues(pName);  
			    String dName = (String)paramNames.nextElement();
			    String[] dValues = request.getParameterValues(dName); 
			    String prg=pValues[0];
			    String nam=fValues[0];
			    String dir=dValues[0];
			    if(dir=="")
			       response.sendRedirect("Editor"); 
			    else
			      {
				    try
				      {
					      String str="C:/UserPrograms";
					      File mdir=new File(str);
					      mdir.mkdir();
					      str="C:/UserPrograms/"+dir;
					      File udir=new File(str);
					      udir.mkdir();
					      String fpath=str+"/"+nam;
					      File f=new File(fpath);
					      FileWriter fw=new FileWriter(f);
					      BufferedWriter bw=new BufferedWriter(fw);
					      bw.write(prg);
					      bw.close();
					      obj.println("<div style=\"position:absolute;top:500px;left:250px;\"><p style='font-family:calibri;font-size:34px;text-align:center; font-weight:bold;'>Your File has been Saved Succesfully.</p></div>");
				      }
				   catch(IOException e)
				      {
					      obj.println("<div style=\"position:absolute;top:500px;left:250px;\"><p style='font-family:calibri;font-size:34px;text-align:center; font-weight:bold;'>Your File has not been Saved Succesfully.</p></div>");
				      } 
				    obj.println("</body>");
				    obj.println("</html>");
			      }
		    }
   }
