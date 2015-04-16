<%@ page import="taller3.File" %>



<div class="fieldcontain ${hasErrors(bean: fileInstance, field: 'fileType', 'error')} required">
	<label for="fileType">
		<g:message code="file.fileType.label" default="File Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fileType" pattern="${fileInstance.constraints.fileType.matches}" required="" value="${fileInstance?.fileType}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fileInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="file.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="content" name="content" />

</div>

<div class="fieldcontain ${hasErrors(bean: fileInstance, field: 'size', 'error')} required">
	<label for="size">
		<g:message code="file.size.label" default="Size" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="size" value="${fieldValue(bean: fileInstance, field: 'size')}" required=""/>

</div>

