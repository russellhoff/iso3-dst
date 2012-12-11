<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.lecturersubjects.addmark"/></h1>
	<br/>
	
	
	
	<table class="borderAll">
	    <tr>
	        <th><s:text name="label.allsubjectmarks.dni"/></th>
	        <th><s:text name="label.allsubjectmarks.name"/></th>
	        <th><s:text name="label.allsubjectmarks.tfno"/></th>
	    </tr>
	    <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
			<td class="nowrap"><s:property value="student.dni"/></td>
			<td class="nowrap"><s:property value="student.nombre"/></td>
			<td class="nowrap"><s:property value="student.telefono"/></td>
		</tr>	
	</table>
	<br/><br/>
	<table class="borderAll">
		<tr>
			<th><s:text name="label.studentsubjects.code"/></th>
	        <th><s:text name="label.studentsubjects.name"/></th>
	        <th><s:text name="label.studentsubjects.credits"/></th>
	        <th><s:text name="label.studentsubjects.lecturer"/></th>
	        <th><s:text name="label.studentsubjects.studentnr"/></th>
		<tr>		
	    <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	        <td class="nowrap"><s:property value="subject.codigo"/></td>
	        <td class="nowrap"><s:property value="subject.nombre"/></td>
	        <td class="nowrap"><s:property value="subject.creditos"/></td>
	        <td class="nowrap"><s:property value="lecturer.nombre"/></td>
	        <td class="nowrap">
				<s:property value="%{subject.alumnos.size()}"/>
			</td>
	    </tr>

	</table>
	<br/><br/>
	<s:form action="doMarks!saveMark" method="POST">
		<s:hidden name="subjectID" value="%{subjectID}"/>
		<s:hidden name="studentDni" value="%{studentDni}"/>
		<s:textfield name="concept" label="%{getText('label.subjectmarks.concept')}"/>
		<s:textfield name="mark" label="%{getText('label.subjectmarks.mark')}"/>
		<s:submit
			value="%{getText('label.submit')}"
		/>
	</s:form>

	<s:form action="doMarks!returnFromEvaluationListing" method="post">
	<s:submit
		value="%{getText('label.cancel')}"
	/>
	</s:form>
		
		
	<br/>
	<s:actionerror />
	<s:actionmessage />		
		
</body>
</html>