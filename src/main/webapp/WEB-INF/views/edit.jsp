<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form:form commandName="contact" action="${pageContext.request.contextPath}/edit" method="post">
		<table class="new-contact">
		<form:input path="id" type="hidden" value="${contact.id}" />
	    <tr>
	        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
	        <td><form:input path="firstname" value="${contact.firstname}" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
	        <td><form:input path="lastname" value="${contact.lastname}" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
	        <td><form:input path="email" value="${contact.email}" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
	        <td><form:input path="telephone" value="${contact.telephone}" /></td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
	        </td>
	    </tr>
	</table> 
	</form:form>
</body>
</html>