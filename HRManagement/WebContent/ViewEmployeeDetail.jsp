<%@page import="com.model.Registration"%>
<%@page import="com.dao.RegistrationDaoImp"%>
<%@page import="com.dao.RegistrationDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Skill of an Employee</title>

<%
 String userType = request.getSession().getAttribute("userType").toString();
		
int employeeId =Integer.parseInt( request.getSession().getAttribute("employeeid").toString()); 
RegistrationDao registrationDao = new RegistrationDaoImp();
int registeredEmployeeId = Integer.parseInt( request.getParameter("employeeid"));
	 Registration employee = registrationDao.getEmployeeUsingId(registeredEmployeeId);
%>
</head>
<body>

<h2>EMPLOYEE SKILL APPROVE PAGE</h2>
<form action="ApproveController" method="post">
<input type="hidden" name="employeeid" value="<%=request.getParameter("employeeid")%>"/>
<table border="1">
 <tr><td>EMPLOYEE ID </td> <td> <%=employee.getEmployeeId() %></td> </tr>
<tr><td>FIRST NAME</td><td><%=employee.getFirstName() %></td></tr>
<tr><td>LAST NAME </td><td><%=employee.getLastName() %></td></tr>
<tr><td>GENDER</td><td><%=employee.getGender() %></td></tr>
<tr><td>DATE OF BIRTH</td><td><%=employee.getDateOfBirth() %></td></tr>
<tr><td>DESIGNATION </td><td><%=employee.getUserType() %></td></tr>
<tr><td>ADDRESS FOR COMMUNICATION</td><td><%=employee.getCommAddress() %></td></tr>
<tr><td>EMAIL ID</td><td><%=employee.getEmailid() %></td></tr>
<tr><td>CONTACT NO</td><td><%=employee.getContact() %></td></tr>
 </table>
 <br/>
<input type="submit" value="APPROVE"/>
</form>
</body>
</html>