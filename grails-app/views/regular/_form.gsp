<%@ page import="taller3.Regular" %>



<div class="fieldcontain ${hasErrors(bean: regularInstance, field: 'strikesNumber', 'error')} required">
	<label for="strikesNumber">
		<g:message code="regular.strikesNumber.label" default="Strikes Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="strikesNumber" from="${0..3}" class="range" required="" value="${fieldValue(bean: regularInstance, field: 'strikesNumber')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: regularInstance, field: 'starsNumber', 'error')} required">
	<label for="starsNumber">
		<g:message code="regular.starsNumber.label" default="Stars Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="starsNumber" from="${0..5}" class="range" required="" value="${fieldValue(bean: regularInstance, field: 'starsNumber')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: regularInstance, field: 'postViews', 'error')} required">
	<label for="postViews">
		<g:message code="regular.postViews.label" default="Post Views" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postViews" type="number" value="${regularInstance.postViews}" required=""/>

</div>

