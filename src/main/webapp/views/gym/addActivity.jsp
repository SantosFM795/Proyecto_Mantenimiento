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

<form:form action="${requestURI}" modelAttribute="addActivity" method="get">

	<form:hidden path="gymId" />
	
	<form:label path="activityId">
		<spring:message code="gym.activity"></spring:message>
	</form:label>
	<form:select path="activityId">
		<form:option value="0" label="----"/>
		<form:options items="${activities}" itemValue="id" itemLabel="title"/>
	</form:select>
	<form:errors cssClass="error" path="activityId"></form:errors>

	 <!-- <input type="submit" name="saveActivity"
		value="<spring:message code="gym.save" />" />&nbsp; -->
		
	<div>
		<a href="gym/manager/saveActivity.do?gymId=${addActivity.gymId}&activityId=${betis}"> <spring:message code="gym.save" />
		</a>
	</div>
	
	<input type="button" name="cancel"
		value="<spring:message code="activity.cancel" />"
		onclick="javascript: relativeRedir('activity/administrator/list.do');" />
	<br />

	<%-- Se debe añadir un script de control, revisar acme-Certifications --%>
</form:form>
