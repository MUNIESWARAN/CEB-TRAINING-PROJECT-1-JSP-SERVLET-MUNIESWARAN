<%@page import="com.model.Registration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.HRDaoImp"%>
<%@page import="com.dao.HRDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR APPROVAL Page</title>
</head>
<body>

<h3> Welcome to HR SKILL Approval Page</h3>

<br/>
<h4>List of profiles pending for Approval</h4>

<%
 String userType = request.getSession().getAttribute("userType").toString();
		
int employeeId =Integer.parseInt( request.getSession().getAttribute("employeeid").toString()); 
		HRDao hrDAO = new HRDaoImp();
		ArrayList<Registration> employeeList = new ArrayList<Registration>(); 
		employeeList = hrDAO.getListOfEmployeesNotApproved();
%>



<table border="1">
<thead><tr><td>EMPLOYEE ID</td> <td>FIRST NAME </td> <td>LAST NAME</td> <td>EMAIL</td> <td> APPROVE</td> </tr></thead>
<tbody>
<%for(Registration registration : employeeList )
{
	
   %> <tr> <td> <%=registration.getEmployeeId() %></td> <td> <%=registration.getFirstName() %></td> <td> <%=registration.getLastName() %></td> <td><%=registration.emailid %></td><td> <a href="ViewEmployeeDetail.jsp?employeeid=<%=registration.getEmployeeId()%>">View Deails</a> </td>  </tr><%  
	
}
	%>
</tbody>
</table>

</body>
</html>