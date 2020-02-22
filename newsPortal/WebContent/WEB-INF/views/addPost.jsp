<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add post</title>
<jsp:include page="container/_link-css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="container/_header.jsp"></jsp:include>

	<main class="main">
		<div class="container">
			<h1 class="d-flex justify-content-center">Додати пост</h1>
			<form:form name="form" action="login" method="post" modelAttribute="add">
				<div class="form-group">
					<label for="title">Заголовок</label>
					<input type="text" class="form-control" id="title">
				</div>
				<div class="form-group">
					<label for="shortDescription">Короткий опис</label>
<!-- 					<textarea class="form-control" id="shortDescription"></textarea> -->
					<textarea id="edit" class="editorFroala" name="content"></textarea>
				</div>
				<div class="form-group">
					<label for="description">Повний опис</label>
<!-- 					<textarea class="form-control" id="description"></textarea> -->
					<textarea id="edit" class="editorFroala" name="content"></textarea>
				</div>
				<div class="form-group">
					<label for="meta">Мета</label>
					<input type="text" class="form-control" id="meta">
				</div>
				<div class="form-group">
					<label for="urlSlug">URL slug</label>
					<input type="text" class="form-control" id="urlSlug">
				</div>
				<div class="form-group">
					<label for="postedOn">Дата публікації</label>
					<input type="date" class="form-control" id="postedOn">
				</div>
				<div class="form-group">
					<label for="category">Виберіть категорію</label>
					<select	class="form-control" id="category">

						<c:forEach var="category" items="${add.categories}">
							<option value="${category.value}">${category.text}</option>
						</c:forEach>
					</select>
				</div>
				<br>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="published">
					<label class="form-check-label" for="published">Показати на сайті</label>
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Додати</button>
			</form:form>
		</div>
	</main>

	<jsp:include page="container/_scripts.jsp"></jsp:include>
		<script
		src="${pageContext.request.contextPath}/resources/node_modules/froala-editor/js/froala_editor.pkgd.min.js"></script>
	<script>
		new FroalaEditor('.editorFroala', {
			// Set the image upload URL.
			imageUploadURL : 'http://localhost:8080/newsPortal/upload_image',
			imageUploadParams : {
				id : 'my_editor'
			}
		})
	</script>
</body>
</html>