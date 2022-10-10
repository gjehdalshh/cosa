<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<form>
		<div>
			<span>아이디</span><input type="email" name="id" id="id"
				autofocus="autofocus">
		</div>
		<div>
			<span>비밀번호</span><input type="password" name="pw" id="pw"
				autocomplete="off">
		</div>
		<div>
			<span>이름</span><input type="text" name="name" id="name">
		</div>
		<div>
			<span>휴대전화</span><input type="tel" name="phone" id="phone"><span
				onclick="getSmsCode()">인증받기</span>
		</div>
		<div>
			<span>인증코드</span><input type="text" name="authCode" id="authCode">
		</div>
	</form>
	<div onclick="join()">회원가입</div>
</div>


<script defer src="/res/js/user/join.js?ver=57"></script>
<script defer src="/res/js/user/verification.js?ver=47"></script>