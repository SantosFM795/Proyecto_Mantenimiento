<%--
 * header.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Acme Gym Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="manager/administrator/list.do"><spring:message code="master.page.administrator.manager" /></a></li>
					<li><a href="administrator/action-2.do"><spring:message code="master.page.administrator.board" /></a></li>	
					<li><a href="administrator/edit.do"><spring:message code="master.page.administrator.edit" /></a></li>				
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="activity/customer/list.do"><spring:message code="master.page.customer.activities" /></a></li>
					<li><a href="training/customer/list.do"><spring:message code="master.page.customer.trainings" /></a></li>
					<li><a href="gym/customer/list.do"><spring:message code="master.page.customer.gyms" /></a></li>			
					<li><a href="customer/edit.do"><spring:message code="master.page.customer.edit" /></a></li>
					<li><a href="annotation/customer/create.do"><spring:message code="master.page.customer.annotations" /></a></li>
					<li><a href="activity/customer/search.do"><spring:message code="master.page.customer.search" /></a></li>
					<li><a href="training/customer/search.do"><spring:message code="master.page.customer.searchTraining" /></a></li>													
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('MANAGER')">
			<li><a class="fNiv"><spring:message	code="master.page.manager" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="gym/manager/list.do"><spring:message code="master.page.manager.gyms" /></a></li>
					<li><a href="activity/manager/list.do"><spring:message code="master.page.manager.activities" /></a></li>
					<li><a href="training/manager/list.do"><spring:message code="master.page.manager.trainings" /></a></li>
					<li><a href="trainer/manager/list.do"><spring:message code="master.page.manager.trainers" /></a></li>
					<li><a href="manager/edit.do"><spring:message code="master.page.manager.edit" /></a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('TRAINER')">
			<li><a class="fNiv"><spring:message	code="master.page.trainer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="cv/trainer/edit.do"><spring:message code="master.page.trainer.editcv" /></a></li>
					<li><a href="trainer/edit.do"><spring:message code="master.page.trainer.edit" /></a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv"><spring:message	code="master.page.noLogin" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="gym/list.do"><spring:message code="master.page.gym.list" /></a></li>
					<li><a href="activity/list.do"><spring:message code="master.page.activities" /></a></li>
					<li><a href="training/list.do"><spring:message code="master.page.trainings" /></a></li>
					<li><a href="security/login.do"><spring:message code="master.page.login" /></a></li>
				</ul>
			</li>
			
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>				
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

