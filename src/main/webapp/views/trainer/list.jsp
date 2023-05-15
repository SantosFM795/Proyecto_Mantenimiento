

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
	name="trainers" requestURI="${requestURI}" id="row">
	
	<spring:message code="trainer.name" var="trainerHeader"/>
	<display:column property="name" title="${trainerHeader}" sortable="true"/>
	
	<spring:message code="trainer.lastName" var="lastNameHeader"/>
	<display:column property="lastName" title="${lastNameHeader}" sortable="true"/>
	
	<spring:message code="trainer.cv.workExperience" var="workExperienceHeader"/>
	<display:column property="curriculum.workExperience" title="${workExperienceHeader}" sortable="true"/>
	
	
</display:table>

<security:authorize access="hasRole('MANAGER')">
		<div>
			<a href="trainer/manager/create.do"> <spring:message
					code="trainer.create" />
			</a>
			<a href="trainer/manager/search.do"> <spring:message
					code="search.search" />
			</a>
		</div>
	</security:authorize>