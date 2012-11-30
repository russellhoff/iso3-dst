<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.subjectregistration.title"/> <s:property value="studentName"/> (<s:property value="studentDni"/>)</h1>
	<br/>
	
	
	<!-- FORMULARIO DE ENVIAR/ACEPTAR DATOS -->
	<table>
		<s:form method="post" action="doListStudentSubjects!matricularseEnAsignatura">
		
			<s:select list="listaAsignaturasNoMatriculadas" name="subjectId" listKey="id" listValue="nombre" label="%{getText('label.subjectregistration.selectsubject')}" />
						
			<s:submit value="%{getText('label.submit')}" />
		</s:form>
	</table>
	
	<!-- CANCELAR FORMULARIO Y VOLVER ATRÁS -->
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