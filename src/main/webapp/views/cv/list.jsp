

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
	
	<spring:message code="cv.skills" var="skillsHeader"/>
	<display:column property="skills" title="${skillsHeader}" sortable="true"/>
	
	<spring:message code="cv.formation" var="formationHeader"/>
	<display:column property="formation" title="${formationHeader}" sortable="true"/>
	
	<spring:message code="cv.workExperience" var="workExperienceHeader"/>
	<display:column property="workExperience" title="${workExperienceHeader}" sortable="true"/>
	
	
	<!-- Action links -->
		<%-- Aqui debería ser entrenador en lugar de admin --%>
	

	

</display:table>