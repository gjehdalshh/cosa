
let smsCode = "";

function getSmsCode() {
	let phone = document.querySelector('#phone')
	
	
	let param = {
		user_phone: phone.value
	}

	fetch(`/user/sms`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		smsCode = data.authCode
	})
}

function join() {
	let id = document.querySelector('#id')
	let pw = document.querySelector('#pw')
	let name = document.querySelector('#name')
	let phone = document.querySelector('#phone')
	let authCode = document.querySelector('#authCode')

	let param = {
		user_id: id.value,
		user_pw: pw.value,
		user_nm: name.value,
		user_phone: phone.value,
		authCode: authCode.value,
		authCodeCheck: smsCode
	}

	fetch(`/user/join`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		if (conditionVerification(data)) {
			if (data.result == 2) {
				alert('아이디가 존재합니다.')
			} else if (data.result == 3) {
				alert('전화번호가 존재합니다.')
			} else if(data.result == 4) {
				alert('보안코드가 올바르지 않습니다.')
			} else {
				alert('회원가입에 성공하였습니다.')
				location.href = `/user/login`
			}
		}
	})
}




