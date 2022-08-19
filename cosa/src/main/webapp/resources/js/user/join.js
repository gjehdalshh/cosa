

function join() {
	let id = document.querySelector('#id')
	let pw = document.querySelector('#pw')
	let name = document.querySelector('#name')
	let phone = document.querySelector('#phone')

	var param = {
		user_id : id.value,
		user_pw : pw.value,
		user_nm : name.value,
		user_phone : phone.value
	}
	console.log(param)
	
	fetch(`/user/joinProc`, {
			method: 'POST',
			headers: {
		'Content-Type': 'application/json'
			},
			body:JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			if(conditionVerification(data)) {
				if(data.result == 2) {
					alert('아이디가 존재합니다.')
				} else if(data.result == 3) {
					alert('전화번호가 존재합니다.')
				} else {
					alert('회원가입에 성공하였습니다.')
					location.href=`/user/login`
				}
			}
		})
}

function conditionVerification(data) {
	if(data.message != null) {
		return alert(data.message)
	}
	return 1
}




