let i_user = document.querySelector('#i_user')


function rename() {
	let url = `/user/profile/modifyNm`
	changeNameAndPhone(url)
}

function changePhoneNumber() {
	let url = `/user/profile/modifyPh`
	changeNameAndPhone(url)
}

function changeNameAndPhone(url) {
	let nm = document.querySelector('#nm')
	let phone = document.querySelector('#phone')

	let param = {
		i_user: i_user.value,
		user_nm: nm.value,
		user_phone: phone.value
	}
	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		if (conditionVerification(data)) {
			alert('회원정보가 변경되었습니다.')
		}
	})
}
