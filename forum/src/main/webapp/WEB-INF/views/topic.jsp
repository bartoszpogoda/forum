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
					${topic.title}
				</h1>

			</div>
		</div>
	</section>
	<section class="container">

		<c:forEach items="${posts}" var="post"> 
		<div class="panel panel-default">
  <div class="panel-heading">${post.author}</div>
  <div class="panel-body">
    ${post.content}
  		</div>
		</div>
		
		</c:forEach>
		
		<c:if test="${not empty sessionScope.loggedUserNickname}">
		<div class="panel panel-default">
		  <div class="panel-heading">${sessionScope.loggedUserNickname}</div>
		  <div class="panel-body">
		    <form action= "<c:url value="/topics/topic/${topic.topicId}/post" ></c:url>" method="post">
				<fieldset>
					<div class="form-group">
						<input class="form-control" placeholder="Content" 
							name='content' type="text">
					</div>
					</div>
					<input class="btn btn-lg btn-success btn-block" type="submit"
						value="Post">
				</fieldset>
			<form>
			
			<a href="<spring:url value="/topics" />" class="btn btn-default"><spring:message code="topic.backToTopicsButton" /></a>
  		</div>
  		</div>
		</c:if>  
		
		
	</section>
</body>
</html>
