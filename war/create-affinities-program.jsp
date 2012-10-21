<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tv.tipoff.infrastructure.DAOProgram" %>
<%@ page import="java.util.List" %>
<%@ page import="tv.tipoff.application.model.Program" %>

<html>
	<head>
		<title>Create an program</title>
	</head>
	<body>
		<%
		DAOProgram daoProgram = new DAOProgram();
		List<Program> programs  = daoProgram.getAllPrograms();
		%>
		
		<form method="POST" action="/program/similar">
			<span>Program #1</span><br/>
			<select name="program1">
			<%for(Program p : programs){	%>
				<option value="<%=p.getId()%>"><%=p.getTitle()%></option>
			<%} %>
			</select><br/>

			<span>Program #2</span><br/>
			<select name="program2">
			<%for(Program p : programs){	%>
				<option value="<%=p.getId()%>"><%=p.getTitle()%></option>
			<%} %>
			</select><br/>
			<input type="submit" />
		</form>
		
	</body>
</html>