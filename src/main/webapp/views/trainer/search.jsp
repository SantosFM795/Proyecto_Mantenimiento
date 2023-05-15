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

<form:form action="trainer/manager/search.do" modelAttribute="search">
	<form:label path="keyWord">
		<spring:message code="search.keyWord" />:
	</form:label>
	<form:input path="keyWord" />
	<form:errors cssClass="error" path="keyWord" />
	<br />
	
	<input type="submit" name="search"
	value="<spring:message code='search.search'/>" >
</form:form>
