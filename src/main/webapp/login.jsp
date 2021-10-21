<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/cust-navigation.jspf"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in with your account</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
    href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
</head>

<body>

    <div class="container">
        <form:form method="POST" action="${contextPath}/login" modelAttribute="acct"  class="form-signin">
            <h2 class="form-heading">Log in</h2>

            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <br>
                <p>ENTER USERNAME</p>
                <input name="username" type="text"
                    class="form-control" placeholder="Username" autofocus="true" />
                    <br>
                    <p>ENTER PASSWORD</p>
                    <input
                    name="password" type="password" class="form-control"
                    placeholder="Password" />
                <span>${error}</span>
                <br><br><input
                    type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <button class="btn btn-lg btn-primary btn-block" type="submit">Log
                    In</button>
                
            </div>
        </form:form>
        <a href="/forgot">Forgot Password</a>
    </div>

</body>
</html>
