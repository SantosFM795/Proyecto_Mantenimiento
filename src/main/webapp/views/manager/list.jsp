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
	name="customers" requestURI="${requestURI}" id="row">
	
	<display:column property="name" titleKey="manager.name"/>
	<display:column property="surname" titleKey="manager.surname"/>
	
	<!-- Action links -->

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="manager/administrator/edit.do?managerId=${row.id}"> <spring:message
					code="manager.edit" />
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<div>
			<a href="manager/administrator/create.do"> <spring:message
					code="manager.create" />
			</a>
		</div>
	</security:authorize>

</display:table>