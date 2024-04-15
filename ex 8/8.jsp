<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! int totage=0;
        int avg; 
String a="";
        %>
        
        <%  Connection c =DriverManager.getConnection("jdbc:derby://localhost:1527/student");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("SELECT Count (student_id) from student");
        ResultSet rs=st.executeQuery("SELECT AVG (age) from student");
        ResultSet rs=st.executeQuery("SELECT dept,COUNT(*) AS num_stu From students GROUP BY dept ORDER BY num_stu FETCH FIRST 1 ROWS ONLY");
        %>
        <% if (rs.next()){
            //out.print("The number of students present:");
            //out.print("Average age of the students:");
            a=rs.getString("dept");
         }
        out.println("The dept with high no of Students:"+a);
        %>
   </body>
</html>
