

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

	<%--------------------------- Roles -----------------------------------%>

	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="gym/manager/edit.do?gymId=${row.id}"> <spring:message
					code="gym.edit" />
			</a>
		</display:column>
	</security:authorize>

	<%-- Main Information --%>
	<spring:message code="gym.logo" var="logoHeader" />
	<display:column property="logo" title="${logoHeader}" />

	<spring:message code="gym.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" />

	<spring:message code="gym.address" var="addressHeader" />
	<display:column property="address" title="${addressHeader}" />

	<spring:message code="gym.mensualCost" var="mensualCostHeader" />
	<display:column property="mensualCost" title="${mensualCostHeader}" />


	<display:column>
		<a href="activity/listByGym.do?gymId=${row.id}"> <spring:message
				code="gym.listActivities" />
		</a>
	</display:column>





	<%--------------------------- Roles -----------------------------------%>
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column>
		<jstl:choose>
			<jstl:when test="${aux==0}">
				<a href="gym/customer/quit.do?gymId=${row.id}"> <spring:message
						code="gym.quit" />
				</a>
			</jstl:when>
			
			<jstl:when test="${aux==1}">
				<a href="gym/customer/join.do?gymId=${row.id}"> <spring:message
						code="gym.join" />
				</a>
			</jstl:when>
			
		</jstl:choose>
		</display:column>
	</security:authorize>

	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="activity/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addActivity" />
			</a>
		</display:column>
	</security:authorize>


	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="training/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addTraining" />
			</a>
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<a href="trainer/manager/listToAdd.do?gymId=${row.id}"> <spring:message
					code="gym.addTrainer" />
			</a>
		</display:column>
	</security:authorize>


	<!-- Action links -->
	<security:authorize access="hasRole('MANAGER')">
		<display:column>
			<jstl:choose>
				<jstl:when test="${row.active==true}">
					<a href="gym/manager/desactivate.do?gymId=${row.id}"> <spring:message
							code="gym.desactivate" />
					</a>
				</jstl:when>
				<jstl:otherwise>
					<a href="gym/manager/activate.do?gymId=${row.id}"> <spring:message
							code="gym.activate" />
					</a>
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
	</security:authorize>
	
	<display:column>
		<a href="annotation/listGym.do?gymId=${row.id}">
			<spring:message code="gym.listAnnotation"/>
		</a>
	</display:column>

</display:table>

<security:authorize access="hasRole('CUSTOMER')">
	<div>
		<a href="gym/customer/listToJoin.do"> <spring:message code="gym.listToJoin" />
		</a>
	</div>
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
	<div>
		<a href="gym/manager/create.do"> <spring:message code="gym.create" />
		</a>
	</div>
</security:authorize>
