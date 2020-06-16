import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class doAll extends HttpServlet 
{
   public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  	{
		    PrintWriter obj=response.getWriter();
		    response.setContentType("text/html");
		    Enumeration paramNames = request.getParameterNames();
		    String dName = (String)paramNames.nextElement();
		    String[] dValues = request.getParameterValues(dName);
		    String allName = (String)paramNames.nextElement();
		    String[] allValues = request.getParameterValues(allName); 
		    String fName = (String)paramNames.nextElement();
		    String[] fValues = request.getParameterValues(fName);
		    String dir=dValues[0];
		    String all=allValues[0];
		    String fil=fValues[0];
		    obj.println("<html>");
		    obj.println("<title>Online Java Compiler</title>");
		    obj.println("<body style=\"position:absolute;top:0%;left:0%;width:100%;height:100%;background:url(web/images/bg.jpg)\">");
		    obj.println("<div style=\"position:absolute;top:100px;left:1000px;\">");
		    obj.println("<img src='web/images/java2.png' />");
		    obj.println("</div>");
		    obj.println("<div style='font-family:calibri;text-align:center;color:black;font-size:50px;font-weight:bold;'><span style='font-size:65px;color:red;'>O</span>n-line <span style='font-size:65px;color:red;'>J</span>ava <span style='font-size:65px;color:red;'>C</span>ompiler</div>");
		    obj.println("<div style='position:absolute;top:100;left:0;'>");   
		    int dnum=Integer.parseInt(dir);
		    int allnum=Integer.parseInt(all);
		    int fnum=Integer.parseInt(fil);
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
	                           path = "C:/UserPrograms/"+filename; 
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
					                        switch(allnum)
					                         {
					                            case 0: 	
											  int count=0;
						            			  boolean flagJava=files.endsWith(".java");
		                 				                    boolean flagClass=files.endsWith(".class");
				   					                if(flagClass)
												{
						  						   count=1;
												}
							   				    if(count==1)
     					 						      {		
								   					files = listOfFiles[j].getName();
													obj.println("<form action=\"doAll\" method=\"post\">");
								 					obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Your Directory:-</span>");
								    	  				obj.println("<select name='userdir' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
								       				obj.println("<option  value='"+i+"' selected>"+filename+"</option>");
								          				obj.println("</select>");
												      obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'><br/>Your File:-</span>");
								           				obj.println("<select name='userfiles' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
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
	 	                 								    obj.println("</select><br/>");
	      										    String fReadPath="c:/UserPrograms/"+filename+"/"+files;
											          obj.println("<input type=\"radio\" name=\"status\" value=\"0\" checked><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Edit</span>");
												    obj.println("<input type=\"radio\" name=\"status\" value=\"1\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Compile</span>");
			                                                          obj.println("<input type=\"radio\" name=\"status\" value=\"2\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Run</span>");
												    obj.println("<input type=\"Submit\" value=\"Go>>\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'>");    
				 				   			   	    obj.println("</div>");
		  							  			    obj.println("<div style=\"position:absolute;top:250px;left:50px;\">");
												    obj.println("<p style='font-family:calibri;font-size:25;font-weight:bold;'>");
												    obj.println("Result After Compiling</p><hr/>");
												    obj.println("<p style='font-family:calibri;font-size:22;'>");
								        	  		    obj.println("Class File Cannot be Edited."); 
											  	    obj.println("</p>");
												    obj.println("</div>");
						 				  		    obj.println("</form>");
							  					    obj.println("</body>");
						  						    obj.println("</html>");
						     						 }
   											     else 
												 {
												    String fReadPath="c:/UserPrograms/"+filename+"/"+files;
												    obj.println("<div style=\"position:absolute;top:75px;left:50px;\">");
												    obj.println("<form action=\"ojc\" method=\"post\">");
												    obj.println("<table border=1 width=500>");
												    obj.println("<tr><td><p style=\"font-family:calibri;font-weight:bold;font-size:22px;text-align:center;\">Welcome to Editor</p></td></tr>");
												    obj.println("<tr  height=400><td>");
												    obj.println("<table>");
												    obj.println("<tr><td><textarea rows=15 cols=110 name=\"program\" style='font-family:calibri;font-weight:bold;font-size:18px;'>");
											          try
													{
												        String fileContent;
												        File fRead=new File(fReadPath);
													  FileReader fr=new FileReader(fRead);
													  BufferedReader br=new BufferedReader(fr);
													  while((fileContent=br.readLine())!=null)
													    {
													       obj.println(fileContent);
													    }
													  br.close();
												       }
												     catch(Exception e)
												       {
													 }
												     obj.println("</textarea></td></tr>");
												     obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter Your Directory Name:-<input type=\"textfield\" name=\"dirname\" style='font-family:calibri;font-size:14px;font-weight:bold;' value='"+filename+"' width=50/></td></tr>");
												     obj.println("<tr><td style='font-family:calibri;font-weight:bold;font-size:18px;'>Enter File Name Including Extension:-<input type=\"textfield\" name=\"filename\"  style='font-family:calibri;font-size:14px;font-weight:bold;' value='"+files+"' width=50/></td></tr>");
												     obj.println("<tr><td><input type=\"Submit\" value=\"Save File\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'></td></tr>");
											           obj.println("</table>");
												     obj.println("</td></tr></table>");
	    											     obj.println(" </form>");
	   											     obj.println(" </div>");
    												     obj.println("</body>");
   												     obj.println("</html>");
   											         }
	                                  					     break;	
			    						   case 1:        
											  obj.println("<form action=\"doAll\" method=\"post\">");
						           				  obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Your Directory:-</span>");
						    	  				  obj.println("<select name='userdir' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
						         				  obj.println("<option value='"+i+"' selected>"+filename+"</option>");
						          				  obj.println("</select>");
				  					              obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'><br/>Your File:-</span>");
						      				  obj.println("<select name='userfiles' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
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
 											   obj.println("<input type=\"radio\" name=\"status\" value=\"1\" checked><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Compile</span>"); 
											   obj.println("<input type=\"radio\" name=\"status\" value=\"2\"><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Run</span>");
											   try
											     {
						                           		    Runtime rt = Runtime.getRuntime();
					  	  		                		    //Process pr = rt.exec("cmd /c dir");
								              		    String fpath="C:/UserPrograms/"+filename+"/";
												    count=0;
										                File f=new File(fpath);
										                String[] clpath={"path=C:/Sun/AppServer/jdk/bin",""};
										                String[] prg={"C:/Sun/AppServer/jdk/bin/javac.exe",files}; 
										                Process pr = rt.exec(prg,clpath,f);
												    flagJava=files.endsWith(".java");
					                     				    if(!flagJava)
													{
								  						pr.destroy();
								  						count=1;
													}
										                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
												    obj.println("<input type=\"Submit\" value=\"Go>>\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'>");    
								 				    obj.println("</div>");
							  					    obj.println("<div style=\"position:absolute;top:250px;left:50px;\">");
												    obj.println("<p style='font-family:calibri;font-size:25;font-weight:bold;'>");
												    obj.println("Result After Compiling</p><hr/>");
												    obj.println("<p style='font-family:calibri;font-size:22;'>");
										                String line=null;
					    				                      while((line=input.readLine()) != null) {obj.println(line); } 
												    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
												    String s;
									      		    while((s = bufferedreader.readLine()) != null){ obj.println(s);}
                                                     				    if(count==0)
 												      obj.println("Compilation Successfull."); 
												    if(count==1)
					 							      obj.println("Only Java files can be Compiled."); 
												    obj.println("</p>");
												    obj.println("</div>");
						 				  		    obj.println("</form>");
						  						    obj.println("</body>");
						  						    obj.println("</html>");
												    pr.destroy();
						                                     }
											     catch (IllegalThreadStateException e) 
												  { 
												  }
					                                        break;
 										case 2: 
											    obj.println("<form action=\"doAll\" method=\"post\">");
							      			    obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'>Your Directory:-</span>");
						    	  				    obj.println("<select name='userdir' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
						         				    obj.println("<option   value='"+i+"' selected>"+filename+"</option>");
						          				    obj.println("</select>");
						            			    obj.println("<span style='font-family:calibri;font-weight:bold;font-size:20px;'><br/>Your File:-</span>");
						           				    obj.println("<select name='userfiles' style='background-color:#FFCCFF;font-family:calibri;font-size:16px;text-align:center; font-weight:bold;'>");
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
											    obj.println("<input type=\"radio\" name=\"status\" value=\"2\" checked><span style='font-family:calibri;font-weight:bold;font-size:15px;'>Run</span>");
											    try 
 												{
						                             		      Runtime rt = Runtime.getRuntime();
									                		//Process pr = rt.exec("cmd /c dir");
									              	      String fpath="C:/UserPrograms/"+filename+"/";
											            File f=new File(fpath);
											            String[] clpath={"path=C:/Sun/AppServer/jdk/bin",""};
											            int l=files.length();
												      String strnew=files;
						                     				flagJava=files.endsWith(".java");
						                     				flagClass=files.endsWith(".class");
						  			                        if(flagJava)
												        strnew=files.substring(0,l-5);
						   					            if(flagClass)
												        strnew=files.substring(0,l-6);
											            String[] prg={"C:/Sun/AppServer/jdk/bin/java.exe",strnew}; 
											            Process pr = rt.exec(prg,clpath,f);
 										                  BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  												      obj.println("<input type=\"Submit\" value=\"Go>>\" style='background-color:#99CCFF;font-family:calibri;font-size:14px;text-align:center; font-weight:bold;'>");    
						 				  		      obj.println("</form>");
									   				obj.println("</div>");
							    						obj.println("<div style=\"position:absolute;top:250px;left:50px;\">");
													obj.println("<p style='font-family:calibri;font-size:25;font-weight:bold;'>");
													obj.println("Result After Running</p><hr/>");
						             					obj.println("<p style='font-family:calibri;font-size:22;'>");
													String line=null;
						                                          while((line=input.readLine()) != null) {obj.println(line); } 
													BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
													String s;
											       	while((s = bufferedreader.readLine()) != null)
												    	obj.println(s);
												      obj.println("</p>");
						    							obj.println("</div>");
													obj.println("</body>");
						  						      obj.println("</html>");
						                    				pr.destroy();
								                        }  
											    catch (IllegalThreadStateException e) 
											      { 
						   					      }	
						 				         break;	
                              		            }
                                               }           
				                }   
                                   }
           			      }   
                    	 }
              	 }
       	 }
 	}
