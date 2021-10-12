<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="common/header.jspf"%>
<%@ include file="common/menu.jsp"%>

<%@ include file="common/footer.jspf"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details and Kyc Details</title>
</head>
<body bgcolor="cyan" >
<img src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9ihqwj9DZQZUVcXDfvA1OUhHMeG1Y-IvNHg&usqp=CAU"  align="right" height="350" width="350"/>


<h1>CUSTOMER DETAILS</h1>

<h2>Welcome ${pageContext.request.userPrincipal.name} </h2> 



<h3>Account Number:  ${acct}</h3>


</body>
</html>






