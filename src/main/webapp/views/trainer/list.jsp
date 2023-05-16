

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

	<spring:message code="trainer.name" var="trainerHeader" />
	<display:column property="name" title="${trainerHeader}" />

	<spring:message code="trainer.lastName" var="lastNameHeader" />
	<display:column property="lastName" title="${lastNameHeader}" />

	<spring:message code="trainer.email" var="emailHeader" />
	<display:column property="email" title="${emailHeader}" />

	<spring:message code="trainer.phoneNumber" var="phoneNumberHeader" />
	<display:column property="phoneNumber" title="${phoneNumberHeader}" />

	<spring:message code="trainer.phoneNumber" var="phoneNumberHeader" />
	<display:column property="phoneNumber" title="${phoneNumberHeader}" />

	<spring:message code="trainer.cv.formation" var="formationHeader" />
	<display:column property="curriculum.formation"
		title="${formationHeader}" />

	<spring:message code="trainer.cv.workExperience"
		var="workExperienceHeader" />
	<display:column property="curriculum.workExperience"
		title="${workExperienceHeader}" />

	<security:authorize access="isAnonymous()">
		<spring:message code="trainer.annotation" var="annotationHeader" />
		<display:column>
			<a href="annotation/list.do?trainerId=${row.id}"> <spring:message
					code="trainer.showAnnotations" />
			</a>
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
		<jstl:if test="${gymId!=0}">
			<spring:message code="trainer.AddToGym"/>
			<display:column>
				<a href="trainer/manager/addToGym.do?trainerId=${row.id}&gymId=${gymId}">
					<spring:message code="trainer.AddToGym"/>
				</a>
			</display:column>
		</jstl:if>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
		<jstl:if test="${activityId!=0}">
			<spring:message code="trainer.AddToActivity"/>
			<display:column>
				<a href="trainer/manager/addToActivity.do?trainerId=${row.id}&activityId=${activityId}">
					<spring:message code="trainer.AddToActivity"/>
				</a>
			</display:column>
		</jstl:if>
	</security:authorize>


	<display:column>
		<a href="cv/list.do?trainerId=${row.id}">
			<spring:message code="trainer.showCV"/>
		</a>
	</display:column>
</display:table>
<%--roles --%>



<security:authorize access="hasRole('MANAGER')">
	<div id="links">
		<a href="trainer/manager/create.do"> <spring:message
				code="trainer.create" />
		</a> <a href="trainer/manager/search.do"> <spring:message
				code="search.search" />
		</a>
	</div>
</security:authorize>