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
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('ADMIN')">
	<form:form action="${url}" modelAttribute="administrator">

		<form:hidden path="id" />
		<form:hidden path="version" />

		<form:label path="name">
			<spring:message code="administrator.name" />:
	</form:label>
		<form:input path="name" />
		<form:errors cssClass="error" path="name" />
		<br />

		<form:label path="lastName">
			<spring:message code="administrator.lastName" />:
	</form:label>
		<form:input path="lastName" />
		<form:errors cssClass="error" path="lastName" />
		<br />

	<form:label path="email">
			<spring:message code="administrator.email" />:
	</form:label>
	<form:input path="email" />
		<form:errors cssClass="error" path="email" />
		<br />
	
	<form:label path="phoneNumber">
			<spring:message code="administrator.phoneNumber" />:
	</form:label>
		<form:input path="phoneNumber" />
		<form:errors cssClass="error" path="phoneNumber" />
	<br />
	<form:label path="postalCode">
			<spring:message code="administrator.postalCode" />:
	</form:label>
		<form:input path="postalCode" />
		<form:errors cssClass="error" path="postalCode" />
	<br />
	<form:label path="city">
			<spring:message code="administrator.city" />:
	</form:label>
		<form:input path="city" />
		<form:errors cssClass="error" path="city" />
	<br />
	<form:label path="country">
			<spring:message code="administrator.country" />:
	</form:label>
		<form:input path="country" />
		<form:errors cssClass="error" path="country" />
	<br />
	
	
	
	<input type="submit" name="save"
			value="<spring:message code="administrator.save" />" />&nbsp; 
	<jstl:if test="${administrator.id != 0}">
			<input type="submit" name="delete"
				value="<spring:message code="administrator.delete" />"
				onclick="return confirm('<spring:message code="administrator.confirm.delete" />')" />&nbsp;
	</jstl:if>
		<input type="button" name="cancel"
			value="<spring:message code="administrator.cancel" />"
			onclick="javascript: relativeRedir('/list.do');" />
		<br />

	</form:form>


</security:authorize>