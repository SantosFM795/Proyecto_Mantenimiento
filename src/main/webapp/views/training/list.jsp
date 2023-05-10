

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
	name="trainings" requestURI="${requestURI}" id="row">
	
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="training/manager/edit.do?trainingId=${row.id}"> <spring:message
					code="training.edit" />
			</a>
		</display:column>
	</security:authorize>
	
	<spring:message code="training.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" sortable="true" />
	<display:column property="description" titleKey="training.description"/>
</display:table>