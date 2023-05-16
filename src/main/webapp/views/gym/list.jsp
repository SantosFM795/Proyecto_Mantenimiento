

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
	name="gyms" requestURI="${requestURI}" id="row">

	<%--------------------------- Roles -----------------------------------%>

	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="gym/manager/edit.do?gymId=${row.id}"> <spring:message
					code="gym.edit" />
			</a>
		</display:column>
	</security:authorize>

	<%-- Main Information --%>
	<spring:message code="gym.logo" var="logoHeader" />
	<display:column property="logo" title="${logoHeader}" />

	<spring:message code="gym.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" />

	<spring:message code="gym.address" var="addressHeader" />
	<display:column property="address" title="${addressHeader}" />

	<spring:message code="gym.mensualCost" var="mensualCostHeader" />
	<display:column property="mensualCost" title="${mensualCostHeader}" />


	<display:column>
		<a href="activity/listByGym.do?gymId=${row.id}"> <spring:message
				code="gym.listActivities" />
		</a>
	</display:column>





	<%--------------------------- Roles -----------------------------------%>

	<security:authorize access="isAnonymous()">
		<spring:message code="gym.annotation" var="stepHeader" />
		<display:column>
			<a href="annotation/list.do?gymId=${row.id}"> <spring:message
					code="gym.showAnnotations" />
			</a>
		</display:column>
	</security:authorize>
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="activity/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addActivity" />
			</a>
		</display:column>
	</security:authorize>


	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="training/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addTraining" />
			</a>
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="trainer/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addTrainer" />
			</a>
		</display:column>
	</security:authorize>


	<!-- Action links -->
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<jstl:choose>
				<jstl:when test="${row.active==true}">
					<a href="gym/manager/desactivate.do?gymId=${row.id}"> <spring:message
							code="gym.desactivate" />
					</a>
				</jstl:when>
				<jstl:otherwise>
					<a href="gym/manager/activate.do?gymId=${row.id}"> <spring:message
							code="gym.activate" />
					</a>
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
	</security:authorize>

</display:table>

<security:authorize access="hasRole('MANAGER')">
	<div>
		<a href="gym/manager/create.do"> <spring:message code="gym.create" />
		</a>
	</div>
</security:authorize>
