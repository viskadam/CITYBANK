<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/cust-navigation.jspf"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
  

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" action="${contextPath}/confirmation" modelAttribute="userForm"  class="form-signin">
         <h3 style="color:#18E339; text-align:center; font-family:georgia;"> ${message}</h3>
         
             <div style="margin-left:90mm; padding:15px 0 20px 14px;">
            
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
               <label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Name :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                   <form:input type="text" path="name" class="form-control" placeholder="Name"
                                autofocus="true" readOnly="true" style="width:150%;"></form:input>
                    <form:errors path="name"></form:errors>
                    </span>
                </div>
            </spring:bind>
          
            <spring:bind path="mobile">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                 <label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Mobile :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                    <form:input type="number" path="mobile" class="form-control" placeholder="Mobile"
                                autofocus="true" id="mobilenumber" readOnly="true" style="width:150%;"></form:input>
                  <span id="messages" style="color:red;"></span>
                  </span>
                   <form:errors path="mobile"></form:errors> 
                </div>
            </spring:bind>
            
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
               <label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Email :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                                autofocus="true" readOnly="true" style="width:150%;"></form:input>
                    <form:errors path="email"></form:errors>
                    </span>
                </div>
             </spring:bind>
             
            <spring:bind path="address">
                <div class="form-group ${status.error ? 'has-error' : ''}">
              	<label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Address :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                    <form:input type="text" path="address" class="form-control" placeholder="Address"
                                autofocus="true" readOnly="true" style="width:150%;"></form:input>
                    <form:errors path="address"></form:errors>
                    </span>
                </div>
            </spring:bind>
           
             
            
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
               <label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Username :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true" readOnly="true" style="width:150%;"></form:input>
                    <form:errors path="username"></form:errors>
                    </span>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                 <label style="display: inline-block; width: 5px; white-space: nowrap; font-family: georgia; text-align:right ">Password :</label><span style="display: inline-block; padding:0 20px 0 100px;">
                    <form:input type="password" path="password" class="form-control" placeholder="Password" readOnly="true" style="width:150%;"></form:input>
                    <form:errors path="password"> </form:errors>
                    </span>
                </div>
            </spring:bind>
            
            </div>
            
             
            
           
			<div class="row">
             <div class="col-sm-4 col-sm-offset-4">

              <button style="background-color: #0295F0;  padding:8px; width:65%; margin-left:27mm;" class="btn btn-lg btn-primary btn-block" type="submit" >Confirm</button> 
           
           </div>
           </div>
            
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>