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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6


* {
        box-sizing: border-box;
      }
      .openBtn {
        display: flex;
        justify-content: left;
      }
      .openButton {
        border: none;
        border-radius: 5px;
        background-color: #1c87c9;
        color: white;
        padding: 14px 20px;
        cursor: pointer;
        position: fixed;
      }
      .loginPopup {
        position: relative;
        text-align: center;
        width: 100%;
      }
      .formPopup {
        display: none;
        position: fixed;
        left: 45%;
        top: 5%;
        transform: translate(-50%, 5%);
        border: 3px solid #999999;
        z-index: 9;
      }
      .formContainer {
        max-width: 300px;
        padding: 20px;
        background-color: #fff;
      }
      .formContainer input[type=text],
      .formContainer input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 20px 0;
        border: none;
        background: #eee;
      }
      .formContainer input[type=text]:focus,
      .formContainer input[type=password]:focus {
        background-color: #ddd;
        outline: none;
      }
      .formContainer .btn {
        padding: 12px 20px;
        border: none;
        background-color: #8ebf42;
        color: #fff;
        cursor: pointer;
        width: 100%;
        margin-bottom: 15px;
        opacity: 0.8;
      }
      .formContainer .cancel {
        background-color: #cc0000;
      }
      .formContainer .btn:hover,
      .openButton:hover {
        opacity: 1;
      }


table {
	width: 100%;
}

<<<<<<< HEAD
=======
=======
table {
	width: 100%;
}
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
table#01, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6

th, td {
	padding: 15px;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

<<<<<<< HEAD
=======
=======
th, td {
	padding: 15px;
}
table#t01 tr:nth-child(even) {
	background-color: #eee;
}
table#t01 tr:nth-child(odd) {
	background-color: #fff;
}
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
table#t01 th {
	background-color: black;
	color: white;
}
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
table#t02 {
	border: none !important;
	border-collapse: collapse !important;
}
</style>

</head>
<body>
	<table class="t02">
		<tr>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
			<td align="left" style="font-size: xx-large;"><b>CUSTOMER
					DETAILS</b></td>
		</tr>
		<tr>
<<<<<<< HEAD
			<td align="left" style="font-size: large;"><b>Welcome,
					${pageContext.request.userPrincipal.name} !!</b></td>
=======
			<td align="left" style="font-size: large;"><b>Welcome, <c:out
						value="${custName}"></c:out> !!
			</b></td>
=======
			<td align="center" style="font-size: xx-large;"><b>CUSTOMER
					DETAILS</b></td>
		</tr>
		<tr>
			<td align="left" style="font-size: large;"><b>Welcome,
					${pageContext.request.userPrincipal.name} !!</b></td>
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
		</tr>
		<tr>
			<td align="left"><b>Account Number :</b> <%=session.getAttribute("acctNum")%></td>
		</tr>
		<tr>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
			<td align="left"><c:choose>
					<c:when test="${kyflag}">
						<b>KYC Status :</b> KYC Pending
				<!--  <a href="/kycupload"><b>Upload your KYC documents here</b></a> -->
                <div class="openBtn">
                    <button class="openButton" onclick="openForm()"><strong>Upload KYC here</strong></button>
                  </div>
              
              
                  <div class="loginPopup">
                    <div class="formPopup" id="popupForm">
                      <form action="${contextPath}/upload" method="post" enctype="multipart/form-data" class="formContainer">
                        <h1 >Welcome to KYC page of City Bank</h1>
              <h3 >Please upload the required document to complete your KYC process</h3>
              <br>
              
              <strong>Select FIle:</strong>
              <br>
              
              <input type="file" name="image" accept="image/png"/ >
              <a type="button" class="btn btn-success"
                      href="/confirm">confirm</a>
              			<br>
                     <!--   <button type="button" class="btn cancel" onclick="closeForm()">Close</button> -->
              
              
                      </form>
                    </div>
                  </div>
					</c:when>
					<c:otherwise>
						<b>KYC Status :</b> KYC Verified/Uploaded.
						
						
						<tr>
			<td align="left"><b>Transaction History :</b> <a class="hidediv">Hide
					transaction</a> <a class="showdiv">show transaction</a></td>
<<<<<<< HEAD
=======
=======
			<td align="left"><b>KYC Status :</b> KYC Pending
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="/kycupload"><b>Upload your KYC
						documents here</b></a></td>
		</tr>
		<tr>
			<td align="left"><b>Transaction History :</b> <a class="hidediv">Hide
					transaction</a> &nbsp;&nbsp; <a class="showdiv">show transaction</a></td>
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
						
						
						
						
						
						
						
						
					</c:otherwise>
				</c:choose></td>

		</tr>
		<br>
		<br>
		
		
			</table>
    <script>
        function openForm() {
          document.getElementById("popupForm").style.display = "block";
        }
        function closeForm() {
          document.getElementById("popupForm").style.display = "none";
        }
      </script>
<<<<<<< HEAD
=======
=======
	</table>
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
</body>
</html>