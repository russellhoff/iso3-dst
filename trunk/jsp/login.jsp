<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	
		<s:form action="doLogin" method="POST">
			<div class="titleDiv"><s:text name="application.title"/></div>
			<h1><s:text name="label.login"/></h1>
			<br/>
			
			<tr>
				<td colspan="2">
					<s:actionerror />
					<!--<s:fielderror />-->
				</td>
			</tr>
			<s:textfield name="username" label="%{getText('label.login.name')}"/>
			
			<s:password name="password" label="%{getText('label.login.password')}"/>
			
			<s:select name="userType" list="{getText('label.login.student'), getText('label.login.lecturer')}" label="%{getText('label.login.type')}"/>
		
			<s:submit value="%{getText('label.login.button')}" align="center"/>
			
		</s:form>
		
	</body>

</html>

