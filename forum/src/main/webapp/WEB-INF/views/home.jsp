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
					<spring:message code="home.titleMessage" />
				</h1>

			</div>
		</div>
	</section>
	<section class="container">

		<c:if test="${not empty info}">
			<div class="alert alert-info">${info}</div>
		</c:if>
		<div class="row">
		
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail" style="background-color: #ECF7FB;">
					<div class="caption">
						<h3><spring:message code="home.sessionTab.title" /></h3>
						
						<c:if test="${not empty sessionScope.loggedUserNickname}">
						
						</c:if>
						<c:choose>
						    <c:when test="${not empty sessionScope.loggedUserNickname}">
						        <p><spring:message code="home.sessionTab.descLoggedIn" />${sessionScope.loggedUserNickname}</p>
								<p>
									<a href="<spring:url value="/logout" />" class="btn btn-default"><spring:message code="home.sessionTab.buttonLoggedIn" /></a>
								</p>
						    </c:when>    
						    <c:otherwise>
						        <p><spring:message code="home.sessionTab.descNotLoggedIn" /></p>
								<p>
									<a href="<spring:url value="/login" />" class="btn btn-default"><spring:message code="home.sessionTab.buttonNotLoggedIn" /></a>
								</p>
						    </c:otherwise>
						</c:choose>
						
						
						
						
					</div>
				</div>
			</div>
			
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail" style="background-color: #ECF7FB;">
					<div class="caption">
						<h3><spring:message code="home.topic.title" /></h3>
						
						
					        <p><spring:message code="home.topic.desc" />${sessionScope.loggedUserNickname}</p>
							<p>
								<a href="<spring:url value="/topics" />" class="btn btn-default"><spring:message code="home.topic.button" /></a>
							</p>
						   
					</div>
				</div>
			</div>
			
		</div>


	</section>
</body>
</html>
