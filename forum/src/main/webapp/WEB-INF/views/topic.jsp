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

		<c:if test="${not empty info}">
			<div class="alert alert-info">${info}</div>
		</c:if>
		<c:forEach items="${posts}" var="post"> 
			<div class="row">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail" style="background-color: #ECF7FB;">
						<div class="caption">
							<h3>${post.author}</h3>
							
					        <p>${post.content}</p>
						</div>
					</div>
				</div>	
			</div>
		</c:forEach>
		<div class="row">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail" style="background-color: #ECF7FB;">
						input tutaj, zmienic styl tego wyzej
					</div>
				</div>	
		</div>
	</section>
</body>
</html>
