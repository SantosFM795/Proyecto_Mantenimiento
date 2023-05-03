

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
	name="cv" requestURI="${requestURI}" id="row">
	
	<display:column property="name" titleKey="cv.nameCv"/>
	<display:column property="formation" titleKey="cv.formation"/>
	<display:column property="workExperience" titleKey="cv.workExperience"/>
	
	<!-- Action links -->
		<%-- Aqui debería ser entrenador en lugar de admin --%>
	<security:authorize access="hasRole('TRAINER')">
		<display:column>
			<a href="cv/trainer/edit.do?cvId=${row.id}"> <spring:message
					code="cv.edit" />
			</a>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<div>
			<a href="cv/administrator/create.do"> <spring:message
					code="cv.create" />
			</a>
		</div>
	</security:authorize>

</display:table>