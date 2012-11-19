<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.studentsubjects.subject"/> <s:text name="label.studentsubjects.student"/> <s:property value="studentName"/> (<s:property value="studentDni"/>)</h1>
	<br/>
	<table>
		<tr>
			<td>
				<s:url id="matricularseEnAsignatura" action="doListStudentSubjects!formularioMatricularseNuevaAsignatra" escapeAmp="false"/>
				<a href="matricularseEnAsignatura"><s:text name="label.studentsubjects.enroll"/></a>
			</td>
			<td>
				<s:url id="consultarTodasNotas" action="showLogin" escapeAmp="false"/>
				<a href="consultarTodasNotas"><s:text name="label.studentsubjects.showfullmarks"/></a>
			</td>
			<td>
				<s:url id="urlLogout" action="showLogin" escapeAmp="false"/>
				<a href="<s:property value="#urlLogout"/>"><s:text name="label.logout"/></a>
			</td>
		</tr>
	</table>
	<br/>
		
	<table class="borderAll">
	    <tr>
	        <th><s:text name="label.studentsubjects.code"/></th>
	        <th><s:text name="label.studentsubjects.name"/></th>
	        <th><s:text name="label.studentsubjects.credits"/></th>
	        <th><s:text name="label.studentsubjects.lecturer"/></th>
	        <th><s:text name="label.studentsubjects.unitlist"/></th>
	        <th><s:text name="label.studentsubjects.studentnr"/></th>
	        <th>&nbsp;&nbsp;</th>
	        <th>&nbsp;&nbsp;</th>
	    </tr>
	    <s:iterator value="listaAsignaturasMatriculadas" status="status">
	        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	            <td class="nowrap"><s:property value="codigo"/></td>
	            <td class="nowrap"><s:property value="nombre"/></td>
	            <td class="nowrap"><s:property value="creditos"/></td>
	            <td class="nowrap"><s:property value="%{profesor.getNombre()}"/></td>
	            <td class="nowrap">
	           		<s:url id="listaUnidadesActual" action="doSubject!ShowSubjectUnits">
	           			<s:param name="subjectID" value="%{id}" />
	           		</s:url>
					<s:a href="%{listaUnidadesActual}"><s:text name="%{unidades.size()}"/></s:a>
				</td>
	            <td class="nowrap">
					<s:property value="%{alumnos.size()}"/>
				</td>
				<td class="nowrap">
					<s:url id="desmatricular" action="doListEnrolledSubjects!unEnroll">
	           			<s:param name="subjectID" value="%{id}" />
	           		</s:url>
					<s:a href="%{desmatricular}"><s:text name="label.studentsubjects.unenroll"/></s:a>
				</td>
				<td class="nowrap">
					<s:url id="mostrarNotas" action="doSubject">
		           		<s:param name="subjectID" value="%{id}" />
		           		<s:param name="studentDNI" value="%{student.dni}" />
	           		</s:url>
					<s:a href="%{mostrarNotas}"><s:text name="label.studentsubjects.showmarks"/></s:a>
				</td>
	        </tr>
	    </s:iterator>
	</table>
	
	<s:actionerror />
	<s:actionmessage />	
		
</body>
</html>
