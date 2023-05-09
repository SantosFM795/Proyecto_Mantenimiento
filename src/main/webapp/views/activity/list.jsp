

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
	name="activities" requestURI="${requestURI}" id="row">
	
	<spring:message code="activity.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}" sortable="true"/>
	
	<spring:message code="activity.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<spring:message code="activity.day" var="dayHeader"/>
	<display:column property="day" title="${dayHeader}" sortable="true"/>
	
	<!-- Action links -->

	<!--<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="activity/administrator/edit.do?activityId=${row.id}"> <spring:message
					code="activity.edit" />
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<div>
			<a href="activity/administrator/create.do"> <spring:message
					code="activity.create" />
			</a>
		</div>
	</security:authorize> -->

</display:table>