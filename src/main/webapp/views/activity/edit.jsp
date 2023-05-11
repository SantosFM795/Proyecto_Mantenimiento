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

<form:form action="activity/manager/edit.do" modelAttribute="activity">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="title">
		<spring:message code="activity.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	<form:label path="day">
		<spring:message code="activity.day" />:
	</form:label>
	<form:input path="day" />
	<form:errors cssClass="error" path="day" />
	<br />

	<form:label path="description">
		<spring:message code="activity.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
	
	<form:label path="startTime">
		<spring:message code="activity.startTime" />:
	</form:label>
	<form:input path="startTime" />
	<form:errors cssClass="error" path="startTime" />
	<br />
	
	<form:label path="endTime">
		<spring:message code="activity.endTime" />:
	</form:label>
	<form:input path="endTime" />
	<form:errors cssClass="error" path="endTime" />
	<br />
	
	<form:label path="availableSpots">
		<spring:message code="activity.availableSpots" />:
	</form:label>
	<form:input path="availableSpots" />
	<form:errors cssClass="error" path="availableSpots" />
	<br />
	
	

	<input type="submit" name="save"
		value="<spring:message code="activity.save" />" />&nbsp; 
	<jstl:if test="${activity.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="activity.delete" />"
			onclick="return confirm('<spring:message code="activity.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="activity.cancel" />"
		onclick="javascript: relativeRedir('activity/manager/list.do');" />
	<br />

	<%-- Se debe añadir un script de control, revisar acme-Certifications --%>
</form:form>
