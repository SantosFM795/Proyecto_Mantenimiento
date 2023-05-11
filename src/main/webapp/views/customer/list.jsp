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
	
	<display:column property="name" titleKey="customer.name"/>
	<display:column property="lastName" titleKey="customer.lastName"/>
	<display:column property="creditCard" titleKey="customer.creditCard"/>
	
	<!-- Action links -->

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="customer/administrator/edit.do?customerId=${row.id}"> <spring:message
					code="customer.edit" />
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<div>
			<a href="customer/administrator/create.do"> <spring:message
					code="customer.create" />
			</a>
		</div>
	</security:authorize>
</display:table>