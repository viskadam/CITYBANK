

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav role="navigation" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >City Bank</a>
    </div>
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>
    <ul class="nav navbar-nav">
      <li><a class="active">My Account</a></li>
      <li><a>Transactions History</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
    </ul>
  </div>
</nav>
  


</body>
</html>
