<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.subjectmarks.title"/> <s:property value="studentName"/> (<s:property value="studentDni"/>)</h1>
	<br/>
	
	<!-- voy por aquí -->
	<table>
		<s:form method="post" action="doSubject!returnFromEvaluationListing">
			<s:submit value="%{getText('label.cancel')}" />
		</s:form>
	</table>
	
	
	<table>
		<s:form method="post" action="doSubject!returnFromEvaluationListing">
			<s:submit value="%{getText('label.cancel')}" />
		</s:form>
	</table>
		
	<br/>
	<s:actionerror />
	<s:actionmessage />		
		
</body>
</html>