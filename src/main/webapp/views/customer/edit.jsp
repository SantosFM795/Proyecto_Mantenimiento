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

<form:form action="customer/administrator/edit.do" modelAttribute="customer">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="name">
		<spring:message code="customer.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />

	<form:label path="surname">
		<spring:message code="customer.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br />

	<form:label path="creditCard">
		<spring:message code="customer.creditCard.number" />:
	</form:label>
	<form:input path="creditCard" />
	<form:errors cssClass="error" path="creditCard" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="customer.save" />" />&nbsp; 
	<jstl:if test="${customer.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="customer.delete" />"
			onclick="return confirm('<spring:message code="customer.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="customer.cancel" />"
		onclick="javascript: relativeRedir('customer/administrator/list.do');" />
	<br />

	<%-- Se debe añadir un script de control, revisar acme-Certifications --%>
</form:form>
