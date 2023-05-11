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
	name="managers" requestURI="${requestURI}" id="row">
	
	
	
	<!-- Action links -->

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="manager/administrator/edit.do?managerId=${row.id}"> <spring:message
					code="manager.edit" />
			</a>
		</display:column>
	</security:authorize>
	
	<spring:message code="manager.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="true" />
	
	<spring:message code="manager.lastName" var="lastNameHeader" />
	<display:column property="lastName" title="${lastNameHeader}" sortable="true" />
	
	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<jstl:choose>
				<jstl:when test="${row.banned==false}">
					<a href="manager/administrator/ban.do?managerId=${row.id}">
						<spring:message code="manager.ban"/>
					</a>
				</jstl:when>
				<jstl:otherwise>
					<a href="manager/administrator/unban.do?managerId=${row.id}">
						<spring:message code="manager.unban"/>
					</a>
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
	</security:authorize>
	
</display:table>

	

