<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.lecturersubjects.markstudents"/> <s:text name="label.lecturersubjects.lecturer"/> "<s:property value="lecturerName"/>" <s:text name="label.lecturersubjects.subject"/> "<s:property value="subjectName"/>"</h1>
	<br/>
	
	
	<table class="borderAll">
		<tr>
			<th><s:text name="label.allsubjectmarks.dni"/></th>
	        <th><s:text name="label.allsubjectmarks.name"/></th>
	        <th><s:text name="label.allsubjectmarks.tfno"/></th>
	        <th><s:text name="label.subjectmarks.id"/></th>
	        
		<tr>
		<s:iterator value="listaAlumnos" status="status">
	        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	            <td class="nowrap"><s:property value="dni"/></td>
	            <td class="nowrap"><s:property value="nombre"/></td>
	            <td class="nowrap"><s:property value="telefono"/></td>
				<td class="nowrap">
					<s:url id="nota" action="doMarks!addMark">
		           		<s:param name="studentDni" value="%{dni}" />
	           		</s:url>
					<s:a href="%{nota}"><s:text name="label.lecturersubjects.addmark"/></s:a>
				</td>
	        </tr>
	    </s:iterator>
	</table>

	<s:actionerror />
	<s:actionmessage />	
	
	<table>
		<s:form method="post" action="doSubjectLecturer!returnFromEvaluationListing">
			<s:submit value="%{getText('label.cancel')}" />
		</s:form>
	</table>
	
</body>
</html>
