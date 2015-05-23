<%@ page import="taller3.Admin" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<title>Perfil de Usuario</title>
</head>
<body>

<div id="show-admin" class="content scaffold-show" role="main">
	<h1>PERFIL DE USUARIO</h1>
	<ol class="property-list admin">

		<li class="fieldcontain">
			<span id="username-label" class="property-label">Tipo de Usuario</span>
			<g:if test = "${session.user?.class.name.equals("taller3.Admin")}">
				<span class="property-value" aria-labelledby="username-label">Administrador</span>
			</g:if>
			<g:else>
				<span class="property-value" aria-labelledby="username-label">Regular</span>
			</g:else>

		</li>

		<g:if test="${session.user?.username}">
			<li class="fieldcontain">
				<span id="username-label" class="property-label"><g:message code="admin.username.label" default="Nombre de usuario" /></span>

				<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${session.user}" field="username"/></span>

			</li>
		</g:if>

		<g:if test="${session.user?.name}">
			<li class="fieldcontain">
				<span id="name-label" class="property-label"><g:message code="admin.name.label" default="Nombres" /></span>

				<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${session.user}" field="name"/></span>

			</li>
		</g:if>

		<g:if test="${session.user?.lastname}">
			<li class="fieldcontain">
				<span id="lastname-label" class="property-label"><g:message code="admin.lastname.label" default="Apellidos" /></span>

				<span class="property-value" aria-labelledby="lastname-label"><g:fieldValue bean="${session.user}" field="lastname"/></span>

			</li>
		</g:if>

		<g:if test="${session.user?.age}">
			<li class="fieldcontain">
				<span id="age-label" class="property-label"><g:message code="admin.age.label" default="Edad" /></span>

				<span class="property-value" aria-labelledby="age-label"><g:fieldValue bean="${session.user}" field="age"/></span>

			</li>
		</g:if>

		<g:if test="${session.user?.class.name.equals("taller3.Admin")}">

			<g:if test="${session.user?.level}">
				<li class="fieldcontain">
					<span id="level-label" class="property-label"><g:message code="admin.level.label" default="Nivel" /></span>

					<span class="property-value" aria-labelledby="level-label"><g:fieldValue bean="${session.user}" field="level"/></span>

				</li>
			</g:if>

			<g:if test="${session.user?.rating}">
				<li class="fieldcontain">
					<span id="rating-label" class="property-label"><g:message code="admin.rating.label" default="Rango" /></span>

					<span class="property-value" aria-labelledby="rating-label"><g:fieldValue bean="${session.user}" field="rating"/></span>

				</li>
			</g:if>

		</g:if>
		<g:else>

			<g:if test="${session.user?.postViews}">
				<li class="fieldcontain">
					<span id="postViews-label" class="property-label"><g:message code="regular.postViews.label" default="Vistas de Post" /></span>

					<span class="property-value" aria-labelledby="postViews-label"><g:fieldValue bean="${session.user}" field="postViews"/></span>

				</li>
			</g:if>

			<g:if test="${session.user?.strikesNumber}">
				<li class="fieldcontain">
					<span id="strikesNumber-label" class="property-label"><g:message code="regular.strikesNumber.label" default="Strikes" /></span>

					<span class="property-value" aria-labelledby="strikesNumber-label"><g:fieldValue bean="${session.user}" field="strikesNumber"/></span>

				</li>
			</g:if>

			<g:if test="${session.user?.starsNumber}">
				<li class="fieldcontain">
					<span id="starsNumber-label" class="property-label"><g:message code="regular.starsNumber.label" default="Numero de estrellas" /></span>

					<span class="property-value" aria-labelledby="starsNumber-label"><g:fieldValue bean="${session.user}" field="starsNumber"/></span>

				</li>
			</g:if>

		</g:else>

	</ol>
</div>
</body>
</html>
