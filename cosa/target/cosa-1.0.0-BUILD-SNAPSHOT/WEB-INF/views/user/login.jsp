<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form>
		<div>
			<span>아이디</span><input type="email" name="id" id="id" value="gjehdalshh@naver.com">
		</div>
		<div>
			<span>비밀번호</span><input type="password" name="pw" id="pw" value="784523eaehdals11">
		</div>
	</form>
	<div onclick="login()">로그인</div>
	<div>
		<a href="/user/join">회원가입</a>
	</div>
	<div>
		<a href="/user/profile">수정</a>
	</div>
</div>


<script defer src="/res/js/user/login.js?ver=51"></script>
<script defer src="/res/js/user/verification.js?ver=49"></script>