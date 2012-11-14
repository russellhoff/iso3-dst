<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="application.title"/></title>
	<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.studentssubjects.subject"/> <s:text name="label.studentssubjects.student"/> <s:property value="studentname"/> (<s:property value="studentdni"/>)</h1>
	<br/>
	<table>
		<tr>
			<td>
				<s:url id="urlLogout" action="showLogin" escapeAmp="false"/>
				<a href="<s:property value="#urlLogout"/>"><s:text name="label.languagedesigner.logout"/></a>
			</td>
		</tr>
	</table>
	<br/>
		
</body>
</html>
