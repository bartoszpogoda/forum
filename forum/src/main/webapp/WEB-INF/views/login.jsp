<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
</head>
<body>
	<section>
		<div class="jumbotron" style="background-color: #46B5DA;">
			<div class="container">
				<h1 style="color: white;">
					<spring:message code="login.titleMessage" />
				</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><spring:message code="login.description" /></h3>
					</div>
					<div class="panel-body">

						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<!--<spring:message code="login.errorMessage" />
								<br /> -->
								${error}
							</div>
						</c:if>

						<form action= "<c:url value="/login" ></c:url>" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User" 
										name='username' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="password"
										name='password' type="password" value="">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Submit">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
