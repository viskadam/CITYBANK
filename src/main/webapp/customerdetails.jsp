<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Details and Kyc Status</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(document).ready(function() {
		$(".data").hide("slow");
		$(".hidediv").click(function() {
			$(".data").hide("slow");
		});

		$(".showdiv").click(function() {
			$(".data").show("fast");
		});

	});
</script>
<style>
table {
	width: 100%;
}

table#01, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: black;
	color: white;
}

table#t02 {
	border: none !important;
	border-collapse: collapse !important;
}
</style>

</head>
<body>
	<table class="t02">
		<tr>
			<td align="center" style="font-size: xx-large;"><b>CUSTOMER
					DETAILS</b></td>
		</tr>
		<tr>
			<td align="left" style="font-size: large;"><b>Welcome,
					${pageContext.request.userPrincipal.name} !!</b></td>
		</tr>
		<tr>
			<td align="left"><b>Account Number :</b> <%=session.getAttribute("acctNum")%></td>
		</tr>
		<tr>
			<td align="left"><b>KYC Status :</b> KYC Pending
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><b>Upload your KYC
						documents here</b></a></td>
		</tr>
		<tr>
			<td align="left"><b>Transaction History :</b> <a class="hidediv">Hide
					transaction</a> &nbsp;&nbsp; <a class="showdiv">show transaction</a></td>
		</tr>

		<tr>
			<td>
				<div class="data">
					<table id="t01">
						<tr>
							<th>Date</th>
							<th>Description</th>
							<th>Withdrawal</th>
							<th>Deposits</th>
							<th>Balance</th>
						</tr>
						<tr>
							<td></td>
							<td>Opening Balance</td>
							<td></td>
							<td></td>
							<td>200000</td>
						</tr>
						<tr>
							<td>10-sept-2021</td>
							<td>IMPS INWARD ORG UPI From gbk55cbi@oksbi,REF NO -
								127412359171, UPI</td>
							<td>10000</td>
							<td></td>
							<td>190000</td>
						</tr>
						<tr>
							<td>20-sept-2021</td>
							<td>ATM WITHDRAWAL SUBJECT: EURONT 01OCT1921</td>
							<td>20000</td>
							<td></td>
							<td>170000</td>

						</tr>
						<tr>
							<td>30-sept-2021</td>
							<td>IMPS INWARD ORG UPI From gbk55cbi@oksbi</td>
							<td></td>
							<td>15000</td>
							<td>185000</td>
						</tr>
						<tr>
							<td></td>
							<td>Total</td>
							<td>30000</td>
							<td>15000</td>
							<td>185000</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>