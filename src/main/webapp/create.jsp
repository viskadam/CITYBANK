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
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
  
  <script type="text/javascript">
  
  function myfun(){
	  
	  
	  var nam=document.myForm.name.value;
	  
	  if(nam==""){
		  alert("Name cannot be Empty!! Please Enter a name");
		  document.myForm.name.focus();
		  return false
	  }
	  
	  var mob = document.myForm.mobile.value;
	 
	  if(mob==""){
		  alert("please enter your mobile number");
		  document.myForm.mobile.focus();
		  return false;
	  }
	  if((mob.length<10)||(mob.length>10)){
		  alert("Mobile number should be of 10 digits")
		  document.myForm.mobile.focus();
		  return false;
	  }
	  
	  var enam=document.myForm.email.value;
	  
	  var at="@";
	  var dot="."
	  var lat=enam.indexOf(at)
	  var lstr=enam.length
	  var ldot=enam.indexOf(dot)
	  
	  
	
	  if ((enam.indexOf(at)==0) || (enam.indexOf(at)==lstr-1) ){
		  alert("Invalid E-mail ID")
		  return false
		  }
	  
	  if ((enam.indexOf(dot)==0) || (enam.indexOf(dot)==lstr-1) ){
		  alert("Invalid E-mail ID")
		  return false
		  }
	  
	  var pass = document.myForm.password.value;
	  if(pass="")
		  {
		  alert(" Please Enter your password");
		  document.myForm.name.focus();
		  return false
		  
		  }
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  </script>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin" name="myForm">
            <h2 class="form-signin-heading">Create your account</h2>
            <div class="row">
             <div class="col-sm-4 col-sm-offset-4" >
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="Name"
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
          
            <spring:bind path="mobile">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="mobile" class="form-control" placeholder="Mobile"
                                autofocus="true" id="mobilenumber"></form:input>
                  <span id="messages" style="color:red;"></span>
                  
                   <!-- <form:errors path="mobile"></form:errors> -->
                </div>
            </spring:bind>
            
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                                autofocus="true"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
             </spring:bind>
             
            <spring:bind path="address">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="address" class="form-control" placeholder="Address"
                                autofocus="true"></form:input>
                    <form:errors path="address"></form:errors>
                </div>
            </spring:bind>
           
             
            
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"> </form:errors>
                </div>
            </spring:bind>
            
<<<<<<< HEAD
          
=======
<<<<<<< HEAD
          
=======
            <spring:bind path="	confirmpassword">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="confirmpassword" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"> </form:errors>
                </div>
            </spring:bind>
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
            
              </div>
            
            </div>
           
			<div class="row">
             <div class="col-sm-3 col-sm-offset-4">

              <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" onClick="return myfun();">Submit</button> 
           
           </div>
           </div>
            
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>