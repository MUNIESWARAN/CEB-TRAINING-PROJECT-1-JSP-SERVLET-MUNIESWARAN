<%@page import="com.dao.CompetancyDaoImp"%>
<%@page import="com.model.Competency"%>
<%@page import="com.dao.CompetancyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.SkillsUpdateDaoImp"%>
<%@page import="com.dao.SkillUpdateDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<br/><h3> UPDATE SKILLS FOR @  <%=request.getSession().getAttribute("email") %> </h3>
<%
 String userType = request.getSession().getAttribute("userType").toString();
int employeeId =Integer.parseInt( request.getSession().getAttribute("employeeid").toString()); 
SkillUpdateDao skillUpdateDAO = new SkillsUpdateDaoImp();
 CompetancyDao competancyDAO = new CompetancyDaoImp();
 ArrayList<String> skillList = skillUpdateDAO.getListOfSkills(userType);
 int count = 1;
%>
<br/><h3>Role: <%=userType %></h3>


<form action="UpdateSkillController" method="post">

<table>

<%

if(competancyDAO.checkCompetencyUpdated(employeeId) )
{
	ArrayList<Competency> competencyList = new ArrayList<Competency> ();
	competencyList = competancyDAO.getCompetencyForAnEmployee(employeeId);
	int counter=0;
for(Competency competency : competencyList){
		
		%><tr> <td><%=skillList.get(counter)%> </td>  <td><input type="hidden" name="skillId<%=count%>" /> <input type="text" name="skillLevel<%=count%>" value="<%=competency.getSkillLevel()%>"/></td> </tr><%
	counter++;
	}
}else{
	for(String question : skillList){
		
		%><tr> <td><%=question%> </td>  <td><input type="hidden" name="skillId<%=count%>" /> <input type="text" name="skillLevel<%=count%>"/></td> </tr><%
	count++;
	}
}
%>

</table>
<input type="submit" />
</form>
</body>
</html>