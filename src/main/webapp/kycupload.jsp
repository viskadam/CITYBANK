<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h1 >Welcome to KYC page of City Bank</h1>
<h3 >Please upload aadhar card photo to complete your KYC process</h3>

<form action="${contextPath}/upload" method="post" enctype="multipart/form-data">
Select File:
<input type="file" name="image" accept="image/png"/>

<a type="button" class="btn btn-success"
        href="/confirm?id=${user.id}">confirm</a>
</form>
</body>
</html>
