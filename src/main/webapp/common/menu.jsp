<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="http://www.karpado.com" class="navbar-brand">City Bank</a>
	</div>
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active">My account</a></li>
			<li><a href="/www.google.com">Transactions History</a></li>
			<li><a href="/kycupload">KYC status</a></li>
		</ul>
		 <ul class="nav navbar-nav navbar-right">
			<li><a href="#" onclick="document.forms['logoutForm'].submit()">Logout</a></li>
		</ul>
	</div>
</nav>