<%--
 * create.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="isAuthenticated()">
	<form:form action="${url}" modelAttribute="annotation">

		<form:hidden path="id" />
		<form:hidden path="version" />

		<form:label path="text">
			<spring:message code="annotation.text" />
		</form:label>
		<div id="textArea">
			<form:textarea path="text" />
		</div>
		
		<form:label path="rating">
			<spring:message code="annotation.rating" />
		</form:label>
		<div id="textRating">
			<form:textarea path="rating" />
		</div>
		
		<br />
	<input type="submit" name="save"
			value="<spring:message code="annotation.save" />" />&nbsp; 
		<input type="button" name="cancel"
			value="<spring:message code="annotation.cancel" />"
			onclick="javascript: relativeRedir('activity/customer/list.do');" />
		<br />

	</form:form>


</security:authorize>