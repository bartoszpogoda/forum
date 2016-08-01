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
					<spring:message code="topics.titleMessage" />
				</h1>

			</div>
		</div>
	</section>
	<section class="container">

		<c:if test="${not empty info}">
			<div class="alert alert-info">${info}</div>
		</c:if>
		<div class="row">
			
			<c:forEach items="${topics}" var="topic"> 
			
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail" style="background-color: #ECF7FB;">
					<div class="caption">
						<h3>${topic.authorNickname}</h3>
						
				        <p>${topic.title}</p>
						<p>
							<a href="<spring:url value="/topics/topic/?id=${topic.topicId}" />" class="btn btn-default"><spring:message code="topics.buttonGoIntoTopic" /></a>
						</p>
				    
					</div>
				</div>
			</div>
			
			</c:forEach>
			
			
			
		</div>


	</section>
</body>
</html>
