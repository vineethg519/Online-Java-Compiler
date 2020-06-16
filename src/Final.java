import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class Final extends HttpServlet 
  {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
		    PrintWriter obj=response.getWriter();
		    response.setContentType("text/html");
		    Enumeration paramNames = request.getParameterNames();
		    String dName = (String)paramNames.nextElement();
		    String[] dValues = request.getParameterValues(dName);
		    String fName = (String)paramNames.nextElement();
		    String[] fValues = request.getParameterValues(fName); 
		    String dir=dValues[0];
		    String fil=fValues[0];
		    obj.println("<html>");
		    obj.println("<title>Online Java Compiler</title>");
		    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
		    obj.println("<div style=\"position:absolute;top:100px;left:800px;\">");
		    obj.println("<img src='web/images/java2.png' />");
		    obj.println("</div>");
		    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
		    obj.println("<div style='position:absolute;top:100;left:0;'>"); 
		    obj.println("<form action=\"doAll\" method=\"post\">");
		    obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Your Directory:-</span>");
		    int dnum=Integer.parseInt(dir);
		    int fnum=Integer.parseInt(fil);
		    String path = "C:/UserPrograms/"; 
		    File d = new File(path);
		    String[] children = d.list();
           	    String strViewPage="Compile";
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
			          obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'><br/>Your File:-</span>");
			          obj.println("<select name='userfiles' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
			          String files;
			          File folder = new File(path);
			          File[] listOfFiles = folder.listFiles(); 
			          for(int j=0;j<listOfFiles.length;j++) 
			            {
			               if(listOfFiles[j].isFile()) 
			                 {
			                     files = listOfFiles[j].getName();
			                     if(j==fnum)
			                       {
							 for(int k=0;k<listOfFiles.length;k++) 
							   {
		           					    if(listOfFiles[k].isFile()) 
	           						      {
            							   files = listOfFiles[k].getName();
                      						   if(fnum==k)	
           							           obj.println("<option  style='font-family:calibri;font-size:14px;font-weight:bold;' value='"+k+"' selected>"+files+"</option>");
					                           else
          							           obj.println("<option  style='font-family:calibri;font-size:14px;font-weight:bold;' value='"+k+"'>"+files+"</option>");
              						      }
            					   }
 					          	 files = listOfFiles[j].getName();
			                     	 obj.println("</select><br/>");
                                       	 obj.println("<input type=\"radio\" name=\"status\" value=\"0\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Edit</span>");
                                      	 obj.println("<input type=\"radio\" name=\"status\" value=\"1\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Compile</span>");
       		                    	 obj.println("<input type=\"radio\" name=\"status\" value=\"2\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Run</span>");
			                       }
				            }
			             }
       		     	    }
       		     }
     			}
    			obj.println("<input type=\"Submit\" value=\"Go>>\" style='background-color:#99CCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");    
    			obj.println("</form>");
   			obj.println("</div>");
  			obj.println("</body>");
		      obj.println("</html>");
        }
  }
