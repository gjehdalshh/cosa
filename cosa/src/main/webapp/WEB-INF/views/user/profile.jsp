<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<input type="hidden" id="i_user" value="${user.i_user }">
	<div>
		<span>아이디</span> <span>${data.user_id }</span>
	</div>
	<div>
		<span>이름</span> <input type="text" name="nm" id="nm"
			value="${data.user_nm }"> <span onclick="rename()">수정</span>
	</div>
	<div>
		<span>휴대전화</span> <input type="tel" name="phone" id="phone"
			value="${data.user_phone }"> <span
			onclick="changePhoneNumber()">수정</span>
	</div>
	<form method="post" action="" enctype="multipart/form-data">
		<div>
			<input type="file" name="file">
			<input type="submit" value="업로드">
		</div>
	</form>
	<input type="file" id="fileUpload"> <span onclick="upload()">업로드</span>
</div>


<script defer src="/res/js/user/profile.js?ver=19"></script>
<script defer src="/res/js/user/verification.js?ver=70"></script>