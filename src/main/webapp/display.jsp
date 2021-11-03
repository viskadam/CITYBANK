<%@ include file="common/header.jspf"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="webjars/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
</head>

<body>


	<div class="container">

		<div class="container text-center" id="tasksDiv">

			<hr>
			<div class="table-responsive">

				<c:out value="${message}"></c:out>


				<table class="table table-striped table-bordered">
					<thead>
						<tr>

							<th>Kyc Number</th>
							<th>Document type</th>
							<th>Account Number</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach var="k" items="${ks}">

							<tr>


								<td>${k.ekyc}</td>
								<td>${k.doc}</td>
								<td>${k.accnum}</td>


								<td><a type="button"
									class="btn btn-success" href="/accept?id=${k.ekyc}&accnum=${k.accnum}">Accept</a>
									<a type="button"
									onclick="return confirm('Mail is sent to respective customer')"
									class="btn btn-warning" href="/reject?id=${k.ekyc}">Reject</a>


								</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>








	</div>
</body>