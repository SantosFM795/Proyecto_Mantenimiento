<%--
 * edit.jsp
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
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="${requestURI}" modelAttribute="gym">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="manager" />
	
	<form:label path="logo">
		<spring:message code="gym.logo" />:
	</form:label>
	<form:input path="logo" />
	<form:errors cssClass="error" path="logo" />
	<br />

	<form:label path="name">
		<spring:message code="gym.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />

	<form:label path="address">
		<spring:message code="gym.address" />:
	</form:label>
	<form:input path="address" />
	<form:errors cssClass="error" path="address" />
	<br />

	<form:label path="mensualCost">
		<spring:message code="gym.mensualCost" />:
	</form:label>
	<form:input path="mensualCost" />
	<form:errors cssClass="error" path="mensualCost" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="gym.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="gym.cancel" />"
		onclick="javascript: relativeRedir('gym/manager/list.do');" />
	<br />

	<%-- Se debe añadir un script de control, revisar acme-Certifications --%>
</form:form>
