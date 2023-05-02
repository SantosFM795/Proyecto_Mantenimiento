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

<form:form action="trainer/administrator/edit.do" modelAttribute="trainer">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="name">
		<spring:message code="trainer.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />

	<form:label path="surname">
		<spring:message code="trainer.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br />

	<form:label path="workExperience">
		<spring:message code="trainer.cv.workExperience" />:
	</form:label>
	<form:input path="workExperience" />
	<form:errors cssClass="error" path="workExperience" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="trainer.save" />" />&nbsp; 
	<jstl:if test="${trainer.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="trainer.delete" />"
			onclick="return confirm('<spring:message code="trainer.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="trainer.cancel" />"
		onclick="javascript: relativeRedir('trainer/administrator/list.do');" />
	<br />

	<%-- Se debe a�adir un script de control, revisar acme-Certifications --%>
</form:form>