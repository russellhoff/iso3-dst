<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.subjectunits.title"/>: <s:property value="%{subject.getNombre()}" /> - <s:property value="lecturerName"/> (<s:property value="lecturerDni"/>)</h1>
	<br/>
	<table class="borderAll">
		<tr>
	        <th><s:text name="label.subjectunits.id"/></th>
	        <th><s:text name="label.subjectunits.acronym"/></th>
	        <th><s:text name="label.subjectunits.title"/></th>
	        <th><s:text name="label.subjectunits.content"/></th>
	    </tr>
	    <s:iterator value="listaUnidades" status="status">
	        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
	            <td class="nowrap"><s:property value="id"/></td>
	            <td class="nowrap"><s:property value="acronimo"/></td>
	            <td class="nowrap"><s:property value="titulo"/></td>
	            <td class="nowrap"><s:property value="contenido"/></td>
	        </tr>
	    </s:iterator>
	</table>
	<br/>
	<s:actionerror />
	<s:actionmessage />	
	
	<table>
		<s:form method="post" action="doSubjectLecturer!returnFromEvaluationListing">
			<s:submit value="%{getText('label.cancel')}" />
		</s:form>
	</table>
		
</body>
</html>