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

<form:form action="activity/customer/search.do" modelAttribute="search">
	<form:label path="keyWord">
		<spring:message code="search.keyWord" />:
	</form:label>
	<form:input path="keyWord" />
	<form:errors cssClass="error" path="keyWord" />
	<br />
	
	<form:label path="startTime">
		<spring:message code="search.startTime" />:
	</form:label>
	<form:input path="keyWord" />
	<form:errors cssClass="error" path="startTime" />
	<br />
	
	<form:label path="endTime">
		<spring:message code="search.endTime" />:
	</form:label>
	<form:input path="endTime" />
	<form:errors cssClass="error" path="endTime" />
	<br />

	
	
	<input type="submit"
	value="<spring:message code='search.list'/>" >
</form:form>
