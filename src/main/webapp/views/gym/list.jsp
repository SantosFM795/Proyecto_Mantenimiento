

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
	
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="gym/manager/edit.do?gymId=${row.id}"> <spring:message
					code="gym.edit" />
			</a>
		</display:column>
	</security:authorize>
	
	<spring:message code="gym.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="gym.address" var="addressHeader"/>
	<display:column property="address" title="${addressHeader}" sortable="true"/>
	
	<spring:message code="gym.mensualCost" var="mensualCostHeader"/>
	<display:column property="mensualCost" title="${mensualCostHeader}" sortable="true" />

	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="gym/manager/addActivity.do?gymId=${row.id}"> <spring:message
					code="gym.addActivity" />
			</a>
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="gym/manager/addTraining.do?gymId=${row.id}"> <spring:message
					code="gym.addTraining" />
			</a>
		</display:column>
	</security:authorize>
	<!-- Action links -->

	
</display:table>

	<security:authorize access="hasRole('MANAGER')">
		<div>
			<a href="gym/manager/create.do"> <spring:message
					code="gym.create" />
			</a>
		</div>
	</security:authorize>
