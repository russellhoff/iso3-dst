<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.lecturersubjects.subjectlist"/> <s:text name="label.lecturersubjects.lecturer"/> <s:property value="lecturerName"/> (<s:property value="lecturerDni"/>)</h1>
	<br/>
	
	<s:url id="urlLogout" action="showLogin" escapeAmp="false"/>
	<a href="<s:property value="#urlLogout"/>"><s:text name="label.logout"/></a>
	
	<table class="borderAll">
		<tr>
			<th><s:text name="label.studentsubjects.code"/></th>
	        <th><s:text name="label.studentsubjects.name"/></th>
	        <th><s:text name="label.studentsubjects.credits"/></th>
	        <th><s:text name="label.studentsubjects.lecturer"/></th>
	        <th><s:text name="label.studentsubjects.unitlist"/></th>
	        <th><s:text name="label.studentsubjects.studentnr"/></th>
	        <th>&nbsp;&nbsp;</th>
		<tr>
		<s:iterator value="listaAsignaturas" status="status">
	        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	            <td class="nowrap"><s:property value="codigo"/></td>
	            <td class="nowrap"><s:property value="nombre"/></td>
	            <td class="nowrap"><s:property value="creditos"/></td>
	            <td class="nowrap"><s:property value="%{profesor.getNombre()}"/></td>
	            <td class="nowrap">
	           		<s:url id="listaUnidadesActual" action="doSubjectLecturer!showUnitListLecturer">
	           			<s:param name="subjectID" value="%{id}" />
	           		</s:url>
					<s:a href="%{listaUnidadesActual}"><s:text name="%{unidades.size()}"/></s:a>
				</td>
	            <td class="nowrap">
					<s:property value="%{alumnos.size()}"/>
				</td>
				<td class="nowrap">
					<s:url id="verEstudiantes" action="doListLecturerSubjects!showStudents">
		           		<s:param name="subjectID" value="%{id}" />
	           		</s:url>
					<s:a href="%{verEstudiantes}"><s:text name="label.lecturersubjects.showstudents"/></s:a>
				</td>
	        </tr>
	    </s:iterator>
	</table>

	<s:actionerror />
	<s:actionmessage />	
	
</body>
</html>
