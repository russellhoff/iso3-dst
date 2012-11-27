<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.subjectmarks.title"/> "<s:property value="studentName"/>" (<s:property value="studentDni"/>)</h1>
	<br/>
	<table class="borderAll">
		<tr>
	        <th><s:text name="label.allsubjectmarks.dni"/></th>
	        <th><s:text name="label.studentsubjects.name"/></th>
	        <th><s:text name="label.allsubjectmarks.tfno"/></th>
	    </tr>
	    <tr>
	    	<td><s:property value="student.dni"/></td>	
	    	<td><s:property value="student.nombre"/></td>
	    	<td><s:property value="student.telefono"/></td>		
	    </tr>
	</table>
	<br/>
	<table class="borderAll">
		<tr>
	        <th><s:text name="label.subjectmarks.name"/></th>
	        <th><s:text name="label.subjectmarks.id"/></th>
	        <th><s:text name="label.subjectmarks.concept"/></th>
	        <th><s:text name="label.subjectmarks.mark"/></th>
	    </tr>
	    <s:iterator value="listaEvaluaciones" status="status">
	        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	            <td class="nowrap"><s:property value="asignatura.nombre"/></td>
	            <td class="nowrap"><s:property value="id"/></td>
	            <td class="nowrap"><s:property value="concepto"/></td> 
	            <td class="nowrap"><s:property value="nota"/></td> 
	        </tr>
	    </s:iterator>
	    
	</table>
	
	<s:actionerror />
	<s:actionmessage />	
	
	<table>
		<s:form method="post" action="doSubject!returnFromEvaluationListing">
			<s:submit value="%{getText('label.cancel')}" />
		</s:form>
	</table>
		
</body>
</html>