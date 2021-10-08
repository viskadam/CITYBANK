<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="common/header.jspf"%>
<%@ include file="common/footer.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan" >
<img src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9ihqwj9DZQZUVcXDfvA1OUhHMeG1Y-IvNHg&usqp=CAU"  align="right" height="350" width="350"/>
<h1 style="color:blue">Welcome to KYC page of City Bank</h1>
<h3 style="color:blue">Please upload aadhar card photo to complete your KYC process</h3>

<form action="${contextPath}/upload" method="post" enctype="multipart/form-data">  
Select File:<input type="file" name="fname"/><br/>  
<input type="file" name="image" accept="image/png"/>

<input type="submit" value="confirm"/>  
</form>  
</body>
</html>