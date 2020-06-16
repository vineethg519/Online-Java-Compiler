# Online-Java-Compiler

1: Install latest version on J2EE
2: setting class path for j2ee
    path="C:\Sun\AppServer\bin"
3: setting class path for jdk
    path="C:\Sun\AppServer\jdk\bin"
4: copy java.policy file 
      source="java.policy"
     destination="C:\Sun\AppServer\jdk\jre\lib\security"
5: Start the Application Server at
    path="start->All Programs(or) Programs->Sun Microsystems->Application server PE->Start Default Server"
6: Deploying OJC
    path="start->All Programs(or) Programs->Sun Microsystems->Application server PE->Admin Console"
7: Browser Appears for 
    username: admin
    password:*********
8: click webApplications on left side.
9: click deploy on the center
10: browse the Project.war file in the center
11: After browsing press next
11: Then  press OK
12: Now Press Launch
13: http://localhost:8080/Project/
14:  now add ojc atlast to the URL
15: http://localhost:8080/Project/ojc
16: Now Copy all the classes to make the Explore Java !!! option work.
      source="api"
     destination="C:\Sun\AppServer\domains\domain1\applications\j2ee-modules\Project\WEB-INF"
