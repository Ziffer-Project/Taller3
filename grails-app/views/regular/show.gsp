
<%@ page import="taller3.Regular" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regular.label', default: 'Regular')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-regular" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-regular" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list regular">
			
				<g:if test="${regularInstance?.strikesNumber}">
				<li class="fieldcontain">
					<span id="strikesNumber-label" class="property-label"><g:message code="regular.strikesNumber.label" default="Strikes Number" /></span>
					
						<span class="property-value" aria-labelledby="strikesNumber-label"><g:fieldValue bean="${regularInstance}" field="strikesNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${regularInstance?.starsNumber}">
				<li class="fieldcontain">
					<span id="starsNumber-label" class="property-label"><g:message code="regular.starsNumber.label" default="Stars Number" /></span>
					
						<span class="property-value" aria-labelledby="starsNumber-label"><g:fieldValue bean="${regularInstance}" field="starsNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${regularInstance?.postViews}">
				<li class="fieldcontain">
					<span id="postViews-label" class="property-label"><g:message code="regular.postViews.label" default="Post Views" /></span>
					
						<span class="property-value" aria-labelledby="postViews-label"><g:fieldValue bean="${regularInstance}" field="postViews"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:regularInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${regularInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
