<%@ include file="common/header.jspf"%>


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
     
			<div class="container text-center" id="tasksDiv">
				<h3> User</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
							
								<th> Name</th>
							
								<th>Kyc number</th>
							
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									
									
									<td>${user.name}</td>
									
									<td>123</td>
									<td><a type="button" class="btn btn-success"
        href="/accept?id=${user.id}">Accept</a>
          <a type="button" class="btn btn-warning"
        href="/reject?id=${user.id}">Reject</a></td>
									
								</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
		
		
		




    </div>
</body>
