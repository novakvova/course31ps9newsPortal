<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posts</title>
<jsp:include page="container/_link-css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="container/_header.jsp"></jsp:include>

	<main class="main">
		<div class="container">
			<h1 class="d-flex justify-content-center">Список постів</h1>
			<a class="button" href="${pageContext.request.contextPath}/addPost">Додати пост</a>
			<br>
			<table class="table" modelAttribute="posts">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>ShortDescription</th>
					<th>Meta</th>
					<th>URL slug</th>
					<th>Published</th>
<!-- 					<th>Edit</th>
					<th>Delete</th> -->
				</tr>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td>${post.id}</td>
						<td>${post.title}</td>
						<td>${post.shortDescription}</td>
						<td>${post.meta}</td>
						<td>${post.urlSlug}</td>
						<td>${post.published}</td>
						
<%-- 						<td><a href="editpost/${post.id}">Edit</a></td>
						<td><a href="deletepost/${post.id}">Delete</a></td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>

	<jsp:include page="container/_scripts.jsp"></jsp:include>
</body>
</html>