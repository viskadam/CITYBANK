<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/cust-navigation.jspf"%>
<%@ include file="common/footer.jspf"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Change Password</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
  
  
  <script type="text/javascript">
  
  function myvalidate(){
	  
	  
	  var pass=document.validate.password.value;
	  var confirmpass=document.validate.confirmpassword.value;
	  
	  if(pass != confirmpass){
		  alert("The Passwords are not matching, Please re-enter them again!!")
		  return false;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  </script>
  

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin" name="validate">
         <h4 style="color:#FE3616;"> ${mail} </h4>
        
            <h3 class="form-signin-heading">Please Enter you new Password </h3>
            <div class="row">
             <div class="col-sm-4 col-sm-offset-4" >
            
            
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <h3>Enter you email Id</h3>
                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                                autofocus="true"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
             </spring:bind>
             
          

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <h3>Enter your new password</h3>
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"> </form:errors>
                </div>
            </spring:bind>
            
            
            
            
         
              </div>
            
            </div>
           
			<div class="row">
             <div class="col-sm-4 col-sm-offset-4">

			<button class="btn btn-lg btn-primary btn-block" type="submit" name="action" onClick="return myvalidate();">Submit</button>
           <!--   <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button> -->
           
          
           </div>
           </div>
            
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>