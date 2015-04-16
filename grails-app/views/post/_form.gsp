<%@ page import="taller3.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="post.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="topic" maxlength="50" required="" value="${postInstance?.topic}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'lastupdate', 'error')} required">
	<label for="lastupdate">
		<g:message code="post.lastupdate.label" default="Lastupdate" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastupdate" precision="day"  value="${postInstance?.lastupdate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'itsAllowed', 'error')} ">
	<label for="itsAllowed">
		<g:message code="post.itsAllowed.label" default="Its Allowed" />
		
	</label>
	<g:checkBox name="itsAllowed" value="${postInstance?.itsAllowed}" />

</div>

