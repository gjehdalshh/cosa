<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<input type="hidden" id="i_user" value="${user.i_user }">
	<div>
		<span>아이디</span> <span>${data.user_id }</span>
	</div>
	<div>
		<span>이름</span><input type="text" name="nm" id="nm"
			value="${data.user_nm }"> <span onclick="rename()">수정</span>
	</div>
	<div>
		<span>휴대전화</span> <input type="tel" name="phone" id="phone"
			value="${data.user_phone }"> <span
			onclick="changePhoneNumber()">수정</span>
	</div>
	<form id="fileForm">
		<input type="hidden" name="i_user" value="${user.i_user }">
		<input type="file" id="fileUpload" name="fileUpload">
		 <span onclick="upload()">업로드</span>
	</form>
	
	<form id="fileForm" method="post" enctype="multipart/form-data">
		<input type="file" id="fileUpload" name="fileUpload" multiple="multiple">
	</form>
	<span onclick="upload()">업로드</span>
</div>


<script defer src="/res/js/user/profile.js?ver=28"></script>
<script defer src="/res/js/user/verification.js?ver=70"></script>