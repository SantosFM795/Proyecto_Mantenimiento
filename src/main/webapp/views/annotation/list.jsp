

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


<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="annotations" requestURI="${requestURI}" id="row">
	
	<spring:message code="annotation.datesend" var="titleHeader"/>
	<display:column property="date_send" title="${titleHeader}" sortable="true"/>
	
	<spring:message code="annotation.text" var="descriptionHeader"/>
	<display:column property="text" title="${descriptionHeader}" sortable="false"/>
	
	<spring:message code="annotation.rating" var="dayHeader"/>
	<display:column property="rating" title="${dayHeader}" sortable="true"/>
	
		
	<!-- Action links -->


</display:table>

	<security:authorize access="isAuthenticated()">
		<div>
			<a href="annotation/edit.do"> <spring:message
					code="annotation.create" />
			</a>
		</div>
	</security:authorize>