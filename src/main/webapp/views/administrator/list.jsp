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
		<spring:message code="administrator.gymsByManager" />
	</h2>
	<display:table name="gymsByManager" id="gymsByManager" pagesize="5" requestURI="${requestURI}" class="displaytag">
			<spring:message code="administrator.min" var="min"/>
			<spring:message code="administrator.avg" var="avg"/>
			<spring:message code="administrator.max" var="max"/>
			<spring:message code="administrator.ds" var="ds"/>
			<display:column title="${min}">
				<h3> <jstl:out value="${gymsByManager[0]}" /> </h3> 
			</display:column>
			<display:column title="${avg}">
				<h3> <jstl:out value="${gymsByManager[1]}" /> </h3> 
			</display:column>
			<display:column title="${max}">
				<h3> <jstl:out value="${gymsByManager[2]}" /> </h3> 
			</display:column>
			<display:column title="${ds}">
				<h3> <jstl:out value="${gymsByManager[3]}" /> </h3> 
			</display:column>
		</display:table>	
	<br>

</security:authorize>