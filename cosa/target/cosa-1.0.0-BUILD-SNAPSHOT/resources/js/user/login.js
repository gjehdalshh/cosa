
function login() {
	let id = document.querySelector('#id')
	let pw = document.querySelector('#pw') 
	
	let param = {
		user_id : id.value,
		user_pw : pw.value
	}
	
	console.log(param)
	
	fetch(`/user/loginProc`, {
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
					alert('아이디가 존재하지 않습니다.')
				} else if(data.result == 3) {
					alert('아이디와 비밀번호를 정확히 입력해주세요.')
				} else {
					alert('로그인에 성공하였습니다.')
				}
			}
		})
}