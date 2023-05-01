

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

	<display:column property="name" titleKey="gym.nameGym" />
	<display:column property="address" titleKey="gym.address" />
	<display:column property="mensualCost" titleKey="gym.mensualCost" />

	<!-- Action links -->

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="gym/administrator/edit.do?gymId=${row.id}"> <spring:message
					code="gym.edit" />
			</a>
		</display:column>
	</security:authorize>

</display:table>
<%-- 	 Check 
	<security:authorize access="hasRole('ADMIN')">
		<div>
			<a href="gym/administrator/create.do"> <spring:message
					code="gym.create" />
			</a>
		</div>
	</security:authorize>
 --%>