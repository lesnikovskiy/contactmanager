<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC - Contact Manager</title>
    <style type="text/css">
    .page {width:736px; color:#333; font-weight:16px Arial; margin:0 auto;}
    table {border-collapse:collapse; font:16px Arial; color:#333;}
    table.data th { text-align:left; border-bottom:1px dotted #333;}
    table.data td {border-bottom:1px solid #333; width: 300px; padding:2px 0 4px 0;}
    table.data td a { font:11px Arial; }
    </style>
</head>
<body>
 <div class="page">
<h2>Contact Manager</h2>
 
<form:form method="post" action="${pageContext.request.contextPath}/add" commandName="contact"> 
    <table class="new-contact">
	    <tr>
	        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
	        <td><form:input path="firstname" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
	        <td><form:input path="lastname" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
	        <td><form:input path="email" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
	        <td><form:input path="telephone" /></td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="<spring:message code="label.addcontact"/>"/>
	        </td>
	    </tr>
	</table> 
</form:form>
 
     
<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
	<table class="data">
		<tr>
		    <th>Name</th>
		    <th>Email</th>
		    <th>Telephone</th>
		    <th>&nbsp;</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">
		    <tr>
		        <td>${contact.lastname}, ${contact.firstname} </td>
		        <td>${contact.email}</td>
		        <td>${contact.telephone}</td>
		        <td>
		        	<a href="edit/${contact.id}">edit</a>
		        	&nbsp;|&nbsp;
		        	<a href="delete/${contact.id}">delete</a>
		        </td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>