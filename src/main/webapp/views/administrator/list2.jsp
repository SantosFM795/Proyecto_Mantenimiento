<%--
 * action-2.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('ADMIN')">	
	
	<h2>
		<spring:message code="administrator.annotationsGym" />
	</h2>
	<display:table name="annotationsGym" id="annotationsGym" pagesize="5" requestURI="${requestURI}" class="displaytag">
			<spring:message code="administrator.avg" var="avg"/>
			<spring:message code="administrator.ds" var="ds"/>
			<display:column title="${avg}">
				<h3> <jstl:out value="${annotationsGym[0]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${annotationsGym[1]}" /> </h3> 
			</display:column>
		</display:table>	
	<br>
	
	<h2>
		<spring:message code="administrator.annotationsActivity" />
	</h2>
	<display:table name="annotationsActivity" id="annotationsActivity" pagesize="5" requestURI="${requestURI}" class="displaytag">
			<spring:message code="administrator.avg" var="avg"/>
			<spring:message code="administrator.ds" var="ds"/>
			<display:column title="${avg}">
				<h3> <jstl:out value="${annotationsActivity[0]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${annotationsActivity[1]}" /> </h3> 
			</display:column>
		</display:table>	
	<br>
	
	<h2>
		<spring:message code="administrator.annotationsTraining" />
	</h2>
	<display:table name="annotationsTraining" id="annotationsTraining" pagesize="5" requestURI="${requestURI}" class="displaytag">
			<spring:message code="administrator.avg" var="avg"/>
			<spring:message code="administrator.ds" var="ds"/>
			<display:column title="${avg}">
				<h3> <jstl:out value="${annotationsTraining[0]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${annotationsTraining[1]}" /> </h3> 
			</display:column>
		</display:table>	
	<br>
	
	<h2>
		<spring:message code="administrator.socialidentitiesTrainer" />
	</h2>
	<display:table name="socialidentitiesTrainer" id="socialidentitiesTrainer" pagesize="5" requestURI="${requestURI}" class="displaytag">
			<spring:message code="administrator.min" var="min"/>
			<spring:message code="administrator.avg" var="avg"/>
			<spring:message code="administrator.max" var="max"/>
			<display:column title="${avg}">
				<h3> <jstl:out value="${socialidentitiesTrainer[0]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${socialidentitiesTrainer[1]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${socialidentitiesTrainer[2]}" /> </h3> 
			</display:column>
		</display:table>	
	<br>

</security:authorize>