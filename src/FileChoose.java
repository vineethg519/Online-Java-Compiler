import java.io.*;
import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class FileChoose extends HttpServlet   
  {
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
     {
 	    PrintWriter obj=response.getWriter();
	    response.setContentType("text/html");
	    obj.println("<html>");
	    obj.println("<title>Online Java Compiler</title>");
	    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
	    obj.println("<div style=\"position:absolute;top:250px;left:350px;\">");
	    obj.println("<img src='web/images/java4.gif' />");
	    obj.println("</div>");
	    String str=request.getParameter("wrong");
	    try 
	      {
		    int strv=Integer.parseInt(str);
		    if(strv==2)
		      obj.println("<div style=\"position:absolute;top:80px;left:650px;\"><p style='color:red;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>Invalid Directory</p></div>");
	      }
	    catch(Exception e)
		{
	      }
	    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
	    obj.println("<div style=\"position:absolute;top:100px;left:0px;\">");
	    obj.println("<form action=\"FileChoose\" method=\"post\">");
	    obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Choose Your Directory:-</span>");
	    obj.println("<select name='directory' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
	    obj.println("<OPTION VALUE='Default' >Default</OPTION>");
	    String path = "C:/UserPrograms/"; 
	    File d = new File(path);
	    String[] children = d.list();
	    if(children == null)
	     {
		    // Either dir does not exist or is not a directory
	     }
	    else 
		{
		  for (int i=0; i<children.length; i++)
		    {
		        // Get filename of file or directory
		        String filename = children[i];
		         obj.println("<option  value='"+i+"'>"+filename+"</option>");
		    }
		}
	    obj.println("</select>");
	    obj.println("<input type=\"Submit\" style='background-color:#99CCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;' value=\"Confirm Directory\" >");
	    obj.println(" </form>");
	    obj.println(" </div>");
	    obj.println(" </body>");
	    obj.println("</html>");
      }
   public void doPost (HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
     {
      try
        {
	    PrintWriter obj=response.getWriter();
	    response.setContentType("text/html");
	    Enumeration paramNames = request.getParameterNames();
	    String dName = (String)paramNames.nextElement();
	    String[] dValues = request.getParameterValues(dName); 
	    String dir=dValues[0];
	    obj.println("<html>");
	    obj.println("<title>Online Java Compiler</title>");
	    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
	    obj.println("<div style=\"position:absolute;top:250px;left:350px;\">");
	    obj.println("<img src='web/images/java4.gif' />");
	    obj.println("</div>");
	    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
	    obj.println("<div style='position:absolute;top:100;left:0;'>");
	    obj.println("<form action=\"Final\" method=\"post\">");
	    obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Your Directory:-</span>");
	    int dnum=Integer.parseInt(dir);
	    String path = "C:/UserPrograms/"; 
	    File d = new File(path);
	    String[] children = d.list();
	    if (children == null)
	     {
		    // Either dir does not exist or is not a directory
	     }
	    else 
	     {
	       for (int i=0; i<children.length; i++)
	        {
		    // Get filename of file or directory
		    String filename = children[i];
		    if(i==dnum)
		      {
		    	    obj.println("<select name='userdir' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
		            obj.println("<option value='"+i+"' selected>"+filename+"</option>");
		            obj.println("</select>");
		            path = "C:/UserPrograms/"+filename; 
		            obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'><br/>Choose Your File:-</span>");
		            obj.println("<select name='userfiles' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
		            String files;
		            File folder = new File(path);
		            File[] listOfFiles = folder.listFiles(); 
		            for(int j=0;j<listOfFiles.length;j++) 
		              {
		                if(listOfFiles[j].isFile()) 
			            {
		                     files = listOfFiles[j].getName();
		                     obj.println("<option  style='font-family:calibri;font-size:14px;font-weight:bold;' value='"+j+"'>"+files+"</option>");
		                     
		                  }
		               }
		            obj.println("</select>");
	              }
	          }
	      }
	    obj.println("<input type=\"Submit\" style='background-color:#99CCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;' value=\"Confirm File\" >");    
	    obj.println("</form>");
	    obj.println("</div>");
	    obj.println("</body>");
	    obj.println("</html>");
	  }
      catch(NumberFormatException e)
        {
          response.sendRedirect("FileChoose?wrong=2");
    	  }
    }
 }