<%--
 * edit.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="cv/trainer/edit.do" modelAttribute="cv">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="name">
		<spring:message code="cv.nameCv" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />

	<form:label path="formation">
		<spring:message code="cv.formation" />:
	</form:label>
	<form:input path="formation" />
	<form:errors cssClass="error" path="formation" />
	<br />

	<form:label path="workExperience">
		<spring:message code="cv.workExperience" />:
	</form:label>
	<form:input path="workExperience" />
	<form:errors cssClass="error" path="workExperience" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="cv.save" />" />&nbsp; 
	<jstl:if test="${cv.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="cv.delete" />"
			onclick="return confirm('<spring:message code="cv.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="cv.cancel" />"
		onclick="javascript: relativeRedir('cv/administrator/list.do');" />
	<br />
	
	<%-- !! Quien lista/controla la vista de listar cv --%>
	<%-- Se debe añadir un script de control, revisar acme-Certifications --%>
</form:form>
