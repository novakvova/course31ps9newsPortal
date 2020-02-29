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
			<form:form name="form" action="addPost" method="post" modelAttribute="postDTO">
				<div class="form-group">
					<label for="title">Заголовок</label>
					<form:input path="title" type="text" class="form-control" id="title"/>
				</div>
				<div class="form-group">
					<label for="shortDescription">Короткий опис</label>
<!-- 					<textarea id="edit" class="editorFroala" name="content"></textarea> -->
					<form:textarea path="shortDescription" name="content" class="editorFroala" id="shortDescription"/>
				</div>
				<div class="form-group">
					<label for="description">Повний опис</label>
<!-- 					<textarea id="edit" class="editorFroala" name="content"></textarea> -->
					<form:textarea path="description" name="content" class="editorFroala" id="description"/>
				</div>
				<div class="form-group">
					<label for="meta">Мета</label>
					<form:input path="meta" type="text" class="form-control" id="meta"/>
				</div>
				<div class="form-group">
					<label for="urlSlug">URL slug</label>
					<form:input path="urlSlug" type="text" class="form-control" id="urlSlug"/>
				</div>
				<div class="form-group">
					<label for="postedOn">Дата публікації</label>
					<form:input path="postedOn" type="date" class="form-control" id="postedOn"/>
				</div>
				<div class="form-group">
					<label for="category">Виберіть категорію</label>
					<form:select path="category_id" class="form-control" id="category_id">
						<c:forEach var="category" items="${postDTO.categories}">
							<option value="${category.value}">${category.text}</option>
						</c:forEach>
					</form:select>
				</div>
				<br>
				<div class="form-check">
					<form:checkbox path="published" class="form-check-label" id="published"/>
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